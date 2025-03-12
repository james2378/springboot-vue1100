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


import com.dao.YangshengzhishiDao;
import com.entity.YangshengzhishiEntity;
import com.service.YangshengzhishiService;
import com.entity.vo.YangshengzhishiVO;
import com.entity.view.YangshengzhishiView;

@Service("yangshengzhishiService")
public class YangshengzhishiServiceImpl extends ServiceImpl<YangshengzhishiDao, YangshengzhishiEntity> implements YangshengzhishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YangshengzhishiEntity> page = this.selectPage(
                new Query<YangshengzhishiEntity>(params).getPage(),
                new EntityWrapper<YangshengzhishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YangshengzhishiEntity> wrapper) {
		  Page<YangshengzhishiView> page =new Query<YangshengzhishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YangshengzhishiVO> selectListVO(Wrapper<YangshengzhishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YangshengzhishiVO selectVO(Wrapper<YangshengzhishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YangshengzhishiView> selectListView(Wrapper<YangshengzhishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YangshengzhishiView selectView(Wrapper<YangshengzhishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YangshengzhishiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YangshengzhishiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YangshengzhishiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
