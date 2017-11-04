package com.music.info;
/**
 * 
 * @author Qibao
 *
 */
public class Music {
	private String id;
	private String name;
	private String language;
	private String classes;
	private String singer;
	
	//设置public函数，在外部可以使用函数对类中变量进行改变和获取。
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}

}
