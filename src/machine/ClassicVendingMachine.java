package machine;

public class ClassicVendingMachine {

	private String[] product = { "1.콜라", "2.사이다", "3.커피", "4.사과주스", "5.오렌지주스", "6.이온음료", "7.탄산수", "8.미숫가루",
			"9.과일탄사주스" };

	private int[] productPrice = { 1000, 1000, 600, 600, 600, 700, 500, 700, 900 };

	public ClassicVendingMachine() {
		System.out.println("\n======음료자판기=======");
		System.out.println("========메뉴========");
		for (int i = 0; i < product.length; i++) {
			System.out.println(product[i] + "(" + productPrice[i] + ")");
		}
		System.out.println("===================");
	}

	public int[] getProductPrice() {
		return productPrice.clone();
	}

	public String[] getProduct() {
		return product.clone();
	}

	public int getProductList() {
		return productPrice.length;
	}

}
