package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyangshengchanpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyangshengchanpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyangshengchanpinView;


/**
 * 养生产品评论表
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
public interface DiscussyangshengchanpinService extends IService<DiscussyangshengchanpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyangshengchanpinVO> selectListVO(Wrapper<DiscussyangshengchanpinEntity> wrapper);
   	
   	DiscussyangshengchanpinVO selectVO(@Param("ew") Wrapper<DiscussyangshengchanpinEntity> wrapper);
   	
   	List<DiscussyangshengchanpinView> selectListView(Wrapper<DiscussyangshengchanpinEntity> wrapper);
   	
   	DiscussyangshengchanpinView selectView(@Param("ew") Wrapper<DiscussyangshengchanpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyangshengchanpinEntity> wrapper);

   	

}

