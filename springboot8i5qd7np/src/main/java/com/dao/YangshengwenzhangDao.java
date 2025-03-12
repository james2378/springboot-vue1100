package com.dao;

import com.entity.YangshengwenzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YangshengwenzhangVO;
import com.entity.view.YangshengwenzhangView;


/**
 * 养生文章
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
public interface YangshengwenzhangDao extends BaseMapper<YangshengwenzhangEntity> {
	
	List<YangshengwenzhangVO> selectListVO(@Param("ew") Wrapper<YangshengwenzhangEntity> wrapper);
	
	YangshengwenzhangVO selectVO(@Param("ew") Wrapper<YangshengwenzhangEntity> wrapper);
	
	List<YangshengwenzhangView> selectListView(@Param("ew") Wrapper<YangshengwenzhangEntity> wrapper);

	List<YangshengwenzhangView> selectListView(Pagination page,@Param("ew") Wrapper<YangshengwenzhangEntity> wrapper);

	
	YangshengwenzhangView selectView(@Param("ew") Wrapper<YangshengwenzhangEntity> wrapper);
	

}
