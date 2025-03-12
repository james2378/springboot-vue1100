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

import com.entity.SijifenleiEntity;
import com.entity.view.SijifenleiView;

import com.service.SijifenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 四季分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 17:19:24
 */
@RestController
@RequestMapping("/sijifenlei")
public class SijifenleiController {
    @Autowired
    private SijifenleiService sijifenleiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SijifenleiEntity sijifenlei,
		HttpServletRequest request){
        EntityWrapper<SijifenleiEntity> ew = new EntityWrapper<SijifenleiEntity>();

		PageUtils page = sijifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sijifenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SijifenleiEntity sijifenlei, 
		HttpServletRequest request){
        EntityWrapper<SijifenleiEntity> ew = new EntityWrapper<SijifenleiEntity>();

		PageUtils page = sijifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sijifenlei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SijifenleiEntity sijifenlei){
       	EntityWrapper<SijifenleiEntity> ew = new EntityWrapper<SijifenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( sijifenlei, "sijifenlei")); 
        return R.ok().put("data", sijifenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SijifenleiEntity sijifenlei){
        EntityWrapper< SijifenleiEntity> ew = new EntityWrapper< SijifenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( sijifenlei, "sijifenlei")); 
		SijifenleiView sijifenleiView =  sijifenleiService.selectView(ew);
		return R.ok("查询四季分类成功").put("data", sijifenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SijifenleiEntity sijifenlei = sijifenleiService.selectById(id);
        return R.ok().put("data", sijifenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SijifenleiEntity sijifenlei = sijifenleiService.selectById(id);
        return R.ok().put("data", sijifenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SijifenleiEntity sijifenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(sijifenlei);
        sijifenleiService.insert(sijifenlei);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SijifenleiEntity sijifenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(sijifenlei);
        sijifenleiService.insert(sijifenlei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SijifenleiEntity sijifenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sijifenlei);
        sijifenleiService.updateById(sijifenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        sijifenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
