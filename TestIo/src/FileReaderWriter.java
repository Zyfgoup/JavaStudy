import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;



/*
 * ʹ��FileReader FileWriter ����ʵ���ı��ļ��ĸ��ơ�
 * ���ڷ��ı��ļ�(��Ƶ ��Ƶ ͼƬ) ֻ��ʹ���ֽ���
 */
public class FileReaderWriter {
	@Test
	public void testFileReaderWriter(){
		FileReader fr = null;
		FileWriter fw = null;
		try {
			File src = new File("Hello.txt");
			File dest = new File("Hello3.txt");
			
			 fr = new FileReader(src);
			 fw = new FileWriter(dest);
			
			char ch[] = new char[1024];
			int len;
			while((len = fr.read(ch)) != -1){
				String str = new String(ch, 0, len);
				fw.write(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	@Test
	public void testFileReader(){
		FileReader fr = null;
		try {
			File file = new File("Hello1.txt");
			fr = new FileReader(file);
			char ch[] = new char[1024];
			int len;
			while((len = fr.read(ch)) != -1){
				String str = new String(ch,0,len);
				System.out.println(str);
			}
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
