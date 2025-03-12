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

import com.entity.TizhiceshiEntity;
import com.entity.view.TizhiceshiView;

import com.service.TizhiceshiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 体质测试
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
@RestController
@RequestMapping("/tizhiceshi")
public class TizhiceshiController {
    @Autowired
    private TizhiceshiService tizhiceshiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TizhiceshiEntity tizhiceshi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			tizhiceshi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TizhiceshiEntity> ew = new EntityWrapper<TizhiceshiEntity>();

		PageUtils page = tizhiceshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tizhiceshi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TizhiceshiEntity tizhiceshi, 
		HttpServletRequest request){
        EntityWrapper<TizhiceshiEntity> ew = new EntityWrapper<TizhiceshiEntity>();

		PageUtils page = tizhiceshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tizhiceshi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TizhiceshiEntity tizhiceshi){
       	EntityWrapper<TizhiceshiEntity> ew = new EntityWrapper<TizhiceshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tizhiceshi, "tizhiceshi")); 
        return R.ok().put("data", tizhiceshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TizhiceshiEntity tizhiceshi){
        EntityWrapper< TizhiceshiEntity> ew = new EntityWrapper< TizhiceshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tizhiceshi, "tizhiceshi")); 
		TizhiceshiView tizhiceshiView =  tizhiceshiService.selectView(ew);
		return R.ok("查询体质测试成功").put("data", tizhiceshiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TizhiceshiEntity tizhiceshi = tizhiceshiService.selectById(id);
        return R.ok().put("data", tizhiceshi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TizhiceshiEntity tizhiceshi = tizhiceshiService.selectById(id);
        return R.ok().put("data", tizhiceshi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TizhiceshiEntity tizhiceshi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tizhiceshi);
        tizhiceshiService.insert(tizhiceshi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody TizhiceshiEntity tizhiceshi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tizhiceshi);
        tizhiceshiService.insert(tizhiceshi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TizhiceshiEntity tizhiceshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tizhiceshi);
        tizhiceshiService.updateById(tizhiceshi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tizhiceshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
