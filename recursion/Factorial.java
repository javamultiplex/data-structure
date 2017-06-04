package recursion;

public class Factorial {

	public static void main(String[] args) {
		
		int num=6;
		int result=fact(num);
		System.out.println("Factorial : "+result);
		
	}

	private static int fact(int num) {
		
		if(num==0 || num==1)
			return 1;
		else
			return num * fact(num-1);
	}
	
}
