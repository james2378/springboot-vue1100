package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SijifenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SijifenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SijifenleiView;


/**
 * 四季分类
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:24
 */
public interface SijifenleiService extends IService<SijifenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SijifenleiVO> selectListVO(Wrapper<SijifenleiEntity> wrapper);
   	
   	SijifenleiVO selectVO(@Param("ew") Wrapper<SijifenleiEntity> wrapper);
   	
   	List<SijifenleiView> selectListView(Wrapper<SijifenleiEntity> wrapper);
   	
   	SijifenleiView selectView(@Param("ew") Wrapper<SijifenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SijifenleiEntity> wrapper);

   	

}

