
public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount acct1 = new BankAccount();
		BankAccount acct2 = new BankAccount();
		acct1.deposit(300, "checking");
		acct1.deposit(3000, "savings");
		acct2.deposit(200, "checking");
		acct2.deposit(20000, "savings");
		acct1.displayAcctInfo();
		acct2.displayAcctInfo();
		acct1.withdraw(150, "checking");
		acct1.displayAcctInfo();
		acct2.withdraw(30, "checking");
		acct2.displayAcctInfo();
		BankAccount.displayBankInfo();
	}

}
