package Function;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import Data.GradeClass;
import Data.LectureRecord;
import Data.LectureRecordLinkedList;
import Data.ListenTeacher;
import Data.SpeakTeacher;

public class MainFunction {
	LectureRecordLinkedList list ;
	int count;//给听课记录做个编号1 2 3 4.....
	final String STR = "C:\\Users\\hah\\Desktop\\听课记录" ;//桌面的位置
	

	
	public MainFunction() {
		File file = new File(STR);//一旦创建对象运行程序后便建立一个文件夹来存储所有的听课记录
		if(!file.exists()) {//文件不存在才创建
			System.out.println("**********在桌面新建听课记录文件夹");
			file.mkdir();
		}else {
			System.out.println("**********桌面已存在听课记录文件夹不再创建");
		}
		list = new LectureRecordLinkedList();
		System.out.println("**********听课记录系统启动成功");
	}
	
	
	//添加听课记录
	public void addLectureRecord(LectureRecord lr){
		//将一开始听课记录文件所在的位置都统一存储到一个固定的文件件（文件名“听课记录”，放在桌面）
		String s1 = Integer.toString(++count);
		String s2 = STR+"\\听课记录"+s1+".doc";
		File file = new File(s2);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			 fis = new FileInputStream(lr.getFile());
			 fos = new FileOutputStream(file);
			 
			 byte[] b = new byte[1024];
			 int len;
			 while((len = fis.read(b))!=-1) {
				 fos.write(b,0,len);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		lr.setFile(file); //修改听课记录文件（修改后是存在听课记录文件中的听课记录）
		list.insert(lr);//将听课文件存入链表中
	}
	
	
	
	//按照授课老师查看听课记录
	public void peekLectureRecordAccordingSpeakTeacher(String name) {
		if(!list.isEmpty()) {
			boolean flag = false;//判断是否有符合条件的听课记录，如果没有就删除创建的文件夹并且提示并没有符合条件的
			SpeakTeacher st = new SpeakTeacher(name);
			int count = 0; // 用来记录授课老师的被听课记录有多少
			
			String fileName1 = "C:\\Users\\hah\\Desktop\\"+st.getName()+"老师的被听课记录";
			File file = new File(fileName1);
			if(!file.exists()) {
				System.out.println("**********正在桌面创建文件夹用来存放符合条件的听课记录");
				file.mkdir();//创建这个FileName文件夹（在桌面）用来存放授课老师的被听课记录
				System.out.println("**********文件夹创建成功,"+"文件名为："+name+"老师被听课的记录");
			}
			
			System.out.println("**********正在查找符合条件的听课记录....");
			LectureRecord current = list.getFirst();
			while(current!=null) {
				if(current.getSt().getName().equals(st.getName())) {
					flag = true;
					FileInputStream fis = null;
					FileOutputStream fos = null;
					String fileName2 = fileName1+"\\"+"听课记录"+Integer.toString(++count)+".doc";
					File outFile = new File(fileName2);
					try {
						fis = new FileInputStream(current.getFile());
						fos = new FileOutputStream(outFile);
						byte[] b = new byte[1024];
						int len;
						while((len = fis.read(b))!=-1) {
							fos.write(b, 0, len);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						if(fos != null) {
							try {
								fos.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(fis != null) {
							try {
								fis.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						current = current.next; //一个错误，当找到一个符合条件的文件之后仍然要移动current
					}
				}else
					current = current.next;//条件不匹配就查找下一个听课记录
			}
			if(flag)
				System.out.println("**********查找完毕，符合条件的听课记录存放在桌面名为："+name+"老师被听课的记录的文件夹");
			else {
				file.delete();
				System.out.println("**********查找完毕,但是没有找到符合条件的听课记录无法提供查看");
			}
		}else {
			System.out.println("**********听课记录文件夹为空");
		}
	}
	
	
	//按照听课老师查看听课记录
	public void peekLectureRecordAccordingListenTeacher(String name) {
		if(!list.isEmpty()) {
			boolean flag = false;
			ListenTeacher lt = new ListenTeacher(name);
			
			// 用来记录授课老师的被听课记录有多少
			int count = 0; 
			
			String fileName1 = "C:\\Users\\hah\\Desktop\\"+lt.getName()+"老师的听课记录";
			File file = new File(fileName1);
			
			if(!file.exists()) {
				System.out.println("**********正在桌面创建文件夹用来存放符合条件的听课记录");
				file.mkdir();//创建这个FileName文件夹（在桌面）用来存放授课老师的被听课记录
				System.out.println("**********文件夹创建成功,"+"文件名为："+name+"老师的听课记录");
			}
			
			System.out.println("**********正在查找符合条件的听课记录....");
			LectureRecord current = list.getFirst();
			while(current!=null) {
				if(current.getLt().getName().equals(lt.getName())) {
					flag = true;//有符合条件的听课记记录则为true
					FileInputStream fis = null;
					FileOutputStream fos = null;
					String fileName2 = fileName1+"\\"+"听课记录"+Integer.toString(++count)+".doc";
					File outFile = new File(fileName2);
					try {
						fis = new FileInputStream(current.getFile());
						fos = new FileOutputStream(outFile);
						byte[] b = new byte[1024];
						int len;
						while((len = fis.read(b))!=-1) {
							fos.write(b, 0, len);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						if(fos != null) {
							try {
								fos.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(fis != null) {
							try {
								fis.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						current = current.next; //一个错误，当找到一个符合条件的文件之后仍然要移动current
					}
				}else
					current = current.next;
			}
			if(flag)
				System.out.println("**********查找完毕，符合条件的听课记录存放在桌面名为："+name+"老师的听课记录的文件夹");
			else {
				file.delete();
				System.out.println("**********查找完毕,但是没有找到符合条件的听课记录无法提供查看");
			}
		}else
			System.out.println("**********听课记录文件夹为空");
	}
	
	
	
	//按照年级班级查看听课记录
	public void peekLectureRecordAccordingGradeClass(String gradeClass) {
		if(!list.isEmpty()) {
			boolean flag = false;
			GradeClass gc = new GradeClass(gradeClass);
			
			// 用来记录授课老师的被听课记录有多少
			int count = 0; 
					
			String fileName1 = "C:\\Users\\hah\\Desktop\\"+gc.getGradeClass()+"班的被听课记录";
			File file = new File(fileName1);
			//创建这个FileName文件夹（在桌面）用来存班级的被听课记录
			if(!file.exists()) {
				System.out.println("**********正在桌面创建文件夹用来存放符合条件的听课记录");
				file.mkdir();//创建这个FileName文件夹（在桌面）用来存放授课老师的被听课记录
				System.out.println("**********文件夹创建成功,"+"文件名为："+gradeClass+"班的听课记录");
			}
		
			System.out.println("**********正在查找符合条件的听课记录....");
			LectureRecord current = list.getFirst();
			while(current!=null) {
				if(current.getGc().getGradeClass().equals(gc.getGradeClass())){
					flag = true;
					FileInputStream fis = null;
					FileOutputStream fos = null;
					String fileName2 = fileName1+"\\"+"听课记录"+Integer.toString(++count)+".doc";
					File outFile = new File(fileName2);
					try {
						fis = new FileInputStream(current.getFile());
						fos = new FileOutputStream(outFile);
						byte[] b = new byte[1024];
						int len;
						while((len = fis.read(b))!=-1) {
							fos.write(b, 0, len);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						if(fos != null) {
							try {
								fos.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(fis != null) {
							try {
								fis.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						current = current.next; //一个错误，当找到一个符合条件的文件之后仍然要移动current
					}
				}else
					current = current.next;
			}
			if(flag)
				System.out.println("**********查找完毕，符合条件的听课记录存放在桌面名为："+gradeClass+"班的听课记录的文件夹");
			else {
				file.delete();
				System.out.println("**********查找完毕,但是没有找到符合条件的听课记录无法提供查看");
			}
	}else
		System.out.println("**********听课记录文件夹为空");
	}
}
