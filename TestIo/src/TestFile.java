import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;




/*
 * java.io.File类
 * 1.凡是与输入、输出相关的类、接口等都定义在java.io包下
 * 2.File是一个类，可以有构造器创建其对象。此对象对应着一个文件（.txt .avi .doc .ppt .mp3 .jpg）或文件目录
 * 3.File类对象是与平台无关的。
 * 4.File中的方法，仅涉及到如何创建、删除、重命名等等。只要涉及文件内容的，File是无能为力的，必须由io流来完成。
 * 5.File类的对象常作为io流的具体类的构造器的形参。
 */
public class TestFile {
	@Test
	/*
	 * 
	 *  createNewFile() 当且仅当不存在具有此抽象路径名
	 *  指定名称的文件时，不可分地创建一个新的空文件。
	 *  
		delete() 删除一个File对象的文件或者文件夹  返回boolean值 
		mkDir():创建一个文件目录。只有在上层文件目录存在的情况下，才能返回true
		mkDirs():创建一个文件目录。若上层文件目录不存在，一并创建
		list() 返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。
		listFiles()返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
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
		String str[] = file3.list();//只看文件名的话 就用list用String数组
		
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
		}
		/*
		 * Hello.txt
			io1
			我是一个文件夹
		 */
		
		System.out.println();
		
		File files[] = file3.listFiles();//除了看名还想对文件做什么就用这个 File数组来操作
		for(int i=0;i < files.length;i++) {
			System.out.println(files[i].getName());
		}
		/*
		 * Hello.txt
			io1
			我是一个文件夹
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
		System.out.println(file1.isFile());//是否是一个标准文件
		System.out.println(file1.isDirectory());//测试此抽象路径名表示的文件是否是一个目录。
		System.out.println(file1.length());
		System.out.println(new Date(file1.lastModified()));//返回此抽象路径名表示的文件最后一次被修改的时间。
		/*
		 * true
			true
			true
			true
			false
			14     一个汉字两个字节
			Mon May 21 11:15:38 CST 2018
		 */
		
		System.out.println();
		
		System.out.println(file2.exists());
		System.out.println(file2.canWrite());
		System.out.println(file2.canRead());
		System.out.println(file2.isFile());//false 不是一个标准文件
		System.out.println(file2.isDirectory());//true  是一个目录
		System.out.println(new Date(file2.lastModified()));
		System.out.println(file2.length());//0
		
		
	}

	@Test
	public void test1() {
		/*
		 * 路径：
		 * 绝对路径：包括盘符在内的完整的文件路径
		 * 相对路径：在当前文件目录下的文件的路径
		 * 
		 *  getName()
			getPath()
			getAbsoluteFile()
			getAbsolutePath()
			getParent()
			renameTo(File newName)
			renameTo(File newName):重命名 返回一个boolean
			file1.renameTo(file2):file重命名为file2,要求：file1文件一定要存在，file2一定不存在
		 */
		File file1 = new File("d:/IO/Hello.txt");//绝对路径
		File file2 = new File("Hello1.txt");//相对路径
		
		File file3 = new File("d:/IO/我是一个文件夹");
		File file4 = new File("d:/我是一个文件夹1");
		/*
		 * 	Hello.txt
			d:\IO\Hello.txt
			d:\IO\Hello.txt
			d:\IO
			d:\IO\Hello.txt
			
			我是一个文件夹
			d:\IO\我是一个文件夹
			d:\IO\我是一个文件夹
			d:\IO
			d:\IO\我是一个文件夹
		 */
		System.out.println(file1.getName());//获取文件名
		System.out.println(file1.getPath());//获取路径
		System.out.println(file1.getAbsoluteFile());//返回此抽象路径名的绝对路径名形式。
		System.out.println(file1.getParent());//返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。
		System.out.println(file1.getAbsolutePath());//返回此抽象路径名的绝对路径名字符串。
		
		System.out.println();
		
		System.out.println(file3.getName());
		System.out.println(file3.getPath());
		System.out.println(file3.getAbsoluteFile());
		System.out.println(file3.getParent());
		System.out.println(file3.getAbsolutePath());
		
		System.out.println();
		
		boolean b = file1.renameTo(file2);//Hello.txt在文件夹IO消失了 出现在该工程下了
		boolean bo = file3.renameTo(file4);//我是一个文件夹在文件夹IO里消失了，出现在d盘的我是一个文件夹1
		System.out.println(b);
		System.out.println(bo);
		
	}
}
