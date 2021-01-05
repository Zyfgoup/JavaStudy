import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class FileBuffered {
/*
* �������			�ڵ������ļ�����                                ����������������һ��,���������ļ�������Ч�ʣ�
* InputStream		FileInputStream			BufferedInputStream
* OutputStream		FileOutputStream		BufferedOutputStream  (flush())
* Reader			FileReader				BufferedReader  (readLine())
* Writer			FileWriter				BufferedWriter  (flush())
*/
	@Test
	public void testCopyFile(){
		long start = System.currentTimeMillis();
		String src = "C:\\Users\\hah\\Pictures\\Camera Roll\\����Vs����.jpg";
		String dest = "C:\\Users\\hah\\Pictures\\Camera Roll\\1.jpg";
		CopyFile(src,dest);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	public void CopyFile(String src,String dest){
		BufferedInputStream bis =  null;
		BufferedOutputStream bos = null;
		try {
			File file1 =new File(src);
			File file2 = new File(dest);
			
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			
			 bis = new BufferedInputStream(fis);
			 bos = new BufferedOutputStream(fos);
			
			byte b[] = new byte[1024];
			int len;
			while((len = bis.read(b)) != -1){
				bos.write(b,0,len);
				bos.flush();
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ص�Buffered���͵�  ����Ҳ�ص���
			if(bos != null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bis != null){
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	@Test
	public void testBufferedReaderWriter(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			File src = new File("Hello.txt");
			File dest = new File("Hello4.txt");
			
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(dest);
			
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			char c[] = new char[24];
			int len;
			while((len = br.read(c)) != -1){
				bw.write(c, 0, len);
				bw.flush();
				//ˢ�´˻���������������ʹ���л��������ֽڱ�д�����ײ�������С� 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
