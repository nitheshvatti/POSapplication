import java.util.Scanner;

public class Upi extends PaymentMethod{

  private static final Scanner scanner = new Scanner(System.in);
  private String upiId;
  private String upiPin;

  public Upi(Merchant merchant, Double amount) {
    super(merchant, amount);
  }

  @Override
  Transaction initiatePayment() {
    getCardDetails();
    Transaction transaction = processPayment();
    return displayTransaction(transaction);
  }

  @Override
  Transaction processPayment() {
    //print status
    System.out.println("Please enter your upi pin: ");
    upiPin = scanner.nextLine();
    merchant.setAccountBalance(merchant.getAccountBalance()+amount);
    return Transaction.builder()
        .merchant(merchant)
        .paymentType(PaymentType.UPI)
        .amount(amount)
        .build();
  }

  private void getCardDetails() {
    //input
    System.out.println("Please enter Upi ID: ");
    upiId = scanner.nextLine();
  }
}
