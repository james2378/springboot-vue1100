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


import com.dao.SijiyangshengDao;
import com.entity.SijiyangshengEntity;
import com.service.SijiyangshengService;
import com.entity.vo.SijiyangshengVO;
import com.entity.view.SijiyangshengView;

@Service("sijiyangshengService")
public class SijiyangshengServiceImpl extends ServiceImpl<SijiyangshengDao, SijiyangshengEntity> implements SijiyangshengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SijiyangshengEntity> page = this.selectPage(
                new Query<SijiyangshengEntity>(params).getPage(),
                new EntityWrapper<SijiyangshengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SijiyangshengEntity> wrapper) {
		  Page<SijiyangshengView> page =new Query<SijiyangshengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SijiyangshengVO> selectListVO(Wrapper<SijiyangshengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SijiyangshengVO selectVO(Wrapper<SijiyangshengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SijiyangshengView> selectListView(Wrapper<SijiyangshengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SijiyangshengView selectView(Wrapper<SijiyangshengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
