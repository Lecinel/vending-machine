package machine;

import java.util.Scanner;

import piece.Button;
import machine.ClassicVendingMachine;
import machine.NewestVendingMachine;

public class VendingMachine implements InputMoney, ReturnMoney {
	private int select = 0;
	private int vmMoney = 0;
	private boolean pushReturnBtn = false;
	private int btnNum, id;

	Scanner stdIn = new Scanner(System.in);

	public VendingMachine() {
		System.out.printf("자판기를 선택해주세요.(Default 음료자판기) 1.음료 2. 꽃자판기 \n:");
		id = stdIn.nextInt();
		setVendingMachine(id);
	}

	public void setVendingMachine(int idNum) { // 자판기 선택 및 기능 수행
		if (idNum > 1 && idNum < 3) {
			NewestVendingMachine fvm = new NewestVendingMachine();
			Button btnF = new Button(fvm.getFlowerList());
			btnF.setProduct(fvm.getFlower());
			btnF.setProductPrice(fvm.getFlowerPrice());
			do {
				inputMoney();
				System.out.println("넣은돈 :" + vmMoney + "원 " + "(불이 들어오는것)");
				btnF.lightable(getVmMoney());
				btnF.pushable();
				btnF.setInputMoney(getVmMoney());
				if (btnF.getBuyable() == true) {
					System.out.printf("첫번째 숫자를 입력해주세요 \n:");
					btnF.newOutPut();
					vmMoney = btnF.getInputMoney();
					System.out.println("현재돈 : " + vmMoney + "원 돈을 반홥하시겠습니까? 1.Yes 2.No");
					pushReturnBtn = (stdIn.nextInt() == 2) ? false : true;
				} else if (pushReturnBtn != true) {
					System.out.println("불이 들어오지 않습니다.");
					System.out.println("돈을 반홥하시겠습니까? 1.Yes 2.No");
					pushReturnBtn = (stdIn.nextInt() == 2) ? false : true;
				}
			} while (pushReturnBtn == false);
			returnMoney();
			pushReturnBtn = false;

		} else {
			ClassicVendingMachine cvm = new ClassicVendingMachine();
			Button btnD = new Button(cvm.getProductList());
			btnD.setProduct(cvm.getProduct());
			btnD.setProductPrice(cvm.getProductPrice());
			do {
				inputMoney();
				System.out.println("넣은돈 :" + vmMoney + "원" + "(불이 들어오는것)");
				btnD.lightable(getVmMoney());
				btnD.pushable();
				btnD.setInputMoney(getVmMoney());
				if (btnD.getBuyable() == true) {
					System.out.printf("사고 싶은 제품의 번호를 입력해주세요. \n:");
					do {
						btnNum = stdIn.nextInt();
					} while (btnNum < 1 && btnNum > 9);
					btnD.outPut(btnNum);
					vmMoney = btnD.getInputMoney();
					btnD.lightable(getVmMoney());
					btnD.pushable();
					if (vmMoney != 0) {
						System.out.println("현재돈 : " + vmMoney + "원 돈을 반환하시겠습니까? 1.Yes 2.No");
						pushReturnBtn = (stdIn.nextInt() == 2) ? false : true;
					}
				} else if (pushReturnBtn != true) {
					System.out.println("불이 들어오지 않습니다.");
					System.out.printf("현재돈 : " + vmMoney + "금액을 투입하시겠습니까? 1.Yes 2.No \n:");
					pushReturnBtn = (stdIn.nextInt() == 2) ? false : true;
				}
			} while (pushReturnBtn == false);
			returnMoney();
			pushReturnBtn = false;
		}

	}

	@Override
	public void inputMoney() { // 자판기 현금 투입
		System.out.printf("금액을 투입해주세요.(press any number kye 투입안함) 1. 동전투입, 2.지폐투입 \n:");
		select = stdIn.nextInt();
		switch (select) {
		case 1:
			System.out.printf("1.500원 2.100원 \n:");
			select = stdIn.nextInt();
			switch (select) {
			case 1:
				addVmMoney(getVmMoney() + 500);
				break;
			case 2:
				addVmMoney(getVmMoney() + 100);
				break;
			default:
				break;
			}
			break;
		case 2:
			System.out.printf("1.10000원, 2.5000원, 3.1000원 \n:");
			select = stdIn.nextInt();
			switch (select) {
			case 1:
				addVmMoney(getVmMoney() + 10000);
				break;
			case 2:
				addVmMoney(getVmMoney() + 5000);
				break;
			case 3:
				addVmMoney(getVmMoney() + 1000);
				break;
			default:
				break;
			}
		default:
			this.pushReturnBtn = true;
		}
	}

	@Override
	public int returnMoney() { // 자판기 돈 반환
		System.out.println("돈을 반환합니다.");
		System.out.println("반환된 돈 " + vmMoney);
		return vmMoney = 0;
	}

	public int getVmMoney() {
		return vmMoney;
	}

	public void addVmMoney(int vmMoney) {
		this.vmMoney = vmMoney;
	}

}
