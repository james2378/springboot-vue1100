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


import com.dao.DiscussyangshengzhishiDao;
import com.entity.DiscussyangshengzhishiEntity;
import com.service.DiscussyangshengzhishiService;
import com.entity.vo.DiscussyangshengzhishiVO;
import com.entity.view.DiscussyangshengzhishiView;

@Service("discussyangshengzhishiService")
public class DiscussyangshengzhishiServiceImpl extends ServiceImpl<DiscussyangshengzhishiDao, DiscussyangshengzhishiEntity> implements DiscussyangshengzhishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyangshengzhishiEntity> page = this.selectPage(
                new Query<DiscussyangshengzhishiEntity>(params).getPage(),
                new EntityWrapper<DiscussyangshengzhishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyangshengzhishiEntity> wrapper) {
		  Page<DiscussyangshengzhishiView> page =new Query<DiscussyangshengzhishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussyangshengzhishiVO> selectListVO(Wrapper<DiscussyangshengzhishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyangshengzhishiVO selectVO(Wrapper<DiscussyangshengzhishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyangshengzhishiView> selectListView(Wrapper<DiscussyangshengzhishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyangshengzhishiView selectView(Wrapper<DiscussyangshengzhishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
