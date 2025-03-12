package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.SijiyangshengEntity;
import com.entity.view.SijiyangshengView;

import com.service.SijiyangshengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 四季养生
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 17:19:24
 */
@RestController
@RequestMapping("/sijiyangsheng")
public class SijiyangshengController {
    @Autowired
    private SijiyangshengService sijiyangshengService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SijiyangshengEntity sijiyangsheng,
		HttpServletRequest request){
        EntityWrapper<SijiyangshengEntity> ew = new EntityWrapper<SijiyangshengEntity>();

		PageUtils page = sijiyangshengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sijiyangsheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SijiyangshengEntity sijiyangsheng, 
		HttpServletRequest request){
        EntityWrapper<SijiyangshengEntity> ew = new EntityWrapper<SijiyangshengEntity>();

		PageUtils page = sijiyangshengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sijiyangsheng), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SijiyangshengEntity sijiyangsheng){
       	EntityWrapper<SijiyangshengEntity> ew = new EntityWrapper<SijiyangshengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( sijiyangsheng, "sijiyangsheng")); 
        return R.ok().put("data", sijiyangshengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SijiyangshengEntity sijiyangsheng){
        EntityWrapper< SijiyangshengEntity> ew = new EntityWrapper< SijiyangshengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( sijiyangsheng, "sijiyangsheng")); 
		SijiyangshengView sijiyangshengView =  sijiyangshengService.selectView(ew);
		return R.ok("查询四季养生成功").put("data", sijiyangshengView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SijiyangshengEntity sijiyangsheng = sijiyangshengService.selectById(id);
		sijiyangsheng.setClicktime(new Date());
		sijiyangshengService.updateById(sijiyangsheng);
        sijiyangsheng = sijiyangshengService.selectView(new EntityWrapper<SijiyangshengEntity>().eq("id", id));
        return R.ok().put("data", sijiyangsheng);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SijiyangshengEntity sijiyangsheng = sijiyangshengService.selectById(id);
		sijiyangsheng.setClicktime(new Date());
		sijiyangshengService.updateById(sijiyangsheng);
        sijiyangsheng = sijiyangshengService.selectView(new EntityWrapper<SijiyangshengEntity>().eq("id", id));
        return R.ok().put("data", sijiyangsheng);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SijiyangshengEntity sijiyangsheng, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(sijiyangsheng);
        sijiyangshengService.insert(sijiyangsheng);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SijiyangshengEntity sijiyangsheng, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(sijiyangsheng);
        sijiyangshengService.insert(sijiyangsheng);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SijiyangshengEntity sijiyangsheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sijiyangsheng);
        sijiyangshengService.updateById(sijiyangsheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        sijiyangshengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,SijiyangshengEntity sijiyangsheng, HttpServletRequest request,String pre){
        EntityWrapper<SijiyangshengEntity> ew = new EntityWrapper<SijiyangshengEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = sijiyangshengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sijiyangsheng), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,SijiyangshengEntity sijiyangsheng, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "sijifenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "sijiyangsheng").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<SijiyangshengEntity> sijiyangshengList = new ArrayList<SijiyangshengEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                sijiyangshengList.addAll(sijiyangshengService.selectList(new EntityWrapper<SijiyangshengEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<SijiyangshengEntity> ew = new EntityWrapper<SijiyangshengEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = sijiyangshengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sijiyangsheng), params), params));
        List<SijiyangshengEntity> pageList = (List<SijiyangshengEntity>)page.getList();
        if(sijiyangshengList.size()<limit) {
            int toAddNum = (limit-sijiyangshengList.size())<=pageList.size()?(limit-sijiyangshengList.size()):pageList.size();
            for(SijiyangshengEntity o1 : pageList) {
                boolean addFlag = true;
                for(SijiyangshengEntity o2 : sijiyangshengList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    sijiyangshengList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(sijiyangshengList.size()>limit) {
            sijiyangshengList = sijiyangshengList.subList(0, limit);
        }
        page.setList(sijiyangshengList);
        return R.ok().put("data", page);
    }








}
