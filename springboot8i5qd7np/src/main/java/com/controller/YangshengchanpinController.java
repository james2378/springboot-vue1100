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

import com.entity.YangshengchanpinEntity;
import com.entity.view.YangshengchanpinView;

import com.service.YangshengchanpinService;
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
 * 养生产品
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 17:19:24
 */
@RestController
@RequestMapping("/yangshengchanpin")
public class YangshengchanpinController {
    @Autowired
    private YangshengchanpinService yangshengchanpinService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YangshengchanpinEntity yangshengchanpin,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<YangshengchanpinEntity> ew = new EntityWrapper<YangshengchanpinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = yangshengchanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangshengchanpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YangshengchanpinEntity yangshengchanpin, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<YangshengchanpinEntity> ew = new EntityWrapper<YangshengchanpinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = yangshengchanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangshengchanpin), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YangshengchanpinEntity yangshengchanpin){
       	EntityWrapper<YangshengchanpinEntity> ew = new EntityWrapper<YangshengchanpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yangshengchanpin, "yangshengchanpin")); 
        return R.ok().put("data", yangshengchanpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YangshengchanpinEntity yangshengchanpin){
        EntityWrapper< YangshengchanpinEntity> ew = new EntityWrapper< YangshengchanpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yangshengchanpin, "yangshengchanpin")); 
		YangshengchanpinView yangshengchanpinView =  yangshengchanpinService.selectView(ew);
		return R.ok("查询养生产品成功").put("data", yangshengchanpinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YangshengchanpinEntity yangshengchanpin = yangshengchanpinService.selectById(id);
		yangshengchanpin.setClicknum(yangshengchanpin.getClicknum()+1);
		yangshengchanpin.setClicktime(new Date());
		yangshengchanpinService.updateById(yangshengchanpin);
        yangshengchanpin = yangshengchanpinService.selectView(new EntityWrapper<YangshengchanpinEntity>().eq("id", id));
        return R.ok().put("data", yangshengchanpin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YangshengchanpinEntity yangshengchanpin = yangshengchanpinService.selectById(id);
		yangshengchanpin.setClicknum(yangshengchanpin.getClicknum()+1);
		yangshengchanpin.setClicktime(new Date());
		yangshengchanpinService.updateById(yangshengchanpin);
        yangshengchanpin = yangshengchanpinService.selectView(new EntityWrapper<YangshengchanpinEntity>().eq("id", id));
        return R.ok().put("data", yangshengchanpin);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YangshengchanpinEntity yangshengchanpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yangshengchanpin);
        yangshengchanpinService.insert(yangshengchanpin);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YangshengchanpinEntity yangshengchanpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yangshengchanpin);
        yangshengchanpinService.insert(yangshengchanpin);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YangshengchanpinEntity yangshengchanpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yangshengchanpin);
        yangshengchanpinService.updateById(yangshengchanpin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yangshengchanpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YangshengchanpinEntity yangshengchanpin, HttpServletRequest request,String pre){
        EntityWrapper<YangshengchanpinEntity> ew = new EntityWrapper<YangshengchanpinEntity>();
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
		PageUtils page = yangshengchanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangshengchanpin), params), params));
        return R.ok().put("data", page);
    }










}
