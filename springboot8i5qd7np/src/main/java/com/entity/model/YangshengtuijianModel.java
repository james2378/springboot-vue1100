package com.entity.model;

import com.entity.YangshengtuijianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 养生推荐
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
public class YangshengtuijianModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 饮食类型
	 */
	
	private String yinshileixing;
		
	/**
	 * 运动
	 */
	
	private String yundong;
		
	/**
	 * 穴位按摩
	 */
	
	private String xueweianmo;
		
	/**
	 * 中药调理
	 */
	
	private String zhongyaodiaoli;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 推荐原因
	 */
	
	private String tuijianyuanyin;
		
	/**
	 * 推荐内容
	 */
	
	private String tuijianneirong;
		
	/**
	 * 推荐时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tuijianshijian;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：饮食类型
	 */
	 
	public void setYinshileixing(String yinshileixing) {
		this.yinshileixing = yinshileixing;
	}
	
	/**
	 * 获取：饮食类型
	 */
	public String getYinshileixing() {
		return yinshileixing;
	}
				
	
	/**
	 * 设置：运动
	 */
	 
	public void setYundong(String yundong) {
		this.yundong = yundong;
	}
	
	/**
	 * 获取：运动
	 */
	public String getYundong() {
		return yundong;
	}
				
	
	/**
	 * 设置：穴位按摩
	 */
	 
	public void setXueweianmo(String xueweianmo) {
		this.xueweianmo = xueweianmo;
	}
	
	/**
	 * 获取：穴位按摩
	 */
	public String getXueweianmo() {
		return xueweianmo;
	}
				
	
	/**
	 * 设置：中药调理
	 */
	 
	public void setZhongyaodiaoli(String zhongyaodiaoli) {
		this.zhongyaodiaoli = zhongyaodiaoli;
	}
	
	/**
	 * 获取：中药调理
	 */
	public String getZhongyaodiaoli() {
		return zhongyaodiaoli;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：推荐原因
	 */
	 
	public void setTuijianyuanyin(String tuijianyuanyin) {
		this.tuijianyuanyin = tuijianyuanyin;
	}
	
	/**
	 * 获取：推荐原因
	 */
	public String getTuijianyuanyin() {
		return tuijianyuanyin;
	}
				
	
	/**
	 * 设置：推荐内容
	 */
	 
	public void setTuijianneirong(String tuijianneirong) {
		this.tuijianneirong = tuijianneirong;
	}
	
	/**
	 * 获取：推荐内容
	 */
	public String getTuijianneirong() {
		return tuijianneirong;
	}
				
	
	/**
	 * 设置：推荐时间
	 */
	 
	public void setTuijianshijian(Date tuijianshijian) {
		this.tuijianshijian = tuijianshijian;
	}
	
	/**
	 * 获取：推荐时间
	 */
	public Date getTuijianshijian() {
		return tuijianshijian;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
