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


import com.dao.YangshengfenxiangDao;
import com.entity.YangshengfenxiangEntity;
import com.service.YangshengfenxiangService;
import com.entity.vo.YangshengfenxiangVO;
import com.entity.view.YangshengfenxiangView;

@Service("yangshengfenxiangService")
public class YangshengfenxiangServiceImpl extends ServiceImpl<YangshengfenxiangDao, YangshengfenxiangEntity> implements YangshengfenxiangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YangshengfenxiangEntity> page = this.selectPage(
                new Query<YangshengfenxiangEntity>(params).getPage(),
                new EntityWrapper<YangshengfenxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YangshengfenxiangEntity> wrapper) {
		  Page<YangshengfenxiangView> page =new Query<YangshengfenxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YangshengfenxiangVO> selectListVO(Wrapper<YangshengfenxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YangshengfenxiangVO selectVO(Wrapper<YangshengfenxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YangshengfenxiangView> selectListView(Wrapper<YangshengfenxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YangshengfenxiangView selectView(Wrapper<YangshengfenxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YangshengfenxiangEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YangshengfenxiangEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YangshengfenxiangEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
