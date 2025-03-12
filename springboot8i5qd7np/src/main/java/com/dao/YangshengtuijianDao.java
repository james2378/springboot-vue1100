package com.dao;

import com.entity.YangshengtuijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YangshengtuijianVO;
import com.entity.view.YangshengtuijianView;


/**
 * 养生推荐
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
public interface YangshengtuijianDao extends BaseMapper<YangshengtuijianEntity> {
	
	List<YangshengtuijianVO> selectListVO(@Param("ew") Wrapper<YangshengtuijianEntity> wrapper);
	
	YangshengtuijianVO selectVO(@Param("ew") Wrapper<YangshengtuijianEntity> wrapper);
	
	List<YangshengtuijianView> selectListView(@Param("ew") Wrapper<YangshengtuijianEntity> wrapper);

	List<YangshengtuijianView> selectListView(Pagination page,@Param("ew") Wrapper<YangshengtuijianEntity> wrapper);

	
	YangshengtuijianView selectView(@Param("ew") Wrapper<YangshengtuijianEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YangshengtuijianEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YangshengtuijianEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YangshengtuijianEntity> wrapper);



}
