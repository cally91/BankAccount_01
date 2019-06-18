package com.biz.bank_exec;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.biz.bank_mode.BankVO;

public class Bankexec {

	private static BankVO[] accounArray = new BankVO[100];
	private static Scanner scanner = new Scanner(System.in);
	private static final String PREFIX = "Bank";
	private static final BankVO BankVO = null;
	private static int seq = 0;
	private static boolean isGeated = false;
	private static int sep;

	public static void main(String[] args) {
		boolean rnu = true;
		while (rnu) {
			System.out.println("==============================================");
			System.out.println("1.계좌생성 2,계좌목록 3.예금 4.출금 5.종료");
			System.out.println("============================================");
			System.out.print("선택>>");
			int sclectNo = scanner.nextInt();
			switch (sclectNo) {
			case 1:
				createAccoun();
				break;
			case 2:
				accounList();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				rnu = false;
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

	private static void withdraw() {
		if (!isRegistered()) {
			System.out.println("먼저 계좌등록을 하세요");
			return;
		}
		accounList();
		System.out.print("출금한 계좌번호를 선택하세요 >");
		BankVO bvo;
		while (true) {
			String ano = scanner.next();
			bvo = findAccount(ano);
			if (bvo == null)
				System.out.println("계좌번호를 확인하세요");
			else
				break;
		}
		System.out.print("출금할 금액을 입력하세요>");
		int amount = scanner.nextInt();
		int result;
		try {
			result = bvo.withdraw(amount);
			System.out.println("출금액" + result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void deposit() {
		if (isRegistered()) {
			System.out.println("먼저 계좌등록을 하세요");
			return;
		}
		accounList();
		System.out.print("입금할 계좌번호를 선택하세요>");
		BankVO bvo;
		while (true) {
			String ano = scanner.next();
			bvo = findAccount(ano);
			if (bvo == null)
				System.out.print("계좌번호을 확인하세요>");
			else
				break;
		}
		System.out.print("입금할 금액을 입력하세요>");
		int amonut = scanner.nextInt();
		bvo.deposit(amonut);
		System.out.println("예금성공");
	}

	private static void accounList() {
		if (!isRegistered()) {
			System.out.println("먼저 계좌등록을 하세요");
			return;
		}
		for (int i = 0; i < accounArray.length; i++) {
			if (accounArray[i] != null) {
				System.out.println(accounArray[i].getAno() + accounArray[i].getOwner() + accounArray[i].getBalance());
			}
		}
	}

	private static void createAccoun() {
		String ano = PREFIX + String.format(new DecimalFormat("0000").format(++sep));
		System.out.print("소유자명>");
		String owner = scanner.next();
		System.out.print("초기입금액>");
		int amount = scanner.nextInt();
		for (int i = 0; i < accounArray.length; i++) {
			if (accounArray[i] == null) {
				accounArray[i] = new BankVO(ano, owner, amount);
				System.out.println("계좌등록 성공");
				isGeated = true;
				break;
			}
		}
	}

	private static boolean isRegistered() {

		return isGeated;
	}

	private static BankVO findAccount(String ano) {
		BankVO bvo = null;
		for (int i = 0; i < accounArray.length; i++) {
			if (accounArray[i] != null)
				if (accounArray[i].getAno().equals(ano)) {
					bvo = accounArray[i];
				}
		}

		return BankVO;
	}
}
