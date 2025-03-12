package com.dao;

import com.entity.YangshengchanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YangshengchanpinVO;
import com.entity.view.YangshengchanpinView;


/**
 * 养生产品
 * 
 * @author 
 * @email 
 * @date 2024-04-09 17:19:24
 */
public interface YangshengchanpinDao extends BaseMapper<YangshengchanpinEntity> {
	
	List<YangshengchanpinVO> selectListVO(@Param("ew") Wrapper<YangshengchanpinEntity> wrapper);
	
	YangshengchanpinVO selectVO(@Param("ew") Wrapper<YangshengchanpinEntity> wrapper);
	
	List<YangshengchanpinView> selectListView(@Param("ew") Wrapper<YangshengchanpinEntity> wrapper);

	List<YangshengchanpinView> selectListView(Pagination page,@Param("ew") Wrapper<YangshengchanpinEntity> wrapper);

	
	YangshengchanpinView selectView(@Param("ew") Wrapper<YangshengchanpinEntity> wrapper);
	

}
