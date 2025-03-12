package com.dao;

import com.entity.SijiyangshengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SijiyangshengVO;
import com.entity.view.SijiyangshengView;


/**
 * 四季养生
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:24
 */
public interface SijiyangshengDao extends BaseMapper<SijiyangshengEntity> {
	
	List<SijiyangshengVO> selectListVO(@Param("ew") Wrapper<SijiyangshengEntity> wrapper);
	
	SijiyangshengVO selectVO(@Param("ew") Wrapper<SijiyangshengEntity> wrapper);
	
	List<SijiyangshengView> selectListView(@Param("ew") Wrapper<SijiyangshengEntity> wrapper);

	List<SijiyangshengView> selectListView(Pagination page,@Param("ew") Wrapper<SijiyangshengEntity> wrapper);

	
	SijiyangshengView selectView(@Param("ew") Wrapper<SijiyangshengEntity> wrapper);
	

}
