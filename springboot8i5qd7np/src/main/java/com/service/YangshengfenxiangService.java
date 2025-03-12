package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YangshengfenxiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YangshengfenxiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YangshengfenxiangView;


/**
 * 养生分享
 *
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
public interface YangshengfenxiangService extends IService<YangshengfenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YangshengfenxiangVO> selectListVO(Wrapper<YangshengfenxiangEntity> wrapper);
   	
   	YangshengfenxiangVO selectVO(@Param("ew") Wrapper<YangshengfenxiangEntity> wrapper);
   	
   	List<YangshengfenxiangView> selectListView(Wrapper<YangshengfenxiangEntity> wrapper);
   	
   	YangshengfenxiangView selectView(@Param("ew") Wrapper<YangshengfenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YangshengfenxiangEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YangshengfenxiangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YangshengfenxiangEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YangshengfenxiangEntity> wrapper);



}

