package com.cap.Beans;

public class Account {
	
		private int AccountNumber;
		private int Amount;
		
		public Account(int accountNumber, int amount) {
			super();
			AccountNumber = accountNumber;
			Amount = amount;
		}

		public int getAccountNumber() {
			return AccountNumber;
		}

		public void setAccountNumber(int accountNumber) {
			AccountNumber = accountNumber;
		}

		public int getAmount() {
			return Amount;
		}

		public void setAmount(int amount) {
			Amount = amount;
		}

		@Override
		public String toString() {
			return "Details: \nAccountNumber=" + AccountNumber + "\nAmount=" + Amount+"\n";
		}

		
}
