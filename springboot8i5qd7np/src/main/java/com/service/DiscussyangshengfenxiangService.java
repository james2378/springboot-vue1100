package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyangshengfenxiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyangshengfenxiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyangshengfenxiangView;


/**
 * 养生分享评论表
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
public interface DiscussyangshengfenxiangService extends IService<DiscussyangshengfenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyangshengfenxiangVO> selectListVO(Wrapper<DiscussyangshengfenxiangEntity> wrapper);
   	
   	DiscussyangshengfenxiangVO selectVO(@Param("ew") Wrapper<DiscussyangshengfenxiangEntity> wrapper);
   	
   	List<DiscussyangshengfenxiangView> selectListView(Wrapper<DiscussyangshengfenxiangEntity> wrapper);
   	
   	DiscussyangshengfenxiangView selectView(@Param("ew") Wrapper<DiscussyangshengfenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyangshengfenxiangEntity> wrapper);

   	

}

