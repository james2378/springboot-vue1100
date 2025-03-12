package com.dao;

import com.entity.YangshengzhishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YangshengzhishiVO;
import com.entity.view.YangshengzhishiView;


/**
 * 养生知识
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
public interface YangshengzhishiDao extends BaseMapper<YangshengzhishiEntity> {
	
	List<YangshengzhishiVO> selectListVO(@Param("ew") Wrapper<YangshengzhishiEntity> wrapper);
	
	YangshengzhishiVO selectVO(@Param("ew") Wrapper<YangshengzhishiEntity> wrapper);
	
	List<YangshengzhishiView> selectListView(@Param("ew") Wrapper<YangshengzhishiEntity> wrapper);

	List<YangshengzhishiView> selectListView(Pagination page,@Param("ew") Wrapper<YangshengzhishiEntity> wrapper);

	
	YangshengzhishiView selectView(@Param("ew") Wrapper<YangshengzhishiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YangshengzhishiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YangshengzhishiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YangshengzhishiEntity> wrapper);



}
