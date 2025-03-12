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


import com.dao.YangshengchanpinDao;
import com.entity.YangshengchanpinEntity;
import com.service.YangshengchanpinService;
import com.entity.vo.YangshengchanpinVO;
import com.entity.view.YangshengchanpinView;

@Service("yangshengchanpinService")
public class YangshengchanpinServiceImpl extends ServiceImpl<YangshengchanpinDao, YangshengchanpinEntity> implements YangshengchanpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YangshengchanpinEntity> page = this.selectPage(
                new Query<YangshengchanpinEntity>(params).getPage(),
                new EntityWrapper<YangshengchanpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YangshengchanpinEntity> wrapper) {
		  Page<YangshengchanpinView> page =new Query<YangshengchanpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YangshengchanpinVO> selectListVO(Wrapper<YangshengchanpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YangshengchanpinVO selectVO(Wrapper<YangshengchanpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YangshengchanpinView> selectListView(Wrapper<YangshengchanpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YangshengchanpinView selectView(Wrapper<YangshengchanpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
