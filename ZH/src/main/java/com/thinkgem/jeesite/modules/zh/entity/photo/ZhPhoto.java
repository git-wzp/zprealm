/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.entity.photo;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 壁纸图片Entity
 * @author 王子鹏
 * @version 2018-01-22
 */
public class ZhPhoto extends DataEntity<ZhPhoto> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 标题
	private String url;		// 路径
	private String hits;		// 点击数
	private String weight;		// 权重，越大越靠前
	private String keywords;		// 关键字
	private String beginKeywords;		// 开始 关键字
	private String endKeywords;		// 结束 关键字
	
	public ZhPhoto() {
		super();
	}

	public ZhPhoto(String id){
		super(id);
	}

	@Length(min=0, max=255, message="标题长度必须介于 0 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=255, message="路径长度必须介于 0 和 255 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Length(min=0, max=64, message="点击数长度必须介于 0 和 64 之间")
	public String getHits() {
		return hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}
	
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	@Length(min=0, max=255, message="关键字长度必须介于 0 和 255 之间")
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	public String getBeginKeywords() {
		return beginKeywords;
	}

	public void setBeginKeywords(String beginKeywords) {
		this.beginKeywords = beginKeywords;
	}
	
	public String getEndKeywords() {
		return endKeywords;
	}

	public void setEndKeywords(String endKeywords) {
		this.endKeywords = endKeywords;
	}
		
}