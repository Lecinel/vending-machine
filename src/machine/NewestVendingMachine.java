package machine;

public class NewestVendingMachine {
	private String[] flower = { "1.장미", "2.개나리", "3.백합", "4.진달래", "5.푸른장미",
								"6.잔디", "7자목련", "8.코스모스", "9.루드베키아", "10.해바라기",
								"11.옥잠화", "12.호접란", "13.알래민다", "14.한련화"};

	private int[] flowerPrice = { 3000, 2500, 4300, 3300, 5000, 1100, 2500, 2000, 3100, 2000, 3600, 4000, 5000, 2700 };

	public NewestVendingMachine() {

		System.out.println("\n======꽃 자판기=======");
		System.out.println("==========종류========");
		for (int i = 0; i < flower.length; i++) {
			System.out.println(flower[i] + "(" + flowerPrice[i] + ")");
		}
		System.out.println("===================");
	}

	public String[] getFlower() {
		return flower.clone();
	}

	public int[] getFlowerPrice() {
		return flowerPrice.clone();
	}

	public int getFlowerList() {
		return flowerPrice.length;
	}
}
