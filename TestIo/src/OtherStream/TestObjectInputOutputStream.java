package OtherStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

public class TestObjectInputOutputStream {
	// ����ķ����л����̣���Ӳ���е��ļ�ͨ��ObjectInputStreamת��Ϊ��Ӧ�Ķ���
	@Test
	public void testObjectInputStream() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(
					"person.txt"));
			
			Person p1 = (Person)ois.readObject();
			System.out.println(p1);
			Person p2 = (Person)ois.readObject();
			System.out.println(p2);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ois != null){
				
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	// ��������л����̣����ڴ��еĶ���ͨ��ObjectOutputStreamת��Ϊ�����������洢��Ӳ���ļ���
	@Test
	public void testObjectOutputStream() {

		Person p1 = new Person("С��", 23,new Pet("����"));
		Person p2 = new Person("����", 21,new Pet("С��"));

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("person.txt"));

			oos.writeObject(p1);
			oos.flush();
			oos.writeObject(p2);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}

/*
 * Ҫʵ�����л����ࣺ 1.Ҫ������ǿ����л��ģ�ʵ��Serializable�ӿ�
 * 2.Ҫ���������ͬ����Ҫʵ��Serializable�ӿ�
 * 3.�ṩһ���汾�ţ�private static final long serialVersionUID
 * 4.ʹ��static��transient���ε����ԣ�����ʵ�����л�
 */
class Person implements Serializable {
	private static final long serialVersionUID = 23425124521L;
	static String name;
	transient Integer age;
	Pet pet;
	public Person(String name, Integer age,Pet pet) {
		this.name = name;
		this.age = age;
		this.pet = pet;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", pet=" + pet + "]";
	}

	
}
class Pet implements Serializable{
	String name;
	public Pet(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		return "Pet [name=" + name + "]";
	}
	
}