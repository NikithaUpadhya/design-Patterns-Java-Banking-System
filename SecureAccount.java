public class SecureAccount {
  private double balance;

  public SecureAccount(double initialBalance) {
      this.balance = initialBalance;
  }

  public double getBalance() {
      return balance;
  }

  public void deposit(double amount) {
      balance += amount;
  }

  public boolean withdraw(double amount) {
      if (balance >= amount) {
          balance -= amount;
          return true;
      }
      return false;
  }
}

