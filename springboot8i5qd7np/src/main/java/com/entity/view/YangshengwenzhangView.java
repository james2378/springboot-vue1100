package com.entity.view;

import com.entity.YangshengwenzhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 养生文章
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
@TableName("yangshengwenzhang")
public class YangshengwenzhangView  extends YangshengwenzhangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YangshengwenzhangView(){
	}
 
 	public YangshengwenzhangView(YangshengwenzhangEntity yangshengwenzhangEntity){
 	try {
			BeanUtils.copyProperties(this, yangshengwenzhangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
