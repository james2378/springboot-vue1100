package com.entity.view;

import com.entity.DiscussyangshengtuijianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 养生推荐评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-09 17:19:25
 */
@TableName("discussyangshengtuijian")
public class DiscussyangshengtuijianView  extends DiscussyangshengtuijianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussyangshengtuijianView(){
	}
 
 	public DiscussyangshengtuijianView(DiscussyangshengtuijianEntity discussyangshengtuijianEntity){
 	try {
			BeanUtils.copyProperties(this, discussyangshengtuijianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
