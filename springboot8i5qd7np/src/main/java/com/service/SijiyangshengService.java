package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SijiyangshengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SijiyangshengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SijiyangshengView;


/**
 * 四季养生
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:24
 */
public interface SijiyangshengService extends IService<SijiyangshengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SijiyangshengVO> selectListVO(Wrapper<SijiyangshengEntity> wrapper);
   	
   	SijiyangshengVO selectVO(@Param("ew") Wrapper<SijiyangshengEntity> wrapper);
   	
   	List<SijiyangshengView> selectListView(Wrapper<SijiyangshengEntity> wrapper);
   	
   	SijiyangshengView selectView(@Param("ew") Wrapper<SijiyangshengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SijiyangshengEntity> wrapper);

   	

}

