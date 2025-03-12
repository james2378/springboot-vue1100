package com.entity.vo;

import com.entity.YangshengzhishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 养生知识
 * @author 
 * @email 
 * @date 2024-04-09 17:19:23
 */
public class YangshengzhishiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 养生分类
	 */
	
	private String yangshengfenlei;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 预防疾病
	 */
	
	private String yufangjibing;
		
	/**
	 * 功能
	 */
	
	private String gongneng;
		
	/**
	 * 禁忌
	 */
	
	private String jinji;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
		
	/**
	 * 推荐理由
	 */
	
	private String tuijianliyou;
		
	/**
	 * 知识详情
	 */
	
	private String zhishixiangqing;
		
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
	 * 设置：养生分类
	 */
	 
	public void setYangshengfenlei(String yangshengfenlei) {
		this.yangshengfenlei = yangshengfenlei;
	}
	
	/**
	 * 获取：养生分类
	 */
	public String getYangshengfenlei() {
		return yangshengfenlei;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：预防疾病
	 */
	 
	public void setYufangjibing(String yufangjibing) {
		this.yufangjibing = yufangjibing;
	}
	
	/**
	 * 获取：预防疾病
	 */
	public String getYufangjibing() {
		return yufangjibing;
	}
				
	
	/**
	 * 设置：功能
	 */
	 
	public void setGongneng(String gongneng) {
		this.gongneng = gongneng;
	}
	
	/**
	 * 获取：功能
	 */
	public String getGongneng() {
		return gongneng;
	}
				
	
	/**
	 * 设置：禁忌
	 */
	 
	public void setJinji(String jinji) {
		this.jinji = jinji;
	}
	
	/**
	 * 获取：禁忌
	 */
	public String getJinji() {
		return jinji;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
				
	
	/**
	 * 设置：推荐理由
	 */
	 
	public void setTuijianliyou(String tuijianliyou) {
		this.tuijianliyou = tuijianliyou;
	}
	
	/**
	 * 获取：推荐理由
	 */
	public String getTuijianliyou() {
		return tuijianliyou;
	}
				
	
	/**
	 * 设置：知识详情
	 */
	 
	public void setZhishixiangqing(String zhishixiangqing) {
		this.zhishixiangqing = zhishixiangqing;
	}
	
	/**
	 * 获取：知识详情
	 */
	public String getZhishixiangqing() {
		return zhishixiangqing;
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
