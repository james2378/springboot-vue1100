<template>
	<div class="addEdit-block" :style='{"minHeight":"100vh","padding":"30px","fontSize":"14px","color":"#666","background":"#e9ecf3"}'>
		<el-form
			:style='{"border":"0px solid #bababa","padding":"40px 30px 20px","borderRadius":"0px","alignItems":"flex-start","flexWrap":"wrap","background":"rgba(255,255,255,1)","display":"flex","fontSize":"inherit"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="150px"
		>
			<template >
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="测试标题" prop="ceshibiaoti">
					<el-input v-model="ruleForm.ceshibiaoti" placeholder="测试标题" clearable  :readonly="ro.ceshibiaoti"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="测试标题" prop="ceshibiaoti">
					<el-input v-model="ruleForm.ceshibiaoti" placeholder="测试标题" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="内容" prop="neirong">
					<el-input v-model="ruleForm.neirong" placeholder="内容" clearable  :readonly="ro.neirong"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="内容" prop="neirong">
					<el-input v-model="ruleForm.neirong" placeholder="内容" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="upload" v-if="type!='info' && !ro.fengmian" label="封面" prop="fengmian">
					<file-upload
						tip="点击上传封面"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.fengmian?ruleForm.fengmian:''"
						@change="fengmianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="upload" v-else-if="ruleForm.fengmian" label="封面" prop="fengmian">
					<img v-if="ruleForm.fengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.fengmian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fengmian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="测试详情" prop="ceshixiangqing">
					<el-input v-model="ruleForm.ceshixiangqing" placeholder="测试详情" clearable  :readonly="ro.ceshixiangqing"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="测试详情" prop="ceshixiangqing">
					<el-input v-model="ruleForm.ceshixiangqing" placeholder="测试详情" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="date" v-if="type!='info'" label="测试时间" prop="ceshishijian">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.ceshishijian" 
						type="date"
						:readonly="ro.ceshishijian"
						placeholder="测试时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-else-if="ruleForm.ceshishijian" label="测试时间" prop="ceshishijian">
					<el-input v-model="ruleForm.ceshishijian" placeholder="测试时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" clearable  :readonly="ro.yonghuzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" clearable  :readonly="ro.yonghuxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="用户姓名" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item :style='{"padding":"10px 0 20px","margin":"30px 0","alignItems":"center","textAlign":"center","display":"flex","width":"100%","perspective":"320px","-webkitPerspective":"320px","fontSize":"48px","justifyContent":"flex-start"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-tijiao16" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"none"}'></span>
					保存修改
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-quxiao09" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"none"}'></span>
					取消修改
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui01" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"none"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				ceshibiaoti : false,
				neirong : false,
				fengmian : false,
				ceshixiangqing : false,
				ceshishijian : false,
				yonghuzhanghao : false,
				yonghuxingming : false,
			},
			
			
			ruleForm: {
				ceshibiaoti: '',
				neirong: '',
				fengmian: '',
				ceshixiangqing: '',
				ceshishijian: '',
				yonghuzhanghao: '',
				yonghuxingming: '',
			},
		

			
			rules: {
				ceshibiaoti: [
				],
				neirong: [
				],
				fengmian: [
				],
				ceshixiangqing: [
				],
				ceshishijian: [
				],
				yonghuzhanghao: [
				],
				yonghuxingming: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
		this.ruleForm.ceshishijian = this.getCurDate()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='ceshibiaoti'){
							this.ruleForm.ceshibiaoti = obj[o];
							this.ro.ceshibiaoti = true;
							continue;
						}
						if(o=='neirong'){
							this.ruleForm.neirong = obj[o];
							this.ro.neirong = true;
							continue;
						}
						if(o=='fengmian'){
							this.ruleForm.fengmian = obj[o];
							this.ro.fengmian = true;
							continue;
						}
						if(o=='ceshixiangqing'){
							this.ruleForm.ceshixiangqing = obj[o];
							this.ro.ceshixiangqing = true;
							continue;
						}
						if(o=='ceshishijian'){
							this.ruleForm.ceshishijian = obj[o];
							this.ro.ceshishijian = true;
							continue;
						}
						if(o=='yonghuzhanghao'){
							this.ruleForm.yonghuzhanghao = obj[o];
							this.ro.yonghuzhanghao = true;
							continue;
						}
						if(o=='yonghuxingming'){
							this.ruleForm.yonghuxingming = obj[o];
							this.ro.yonghuxingming = true;
							continue;
						}
				}
			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
					if(((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yonghuzhanghao = json.yonghuzhanghao
						this.ro.yonghuzhanghao = true;
					}
					if(((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yonghuxingming = json.yonghuxingming
						this.ro.yonghuxingming = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `tizhiceshi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
	if(this.ruleForm.fengmian!=null) {
		this.ruleForm.fengmian = this.ruleForm.fengmian.replace(new RegExp(this.$base.url,"g"),"");
	}
var objcross = this.$storage.getObj('crossObj');
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "tizhiceshi/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `tizhiceshi/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.tizhiceshiCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `tizhiceshi/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.tizhiceshiCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
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
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.tizhiceshiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    fengmianUploadChange(fileUrls) {
	    this.ruleForm.fengmian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #999;
	  	  font-weight: 500;
	  	  display: inline-block;
	  	  width: 150px;
	  	  font-size: inherit;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  color: inherit;
	  	  background: none;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  border-color: #ccc;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  height: 39px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  color: inherit;
	  	  background: none;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  border-color: #ccc;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  height: 39px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border-radius: 0px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  color: inherit;
	  	  background: none;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  border-color: #ccc;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  height: 39px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border-radius: 0px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: none;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  border-color: #ccc;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  height: 39px;
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
	  	  color: #bbb;
	  	  object-fit: cover;
	  	  font-size: 24px;
	  	  border-color: #ccc;
	  	  line-height: 80px;
	  	  border-radius: 0px;
	  	  background: none;
	  	  width: 120px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  cursor: pointer;
	  	  color: #bbb;
	  	  object-fit: cover;
	  	  font-size: 24px;
	  	  border-color: #ccc;
	  	  line-height: 80px;
	  	  border-radius: 0px;
	  	  background: none;
	  	  width: 120px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  cursor: pointer;
	  	  color: #bbb;
	  	  object-fit: cover;
	  	  font-size: 24px;
	  	  border-color: #ccc;
	  	  line-height: 80px;
	  	  border-radius: 0px;
	  	  background: none;
	  	  width: 120px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  padding: 12px;
	  	  color: inherit;
	  	  font-size: 14px;
	  	  border-color: #ccc;
	  	  min-height: 120px;
	  	  border-radius: 0px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  background: none;
	  	  width: auto;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  min-width: 400px;
	  	  height: auto;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 1px solid rgba(53, 184, 224, 0.1);
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 4px;
				color: #fff;
				display: inline-block;
				font-size: 14px;
				line-height: 24px;
				border-radius: 0px;
				outline: none;
				background: #35b8e0;
				width: auto;
				height: 36px;
			}
	
	.add-update-preview .btn .btn1:hover {
			}
	
	.add-update-preview .btn .btn2 {
				border: 1px solid rgba(24, 138, 226, 0.1) ;
				cursor: pointer;
				border-radius: 0px;
				padding: 0 20px;
				margin: 0px 4px;
				outline: none;
				color: #fff;
				background: #188ae2;
				width: auto;
				font-size: 14px;
				line-height: 24px;
				height: 36px;
			}
	
	.add-update-preview .btn .btn2:hover {
			}
	
	.add-update-preview .btn .btn3 {
				border: 0px solid #0260ad;
				cursor: pointer;
				border-radius: 0px;
				padding: 0 20px;
				margin: 0px 4px;
				outline: none;
				color: #fff;
				background: #0e90d2;
				width: auto;
				font-size: 14px;
				line-height: 24px;
				height: 36px;
			}
	
	.add-update-preview .btn .btn3:hover {
			}
	
	.add-update-preview .btn .btn4 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 0px;
				padding: 0 20px;
				margin: 0px 4px;
				outline: none;
				color: #fff;
				background: #727b84;
				width: auto;
				font-size: 14px;
				line-height: 24px;
				height: 36px;
			}
	
	.add-update-preview .btn .btn4:hover {
			}
	
	.add-update-preview .btn .btn5 {
				border: 1px solid rgba(114, 123, 132, 0.1);
				cursor: pointer;
				padding: 0 20px;
				margin: 4px;
				color: #fff;
				font-size: 14px;
				line-height: 24px;
				border-radius: 0px;
				outline: none;
				background: #727b84;
				width: auto;
				min-width: 90px;
				height: 36px;
			}
	
	.add-update-preview .btn .btn5:hover {
			}
</style>
