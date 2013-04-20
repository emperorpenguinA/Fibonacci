package test20130420;

public class Fibonacci {

	/**
	 * 1以上の整数を引数に取る関数
	 * 入力された引数の桁数に最初に到達するフィボナッチ数列の値を表示する
	 * */
	public static void main(String[] args) {
		try {
			Integer number = Integer.parseInt(args[0]);
			if (number == 0) {
				System.out.println("ERROR：1以上の整数を入力して下さい。");
			} else {
				FibonacciClass result = Disp(number);
				System.out.println(number + "桁に達する最初の項は" + result.value + "(第" + result.term + "項)" + "です。");
			}

		} catch (NumberFormatException e) {
			System.out.println("ERROR：1以上の整数を入力して下さい。");
		}

	}

	/**
	 * 入力された引数の桁数に最初に到達するフィボナッチ数列を返す関数
	 * */
	private static FibonacciClass Disp(Integer number) {

		FibonacciClass result = new FibonacciClass();

		int i = 1;
		/*
		 * フィボナッチ数列の値が n桁の数字(10のn-1乗以上の数字)になったとき
		 * そのフィボナッチ数列の情報を返す
		 */
		while (result.value < (int)Math.pow(10, (double)(number - 1))) {
			result.value = getFibonacciValue(i);
			result.term = i;
			i++;
		}

		return result;
	}

	/**
	 * 引数の項のフィボナッチ数列の値を返す
	 * フィボナッチ数列：F(n) = F(n-1) + F(n-2)
	 * */
	private static Integer getFibonacciValue(Integer number){

		//第1項の値
		Integer F1 = 0;

		//第2項の値
		Integer F2 = 1;

		Integer result = 0;

		if (number == 1) {
			result = F1;
		} else if (number == 2) {
			result = F2;
		} else {
			result = getFibonacciValue(number - 1) + getFibonacciValue(number - 2);
		}

		return result;
	}

	/**
	 * フィボナッチ数列の項数(term)と値(value)をもつクラス
	 * */
	private static class FibonacciClass {
		/** フィボナッチ数列の項数 */
		private Integer term;

		/** フィボナッチ数列の値 */
		private Integer value;

		public FibonacciClass() {
			term = 0;
			value = 0;
		}

	}

}
