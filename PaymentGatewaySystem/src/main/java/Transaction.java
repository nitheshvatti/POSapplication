import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Transaction {
  Merchant merchant;
  Double amount;
  PaymentType paymentType;

  String toString(Transaction transaction){
    return "Transaction Amount: "+transaction.getAmount()+" Payment Type: "+transaction.getPaymentType();
  }

}
