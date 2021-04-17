package com.thread.deadlock;

public class Account {
	int balance = 10000;
	
	public void withdraw(int amount) {
		balance -= amount;
	}
	
	public void deposit(int amount) {
		balance += amount;
	}
	
	public static void transfer(Account ac1, Account ac2, int amount) {
		ac1.withdraw(amount);
		ac2.deposit(amount);
	}

	public int getBalance() {
		return balance;
	}
}
