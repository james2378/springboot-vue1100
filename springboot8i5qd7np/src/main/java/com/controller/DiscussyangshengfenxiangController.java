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

import com.entity.DiscussyangshengfenxiangEntity;
import com.entity.view.DiscussyangshengfenxiangView;

import com.service.DiscussyangshengfenxiangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 养生分享评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
@RestController
@RequestMapping("/discussyangshengfenxiang")
public class DiscussyangshengfenxiangController {
    @Autowired
    private DiscussyangshengfenxiangService discussyangshengfenxiangService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussyangshengfenxiangEntity discussyangshengfenxiang,
		HttpServletRequest request){
        EntityWrapper<DiscussyangshengfenxiangEntity> ew = new EntityWrapper<DiscussyangshengfenxiangEntity>();

		PageUtils page = discussyangshengfenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyangshengfenxiang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussyangshengfenxiangEntity discussyangshengfenxiang, 
		HttpServletRequest request){
        EntityWrapper<DiscussyangshengfenxiangEntity> ew = new EntityWrapper<DiscussyangshengfenxiangEntity>();

		PageUtils page = discussyangshengfenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyangshengfenxiang), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussyangshengfenxiangEntity discussyangshengfenxiang){
       	EntityWrapper<DiscussyangshengfenxiangEntity> ew = new EntityWrapper<DiscussyangshengfenxiangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussyangshengfenxiang, "discussyangshengfenxiang")); 
        return R.ok().put("data", discussyangshengfenxiangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussyangshengfenxiangEntity discussyangshengfenxiang){
        EntityWrapper< DiscussyangshengfenxiangEntity> ew = new EntityWrapper< DiscussyangshengfenxiangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussyangshengfenxiang, "discussyangshengfenxiang")); 
		DiscussyangshengfenxiangView discussyangshengfenxiangView =  discussyangshengfenxiangService.selectView(ew);
		return R.ok("查询养生分享评论表成功").put("data", discussyangshengfenxiangView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussyangshengfenxiangEntity discussyangshengfenxiang = discussyangshengfenxiangService.selectById(id);
        return R.ok().put("data", discussyangshengfenxiang);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussyangshengfenxiangEntity discussyangshengfenxiang = discussyangshengfenxiangService.selectById(id);
        return R.ok().put("data", discussyangshengfenxiang);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussyangshengfenxiangEntity discussyangshengfenxiang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussyangshengfenxiang);
        discussyangshengfenxiangService.insert(discussyangshengfenxiang);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussyangshengfenxiangEntity discussyangshengfenxiang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussyangshengfenxiang);
        discussyangshengfenxiangService.insert(discussyangshengfenxiang);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussyangshengfenxiangEntity discussyangshengfenxiang = discussyangshengfenxiangService.selectOne(new EntityWrapper<DiscussyangshengfenxiangEntity>().eq("", username));
        return R.ok().put("data", discussyangshengfenxiang);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussyangshengfenxiangEntity discussyangshengfenxiang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyangshengfenxiang);
        discussyangshengfenxiangService.updateById(discussyangshengfenxiang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussyangshengfenxiangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussyangshengfenxiangEntity discussyangshengfenxiang, HttpServletRequest request,String pre){
        EntityWrapper<DiscussyangshengfenxiangEntity> ew = new EntityWrapper<DiscussyangshengfenxiangEntity>();
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
		PageUtils page = discussyangshengfenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyangshengfenxiang), params), params));
        return R.ok().put("data", page);
    }










}
