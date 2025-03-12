package com.dao;

import com.entity.DiscussyangshengtuijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyangshengtuijianVO;
import com.entity.view.DiscussyangshengtuijianView;


/**
 * 养生推荐评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
public interface DiscussyangshengtuijianDao extends BaseMapper<DiscussyangshengtuijianEntity> {
	
	List<DiscussyangshengtuijianVO> selectListVO(@Param("ew") Wrapper<DiscussyangshengtuijianEntity> wrapper);
	
	DiscussyangshengtuijianVO selectVO(@Param("ew") Wrapper<DiscussyangshengtuijianEntity> wrapper);
	
	List<DiscussyangshengtuijianView> selectListView(@Param("ew") Wrapper<DiscussyangshengtuijianEntity> wrapper);

	List<DiscussyangshengtuijianView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyangshengtuijianEntity> wrapper);

	
	DiscussyangshengtuijianView selectView(@Param("ew") Wrapper<DiscussyangshengtuijianEntity> wrapper);
	

}
