import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {

  private String name;
  private Double accountBalance;
  private String bankAccountNo;
  private String ifscCode;
  private String bankName;

}
