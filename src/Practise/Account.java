package Practise;

public class Account {

	int acct_no;
	String name;
	float amount;

	Account(int a, String n,float amt){
		acct_no=a;
		name=n;
		amount=amt;
	}
	
	//	void insert(int a, String n,float amt) {
	//		acct_no=a;
	//		name=n;
	//		amount=amt;
	//	}

	void deposit(float amt) {
		amount=amount+amt;
		System.out.println(amt+" "+ "deposited");
		checkBalance();
	}

	void withdraw(float amt) {
		if(amount<amt) {
			System.out.println("Insufficient");
		}
		else {
			amount=amount-amt;
			System.out.println(amt+" "+"withdrawn");
		}
		checkBalance();
	}

	void checkBalance() {
		System.out.println(amount +" "+"Balance is");
	}

	void display() {
		System.out.println(acct_no+" "+name+" "+amount);
	}
}
