package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyangshengwenzhangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyangshengwenzhangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyangshengwenzhangView;


/**
 * 养生文章评论表
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
public interface DiscussyangshengwenzhangService extends IService<DiscussyangshengwenzhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyangshengwenzhangVO> selectListVO(Wrapper<DiscussyangshengwenzhangEntity> wrapper);
   	
   	DiscussyangshengwenzhangVO selectVO(@Param("ew") Wrapper<DiscussyangshengwenzhangEntity> wrapper);
   	
   	List<DiscussyangshengwenzhangView> selectListView(Wrapper<DiscussyangshengwenzhangEntity> wrapper);
   	
   	DiscussyangshengwenzhangView selectView(@Param("ew") Wrapper<DiscussyangshengwenzhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyangshengwenzhangEntity> wrapper);

   	

}

