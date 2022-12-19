package Practise;

public class AccountRunner {

	public static void main(String[] args) {
		Account a = new Account(123456, "Amar", 2000);
		//a.insert(123456, "Amar", 2000);
		a.display();
		//a.checkBalance();
		a.deposit(200);
		//a.checkBalance();
		a.withdraw(700);
		//		a.checkBalance();
	}

}
