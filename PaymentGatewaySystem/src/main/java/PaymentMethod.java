
public abstract class PaymentMethod {
  Double amount;
  Merchant merchant;

  public PaymentMethod(Merchant merchant, Double amount) {
    this.amount=amount;
    this.merchant=merchant;
  }

  abstract Transaction initiatePayment();
  abstract Transaction processPayment();

  protected Transaction displayTransaction(Transaction transaction) {
    System.out.println(transaction.toString(transaction));
    return transaction;
  }

}
