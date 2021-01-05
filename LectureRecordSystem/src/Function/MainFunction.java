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
	int count;//�����μ�¼�������1 2 3 4.....
	final String STR = "C:\\Users\\hah\\Desktop\\���μ�¼" ;//�����λ��
	

	
	public MainFunction() {
		File file = new File(STR);//һ�������������г����㽨��һ���ļ������洢���е����μ�¼
		if(!file.exists()) {//�ļ������ڲŴ���
			System.out.println("**********�������½����μ�¼�ļ���");
			file.mkdir();
		}else {
			System.out.println("**********�����Ѵ������μ�¼�ļ��в��ٴ���");
		}
		list = new LectureRecordLinkedList();
		System.out.println("**********���μ�¼ϵͳ�����ɹ�");
	}
	
	
	//������μ�¼
	public void addLectureRecord(LectureRecord lr){
		//��һ��ʼ���μ�¼�ļ����ڵ�λ�ö�ͳһ�洢��һ���̶����ļ������ļ��������μ�¼�����������棩
		String s1 = Integer.toString(++count);
		String s2 = STR+"\\���μ�¼"+s1+".doc";
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
		
		lr.setFile(file); //�޸����μ�¼�ļ����޸ĺ��Ǵ������μ�¼�ļ��е����μ�¼��
		list.insert(lr);//�������ļ�����������
	}
	
	
	
	//�����ڿ���ʦ�鿴���μ�¼
	public void peekLectureRecordAccordingSpeakTeacher(String name) {
		if(!list.isEmpty()) {
			boolean flag = false;//�ж��Ƿ��з������������μ�¼�����û�о�ɾ���������ļ��в�����ʾ��û�з���������
			SpeakTeacher st = new SpeakTeacher(name);
			int count = 0; // ������¼�ڿ���ʦ�ı����μ�¼�ж���
			
			String fileName1 = "C:\\Users\\hah\\Desktop\\"+st.getName()+"��ʦ�ı����μ�¼";
			File file = new File(fileName1);
			if(!file.exists()) {
				System.out.println("**********�������洴���ļ���������ŷ������������μ�¼");
				file.mkdir();//�������FileName�ļ��У������棩��������ڿ���ʦ�ı����μ�¼
				System.out.println("**********�ļ��д����ɹ�,"+"�ļ���Ϊ��"+name+"��ʦ�����εļ�¼");
			}
			
			System.out.println("**********���ڲ��ҷ������������μ�¼....");
			LectureRecord current = list.getFirst();
			while(current!=null) {
				if(current.getSt().getName().equals(st.getName())) {
					flag = true;
					FileInputStream fis = null;
					FileOutputStream fos = null;
					String fileName2 = fileName1+"\\"+"���μ�¼"+Integer.toString(++count)+".doc";
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
						current = current.next; //һ�����󣬵��ҵ�һ�������������ļ�֮����ȻҪ�ƶ�current
					}
				}else
					current = current.next;//������ƥ��Ͳ�����һ�����μ�¼
			}
			if(flag)
				System.out.println("**********������ϣ��������������μ�¼�����������Ϊ��"+name+"��ʦ�����εļ�¼���ļ���");
			else {
				file.delete();
				System.out.println("**********�������,����û���ҵ��������������μ�¼�޷��ṩ�鿴");
			}
		}else {
			System.out.println("**********���μ�¼�ļ���Ϊ��");
		}
	}
	
	
	//����������ʦ�鿴���μ�¼
	public void peekLectureRecordAccordingListenTeacher(String name) {
		if(!list.isEmpty()) {
			boolean flag = false;
			ListenTeacher lt = new ListenTeacher(name);
			
			// ������¼�ڿ���ʦ�ı����μ�¼�ж���
			int count = 0; 
			
			String fileName1 = "C:\\Users\\hah\\Desktop\\"+lt.getName()+"��ʦ�����μ�¼";
			File file = new File(fileName1);
			
			if(!file.exists()) {
				System.out.println("**********�������洴���ļ���������ŷ������������μ�¼");
				file.mkdir();//�������FileName�ļ��У������棩��������ڿ���ʦ�ı����μ�¼
				System.out.println("**********�ļ��д����ɹ�,"+"�ļ���Ϊ��"+name+"��ʦ�����μ�¼");
			}
			
			System.out.println("**********���ڲ��ҷ������������μ�¼....");
			LectureRecord current = list.getFirst();
			while(current!=null) {
				if(current.getLt().getName().equals(lt.getName())) {
					flag = true;//�з������������μǼ�¼��Ϊtrue
					FileInputStream fis = null;
					FileOutputStream fos = null;
					String fileName2 = fileName1+"\\"+"���μ�¼"+Integer.toString(++count)+".doc";
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
						current = current.next; //һ�����󣬵��ҵ�һ�������������ļ�֮����ȻҪ�ƶ�current
					}
				}else
					current = current.next;
			}
			if(flag)
				System.out.println("**********������ϣ��������������μ�¼�����������Ϊ��"+name+"��ʦ�����μ�¼���ļ���");
			else {
				file.delete();
				System.out.println("**********�������,����û���ҵ��������������μ�¼�޷��ṩ�鿴");
			}
		}else
			System.out.println("**********���μ�¼�ļ���Ϊ��");
	}
	
	
	
	//�����꼶�༶�鿴���μ�¼
	public void peekLectureRecordAccordingGradeClass(String gradeClass) {
		if(!list.isEmpty()) {
			boolean flag = false;
			GradeClass gc = new GradeClass(gradeClass);
			
			// ������¼�ڿ���ʦ�ı����μ�¼�ж���
			int count = 0; 
					
			String fileName1 = "C:\\Users\\hah\\Desktop\\"+gc.getGradeClass()+"��ı����μ�¼";
			File file = new File(fileName1);
			//�������FileName�ļ��У������棩������༶�ı����μ�¼
			if(!file.exists()) {
				System.out.println("**********�������洴���ļ���������ŷ������������μ�¼");
				file.mkdir();//�������FileName�ļ��У������棩��������ڿ���ʦ�ı����μ�¼
				System.out.println("**********�ļ��д����ɹ�,"+"�ļ���Ϊ��"+gradeClass+"������μ�¼");
			}
		
			System.out.println("**********���ڲ��ҷ������������μ�¼....");
			LectureRecord current = list.getFirst();
			while(current!=null) {
				if(current.getGc().getGradeClass().equals(gc.getGradeClass())){
					flag = true;
					FileInputStream fis = null;
					FileOutputStream fos = null;
					String fileName2 = fileName1+"\\"+"���μ�¼"+Integer.toString(++count)+".doc";
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
						current = current.next; //һ�����󣬵��ҵ�һ�������������ļ�֮����ȻҪ�ƶ�current
					}
				}else
					current = current.next;
			}
			if(flag)
				System.out.println("**********������ϣ��������������μ�¼�����������Ϊ��"+gradeClass+"������μ�¼���ļ���");
			else {
				file.delete();
				System.out.println("**********�������,����û���ҵ��������������μ�¼�޷��ṩ�鿴");
			}
	}else
		System.out.println("**********���μ�¼�ļ���Ϊ��");
	}
}
