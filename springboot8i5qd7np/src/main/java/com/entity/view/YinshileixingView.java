package com.entity.view;

import com.entity.YinshileixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 饮食类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
@TableName("yinshileixing")
public class YinshileixingView  extends YinshileixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YinshileixingView(){
	}
 
 	public YinshileixingView(YinshileixingEntity yinshileixingEntity){
 	try {
			BeanUtils.copyProperties(this, yinshileixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
