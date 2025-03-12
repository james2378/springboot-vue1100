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


import com.dao.YangshengtuijianDao;
import com.entity.YangshengtuijianEntity;
import com.service.YangshengtuijianService;
import com.entity.vo.YangshengtuijianVO;
import com.entity.view.YangshengtuijianView;

@Service("yangshengtuijianService")
public class YangshengtuijianServiceImpl extends ServiceImpl<YangshengtuijianDao, YangshengtuijianEntity> implements YangshengtuijianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YangshengtuijianEntity> page = this.selectPage(
                new Query<YangshengtuijianEntity>(params).getPage(),
                new EntityWrapper<YangshengtuijianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YangshengtuijianEntity> wrapper) {
		  Page<YangshengtuijianView> page =new Query<YangshengtuijianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YangshengtuijianVO> selectListVO(Wrapper<YangshengtuijianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YangshengtuijianVO selectVO(Wrapper<YangshengtuijianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YangshengtuijianView> selectListView(Wrapper<YangshengtuijianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YangshengtuijianView selectView(Wrapper<YangshengtuijianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YangshengtuijianEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YangshengtuijianEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YangshengtuijianEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
