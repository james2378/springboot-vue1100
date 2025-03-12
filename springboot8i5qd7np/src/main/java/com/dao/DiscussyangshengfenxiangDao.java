package com.dao;

import com.entity.DiscussyangshengfenxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyangshengfenxiangVO;
import com.entity.view.DiscussyangshengfenxiangView;


/**
 * 养生分享评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
public interface DiscussyangshengfenxiangDao extends BaseMapper<DiscussyangshengfenxiangEntity> {
	
	List<DiscussyangshengfenxiangVO> selectListVO(@Param("ew") Wrapper<DiscussyangshengfenxiangEntity> wrapper);
	
	DiscussyangshengfenxiangVO selectVO(@Param("ew") Wrapper<DiscussyangshengfenxiangEntity> wrapper);
	
	List<DiscussyangshengfenxiangView> selectListView(@Param("ew") Wrapper<DiscussyangshengfenxiangEntity> wrapper);

	List<DiscussyangshengfenxiangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyangshengfenxiangEntity> wrapper);

	
	DiscussyangshengfenxiangView selectView(@Param("ew") Wrapper<DiscussyangshengfenxiangEntity> wrapper);
	

}
