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


import com.dao.DiscusssijiyangshengDao;
import com.entity.DiscusssijiyangshengEntity;
import com.service.DiscusssijiyangshengService;
import com.entity.vo.DiscusssijiyangshengVO;
import com.entity.view.DiscusssijiyangshengView;

@Service("discusssijiyangshengService")
public class DiscusssijiyangshengServiceImpl extends ServiceImpl<DiscusssijiyangshengDao, DiscusssijiyangshengEntity> implements DiscusssijiyangshengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusssijiyangshengEntity> page = this.selectPage(
                new Query<DiscusssijiyangshengEntity>(params).getPage(),
                new EntityWrapper<DiscusssijiyangshengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusssijiyangshengEntity> wrapper) {
		  Page<DiscusssijiyangshengView> page =new Query<DiscusssijiyangshengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusssijiyangshengVO> selectListVO(Wrapper<DiscusssijiyangshengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusssijiyangshengVO selectVO(Wrapper<DiscusssijiyangshengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusssijiyangshengView> selectListView(Wrapper<DiscusssijiyangshengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusssijiyangshengView selectView(Wrapper<DiscusssijiyangshengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
