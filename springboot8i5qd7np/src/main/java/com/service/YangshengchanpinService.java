package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YangshengchanpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YangshengchanpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YangshengchanpinView;


/**
 * 养生产品
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:24
 */
public interface YangshengchanpinService extends IService<YangshengchanpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YangshengchanpinVO> selectListVO(Wrapper<YangshengchanpinEntity> wrapper);
   	
   	YangshengchanpinVO selectVO(@Param("ew") Wrapper<YangshengchanpinEntity> wrapper);
   	
   	List<YangshengchanpinView> selectListView(Wrapper<YangshengchanpinEntity> wrapper);
   	
   	YangshengchanpinView selectView(@Param("ew") Wrapper<YangshengchanpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YangshengchanpinEntity> wrapper);

   	

}

