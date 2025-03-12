package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YangshengzhishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YangshengzhishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YangshengzhishiView;


/**
 * 养生知识
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
public interface YangshengzhishiService extends IService<YangshengzhishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YangshengzhishiVO> selectListVO(Wrapper<YangshengzhishiEntity> wrapper);
   	
   	YangshengzhishiVO selectVO(@Param("ew") Wrapper<YangshengzhishiEntity> wrapper);
   	
   	List<YangshengzhishiView> selectListView(Wrapper<YangshengzhishiEntity> wrapper);
   	
   	YangshengzhishiView selectView(@Param("ew") Wrapper<YangshengzhishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YangshengzhishiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YangshengzhishiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YangshengzhishiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YangshengzhishiEntity> wrapper);



}

