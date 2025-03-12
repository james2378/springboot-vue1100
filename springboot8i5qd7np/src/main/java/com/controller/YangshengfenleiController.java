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

import com.entity.YangshengfenleiEntity;
import com.entity.view.YangshengfenleiView;

import com.service.YangshengfenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 养生分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
@RestController
@RequestMapping("/yangshengfenlei")
public class YangshengfenleiController {
    @Autowired
    private YangshengfenleiService yangshengfenleiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YangshengfenleiEntity yangshengfenlei,
		HttpServletRequest request){
        EntityWrapper<YangshengfenleiEntity> ew = new EntityWrapper<YangshengfenleiEntity>();

		PageUtils page = yangshengfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangshengfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YangshengfenleiEntity yangshengfenlei, 
		HttpServletRequest request){
        EntityWrapper<YangshengfenleiEntity> ew = new EntityWrapper<YangshengfenleiEntity>();

		PageUtils page = yangshengfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangshengfenlei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YangshengfenleiEntity yangshengfenlei){
       	EntityWrapper<YangshengfenleiEntity> ew = new EntityWrapper<YangshengfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yangshengfenlei, "yangshengfenlei")); 
        return R.ok().put("data", yangshengfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YangshengfenleiEntity yangshengfenlei){
        EntityWrapper< YangshengfenleiEntity> ew = new EntityWrapper< YangshengfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yangshengfenlei, "yangshengfenlei")); 
		YangshengfenleiView yangshengfenleiView =  yangshengfenleiService.selectView(ew);
		return R.ok("查询养生分类成功").put("data", yangshengfenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YangshengfenleiEntity yangshengfenlei = yangshengfenleiService.selectById(id);
        return R.ok().put("data", yangshengfenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YangshengfenleiEntity yangshengfenlei = yangshengfenleiService.selectById(id);
        return R.ok().put("data", yangshengfenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YangshengfenleiEntity yangshengfenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yangshengfenlei);
        yangshengfenleiService.insert(yangshengfenlei);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YangshengfenleiEntity yangshengfenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yangshengfenlei);
        yangshengfenleiService.insert(yangshengfenlei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YangshengfenleiEntity yangshengfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yangshengfenlei);
        yangshengfenleiService.updateById(yangshengfenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yangshengfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
