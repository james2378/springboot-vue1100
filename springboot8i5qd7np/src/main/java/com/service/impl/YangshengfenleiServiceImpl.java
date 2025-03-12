package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YangshengfenleiDao;
import com.entity.YangshengfenleiEntity;
import com.service.YangshengfenleiService;
import com.entity.vo.YangshengfenleiVO;
import com.entity.view.YangshengfenleiView;

@Service("yangshengfenleiService")
public class YangshengfenleiServiceImpl extends ServiceImpl<YangshengfenleiDao, YangshengfenleiEntity> implements YangshengfenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YangshengfenleiEntity> page = this.selectPage(
                new Query<YangshengfenleiEntity>(params).getPage(),
                new EntityWrapper<YangshengfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YangshengfenleiEntity> wrapper) {
		  Page<YangshengfenleiView> page =new Query<YangshengfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YangshengfenleiVO> selectListVO(Wrapper<YangshengfenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YangshengfenleiVO selectVO(Wrapper<YangshengfenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YangshengfenleiView> selectListView(Wrapper<YangshengfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YangshengfenleiView selectView(Wrapper<YangshengfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
