package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusssijiyangshengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusssijiyangshengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusssijiyangshengView;


/**
 * 四季养生评论表
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
public interface DiscusssijiyangshengService extends IService<DiscusssijiyangshengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusssijiyangshengVO> selectListVO(Wrapper<DiscusssijiyangshengEntity> wrapper);
   	
   	DiscusssijiyangshengVO selectVO(@Param("ew") Wrapper<DiscusssijiyangshengEntity> wrapper);
   	
   	List<DiscusssijiyangshengView> selectListView(Wrapper<DiscusssijiyangshengEntity> wrapper);
   	
   	DiscusssijiyangshengView selectView(@Param("ew") Wrapper<DiscusssijiyangshengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusssijiyangshengEntity> wrapper);

   	

}

