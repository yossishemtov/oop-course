package bank;

public class Account {
	private int balancAccount = 0;
	private String accountName;

	public Account(String name) {
		this.accountName = name;

	}

	public int getShekels() {
		return balancAccount;
	}

	public String getName() {
		return accountName;
	}

	public void add(int amount) {
		balancAccount += amount;
	}

	public String toString() {
		return String.format("%s has %d shekels", accountName, balancAccount);
	}

}
