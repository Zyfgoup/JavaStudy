package TestSystem;

import java.util.Scanner;

import Data.LectureRecord;
import Function.MainFunction;

public class TestSystemInConsole {
	public static void main(String[] args) {
		System.out.println("**********程序运行......");
		Scanner cin = new Scanner(System.in);
		System.out.print("**********请输入(输入S启动听课记录系统,输入0退出程序)：");
		while(!cin.hasNext("0")) {
				String str = cin.next();
				char c = str.charAt(0);
				switch(c) {
				case 'S':
					System.out.println("");
					System.out.println("**********启动听课记录系统中......");
					start();
					System.out.print("**********已经退出听课记录系统，输入0可退出程序：");
					break;
				default:
					System.out.print("**********输入无效，请重新输入：");
					break;
				}
		}
		System.out.println("**********程序运行完毕");
	}
	public static void start() {
		MainFunction ma = new MainFunction();
		System.out.println("**********听课记录系统功能如下：");
		System.out.println("**********1.添加听课记录(输入1)");
		System.out.println("**********2.根据授课老师查看该老师的被听课记录(输入2)");
		System.out.println("**********3.根据听课老师查看该老师的听课记录(输入3)");
		System.out.println("**********4.根据班级查看该班级被听课记录(输入4)");
		System.out.println("**********输入0退出听课记录管理系统");
		System.out.print("**********请输入：");
		Scanner cin = new Scanner(System.in);
		while(!cin.hasNext("0")) {
			int i = cin.nextInt();
			switch(i) {
			case 1:
				System.out.println("");
				fun1(ma);
				System.out.print("**********请输入(功能1、2、3、4或者0退出)：");
				break;
			case 2:
				System.out.println("");
				fun2(ma);
				System.out.print("**********请输入(功能1、2、3、4或者0退出)：");
				break;
			case 3:
				System.out.println("");
				fun3(ma);
				System.out.print("**********请输入(功能1、2、3、4或者0退出)：");
				break;
			case 4:
				System.out.println("");
				fun4(ma);
				System.out.print("**********请输入(功能1、2、3、4或者0退出)：");
				break;
			default:
				System.out.print("**********输入无效，请重新输入：");
				break;
			}
		}
		System.out.println("**********退出听课管理系统");
		
	}
	private static void fun4(MainFunction ma) {
		Scanner cin = new Scanner(System.in);
		System.out.print("**********请输入班级：");
		String gradeClass = cin.next();
		ma.peekLectureRecordAccordingGradeClass(gradeClass);
		
	}
	private static void fun3(MainFunction ma) {

		Scanner cin = new Scanner(System.in);
		System.out.print("**********请输入听课老师名字：");
		String name = cin.next();
		ma.peekLectureRecordAccordingListenTeacher(name);
	}
	private static void fun2(MainFunction ma) {

		Scanner cin = new Scanner(System.in);
		System.out.print("**********请输入授课老师名字：");
		String name = cin.next();
		ma.peekLectureRecordAccordingSpeakTeacher(name);
		
	}
	private static void fun1(MainFunction ma) {
		Scanner cin = new Scanner(System.in);
		System.out.println("**********请输入听课记录文件路径、授课老师名字、听课老师名字、班级");
		System.out.println("**********输入0则退出添加听课记录功能");
		System.out.print("**********输入：");
		while(!cin.hasNext("0")) {
			String path = cin.next();
			String st = cin.next();
			String lt = cin.next();
			String gc = cin.next();
			LectureRecord lr = new LectureRecord(path,st,lt,gc);
			ma.addLectureRecord(lr);
			System.out.println("**********添加听课记录成功");
			System.out.println("**********输入0则退出添加听课记录功能");
		}
		System.out.println("**********退出添加听课记录功能");
	}

}
