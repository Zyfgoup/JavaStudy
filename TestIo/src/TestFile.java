import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;




/*
 * java.io.File��
 * 1.���������롢�����ص��ࡢ�ӿڵȶ�������java.io����
 * 2.File��һ���࣬�����й�������������󡣴˶����Ӧ��һ���ļ���.txt .avi .doc .ppt .mp3 .jpg�����ļ�Ŀ¼
 * 3.File���������ƽ̨�޹صġ�
 * 4.File�еķ��������漰����δ�����ɾ�����������ȵȡ�ֻҪ�漰�ļ����ݵģ�File������Ϊ���ģ�������io������ɡ�
 * 5.File��Ķ�����Ϊio���ľ�����Ĺ��������βΡ�
 */
public class TestFile {
	@Test
	/*
	 * 
	 *  createNewFile() ���ҽ��������ھ��д˳���·����
	 *  ָ�����Ƶ��ļ�ʱ�����ɷֵش���һ���µĿ��ļ���
	 *  
		delete() ɾ��һ��File������ļ������ļ���  ����booleanֵ 
		mkDir():����һ���ļ�Ŀ¼��ֻ�����ϲ��ļ�Ŀ¼���ڵ�����£����ܷ���true
		mkDirs():����һ���ļ�Ŀ¼�����ϲ��ļ�Ŀ¼�����ڣ�һ������
		list() ����һ���ַ������飬��Щ�ַ���ָ���˳���·������ʾ��Ŀ¼�е��ļ���Ŀ¼��
		listFiles()����һ������·�������飬��Щ·������ʾ�˳���·������ʾ��Ŀ¼�е��ļ���
	 */
	public void test3() throws IOException {
		File file1 = new File("d:/IO/Hello.txt");
		System.out.println(file1.delete());
		
		if(!file1.exists()) {
			boolean b = file1.createNewFile();
			System.out.println(b);
		}
		
		File file2 = new File("d:/io1/io2");
		if(!file2.exists()) {
			boolean b = file2.mkdirs();
			System.out.println(b);
		}
		
		System.out.println();
		
		File file3 = new File("d:/IO");
		String str[] = file3.list();//ֻ���ļ����Ļ� ����list��String����
		
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
		}
		/*
		 * Hello.txt
			io1
			����һ���ļ���
		 */
		
		System.out.println();
		
		File files[] = file3.listFiles();//���˿���������ļ���ʲô������� File����������
		for(int i=0;i < files.length;i++) {
			System.out.println(files[i].getName());
		}
		/*
		 * Hello.txt
			io1
			����һ���ļ���
		 */
	}
	
	@Test
	public void test2() {
		/*
		 *  exists()
			canWrite()
			canRead()
			isFile()
			isDirectory()
			lastModified()
			length()
		 */
		File file1 = new File("d://IO//Hello.txt");
		File file2 = new File("d://IO//io1");
		
		System.out.println(file1.exists());
		System.out.println(file1.canWrite());
		System.out.println(file1.canRead());
		System.out.println(file1.isFile());//�Ƿ���һ����׼�ļ�
		System.out.println(file1.isDirectory());//���Դ˳���·������ʾ���ļ��Ƿ���һ��Ŀ¼��
		System.out.println(file1.length());
		System.out.println(new Date(file1.lastModified()));//���ش˳���·������ʾ���ļ����һ�α��޸ĵ�ʱ�䡣
		/*
		 * true
			true
			true
			true
			false
			14     һ�����������ֽ�
			Mon May 21 11:15:38 CST 2018
		 */
		
		System.out.println();
		
		System.out.println(file2.exists());
		System.out.println(file2.canWrite());
		System.out.println(file2.canRead());
		System.out.println(file2.isFile());//false ����һ����׼�ļ�
		System.out.println(file2.isDirectory());//true  ��һ��Ŀ¼
		System.out.println(new Date(file2.lastModified()));
		System.out.println(file2.length());//0
		
		
	}

	@Test
	public void test1() {
		/*
		 * ·����
		 * ����·���������̷����ڵ��������ļ�·��
		 * ���·�����ڵ�ǰ�ļ�Ŀ¼�µ��ļ���·��
		 * 
		 *  getName()
			getPath()
			getAbsoluteFile()
			getAbsolutePath()
			getParent()
			renameTo(File newName)
			renameTo(File newName):������ ����һ��boolean
			file1.renameTo(file2):file������Ϊfile2,Ҫ��file1�ļ�һ��Ҫ���ڣ�file2һ��������
		 */
		File file1 = new File("d:/IO/Hello.txt");//����·��
		File file2 = new File("Hello1.txt");//���·��
		
		File file3 = new File("d:/IO/����һ���ļ���");
		File file4 = new File("d:/����һ���ļ���1");
		/*
		 * 	Hello.txt
			d:\IO\Hello.txt
			d:\IO\Hello.txt
			d:\IO
			d:\IO\Hello.txt
			
			����һ���ļ���
			d:\IO\����һ���ļ���
			d:\IO\����һ���ļ���
			d:\IO
			d:\IO\����һ���ļ���
		 */
		System.out.println(file1.getName());//��ȡ�ļ���
		System.out.println(file1.getPath());//��ȡ·��
		System.out.println(file1.getAbsoluteFile());//���ش˳���·�����ľ���·������ʽ��
		System.out.println(file1.getParent());//���ش˳���·������Ŀ¼��·�����ַ����������·����û��ָ����Ŀ¼���򷵻� null��
		System.out.println(file1.getAbsolutePath());//���ش˳���·�����ľ���·�����ַ�����
		
		System.out.println();
		
		System.out.println(file3.getName());
		System.out.println(file3.getPath());
		System.out.println(file3.getAbsoluteFile());
		System.out.println(file3.getParent());
		System.out.println(file3.getAbsolutePath());
		
		System.out.println();
		
		boolean b = file1.renameTo(file2);//Hello.txt���ļ���IO��ʧ�� �����ڸù�������
		boolean bo = file3.renameTo(file4);//����һ���ļ������ļ���IO����ʧ�ˣ�������d�̵�����һ���ļ���1
		System.out.println(b);
		System.out.println(bo);
		
	}
}
