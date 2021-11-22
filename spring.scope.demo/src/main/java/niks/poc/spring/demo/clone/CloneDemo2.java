package niks.poc.spring.demo.clone;

class CloneDemo1 implements Cloneable{
	int x;
	int y;
	
	
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
		//throw new CloneNotSupportedException("illegal contract! not supported");
	}
}
public class CloneDemo2 implements Cloneable{
	int a;
	int b;
	CloneDemo1 c = new CloneDemo1();
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneDemo2 t1 = new CloneDemo2();
		
		t1.a = 10;
		t1.b = 20;
		t1.c.x = 30;
		t1.c.y = 40;
		
		CloneDemo2 t2 =  (CloneDemo2) t1.clone();
		
		//t2.c = new CloneDemo1(); //deep copy
		
		t2.c = (CloneDemo1) t2.c.clone();
		
		t2.a = 100;
		
		t2.c.x = 300;
		//t2.c.y = 400;
		
		System.out.println(t1.c.hashCode());
		System.out.println(t2.c.hashCode());
		
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		
		// Change in object type field will be
        // reflected in both t2 and t1(shallow copy)
        System.out.println(t1.a + " " + t1.b + " " + t1.c.x
                           + " " + t1.c.y);
        System.out.println(t2.a + " " + t2.b + " " + t2.c.x
                           + " " + t2.c.y);
	}

}
