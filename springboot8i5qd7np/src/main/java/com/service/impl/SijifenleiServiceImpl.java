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


import com.dao.SijifenleiDao;
import com.entity.SijifenleiEntity;
import com.service.SijifenleiService;
import com.entity.vo.SijifenleiVO;
import com.entity.view.SijifenleiView;

@Service("sijifenleiService")
public class SijifenleiServiceImpl extends ServiceImpl<SijifenleiDao, SijifenleiEntity> implements SijifenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SijifenleiEntity> page = this.selectPage(
                new Query<SijifenleiEntity>(params).getPage(),
                new EntityWrapper<SijifenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SijifenleiEntity> wrapper) {
		  Page<SijifenleiView> page =new Query<SijifenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SijifenleiVO> selectListVO(Wrapper<SijifenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SijifenleiVO selectVO(Wrapper<SijifenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SijifenleiView> selectListView(Wrapper<SijifenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SijifenleiView selectView(Wrapper<SijifenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
