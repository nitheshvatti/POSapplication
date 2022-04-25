import java.util.Scanner;

public class Card extends PaymentMethod{
  private String cardNumber;
  private String expiryDate;
  private String cvv;
  private String pin;
  private PaymentType paymentType=PaymentType.CARD;
  private Merchant merchant;
  private Double amount;
  private static final Scanner scanner = new Scanner(System.in);

  public Card(Merchant merchant, Double amount) {
    super(merchant,amount);
    this.merchant = merchant;
    this.amount = amount;
  }

  @Override
  Transaction initiatePayment() {
    getCardDetails();
    Transaction transaction = processPayment();
    return displayTransaction(transaction);
  }

  @Override
  Transaction processPayment() {
    System.out.println("Please enter your pin: ");
    pin = scanner.nextLine();
    merchant.setAccountBalance(merchant.getAccountBalance()+amount);
    return Transaction.builder()
        .merchant(merchant)
        .paymentType(PaymentType.CARD)
        .amount(amount)
        .build();
  }

  private void getCardDetails() {
    System.out.println("Please enter card number: ");
    cardNumber = scanner.nextLine();
    System.out.println("Please enter expiry date: ");
    expiryDate = scanner.nextLine();
    System.out.println("Please enter cvv: ");
    cvv = scanner.nextLine();
  }
}
