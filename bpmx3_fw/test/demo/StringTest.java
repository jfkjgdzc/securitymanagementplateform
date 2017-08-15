package demo;

public class StringTest {
	
	public static void main(String[] args) {
		String a1="abc";
		String a2="abc";
		
		System.out.println(a1==a2);
		
		String a3=new String("abc");
		String a4=new String("abc");
		
		System.out.println(a3.intern()==a1);
		
		System.out.println(a3.intern()==a4.intern());
		
		System.out.println(a3==a4);
	}
}
