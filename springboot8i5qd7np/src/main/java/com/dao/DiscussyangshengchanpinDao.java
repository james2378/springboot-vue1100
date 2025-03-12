package com.dao;

import com.entity.DiscussyangshengchanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyangshengchanpinVO;
import com.entity.view.DiscussyangshengchanpinView;


/**
 * 养生产品评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
public interface DiscussyangshengchanpinDao extends BaseMapper<DiscussyangshengchanpinEntity> {
	
	List<DiscussyangshengchanpinVO> selectListVO(@Param("ew") Wrapper<DiscussyangshengchanpinEntity> wrapper);
	
	DiscussyangshengchanpinVO selectVO(@Param("ew") Wrapper<DiscussyangshengchanpinEntity> wrapper);
	
	List<DiscussyangshengchanpinView> selectListView(@Param("ew") Wrapper<DiscussyangshengchanpinEntity> wrapper);

	List<DiscussyangshengchanpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyangshengchanpinEntity> wrapper);

	
	DiscussyangshengchanpinView selectView(@Param("ew") Wrapper<DiscussyangshengchanpinEntity> wrapper);
	

}
