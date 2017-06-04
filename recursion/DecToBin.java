package recursion;

public class DecToBin {

	public static void main(String[] args) {

		int num = 128;
		String result = decToBin(num);
		System.out.println("Dec -> Bin : " + result);

	}

	private static String decToBin(int num) {

		if (num == 1) {
			return String.valueOf(1);
		} else {
			return decToBin(num / 2) + String.valueOf(num % 2);
		}

	}

}
