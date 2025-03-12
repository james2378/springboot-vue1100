package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YinshileixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YinshileixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YinshileixingView;


/**
 * 饮食类型
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
public interface YinshileixingService extends IService<YinshileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinshileixingVO> selectListVO(Wrapper<YinshileixingEntity> wrapper);
   	
   	YinshileixingVO selectVO(@Param("ew") Wrapper<YinshileixingEntity> wrapper);
   	
   	List<YinshileixingView> selectListView(Wrapper<YinshileixingEntity> wrapper);
   	
   	YinshileixingView selectView(@Param("ew") Wrapper<YinshileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinshileixingEntity> wrapper);

   	

}

