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

import com.entity.YangshengfenxiangEntity;
import com.entity.view.YangshengfenxiangView;

import com.service.YangshengfenxiangService;
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
 * 养生分享
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
@RestController
@RequestMapping("/yangshengfenxiang")
public class YangshengfenxiangController {
    @Autowired
    private YangshengfenxiangService yangshengfenxiangService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YangshengfenxiangEntity yangshengfenxiang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yangshengfenxiang.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YangshengfenxiangEntity> ew = new EntityWrapper<YangshengfenxiangEntity>();

		PageUtils page = yangshengfenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangshengfenxiang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YangshengfenxiangEntity yangshengfenxiang, 
		HttpServletRequest request){
        EntityWrapper<YangshengfenxiangEntity> ew = new EntityWrapper<YangshengfenxiangEntity>();

		PageUtils page = yangshengfenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangshengfenxiang), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YangshengfenxiangEntity yangshengfenxiang){
       	EntityWrapper<YangshengfenxiangEntity> ew = new EntityWrapper<YangshengfenxiangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yangshengfenxiang, "yangshengfenxiang")); 
        return R.ok().put("data", yangshengfenxiangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YangshengfenxiangEntity yangshengfenxiang){
        EntityWrapper< YangshengfenxiangEntity> ew = new EntityWrapper< YangshengfenxiangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yangshengfenxiang, "yangshengfenxiang")); 
		YangshengfenxiangView yangshengfenxiangView =  yangshengfenxiangService.selectView(ew);
		return R.ok("查询养生分享成功").put("data", yangshengfenxiangView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YangshengfenxiangEntity yangshengfenxiang = yangshengfenxiangService.selectById(id);
		yangshengfenxiang.setClicknum(yangshengfenxiang.getClicknum()+1);
		yangshengfenxiang.setClicktime(new Date());
		yangshengfenxiangService.updateById(yangshengfenxiang);
        yangshengfenxiang = yangshengfenxiangService.selectView(new EntityWrapper<YangshengfenxiangEntity>().eq("id", id));
        return R.ok().put("data", yangshengfenxiang);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YangshengfenxiangEntity yangshengfenxiang = yangshengfenxiangService.selectById(id);
		yangshengfenxiang.setClicknum(yangshengfenxiang.getClicknum()+1);
		yangshengfenxiang.setClicktime(new Date());
		yangshengfenxiangService.updateById(yangshengfenxiang);
        yangshengfenxiang = yangshengfenxiangService.selectView(new EntityWrapper<YangshengfenxiangEntity>().eq("id", id));
        return R.ok().put("data", yangshengfenxiang);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        YangshengfenxiangEntity yangshengfenxiang = yangshengfenxiangService.selectById(id);
        if(type.equals("1")) {
        	yangshengfenxiang.setThumbsupnum(yangshengfenxiang.getThumbsupnum()+1);
        } else {
        	yangshengfenxiang.setCrazilynum(yangshengfenxiang.getCrazilynum()+1);
        }
        yangshengfenxiangService.updateById(yangshengfenxiang);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YangshengfenxiangEntity yangshengfenxiang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yangshengfenxiang);
        yangshengfenxiangService.insert(yangshengfenxiang);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YangshengfenxiangEntity yangshengfenxiang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yangshengfenxiang);
        yangshengfenxiangService.insert(yangshengfenxiang);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YangshengfenxiangEntity yangshengfenxiang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yangshengfenxiang);
        yangshengfenxiangService.updateById(yangshengfenxiang);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YangshengfenxiangEntity> list = new ArrayList<YangshengfenxiangEntity>();
        for(Long id : ids) {
            YangshengfenxiangEntity yangshengfenxiang = yangshengfenxiangService.selectById(id);
            yangshengfenxiang.setSfsh(sfsh);
            yangshengfenxiang.setShhf(shhf);
            list.add(yangshengfenxiang);
        }
        yangshengfenxiangService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yangshengfenxiangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YangshengfenxiangEntity yangshengfenxiang, HttpServletRequest request,String pre){
        EntityWrapper<YangshengfenxiangEntity> ew = new EntityWrapper<YangshengfenxiangEntity>();
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
		PageUtils page = yangshengfenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangshengfenxiang), params), params));
        return R.ok().put("data", page);
    }






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<YangshengfenxiangEntity> ew = new EntityWrapper<YangshengfenxiangEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = yangshengfenxiangService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<YangshengfenxiangEntity> ew = new EntityWrapper<YangshengfenxiangEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = yangshengfenxiangService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<YangshengfenxiangEntity> ew = new EntityWrapper<YangshengfenxiangEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = yangshengfenxiangService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<YangshengfenxiangEntity> ew = new EntityWrapper<YangshengfenxiangEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = yangshengfenxiangService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<YangshengfenxiangEntity> ew = new EntityWrapper<YangshengfenxiangEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = yangshengfenxiangService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,YangshengfenxiangEntity yangshengfenxiang, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            yangshengfenxiang.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<YangshengfenxiangEntity> ew = new EntityWrapper<YangshengfenxiangEntity>();
        int count = yangshengfenxiangService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangshengfenxiang), params), params));
        return R.ok().put("data", count);
    }



}
