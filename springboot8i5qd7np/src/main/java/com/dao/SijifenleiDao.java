package com.dao;

import com.entity.SijifenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SijifenleiVO;
import com.entity.view.SijifenleiView;


/**
 * 四季分类
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:24
 */
public interface SijifenleiDao extends BaseMapper<SijifenleiEntity> {
	
	List<SijifenleiVO> selectListVO(@Param("ew") Wrapper<SijifenleiEntity> wrapper);
	
	SijifenleiVO selectVO(@Param("ew") Wrapper<SijifenleiEntity> wrapper);
	
	List<SijifenleiView> selectListView(@Param("ew") Wrapper<SijifenleiEntity> wrapper);

	List<SijifenleiView> selectListView(Pagination page,@Param("ew") Wrapper<SijifenleiEntity> wrapper);

	
	SijifenleiView selectView(@Param("ew") Wrapper<SijifenleiEntity> wrapper);
	

}
