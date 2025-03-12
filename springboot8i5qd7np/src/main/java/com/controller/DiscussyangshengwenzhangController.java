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

import com.entity.DiscussyangshengwenzhangEntity;
import com.entity.view.DiscussyangshengwenzhangView;

import com.service.DiscussyangshengwenzhangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 养生文章评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
@RestController
@RequestMapping("/discussyangshengwenzhang")
public class DiscussyangshengwenzhangController {
    @Autowired
    private DiscussyangshengwenzhangService discussyangshengwenzhangService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussyangshengwenzhangEntity discussyangshengwenzhang,
		HttpServletRequest request){
        EntityWrapper<DiscussyangshengwenzhangEntity> ew = new EntityWrapper<DiscussyangshengwenzhangEntity>();

		PageUtils page = discussyangshengwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyangshengwenzhang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussyangshengwenzhangEntity discussyangshengwenzhang, 
		HttpServletRequest request){
        EntityWrapper<DiscussyangshengwenzhangEntity> ew = new EntityWrapper<DiscussyangshengwenzhangEntity>();

		PageUtils page = discussyangshengwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyangshengwenzhang), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussyangshengwenzhangEntity discussyangshengwenzhang){
       	EntityWrapper<DiscussyangshengwenzhangEntity> ew = new EntityWrapper<DiscussyangshengwenzhangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussyangshengwenzhang, "discussyangshengwenzhang")); 
        return R.ok().put("data", discussyangshengwenzhangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussyangshengwenzhangEntity discussyangshengwenzhang){
        EntityWrapper< DiscussyangshengwenzhangEntity> ew = new EntityWrapper< DiscussyangshengwenzhangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussyangshengwenzhang, "discussyangshengwenzhang")); 
		DiscussyangshengwenzhangView discussyangshengwenzhangView =  discussyangshengwenzhangService.selectView(ew);
		return R.ok("查询养生文章评论表成功").put("data", discussyangshengwenzhangView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussyangshengwenzhangEntity discussyangshengwenzhang = discussyangshengwenzhangService.selectById(id);
        return R.ok().put("data", discussyangshengwenzhang);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussyangshengwenzhangEntity discussyangshengwenzhang = discussyangshengwenzhangService.selectById(id);
        return R.ok().put("data", discussyangshengwenzhang);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussyangshengwenzhangEntity discussyangshengwenzhang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussyangshengwenzhang);
        discussyangshengwenzhangService.insert(discussyangshengwenzhang);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussyangshengwenzhangEntity discussyangshengwenzhang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussyangshengwenzhang);
        discussyangshengwenzhangService.insert(discussyangshengwenzhang);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussyangshengwenzhangEntity discussyangshengwenzhang = discussyangshengwenzhangService.selectOne(new EntityWrapper<DiscussyangshengwenzhangEntity>().eq("", username));
        return R.ok().put("data", discussyangshengwenzhang);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussyangshengwenzhangEntity discussyangshengwenzhang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyangshengwenzhang);
        discussyangshengwenzhangService.updateById(discussyangshengwenzhang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussyangshengwenzhangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussyangshengwenzhangEntity discussyangshengwenzhang, HttpServletRequest request,String pre){
        EntityWrapper<DiscussyangshengwenzhangEntity> ew = new EntityWrapper<DiscussyangshengwenzhangEntity>();
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
		PageUtils page = discussyangshengwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyangshengwenzhang), params), params));
        return R.ok().put("data", page);
    }










}
