package Bank.demo.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TransferBalance {

  private Long from;
  private Long to;
  private BigDecimal amount;
}
