import java.util.Scanner;

public class PaymentGatewayService {
  Merchant merchant;
  Double amount;
  PaymentMethod paymentMethod;
  private static final Scanner scanner = new Scanner(System.in);
  public PaymentGatewayService(Merchant merchant, Double amount) {
    this.merchant=merchant;
    this.amount=amount;
  }

  Transaction acceptPayment() {
    System.out.println("Select your payment method \n1: Card  \n2: Upi");
    switch (scanner.nextInt()){
      case 1:
        paymentMethod=new Card(merchant,amount);
        break;
      case 2:
        paymentMethod=new Upi(merchant,amount);
    }

    return paymentMethod.initiatePayment();
  }

}
