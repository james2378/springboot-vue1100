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


import com.dao.DiscussyangshengchanpinDao;
import com.entity.DiscussyangshengchanpinEntity;
import com.service.DiscussyangshengchanpinService;
import com.entity.vo.DiscussyangshengchanpinVO;
import com.entity.view.DiscussyangshengchanpinView;

@Service("discussyangshengchanpinService")
public class DiscussyangshengchanpinServiceImpl extends ServiceImpl<DiscussyangshengchanpinDao, DiscussyangshengchanpinEntity> implements DiscussyangshengchanpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyangshengchanpinEntity> page = this.selectPage(
                new Query<DiscussyangshengchanpinEntity>(params).getPage(),
                new EntityWrapper<DiscussyangshengchanpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyangshengchanpinEntity> wrapper) {
		  Page<DiscussyangshengchanpinView> page =new Query<DiscussyangshengchanpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussyangshengchanpinVO> selectListVO(Wrapper<DiscussyangshengchanpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyangshengchanpinVO selectVO(Wrapper<DiscussyangshengchanpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyangshengchanpinView> selectListView(Wrapper<DiscussyangshengchanpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyangshengchanpinView selectView(Wrapper<DiscussyangshengchanpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
