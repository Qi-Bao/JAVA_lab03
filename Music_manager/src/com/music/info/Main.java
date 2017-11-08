package com.music.info;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		String fileName = "Music.txt";
		while(true){
		Menu(fileName);
		}
	}
	public static void Menu(String fileName) throws IOException{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("欢迎来到音乐管理系统");
		System.out.println("1.显示歌曲");
		System.out.println("2.查找歌曲");
		System.out.println("3.增加歌曲");
		System.out.println("4.删除歌曲");
		System.out.println("请选择：");
		String choice = sc.nextLine();
		switch (choice) {
		case "1":
			disMusic(fileName);
			break;
			
		case "2":
			findMusic(fileName);
			break;
			
		case "3":
			addMusic(fileName);
			break;
			
		case "4":
			deleteMusic(fileName);
			break;
		default:
			System.out.println("输入错误！");
			System.exit(0);
			break;
		}
	}
	public static void readData(String fileName,ArrayList<Music> array) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		String line;
		while ((line = br.readLine())!=null) {
			String [] str = line.split(",");
			Music m = new Music();
			m.setID(str[0]);
			m.setName(str[1]);
			m.setSinger(str[2]);
			m.setLanguage(str[3]);
			m.setClasses(str[4]);
			array.add(m);
		}
		br.close();
	}
	public static void writeData(String fileName,ArrayList<Music> array) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		
		for (int i = 0; i < array.size(); i++) {
			Music m = array.get(i);
			
			StringBuilder mb = new StringBuilder();
			mb.append(m.getID()).append(",").append(m.getName()).append(",").append(m.getSinger()).append(",").append(m.getLanguage()).append(",").append(m.getClasses());
			bw.write(mb.toString());
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
	public static void disMusic(String fileName) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Music> array = new ArrayList<>();
		
		readData(fileName,array);
		
		if (array.size() == 0) {
			System.out.println("没有音乐信息！");
			return;
		} else {
			System.out.println("ID\t名称\t歌手\t语言\t类别 ");
			for (int i = 0; i < array.size(); i++) {
				Music m = array.get(i);
				System.out.println(m.getID() +"\t"+ m.getName() +"\t"+ m.getSinger() +"\t" + m.getClasses() +"\t" + m.getLanguage());
			}

		}

	}
	public static void findMusic(String fileName) throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ArrayList<Music> array = new ArrayList<>();
		readData(fileName,array);
		String id,name,singer,language,classes;
		String c;
		System.out.println("1.按ID查询");
		System.out.println("2.按名称查询");
		System.out.println("3.按歌手查询");
		System.out.println("4.按类型查询");
		System.out.println("5.按语言查询");
		System.out.println("请选择：");
		c = sc.nextLine();
		boolean flag = false;
		switch (c) {
		case "1":
			System.out.println("请输入ID！");
			id = sc.nextLine();
			for (int i = 0; i < array.size(); i++) {
				Music m = array.get(i);
				if(m.getID().equals(id)) {
					System.out.println("ID\t名称\t歌手\t类别\t语言 ");
					System.out.println(m.getID() +"\t"+ m.getName() +"\t"+ m.getSinger() +"\t" + m.getLanguage() +"\t" + m.getClasses());
					flag = true;
				}
			}
			if (flag == false) {
					System.out.println("未找到歌曲信息！");
			}
			break;
		case "2":
			System.out.println("请输入名称！");
			name = sc.nextLine();
			System.out.println("ID\t名称\t歌手\t类别\t语言 ");
			for (int i = 0; i < array.size(); i++) {
				Music m = array.get(i);
				if(m.getName().equals(name)) {
					System.out.println(m.getID() +"\t"+ m.getName() +"\t"+ m.getSinger() +"\t" + m.getLanguage() +"\t" + m.getClasses());
					flag = true;
				}
			}
			if (flag == false) {
				System.out.println("未找到歌曲信息！");
			}
			break;

		case "3":
			System.out.println("请输入歌手！");
			singer = sc.nextLine();
			System.out.println("ID\t名称\t歌手\t类别\t语言 ");
			for (int i = 0; i < array.size(); i++) {
				Music m = array.get(i);
				if(m.getSinger().equals(singer)) {
					
					System.out.println(m.getID() +"\t"+ m.getName() +"\t"+ m.getSinger() +"\t" + m.getLanguage() +"\t" + m.getClasses());
					flag = true;
				}
			}
			if (flag == false) {
				System.out.println("未找到歌曲信息！");
			}
			break;

		case "4":
			System.out.println("请输入类型！");
			language = sc.nextLine();
			System.out.println("ID\t名称\t歌手\t类别\t语言 ");
			for (int i = 0; i < array.size(); i++) {
				Music m = array.get(i);
				if(m.getLanguage().equals(language)) {
					flag = true;
					System.out.println(m.getID() +"\t"+ m.getName() +"\t"+ m.getSinger() +"\t" + m.getLanguage() +"\t" + m.getClasses());
				}
			}
			if (flag == false) {
				System.out.println("未找到歌曲信息！");
			}
			break;

		case "5":
			System.out.println("请输入语言！");
			classes = sc.nextLine();
			System.out.println("ID\t名称\t歌手\t类别\t语言 ");
			for (int i = 0; i < array.size(); i++) {
				Music m = array.get(i);
				if(m.getClasses().equals(classes)) {
					System.out.println(m.getID() +"\t"+ m.getName() +"\t"+ m.getSinger() +"\t" + m.getLanguage() +"\t" + m.getClasses());
					flag = true;
				}
			}
			if (flag == false) {
				System.out.println("未找到歌曲信息！");
			}
			break;
		default:
			System.out.println("输入错误！");
			break;
		}
		
	}
	
	public static void addMusic(String fileName) throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ArrayList<Music> array = new ArrayList<>();
		readData(fileName,array);
		String id;
		while(true) {
		System.out.println("输入歌曲ID");
		id = sc.nextLine();
		boolean flag = false;
		for (int i = 0; i < array.size(); i++) {
			Music m = new Music();
			m = array.get(i);
			if (m.getID().equals(id)) {
				flag = true;
				break;
			}
		}
			if (flag) {
				System.out.println("音乐已存在！");
			}
			else {
				break;
			}
		}
		
		System.out.println("输入歌曲名称");
		String name = sc.nextLine();
		System.out.println("输入歌手");
		String singer = sc.nextLine();
		System.out.println("输入歌曲语言");
		String classes = sc.nextLine();
		System.out.println("输入歌曲类别");
		String language = sc.nextLine();
		Music mm = new Music();
		mm.setID(id);
		mm.setName(name);
		mm.setSinger(singer);
		mm.setLanguage(language);
		mm.setClasses(classes);
		
		array.add(mm);
		writeData(fileName,array);
		System.out.println("添加成功！");	
	}
	
	public static void deleteMusic(String fileName) throws IOException {
		ArrayList<Music> array = new ArrayList<>();
		readData(fileName,array);
		while(true) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入要删除的歌曲ID。");
			String id = sc.nextLine();
			int index = -1;
			for (int i = 0; i < array.size(); i++) {
				Music m =array.get(i);
				if (m.getID().equals(id)) {
					index = i;
					break;
				}
			}
			if (index == -1) {
				System.out.println("歌曲不存在！");
			} else {
				array.remove(index);
				writeData(fileName,array);
				System.out.println("删除音乐成功！");
				break;

			}
		}
		
	}
}


