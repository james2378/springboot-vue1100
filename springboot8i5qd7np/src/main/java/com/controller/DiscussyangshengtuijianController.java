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

import com.entity.DiscussyangshengtuijianEntity;
import com.entity.view.DiscussyangshengtuijianView;

import com.service.DiscussyangshengtuijianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 养生推荐评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
@RestController
@RequestMapping("/discussyangshengtuijian")
public class DiscussyangshengtuijianController {
    @Autowired
    private DiscussyangshengtuijianService discussyangshengtuijianService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussyangshengtuijianEntity discussyangshengtuijian,
		HttpServletRequest request){
        EntityWrapper<DiscussyangshengtuijianEntity> ew = new EntityWrapper<DiscussyangshengtuijianEntity>();

		PageUtils page = discussyangshengtuijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyangshengtuijian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussyangshengtuijianEntity discussyangshengtuijian, 
		HttpServletRequest request){
        EntityWrapper<DiscussyangshengtuijianEntity> ew = new EntityWrapper<DiscussyangshengtuijianEntity>();

		PageUtils page = discussyangshengtuijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyangshengtuijian), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussyangshengtuijianEntity discussyangshengtuijian){
       	EntityWrapper<DiscussyangshengtuijianEntity> ew = new EntityWrapper<DiscussyangshengtuijianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussyangshengtuijian, "discussyangshengtuijian")); 
        return R.ok().put("data", discussyangshengtuijianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussyangshengtuijianEntity discussyangshengtuijian){
        EntityWrapper< DiscussyangshengtuijianEntity> ew = new EntityWrapper< DiscussyangshengtuijianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussyangshengtuijian, "discussyangshengtuijian")); 
		DiscussyangshengtuijianView discussyangshengtuijianView =  discussyangshengtuijianService.selectView(ew);
		return R.ok("查询养生推荐评论表成功").put("data", discussyangshengtuijianView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussyangshengtuijianEntity discussyangshengtuijian = discussyangshengtuijianService.selectById(id);
        return R.ok().put("data", discussyangshengtuijian);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussyangshengtuijianEntity discussyangshengtuijian = discussyangshengtuijianService.selectById(id);
        return R.ok().put("data", discussyangshengtuijian);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussyangshengtuijianEntity discussyangshengtuijian, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussyangshengtuijian);
        discussyangshengtuijianService.insert(discussyangshengtuijian);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussyangshengtuijianEntity discussyangshengtuijian, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussyangshengtuijian);
        discussyangshengtuijianService.insert(discussyangshengtuijian);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussyangshengtuijianEntity discussyangshengtuijian = discussyangshengtuijianService.selectOne(new EntityWrapper<DiscussyangshengtuijianEntity>().eq("", username));
        return R.ok().put("data", discussyangshengtuijian);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussyangshengtuijianEntity discussyangshengtuijian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyangshengtuijian);
        discussyangshengtuijianService.updateById(discussyangshengtuijian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussyangshengtuijianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussyangshengtuijianEntity discussyangshengtuijian, HttpServletRequest request,String pre){
        EntityWrapper<DiscussyangshengtuijianEntity> ew = new EntityWrapper<DiscussyangshengtuijianEntity>();
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
		PageUtils page = discussyangshengtuijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyangshengtuijian), params), params));
        return R.ok().put("data", page);
    }










}
