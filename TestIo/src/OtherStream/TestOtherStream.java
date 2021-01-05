package OtherStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

public class TestOtherStream {
	@Test
	public void testData1(){
		DataInputStream dis = null;
		try{
			dis = new DataInputStream(new FileInputStream(new File("data.txt")));
//			byte[] b = new byte[20];
//			int len;
//			while((len = dis.read(b)) != -1){
//				System.out.println(new String(b,0,len));
//			}
			String str = dis.readUTF();
			System.out.println(str);
			boolean b = dis.readBoolean();
			System.out.println(b);
			long l = dis.readLong();
			System.out.println(l);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(dis != null){
				try {
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//��������������������������͡�String���ֽ����������:DataInputStream DataOutputStream
	@Test 
	public void testData(){
		DataOutputStream dos = null;
		try {
			FileOutputStream fos = new FileOutputStream("data.txt");
			dos = new DataOutputStream(fos);
			
			dos.writeUTF("�Ұ��㣬����ȴ��֪����");
			dos.writeBoolean(true);
			dos.writeLong(1432522344);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(dos != null){
				try {
					dos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	// ��ӡ�����ֽ�����PrintStream �ַ�����PrintWriter
	@Test
	public void printStreamWriter() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("print.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// ������ӡ�����,����Ϊ�Զ�ˢ��ģʽ(д�뻻�з����ֽ� '\n' ʱ����ˢ�����������)
		PrintStream ps = new PrintStream(fos, true);
		if (ps != null) { // �ѱ�׼�����(����̨���)�ĳ��ļ�
			System.setOut(ps);
		}
		for (int i = 0; i <= 255; i++) { // ���ASCII�ַ�
			System.out.print((char) i);
			if (i % 50 == 0) { // ÿ50������һ��
				System.out.println(); // ����
			}
		}
		ps.close();

	}
}
