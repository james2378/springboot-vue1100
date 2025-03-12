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


import com.dao.DiscussyangshengfenxiangDao;
import com.entity.DiscussyangshengfenxiangEntity;
import com.service.DiscussyangshengfenxiangService;
import com.entity.vo.DiscussyangshengfenxiangVO;
import com.entity.view.DiscussyangshengfenxiangView;

@Service("discussyangshengfenxiangService")
public class DiscussyangshengfenxiangServiceImpl extends ServiceImpl<DiscussyangshengfenxiangDao, DiscussyangshengfenxiangEntity> implements DiscussyangshengfenxiangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyangshengfenxiangEntity> page = this.selectPage(
                new Query<DiscussyangshengfenxiangEntity>(params).getPage(),
                new EntityWrapper<DiscussyangshengfenxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyangshengfenxiangEntity> wrapper) {
		  Page<DiscussyangshengfenxiangView> page =new Query<DiscussyangshengfenxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussyangshengfenxiangVO> selectListVO(Wrapper<DiscussyangshengfenxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyangshengfenxiangVO selectVO(Wrapper<DiscussyangshengfenxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyangshengfenxiangView> selectListView(Wrapper<DiscussyangshengfenxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyangshengfenxiangView selectView(Wrapper<DiscussyangshengfenxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
