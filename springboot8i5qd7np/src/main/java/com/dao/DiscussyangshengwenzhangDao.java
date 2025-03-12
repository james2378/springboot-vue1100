package com.dao;

import com.entity.DiscussyangshengwenzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyangshengwenzhangVO;
import com.entity.view.DiscussyangshengwenzhangView;


/**
 * 养生文章评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
public interface DiscussyangshengwenzhangDao extends BaseMapper<DiscussyangshengwenzhangEntity> {
	
	List<DiscussyangshengwenzhangVO> selectListVO(@Param("ew") Wrapper<DiscussyangshengwenzhangEntity> wrapper);
	
	DiscussyangshengwenzhangVO selectVO(@Param("ew") Wrapper<DiscussyangshengwenzhangEntity> wrapper);
	
	List<DiscussyangshengwenzhangView> selectListView(@Param("ew") Wrapper<DiscussyangshengwenzhangEntity> wrapper);

	List<DiscussyangshengwenzhangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyangshengwenzhangEntity> wrapper);

	
	DiscussyangshengwenzhangView selectView(@Param("ew") Wrapper<DiscussyangshengwenzhangEntity> wrapper);
	

}
