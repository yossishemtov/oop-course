package bank;

public class ProAccount extends Account {
	private int[] histAcount = new int[100];
	private int numOfTran = 0;

	public ProAccount(String name) {
		super(name);
	}

	@Override
	public void add(int amount) {
		// Using the parent class add method
		super.add(amount);
		/*
		 * Updating the current amount in the account in the account activity log
		 */
		histAcount[numOfTran] = getShekels();
		numOfTran++;
	}

	public static void transfer(ProAccount from, ProAccount to, int amount) {
		// minus the transferred amount
		from.add(-amount);
		// Adding the transferred amount
		to.add(amount);

	}

	public String toString() {
		int i;
		String res = "[";
		for (i = 0; i < numOfTran - 1; i++) {
			res = String.format("%s%d,", res, histAcount[i]);
		}
		res = String.format("%s%d]", res, histAcount[numOfTran - 1]);
		return String.format("%s %s", super.toString(), res);
	}

}
