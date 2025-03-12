package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YangshengfenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YangshengfenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YangshengfenleiView;


/**
 * 养生分类
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
public interface YangshengfenleiService extends IService<YangshengfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YangshengfenleiVO> selectListVO(Wrapper<YangshengfenleiEntity> wrapper);
   	
   	YangshengfenleiVO selectVO(@Param("ew") Wrapper<YangshengfenleiEntity> wrapper);
   	
   	List<YangshengfenleiView> selectListView(Wrapper<YangshengfenleiEntity> wrapper);
   	
   	YangshengfenleiView selectView(@Param("ew") Wrapper<YangshengfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YangshengfenleiEntity> wrapper);

   	

}

