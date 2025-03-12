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

import com.entity.YangshengwenzhangEntity;
import com.entity.view.YangshengwenzhangView;

import com.service.YangshengwenzhangService;
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
 * 养生文章
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
@RestController
@RequestMapping("/yangshengwenzhang")
public class YangshengwenzhangController {
    @Autowired
    private YangshengwenzhangService yangshengwenzhangService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YangshengwenzhangEntity yangshengwenzhang,
		HttpServletRequest request){
        EntityWrapper<YangshengwenzhangEntity> ew = new EntityWrapper<YangshengwenzhangEntity>();

		PageUtils page = yangshengwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangshengwenzhang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YangshengwenzhangEntity yangshengwenzhang, 
		HttpServletRequest request){
        EntityWrapper<YangshengwenzhangEntity> ew = new EntityWrapper<YangshengwenzhangEntity>();

		PageUtils page = yangshengwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangshengwenzhang), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YangshengwenzhangEntity yangshengwenzhang){
       	EntityWrapper<YangshengwenzhangEntity> ew = new EntityWrapper<YangshengwenzhangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yangshengwenzhang, "yangshengwenzhang")); 
        return R.ok().put("data", yangshengwenzhangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YangshengwenzhangEntity yangshengwenzhang){
        EntityWrapper< YangshengwenzhangEntity> ew = new EntityWrapper< YangshengwenzhangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yangshengwenzhang, "yangshengwenzhang")); 
		YangshengwenzhangView yangshengwenzhangView =  yangshengwenzhangService.selectView(ew);
		return R.ok("查询养生文章成功").put("data", yangshengwenzhangView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YangshengwenzhangEntity yangshengwenzhang = yangshengwenzhangService.selectById(id);
		yangshengwenzhang.setClicknum(yangshengwenzhang.getClicknum()+1);
		yangshengwenzhang.setClicktime(new Date());
		yangshengwenzhangService.updateById(yangshengwenzhang);
        yangshengwenzhang = yangshengwenzhangService.selectView(new EntityWrapper<YangshengwenzhangEntity>().eq("id", id));
        return R.ok().put("data", yangshengwenzhang);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YangshengwenzhangEntity yangshengwenzhang = yangshengwenzhangService.selectById(id);
		yangshengwenzhang.setClicknum(yangshengwenzhang.getClicknum()+1);
		yangshengwenzhang.setClicktime(new Date());
		yangshengwenzhangService.updateById(yangshengwenzhang);
        yangshengwenzhang = yangshengwenzhangService.selectView(new EntityWrapper<YangshengwenzhangEntity>().eq("id", id));
        return R.ok().put("data", yangshengwenzhang);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        YangshengwenzhangEntity yangshengwenzhang = yangshengwenzhangService.selectById(id);
        if(type.equals("1")) {
        	yangshengwenzhang.setThumbsupnum(yangshengwenzhang.getThumbsupnum()+1);
        } else {
        	yangshengwenzhang.setCrazilynum(yangshengwenzhang.getCrazilynum()+1);
        }
        yangshengwenzhangService.updateById(yangshengwenzhang);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YangshengwenzhangEntity yangshengwenzhang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yangshengwenzhang);
        yangshengwenzhangService.insert(yangshengwenzhang);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YangshengwenzhangEntity yangshengwenzhang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yangshengwenzhang);
        yangshengwenzhangService.insert(yangshengwenzhang);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YangshengwenzhangEntity yangshengwenzhang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yangshengwenzhang);
        yangshengwenzhangService.updateById(yangshengwenzhang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yangshengwenzhangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YangshengwenzhangEntity yangshengwenzhang, HttpServletRequest request,String pre){
        EntityWrapper<YangshengwenzhangEntity> ew = new EntityWrapper<YangshengwenzhangEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = yangshengwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangshengwenzhang), params), params));
        return R.ok().put("data", page);
    }










}
