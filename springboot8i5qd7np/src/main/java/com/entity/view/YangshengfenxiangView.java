package com.entity.view;

import com.entity.YangshengfenxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 养生分享
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
@TableName("yangshengfenxiang")
public class YangshengfenxiangView  extends YangshengfenxiangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YangshengfenxiangView(){
	}
 
 	public YangshengfenxiangView(YangshengfenxiangEntity yangshengfenxiangEntity){
 	try {
			BeanUtils.copyProperties(this, yangshengfenxiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
