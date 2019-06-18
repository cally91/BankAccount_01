package com.biz.bank_mode;

public class BankVO {

	private String ano; // 계좌번호
	private String owner; // 소유자
	private int balance;
	private int deposit;

	public BankVO(String ano, String owner, int balance) {
		super();
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
	
		this.balance = balance;
	}
	public void deposit(int amount) {
		this.deposit+= amount;
	}
	public int withdraw (int ampunt )throws Exception{
		if(this.deposit<ampunt) {
			throw new Exception("잔액이 모자랍니다.");
		}else {
			this.balance-=ampunt;
		}
		return ampunt;
	}


	}
