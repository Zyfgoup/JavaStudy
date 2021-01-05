import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;



/*
 * 1.流的分类：
 * 按照数据流向的不同：输入流 输出流
 * 按照处理数据的单位的不同；字节流 字符流（处理的文本文件）
 * 按照角色的不同： 节点流（直接作用于文件）  处理流
 * 
 *  
 * 2.IO的体系
 * 抽象基类                 节点流(文件流)
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
		String dest = "C:\\Users\\hah\\Desktop\\exp6_3.txt";//可以不存在 不存在则创建一个！
		copyFile(src,dest);
		long end = System.currentTimeMillis();
		System.out.println(start-end);
	}
	
	//实现文件复制的方法
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
			//相当于会把要写入的文件的全部内容先删除了，
			//然后写入读取的文件的内容
			while((len=fis.read(b)) !=-1) {
				fos.write(b,0,len);
				
			}
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//先关闭输出流
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
			//相当于会把要写入的文件的全部内容先删除了，
			//然后写入读取的文件的内容
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
		// 输出的物理文件可以不存在，当执行过程中，
		//若不存在，会自动的创建。若存在，会将原有的文件覆盖
		FileOutputStream  fos = null;
		try {
			File file = new File("Hello2.txt");
			  fos = new FileOutputStream(file);
			//写入内容会把原来的内容覆盖掉
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
		FileInputStream fis = null;//要设置初始值 不然后面关闭close()处有错误
		try {
			File file = new File("Hello2.txt");
			fis = new FileInputStream(file);
			
			byte b[] = new byte[5];
			int len;//每次读入到byte中的字节的长度
			// fis.read(b) 从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。
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
	// 使用try-catch的方式处理如下的异常更合理:保证流的关闭操作一定可以执行
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
	// 从硬盘存在的一个文件中，读取其内容到程序中。使用FileInputStream
    // 要读取的文件一定要存在。否则抛FileNotFoundException
	public void testFileInputStream1() throws Exception {
		File file = new File("Hello1.txt");
		FileInputStream fis = new FileInputStream(file);
		/*
		 * read():读取文件的一个字节。一个字节 如果是汉字读不出来
		 * 当执行到文件结尾时，返回-1
		 */
		int b;
		while((b=fis.read())!=-1) {
			System.out.print((char)b);

		}
		
		fis.close();
	}
}
