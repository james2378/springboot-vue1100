package com.dao;

import com.entity.DiscussyangshengzhishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyangshengzhishiVO;
import com.entity.view.DiscussyangshengzhishiView;


/**
 * 养生知识评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
public interface DiscussyangshengzhishiDao extends BaseMapper<DiscussyangshengzhishiEntity> {
	
	List<DiscussyangshengzhishiVO> selectListVO(@Param("ew") Wrapper<DiscussyangshengzhishiEntity> wrapper);
	
	DiscussyangshengzhishiVO selectVO(@Param("ew") Wrapper<DiscussyangshengzhishiEntity> wrapper);
	
	List<DiscussyangshengzhishiView> selectListView(@Param("ew") Wrapper<DiscussyangshengzhishiEntity> wrapper);

	List<DiscussyangshengzhishiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyangshengzhishiEntity> wrapper);

	
	DiscussyangshengzhishiView selectView(@Param("ew") Wrapper<DiscussyangshengzhishiEntity> wrapper);
	

}
