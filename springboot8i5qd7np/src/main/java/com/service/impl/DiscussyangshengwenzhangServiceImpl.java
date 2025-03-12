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


import com.dao.DiscussyangshengwenzhangDao;
import com.entity.DiscussyangshengwenzhangEntity;
import com.service.DiscussyangshengwenzhangService;
import com.entity.vo.DiscussyangshengwenzhangVO;
import com.entity.view.DiscussyangshengwenzhangView;

@Service("discussyangshengwenzhangService")
public class DiscussyangshengwenzhangServiceImpl extends ServiceImpl<DiscussyangshengwenzhangDao, DiscussyangshengwenzhangEntity> implements DiscussyangshengwenzhangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyangshengwenzhangEntity> page = this.selectPage(
                new Query<DiscussyangshengwenzhangEntity>(params).getPage(),
                new EntityWrapper<DiscussyangshengwenzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyangshengwenzhangEntity> wrapper) {
		  Page<DiscussyangshengwenzhangView> page =new Query<DiscussyangshengwenzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussyangshengwenzhangVO> selectListVO(Wrapper<DiscussyangshengwenzhangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyangshengwenzhangVO selectVO(Wrapper<DiscussyangshengwenzhangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyangshengwenzhangView> selectListView(Wrapper<DiscussyangshengwenzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyangshengwenzhangView selectView(Wrapper<DiscussyangshengwenzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
