import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;



/*
 * 1.���ķ��ࣺ
 * ������������Ĳ�ͬ�������� �����
 * ���մ������ݵĵ�λ�Ĳ�ͬ���ֽ��� �ַ�����������ı��ļ���
 * ���ս�ɫ�Ĳ�ͬ�� �ڵ�����ֱ���������ļ���  ������
 * 
 *  
 * 2.IO����ϵ
 * �������                 �ڵ���(�ļ���)
 * InputStream       FileInputStream
 * OutputStream      FileOutputStream
 * Reader             FileReader
 * Writer               FileWriter
 */
public class TestFileInputOutputStream {
	@Test
	public void testCopyFile() {
		long start = System.currentTimeMillis();
		String src = "C:\\Users\\hah\\Desktop\\exp6_1.txt";
		String dest = "C:\\Users\\hah\\Desktop\\exp6_3.txt";//���Բ����� �������򴴽�һ����
		copyFile(src,dest);
		long end = System.currentTimeMillis();
		System.out.println(start-end);
	}
	
	//ʵ���ļ����Ƶķ���
	public void copyFile(String src,String dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			File file1 = new File(src);
			File file2 = new File(dest);
			
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			
			byte b[] = new byte[1024];
			int len;
			//�൱�ڻ��Ҫд����ļ���ȫ��������ɾ���ˣ�
			//Ȼ��д���ȡ���ļ�������
			while((len=fis.read(b)) !=-1) {
				fos.write(b,0,len);
				
			}
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ȹر������
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
		}
	}
	
	
	@Test
	public void testFileOutputStream2() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			File file1 = new File("Hello1.txt");
			File file2 = new File("Hello2.txt");
			
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			
			byte b[] = new byte[20];
			int len;
			//�൱�ڻ��Ҫд����ļ���ȫ��������ɾ���ˣ�
			//Ȼ��д���ȡ���ļ�������
			while((len=fis.read(b)) !=-1) {
				fos.write(b,0,len);
				
			}
		}  catch (IOException e) {
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
		}
	}
	
	@Test
	public void testFileOutputSteam1() {
		// ����������ļ����Բ����ڣ���ִ�й����У�
		//�������ڣ����Զ��Ĵ����������ڣ��Ὣԭ�е��ļ�����
		FileOutputStream  fos = null;
		try {
			File file = new File("Hello2.txt");
			  fos = new FileOutputStream(file);
			//д�����ݻ��ԭ�������ݸ��ǵ�
			fos.write(new String("I love China too").getBytes());
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
		}
		
		
	}
	
	@Test
	public void testFileInputStream3()  {
		FileInputStream fis = null;//Ҫ���ó�ʼֵ ��Ȼ����ر�close()���д���
		try {
			File file = new File("Hello2.txt");
			fis = new FileInputStream(file);
			
			byte b[] = new byte[5];
			int len;//ÿ�ζ��뵽byte�е��ֽڵĳ���
			// fis.read(b) �Ӵ��������н���� b.length ���ֽڵ����ݶ���һ�� byte �����С�
			while((len = fis.read(b)) !=-1 ) {
				String st = new String(b, 0, len);
				System.out.print(st);
				
//				 for (int i = 0; i < len; i++) {
//					 System.out.print((char) b[i]);
//				 }
			}
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	@Test
	// ʹ��try-catch�ķ�ʽ�������µ��쳣������:��֤���Ĺرղ���һ������ִ��
	public void testFileInputStream2() {
		FileInputStream fis = null;
		try {
			File file = new File("Hello1.txt");
			fis = new FileInputStream(file);
			
			int b;
			while((b=fis.read())!=-1) {
				System.out.print((char)b);
			} 
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
				}
			}
	}
	
	@Test
	// ��Ӳ�̴��ڵ�һ���ļ��У���ȡ�����ݵ������С�ʹ��FileInputStream
    // Ҫ��ȡ���ļ�һ��Ҫ���ڡ�������FileNotFoundException
	public void testFileInputStream1() throws Exception {
		File file = new File("Hello1.txt");
		FileInputStream fis = new FileInputStream(file);
		/*
		 * read():��ȡ�ļ���һ���ֽڡ�һ���ֽ� ����Ǻ��ֶ�������
		 * ��ִ�е��ļ���βʱ������-1
		 */
		int b;
		while((b=fis.read())!=-1) {
			System.out.print((char)b);

		}
		
		fis.close();
	}
}
