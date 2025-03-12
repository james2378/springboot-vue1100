package com.dao;

import com.entity.DiscusssijiyangshengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusssijiyangshengVO;
import com.entity.view.DiscusssijiyangshengView;


/**
 * 四季养生评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
public interface DiscusssijiyangshengDao extends BaseMapper<DiscusssijiyangshengEntity> {
	
	List<DiscusssijiyangshengVO> selectListVO(@Param("ew") Wrapper<DiscusssijiyangshengEntity> wrapper);
	
	DiscusssijiyangshengVO selectVO(@Param("ew") Wrapper<DiscusssijiyangshengEntity> wrapper);
	
	List<DiscusssijiyangshengView> selectListView(@Param("ew") Wrapper<DiscusssijiyangshengEntity> wrapper);

	List<DiscusssijiyangshengView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusssijiyangshengEntity> wrapper);

	
	DiscusssijiyangshengView selectView(@Param("ew") Wrapper<DiscusssijiyangshengEntity> wrapper);
	

}
