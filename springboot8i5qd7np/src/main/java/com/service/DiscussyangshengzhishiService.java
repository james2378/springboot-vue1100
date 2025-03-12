package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyangshengzhishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyangshengzhishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyangshengzhishiView;


/**
 * 养生知识评论表
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
public interface DiscussyangshengzhishiService extends IService<DiscussyangshengzhishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyangshengzhishiVO> selectListVO(Wrapper<DiscussyangshengzhishiEntity> wrapper);
   	
   	DiscussyangshengzhishiVO selectVO(@Param("ew") Wrapper<DiscussyangshengzhishiEntity> wrapper);
   	
   	List<DiscussyangshengzhishiView> selectListView(Wrapper<DiscussyangshengzhishiEntity> wrapper);
   	
   	DiscussyangshengzhishiView selectView(@Param("ew") Wrapper<DiscussyangshengzhishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyangshengzhishiEntity> wrapper);

   	

}

