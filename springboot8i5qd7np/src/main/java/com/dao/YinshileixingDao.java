package com.dao;

import com.entity.YinshileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YinshileixingVO;
import com.entity.view.YinshileixingView;


/**
 * 饮食类型
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
public interface YinshileixingDao extends BaseMapper<YinshileixingEntity> {
	
	List<YinshileixingVO> selectListVO(@Param("ew") Wrapper<YinshileixingEntity> wrapper);
	
	YinshileixingVO selectVO(@Param("ew") Wrapper<YinshileixingEntity> wrapper);
	
	List<YinshileixingView> selectListView(@Param("ew") Wrapper<YinshileixingEntity> wrapper);

	List<YinshileixingView> selectListView(Pagination page,@Param("ew") Wrapper<YinshileixingEntity> wrapper);

	
	YinshileixingView selectView(@Param("ew") Wrapper<YinshileixingEntity> wrapper);
	

}
