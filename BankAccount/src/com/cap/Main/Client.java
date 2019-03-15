package com.cap.Main;

import java.util.Scanner;

import com.cap.BussLogic.ICICIBank;
import com.cap.Excep.InsufficientBalanceException;
import com.cap.Excep.InsufficientOpeningBalException;
import com.cap.Excep.InvalidAccountNumberException;

public class Client {
	
    public static Scanner sc=new Scanner(System.in);
    static ICICIBank a=new ICICIBank();
    static int AccNum=1000;
    
	public static void main(String[] args) {
              
			while(true) {
			          menu();
		}
}
	
	
	
public static void menu() {
		
		System.out.println("ICICC BANK");
		System.out.println("___________");
		System.out.println("1: New User");
		System.out.println("2: WithDraw");
		System.out.println("3: Deposit");
		System.out.println("4: Fund Transfer");
		System.out.println("5: Account Details");
		System.out.println("6: Exit");
		System.out.println("Enter your choice: ");
		int ch=sc.nextInt();
		switch(ch) {
				
					case 1: RDetails();
							break;
					case 2: WithDraw();
							break;
					case 3: Deposit();
							break;
					case 4: FundTransfer();
							break;
					case 5: AccDetails();
							break;
					case 6: System.exit(0);
							break;
					default: System.out.println("Wrong choice !!!");
							
		}
	}
	
	public static void RDetails() {
		
		System.out.println("Account Number: "+AccNum);
		System.out.println("Enter the amount:");
		int amt=sc.nextInt();
		try {
			if(amt>=500) {
				System.out.println(a.register(AccNum, amt));
				AccNum++;
			}
		} catch (InsufficientOpeningBalException e) {
			System.out.println("Insufficient Balance For Opening an account(i.e.,): "+500+"\n");
		}
		
	}
	
	public static void WithDraw() {
			
			System.out.println("Enetr Account Number: ");
			int acc=sc.nextInt();
			System.out.println("Enter Amount to be withdrawn: ");
			int amt=sc.nextInt();
			try {
				System.out.println(a.withdraw(acc, amt));
			} catch (InsufficientBalanceException  e) {
				System.out.println("Insufficient Balance in your account\n");
			}
			  catch( InvalidAccountNumberException e) {
				System.out.println("Invalid Account Number\n");
			}
	}
	
	public static void Deposit() {
		
		System.out.println("Enetr Account Number: ");
		int acc=sc.nextInt();
		System.out.println("Enter Amount to Deposit: ");
		int amt=sc.nextInt();
		try {
			System.out.println(a.deposit(acc, amt));
		} catch (InvalidAccountNumberException e) {
			System.out.println("Invalid Account Number\n");
		}
   }
	
	public static void FundTransfer() {
		
		System.out.println("Enter your Account Number: ");
		int a1=sc.nextInt();
		System.out.println("Enter the Account Nummber of the other person: ");
		int a2=sc.nextInt();
		System.out.println("Enter the amount that you want to transfer: ");
		int amt=sc.nextInt();
		try {
			System.out.println(a.fundTransfer(a1, a2, amt));
		} catch (InsufficientBalanceException  e) {
			System.out.println("Insufficient Balance in your account\n");
		}
		  catch( InvalidAccountNumberException e) {
			System.out.println("Invalid Account Number\n");
		}
	}
	
	public static void AccDetails() {
		
		System.out.println("Enter the Account Number: ");
		int acc=sc.nextInt();
		try {
			System.out.println(a.view(acc));
		} catch (InvalidAccountNumberException e) {
			System.out.println("Invalid Account Number\n");
		}
	}

}
