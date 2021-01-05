package TestSystem;

import java.util.Scanner;

import Data.LectureRecord;
import Function.MainFunction;

public class TestSystemInConsole {
	public static void main(String[] args) {
		System.out.println("**********��������......");
		Scanner cin = new Scanner(System.in);
		System.out.print("**********������(����S�������μ�¼ϵͳ,����0�˳�����)��");
		while(!cin.hasNext("0")) {
				String str = cin.next();
				char c = str.charAt(0);
				switch(c) {
				case 'S':
					System.out.println("");
					System.out.println("**********�������μ�¼ϵͳ��......");
					start();
					System.out.print("**********�Ѿ��˳����μ�¼ϵͳ������0���˳�����");
					break;
				default:
					System.out.print("**********������Ч�����������룺");
					break;
				}
		}
		System.out.println("**********�����������");
	}
	public static void start() {
		MainFunction ma = new MainFunction();
		System.out.println("**********���μ�¼ϵͳ�������£�");
		System.out.println("**********1.������μ�¼(����1)");
		System.out.println("**********2.�����ڿ���ʦ�鿴����ʦ�ı����μ�¼(����2)");
		System.out.println("**********3.����������ʦ�鿴����ʦ�����μ�¼(����3)");
		System.out.println("**********4.���ݰ༶�鿴�ð༶�����μ�¼(����4)");
		System.out.println("**********����0�˳����μ�¼����ϵͳ");
		System.out.print("**********�����룺");
		Scanner cin = new Scanner(System.in);
		while(!cin.hasNext("0")) {
			int i = cin.nextInt();
			switch(i) {
			case 1:
				System.out.println("");
				fun1(ma);
				System.out.print("**********������(����1��2��3��4����0�˳�)��");
				break;
			case 2:
				System.out.println("");
				fun2(ma);
				System.out.print("**********������(����1��2��3��4����0�˳�)��");
				break;
			case 3:
				System.out.println("");
				fun3(ma);
				System.out.print("**********������(����1��2��3��4����0�˳�)��");
				break;
			case 4:
				System.out.println("");
				fun4(ma);
				System.out.print("**********������(����1��2��3��4����0�˳�)��");
				break;
			default:
				System.out.print("**********������Ч�����������룺");
				break;
			}
		}
		System.out.println("**********�˳����ι���ϵͳ");
		
	}
	private static void fun4(MainFunction ma) {
		Scanner cin = new Scanner(System.in);
		System.out.print("**********������༶��");
		String gradeClass = cin.next();
		ma.peekLectureRecordAccordingGradeClass(gradeClass);
		
	}
	private static void fun3(MainFunction ma) {

		Scanner cin = new Scanner(System.in);
		System.out.print("**********������������ʦ���֣�");
		String name = cin.next();
		ma.peekLectureRecordAccordingListenTeacher(name);
	}
	private static void fun2(MainFunction ma) {

		Scanner cin = new Scanner(System.in);
		System.out.print("**********�������ڿ���ʦ���֣�");
		String name = cin.next();
		ma.peekLectureRecordAccordingSpeakTeacher(name);
		
	}
	private static void fun1(MainFunction ma) {
		Scanner cin = new Scanner(System.in);
		System.out.println("**********���������μ�¼�ļ�·�����ڿ���ʦ���֡�������ʦ���֡��༶");
		System.out.println("**********����0���˳�������μ�¼����");
		System.out.print("**********���룺");
		while(!cin.hasNext("0")) {
			String path = cin.next();
			String st = cin.next();
			String lt = cin.next();
			String gc = cin.next();
			LectureRecord lr = new LectureRecord(path,st,lt,gc);
			ma.addLectureRecord(lr);
			System.out.println("**********������μ�¼�ɹ�");
			System.out.println("**********����0���˳�������μ�¼����");
		}
		System.out.println("**********�˳�������μ�¼����");
	}

}
