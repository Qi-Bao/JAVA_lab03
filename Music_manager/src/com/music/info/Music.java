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
	
	//����public���������ⲿ����ʹ�ú��������б������иı�ͻ�ȡ��
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
