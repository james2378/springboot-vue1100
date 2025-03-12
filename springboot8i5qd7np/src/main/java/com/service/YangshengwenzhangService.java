package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YangshengwenzhangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YangshengwenzhangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YangshengwenzhangView;


/**
 * 养生文章
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
public interface YangshengwenzhangService extends IService<YangshengwenzhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YangshengwenzhangVO> selectListVO(Wrapper<YangshengwenzhangEntity> wrapper);
   	
   	YangshengwenzhangVO selectVO(@Param("ew") Wrapper<YangshengwenzhangEntity> wrapper);
   	
   	List<YangshengwenzhangView> selectListView(Wrapper<YangshengwenzhangEntity> wrapper);
   	
   	YangshengwenzhangView selectView(@Param("ew") Wrapper<YangshengwenzhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YangshengwenzhangEntity> wrapper);

   	

}

