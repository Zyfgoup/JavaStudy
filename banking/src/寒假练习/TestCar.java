package 寒假练习;
class Car{
	String name;
	int wheel;
	
	public void info() {
		System.out.println("name:"+name+" wheel:"+wheel);
	} 
	
	public void show() {
		System.out.println("我是一辆车");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name=n;
	}
	
	public void setWheel(int w) {
		wheel=w;
	}
}

class Factory{
	
	public Car produceCar() {
		return new Car();
	}
	
	public Car produceCar(String n,int w) {
		Car c=new Car();
		c.name=n;
		c.wheel=w;
		return c;
	}
	
	public void decribeCar(Car c) {
		c.info();
	}
}
public class TestCar {
	public static void main(String[] args) {
		Car c1=new Car();
		c1.info();
		c1.name="玛莎拉蒂";
		c1.wheel=4;
		c1.info();
		
		c1.setName("劳斯莱斯");
		c1.setWheel(4);
		c1.info();
		
		Factory f=new Factory();
		Car c2=f.produceCar();
		f.decribeCar(c2);
		
		Car c3=f.produceCar("保时捷", 4);
		f.decribeCar(c3);
	}
}
