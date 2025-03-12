<template>
<div :style='{"width":"100%","padding":"30px 7% 40px","margin":"0px auto","position":"relative","background":"none"}'>
    <el-form
	  :style='{"border":"0px solid #28890b30","width":"100%","padding":"30px","position":"relative","background":"none"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="180px"
    >
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="产品名称" prop="chanpinmingcheng">
            <el-input v-model="ruleForm.chanpinmingcheng" 
                placeholder="产品名称" clearable :disabled=" false  ||ro.chanpinmingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}'  label="产品分类" prop="chanpinfenlei">
            <el-select v-model="ruleForm.chanpinfenlei" placeholder="请选择产品分类" :disabled=" false  ||ro.chanpinfenlei" >
              <el-option
                  v-for="(item,index) in chanpinfenleiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="产品图片" v-if="type!='cross' || (type=='cross' && !ro.chanpintupian)" prop="chanpintupian">
            <file-upload
            tip="点击上传产品图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.chanpintupian?ruleForm.chanpintupian:''"
            @change="chanpintupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' class="upload" v-else label="产品图片" prop="chanpintupian">
                <img v-if="ruleForm.chanpintupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.chanpintupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.chanpintupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="产品品牌" prop="chanpinpinpai">
            <el-input v-model="ruleForm.chanpinpinpai" 
                placeholder="产品品牌" clearable :disabled=" false  ||ro.chanpinpinpai"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="产品规格" prop="chanpinguige">
            <el-input v-model="ruleForm.chanpinguige" 
                placeholder="产品规格" clearable :disabled=" false  ||ro.chanpinguige"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="产品厂家" prop="chanpinchangjia">
            <el-input v-model="ruleForm.chanpinchangjia" 
                placeholder="产品厂家" clearable :disabled=" false  ||ro.chanpinchangjia"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="上架日期" prop="shangjiariqi">
              <el-date-picker
				  :disabled=" false  ||ro.shangjiariqi"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.shangjiariqi" 
                  type="date"
                  placeholder="上架日期">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="单限" prop="onelimittimes">
            <el-input v-model.number="ruleForm.onelimittimes" 
                placeholder="单限" clearable :disabled=" false  ||ro.onelimittimes"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="库存" prop="alllimittimes">
            <el-input v-model.number="ruleForm.alllimittimes" 
                placeholder="库存" clearable :disabled=" false  ||ro.alllimittimes"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="价格" prop="price">
			<el-input-number v-model="ruleForm.price" placeholder="价格" :disabled="ro.price"></el-input-number>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="产品介绍" prop="chanpinjieshao">
            <editor 
                :style='{"minHeight":"250px","padding":"0","margin":"0","borderColor":"#1abc9e30","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0px","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.chanpinjieshao" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"6px","background":"#1e3c4f","width":"128px","lineHeight":"36px","fontSize":"14px","height":"36px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"1px solid #1e3c4f","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#1e3c4f","borderRadius":"6px","background":"none","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
        ro:{
				chanpinmingcheng : false,
				chanpinfenlei : false,
				chanpintupian : false,
				chanpinpinpai : false,
				chanpinguige : false,
				chanpinchangjia : false,
				shangjiariqi : false,
				chanpinjieshao : false,
				onelimittimes : false,
				alllimittimes : false,
				clicktime : false,
				clicknum : false,
				discussnum : false,
				price : false,
				storeupnum : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          chanpinmingcheng: '',
          chanpinfenlei: '',
          chanpintupian: '',
          chanpinpinpai: '',
          chanpinguige: '',
          chanpinchangjia: '',
          shangjiariqi: '',
          chanpinjieshao: '',
          onelimittimes: Number('-1') ,
          alllimittimes: Number('-1') ,
          clicktime: '',
          clicknum: '',
          discussnum: '',
          price: '',
          storeupnum: '',
        },
        chanpinfenleiOptions: [],


        rules: {
          chanpinmingcheng: [
          ],
          chanpinfenlei: [
          ],
          chanpintupian: [
          ],
          chanpinpinpai: [
          ],
          chanpinguige: [
          ],
          chanpinchangjia: [
          ],
          shangjiariqi: [
          ],
          chanpinjieshao: [
          ],
          onelimittimes: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          alllimittimes: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          clicktime: [
          ],
          clicknum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          discussnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          price: [
            { required: true, message: '价格不能为空', trigger: 'blur' },
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          storeupnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='chanpinmingcheng'){
              this.ruleForm.chanpinmingcheng = obj[o];
              this.ro.chanpinmingcheng = true;
              continue;
            }
            if(o=='chanpinfenlei'){
              this.ruleForm.chanpinfenlei = obj[o];
              this.ro.chanpinfenlei = true;
              continue;
            }
            if(o=='chanpintupian'){
              this.ruleForm.chanpintupian = obj[o].split(",")[0];
              this.ro.chanpintupian = true;
              continue;
            }
            if(o=='chanpinpinpai'){
              this.ruleForm.chanpinpinpai = obj[o];
              this.ro.chanpinpinpai = true;
              continue;
            }
            if(o=='chanpinguige'){
              this.ruleForm.chanpinguige = obj[o];
              this.ro.chanpinguige = true;
              continue;
            }
            if(o=='chanpinchangjia'){
              this.ruleForm.chanpinchangjia = obj[o];
              this.ro.chanpinchangjia = true;
              continue;
            }
            if(o=='shangjiariqi'){
              this.ruleForm.shangjiariqi = obj[o];
              this.ro.shangjiariqi = true;
              continue;
            }
            if(o=='chanpinjieshao'){
              this.ruleForm.chanpinjieshao = obj[o];
              this.ro.chanpinjieshao = true;
              continue;
            }
            if(o=='onelimittimes'){
              this.ruleForm.onelimittimes = obj[o];
              this.ro.onelimittimes = true;
              continue;
            }
            if(o=='alllimittimes'){
              this.ruleForm.alllimittimes = obj[o];
              this.ro.alllimittimes = true;
              continue;
            }
            if(o=='clicktime'){
              this.ruleForm.clicktime = obj[o];
              this.ro.clicktime = true;
              continue;
            }
            if(o=='clicknum'){
              this.ruleForm.clicknum = obj[o];
              this.ro.clicknum = true;
              continue;
            }
            if(o=='discussnum'){
              this.ruleForm.discussnum = obj[o];
              this.ro.discussnum = true;
              continue;
            }
            if(o=='price'){
              this.ruleForm.price = obj[o];
              this.ro.price = true;
              continue;
            }
            if(o=='storeupnum'){
              this.ruleForm.storeupnum = obj[o];
              this.ro.storeupnum = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.$http.get('option/chanpinfenlei/chanpinfenlei', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.chanpinfenleiOptions = res.data.data;
          }
        });

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`yangshengchanpin/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {
			if(this.ruleForm.price<0){
				this.$message.error("价格不能输入负数");
				return
			}
			if(this.ruleForm.alllimittimes<0){
				this.$message.error("库存不能输入负数");
				return
			}
			if(this.ruleForm.onelimittimes<0){
				this.$message.error("单次购买不能输入负数");
				return
			}
			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('yangshengchanpin/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`yangshengchanpin/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`yangshengchanpin/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				}
			});
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		// 返回
		back() {
			this.$router.go(-1);
		},
      chanpintupianUploadChange(fileUrls) {
          this.ruleForm.chanpintupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 180px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 180px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border-radius: 30px;
	  padding: 0 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #eee;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 300px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  border-radius: 30px;
	  padding: 0 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #eee;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 300px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border-radius: 30px;
	  padding: 0 10px;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #eee;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 350px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border-radius: 30px;
	  padding: 0 10px 0 30px;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #eee;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 350px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  cursor: pointer;
	  color: #999;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #eee;
	  line-height: 60px;
	  border-radius: 20px;
	  background: #fff;
	  width: 120px;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  cursor: pointer;
	  color: #999;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #eee;
	  line-height: 60px;
	  border-radius: 20px;
	  background: #fff;
	  width: 120px;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  cursor: pointer;
	  color: #999;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #eee;
	  line-height: 60px;
	  border-radius: 20px;
	  background: #fff;
	  width: 120px;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #eee;
	  border-radius: 20px;
	  padding: 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  min-width: 800px;
	  height: 120px;
	}
</style>
