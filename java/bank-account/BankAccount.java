
class BankAccount {

	private boolean isOpen;

	private int balance;

	public void open() {
		isOpen = true;
		balance = 0;
	}

	public int getBalance() throws BankAccountActionInvalidException {
		checkkAccountStatus();
		return balance;
	}

	public synchronized void deposit(int amount) throws BankAccountActionInvalidException {
		validateNegativeAmount(amount);
		checkkAccountStatus();
		balance += amount;
	}

	public synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
		validateAccountBalance(amount);
		validateNegativeAmount(amount);
		checkkAccountStatus();
		balance -= amount;
	}

	private void checkkAccountStatus() throws BankAccountActionInvalidException {
		if (!isOpen) {
			throw new BankAccountActionInvalidException("Account closed");
		}
	}

	private void validateNegativeAmount(int amount) throws BankAccountActionInvalidException {
		if (amount < 0) {
			throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
		}
	}

	private void validateAccountBalance(int amount) throws BankAccountActionInvalidException {
		if (balance == 0) {
			throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
		}
		if (balance < amount) {
			throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
		}
	}

	public void close() {
		isOpen = false;
	}

}
