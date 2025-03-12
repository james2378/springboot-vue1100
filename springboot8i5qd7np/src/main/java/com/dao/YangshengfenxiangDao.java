package com.dao;

import com.entity.YangshengfenxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YangshengfenxiangVO;
import com.entity.view.YangshengfenxiangView;


/**
 * 养生分享
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
public interface YangshengfenxiangDao extends BaseMapper<YangshengfenxiangEntity> {
	
	List<YangshengfenxiangVO> selectListVO(@Param("ew") Wrapper<YangshengfenxiangEntity> wrapper);
	
	YangshengfenxiangVO selectVO(@Param("ew") Wrapper<YangshengfenxiangEntity> wrapper);
	
	List<YangshengfenxiangView> selectListView(@Param("ew") Wrapper<YangshengfenxiangEntity> wrapper);

	List<YangshengfenxiangView> selectListView(Pagination page,@Param("ew") Wrapper<YangshengfenxiangEntity> wrapper);

	
	YangshengfenxiangView selectView(@Param("ew") Wrapper<YangshengfenxiangEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YangshengfenxiangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YangshengfenxiangEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YangshengfenxiangEntity> wrapper);



}
