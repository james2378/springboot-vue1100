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


import com.dao.YangshengwenzhangDao;
import com.entity.YangshengwenzhangEntity;
import com.service.YangshengwenzhangService;
import com.entity.vo.YangshengwenzhangVO;
import com.entity.view.YangshengwenzhangView;

@Service("yangshengwenzhangService")
public class YangshengwenzhangServiceImpl extends ServiceImpl<YangshengwenzhangDao, YangshengwenzhangEntity> implements YangshengwenzhangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YangshengwenzhangEntity> page = this.selectPage(
                new Query<YangshengwenzhangEntity>(params).getPage(),
                new EntityWrapper<YangshengwenzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YangshengwenzhangEntity> wrapper) {
		  Page<YangshengwenzhangView> page =new Query<YangshengwenzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YangshengwenzhangVO> selectListVO(Wrapper<YangshengwenzhangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YangshengwenzhangVO selectVO(Wrapper<YangshengwenzhangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YangshengwenzhangView> selectListView(Wrapper<YangshengwenzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YangshengwenzhangView selectView(Wrapper<YangshengwenzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
