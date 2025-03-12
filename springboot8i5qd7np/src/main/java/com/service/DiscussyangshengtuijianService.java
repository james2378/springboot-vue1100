package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyangshengtuijianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyangshengtuijianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyangshengtuijianView;


/**
 * 养生推荐评论表
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
public interface DiscussyangshengtuijianService extends IService<DiscussyangshengtuijianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyangshengtuijianVO> selectListVO(Wrapper<DiscussyangshengtuijianEntity> wrapper);
   	
   	DiscussyangshengtuijianVO selectVO(@Param("ew") Wrapper<DiscussyangshengtuijianEntity> wrapper);
   	
   	List<DiscussyangshengtuijianView> selectListView(Wrapper<DiscussyangshengtuijianEntity> wrapper);
   	
   	DiscussyangshengtuijianView selectView(@Param("ew") Wrapper<DiscussyangshengtuijianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyangshengtuijianEntity> wrapper);

   	

}

