package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YangshengtuijianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YangshengtuijianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YangshengtuijianView;


/**
 * 养生推荐
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
public interface YangshengtuijianService extends IService<YangshengtuijianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YangshengtuijianVO> selectListVO(Wrapper<YangshengtuijianEntity> wrapper);
   	
   	YangshengtuijianVO selectVO(@Param("ew") Wrapper<YangshengtuijianEntity> wrapper);
   	
   	List<YangshengtuijianView> selectListView(Wrapper<YangshengtuijianEntity> wrapper);
   	
   	YangshengtuijianView selectView(@Param("ew") Wrapper<YangshengtuijianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YangshengtuijianEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YangshengtuijianEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YangshengtuijianEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YangshengtuijianEntity> wrapper);



}

