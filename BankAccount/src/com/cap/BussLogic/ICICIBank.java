package com.cap.BussLogic;

import java.util.LinkedList;

import com.cap.Beans.Account;
import com.cap.Excep.InsufficientBalanceException;
import com.cap.Excep.InsufficientOpeningBalException;
import com.cap.Excep.InvalidAccountNumberException;

public class ICICIBank {
	
	LinkedList<Account> l=new LinkedList<>();
	
	public String register(int AccountNumber, int Amount) throws InsufficientOpeningBalException
	{
		if(Amount<=500) {
			throw new InsufficientOpeningBalException();
		}
			
		 Account a=new Account(AccountNumber,Amount);
		 l.add(a);
		 return "User Registered Successfully"+"\n";
			
	}
	
	public String withdraw(int AccountNumber, int Amount) throws InsufficientBalanceException, InvalidAccountNumberException {
		
		  boolean b=false;
		  int bal=0;
		  for(Account a:l) {
			  	
			     if(a.getAccountNumber()==AccountNumber) {
			    	 
			    	 if(a.getAmount()-Amount<=500) {
			    		 
			    		 	throw new InsufficientBalanceException();
			    	 }
			    	 
			    	 bal=a.getAmount()-Amount;
			    	 a.setAmount(bal);
			    	 b=true;
			     }
			}
		  if(b==false) {
			  	
			  throw new InvalidAccountNumberException();
		  }
		return "\nYour Updated Balance is: "+bal+"\n";
	}
	
	public String deposit(int AccountNumber,int Amount) throws InvalidAccountNumberException {
		
		 boolean b=false;
		  int bal=0;
		  for(Account a:l) {
			  	
			     if(a.getAccountNumber()==AccountNumber) {
			    	 
			    	 bal=a.getAmount()+Amount;
			    	 a.setAmount(bal);
			    	 b=true;
			     }
			}
		  if(b==false) {
			  	
			  throw new InvalidAccountNumberException();
		  }
		return "\nUpdated Balance is: "+bal+"\n";
	}
	
	public String fundTransfer(int AccNum1,int AccNum2,int Amount) throws InvalidAccountNumberException, InsufficientBalanceException {
		
		if(AccNumSearch(AccNum1) && AccNumSearch(AccNum2))
		{
			String a=withdraw(AccNum1,Amount);
			String b=deposit(AccNum2,Amount);
			return "Fund Transfered Successfully\n"+a+"Other's "+b;
		}
		
		return "Process Terminate\nPlease re-check the Account Number"+"\n";
						
	}
	
	public Account view(int AccNum) throws InvalidAccountNumberException {
		
		for(Account a:l) {
				if(a.getAccountNumber()==AccNum)
					return a;
		}
		throw new InvalidAccountNumberException();
	}
	
	public boolean AccNumSearch(int AccNumber) {
		
		   for(Account a:l) {
			   
			   		if(a.getAccountNumber()==AccNumber)
			   			  return true;
		   }
		   return false;
	}

}
