package piece;

import java.util.Scanner;

public class Button implements Lightable, Pushable, OutPut {

	private boolean[] lighting;
	private boolean[] push;
	private int count = 0;
	private int[] productPrice;
	private String[] product;
	private boolean buy;
	private int inputMoney;
	private int[] productStock;
	private int countNum;
	Scanner stdIn = new Scanner(System.in);
	private int btnNum;
	private String vacuum;
	private boolean okBtn;

	public Button(int productList) {
		this.count = productList;
		this.lighting = new boolean[productList];
		this.push = new boolean[productList];
		this.productStock = new int[productList];
		for (int i = 0; i < productList; i++) {
			lighting[i] = false;
			push[i] = false;
			productStock[i] = 5;
		}
	}

	@Override
	public void pushable() {
		buy = false;
		for (int n = 0; n < count; n++) {
			if (lighting[n] == true) {
				push[n] = true;
				buy = true;
			}
		}
	}

	@Override
	public void lightable(int vmMoney) {
		for (int y = 0; y < count; y++) {
			this.lighting[y] = false;
			if (vmMoney >= productPrice[y] && productStock[y] > 0) {
				this.lighting[y] = true;
			}
			if (lighting[y] == true) {
				System.out.print(product[y] + " ");
			}
		}
		System.out.println();
	}

	@Override
	public void outPut(int select) {
		try {
			if (push[select - 1] == true && lighting[select - 1]) {
				setInputMoney(getInputMoney() - productPrice[select - 1]);
				productStock[select - 1] -= 1;
				System.out.println(product[select - 1] + "을 구매했습니다.");
			} else {
				System.out.println("불이 들어온 것이 없습니다.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void newOutPut() {
		countNum = 0;
		okBtn = false;
		do {
			btnNum = stdIn.nextInt();
		} while (btnNum < 1 || btnNum > 9);
		if (btnNum == 1 && countNum == 0) {
			System.out.printf("두번째 숫자를 입력해주세요: \n");
			Btn: do {
				System.out.println("y를 입력할경우 두번째  자리는 입력되지않습니다.");
				vacuum = stdIn.next();
				if (vacuum.equals("y")) {
					okBtn = true;
					break Btn;
				} else {
					do {
						btnNum = Integer.parseInt(vacuum);
						okBtn = true;
					} while (btnNum < 0 && btnNum > 4);
					countNum += 1;
				}
			} while (okBtn == false);
		} else if (countNum == 0 && btnNum < 10) {
			while (okBtn == true) {
				if (stdIn.next().equals("y")) {
					okBtn = true;
				}
			}
		}
		btnNum = countNum > 0 ? countNum + 9 + btnNum : btnNum;
		outPut(btnNum);
	}

	public boolean getBuyable() {
		return buy;
	}

	public void setProduct(String[] product) {
		this.product = product.clone();
	}

	public void setProductPrice(int[] productPrice) {
		this.productPrice = productPrice.clone();
	}

	public int getInputMoney() {
		return inputMoney;
	}

	public void setInputMoney(int inputMoney) {
		this.inputMoney = inputMoney;
	}

}
