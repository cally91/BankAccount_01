package com.biz.bank_exec;

import java.util.Scanner;

import com.biz.bank_mode.BankVO;

public class Bankexec {

	private static BankVO[] accounArray = new BankVO[100];
	private static Scanner scanner = new Scanner(System.in);
	private static final String PREFIX = "Bank";
	private static int seq = 0;
	private static boolean isGeated = false;

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
		System.out.println("출금한 계좌번호를 선택하세요 >");
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
			result =  bvo.withdraw(amount);
			System.out.println("출금액"+result);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	private static void deposit() {
		if(isRegistered()) {
			System.out.println("먼저 계좌등록을 하세요");
			return;
		}
		accounList();
		System.out.println("입금할 계좌번호를 선택하세요>");
		BankVO bVO;
	}

	private static void accounList() {

	}

	private static void createAccoun() {

	}
	private static boolean isRegistered() {
		// TODO Auto-generated method stub
		return false;
	}
	private static BankVO findAccount(String ano) {
		// TODO Auto-generated method stub
		return null;
	}
}
