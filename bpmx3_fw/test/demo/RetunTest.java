package demo;

public class RetunTest {
	
	
	
	public static void main(String[] args) {
		Void obj= Test.hello();
	}

	static class Test{
		public static Void hello(){
			System.out.println("hello");
			return null;
		}
	}
}

