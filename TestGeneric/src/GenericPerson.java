interface Info{//只有此接口的子类才是表示人的信息
}

class Contact implements Info {
	private String address;  //联系地址
	private String telephone;  //联系电话
	private String zipcode;  //邮政编码
	
	public Contact (String address,String telephone,String zipcode) {
		this.address=address;
		this.telephone=telephone;
		this.zipcode=zipcode;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	public String getAddress() {
		return address;
	}
	
	public void setTelephone(String telephone) {
		this.telephone=telephone;
	}
	public String getTelephone() {
		return telephone;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode=zipcode;
	}
	public String getZipcode() {
		return zipcode;
	}

	@Override
	public String toString() {
		return "Contact [address=" + address + ", telephone=" + telephone + ", zipcode=" + zipcode + "]";
	}
	
}

class Introduction implements Info{
	private String name;
	private String sex;
	private int age;
	
	
	public Introduction(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Introduction [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
}

class Person<T extends Info>{
	private T info;
	
	public Person(T info) {
		this.info=info;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Person [info=" + info + "]";
	}
}

public class GenericPerson{
	public static void main(String args[]){
		Person<Contact> per=null;
		per=new Person<>(new Contact("广州", "13169232921", "514453"));
		System.out.println(per);
		
		Person<Introduction> per2=null;
		per2=new Person<>(new Introduction("邹", "男", 18));
		System.out.println(per2);
	}
}
