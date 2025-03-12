package com.dao;

import com.entity.YangshengfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YangshengfenleiVO;
import com.entity.view.YangshengfenleiView;


/**
 * 养生分类
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
public interface YangshengfenleiDao extends BaseMapper<YangshengfenleiEntity> {
	
	List<YangshengfenleiVO> selectListVO(@Param("ew") Wrapper<YangshengfenleiEntity> wrapper);
	
	YangshengfenleiVO selectVO(@Param("ew") Wrapper<YangshengfenleiEntity> wrapper);
	
	List<YangshengfenleiView> selectListView(@Param("ew") Wrapper<YangshengfenleiEntity> wrapper);

	List<YangshengfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<YangshengfenleiEntity> wrapper);

	
	YangshengfenleiView selectView(@Param("ew") Wrapper<YangshengfenleiEntity> wrapper);
	

}
