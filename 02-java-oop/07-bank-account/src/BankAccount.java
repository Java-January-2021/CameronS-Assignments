import java.util.Random;

public class BankAccount {
	private String accountNum;
	private double checkingBalance;
	private double savingsBalance;
	public static int accountCount;
	public static double totalBalance = 0;
	private double defChecking = 0;
	private double defSavings = 0;

	public BankAccount() {
		this.accountNum = createAccountNum();
		this.checkingBalance = defChecking;
		this.savingsBalance = defSavings;
		accountCount += 1;
	}

	private String createAccountNum() {
		String randomNum = "";
		Random rand = new Random();
		System.out.println(randomNum);
		for(int i = 0; i<10; i++) {
			randomNum += rand.nextInt(10);
		}
		return randomNum;
	}
	private double displayAccountBalance() {
		double userTotal = (this.checkingBalance+this.savingsBalance);
		return userTotal;
	}
	private double getCheckingBalance() {
		return this.checkingBalance;
	}
	private double getSavingsBalance() {
		return this.savingsBalance;
	}
	private String getID() {
		return this.accountNum;
	}
	
	public static int getAccountCount() {
		return accountCount;
	}

	public static double getTotalBalance() {
		return totalBalance;
	}

	public void deposit(int amount, String account) {
		if(account.equals("savings")) {
			this.savingsBalance += amount;
			System.out.println("Accout: "+getID()+" Deposited "+amount+" into: "+account);
		}
		else if(account.equals("checking")) {
			this.checkingBalance += amount;
			System.out.println("Accout: "+getID()+" Deposited "+amount+" into: "+account);
		}
		BankAccount.totalBalance += amount;
	}
	public void withdraw(int amount, String account) {
		if(account.equals("savings") && this.savingsBalance >= amount) {
			this.savingsBalance -= amount;
			BankAccount.totalBalance -= amount;
			System.out.println("Accout: "+getID()+" Withdrew "+amount+" From: "+account);
		}
		else if(account.equals("checking")&& this.checkingBalance >= amount) {
			this.savingsBalance -= amount;
			BankAccount.totalBalance -= amount;
			System.out.println("Accout: "+getID()+" Withdrew "+amount+" From: "+account);
		}
		else {
			System.out.println("Insufficient funds.");
			return;
		}
	}
	public void displayAcctInfo() {
		System.out.println("Accout: "+getID());
		System.out.println("Savings: "+getSavingsBalance());
		System.out.println("Checking: "+getCheckingBalance());
		System.out.println("Total Balance: "+displayAccountBalance());
	}
	public static void displayBankInfo() {
		System.out.println("Total Acounts: "+getAccountCount());
		System.out.println("Bank Assets: "+getTotalBalance());
	}
}