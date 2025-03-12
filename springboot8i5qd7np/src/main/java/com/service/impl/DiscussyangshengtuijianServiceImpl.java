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


import com.dao.DiscussyangshengtuijianDao;
import com.entity.DiscussyangshengtuijianEntity;
import com.service.DiscussyangshengtuijianService;
import com.entity.vo.DiscussyangshengtuijianVO;
import com.entity.view.DiscussyangshengtuijianView;

@Service("discussyangshengtuijianService")
public class DiscussyangshengtuijianServiceImpl extends ServiceImpl<DiscussyangshengtuijianDao, DiscussyangshengtuijianEntity> implements DiscussyangshengtuijianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyangshengtuijianEntity> page = this.selectPage(
                new Query<DiscussyangshengtuijianEntity>(params).getPage(),
                new EntityWrapper<DiscussyangshengtuijianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyangshengtuijianEntity> wrapper) {
		  Page<DiscussyangshengtuijianView> page =new Query<DiscussyangshengtuijianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussyangshengtuijianVO> selectListVO(Wrapper<DiscussyangshengtuijianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyangshengtuijianVO selectVO(Wrapper<DiscussyangshengtuijianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyangshengtuijianView> selectListView(Wrapper<DiscussyangshengtuijianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyangshengtuijianView selectView(Wrapper<DiscussyangshengtuijianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
