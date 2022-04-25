import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopService {
  private static final Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) {
    List<Transaction> transactionList = new ArrayList<>();
    Merchant merchant = getMerchantDetails();
    //merchant details
      while (true) {
        System.out.println("1: Initiate transaction \n2: View transactions \n3: View account balance \n4: exit ");
        switch (scanner.nextInt()) {
          case 1:
            initiatePayment(transactionList,merchant);
            break;
          case 2:
            viewTransactions(transactionList);
            break;
          case 3:
            viewMerchantBalance(merchant);
            break;
          case 4:
            System.exit(0);
        }
      }
  }

  private static void viewMerchantBalance(Merchant merchant) {
    System.out.println("Merchant Account Balance: "+ merchant.getAccountBalance());
  }

  private static void initiatePayment(List<Transaction> transactionDb,Merchant merchant) {
    Double amount = getPrice();
    PaymentGatewayService paymentGatewayService = new PaymentGatewayService(merchant, amount);
    Transaction transaction = paymentGatewayService.acceptPayment();
    transactionDb.add(transaction);
  }

  private static void viewTransactions(List<Transaction> transactionList) {
    transactionList.stream().forEach(x -> {
      System.out.println(x.toString(x));
    });
  }

  private static Merchant getMerchantDetails() {
    return Merchant.builder()
        .accountBalance(0.0)
        .bankAccountNo("12345")
        .ifscCode("IFSC")
        .bankName("merchant bank")
        .name("merchant")
        .build();
  }

  private static Double getPrice() {
    System.out.println("Please enter amount: ");
    Double amount = scanner.nextDouble();
    return amount;
  }
}
