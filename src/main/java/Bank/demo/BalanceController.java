package Bank.demo;

import Bank.demo.model.TransferBalance;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/Balance")
@AllArgsConstructor
public class BalanceController {

  private BankService bankService;


  @GetMapping("/{accountId}")
  public BigDecimal getBalance(@PathVariable Long accountId) {
    return bankService.getBalance(accountId);
  }

  @PostMapping("/add")
  public BigDecimal addMoney(@RequestBody TransferBalance transferBalance) {
    return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());
  }

  @PostMapping("/transfer")
  public void transfer(@RequestBody TransferBalance transferBalance) {
   bankService.makeTransfer(transferBalance);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public String handle(IllegalArgumentException e) {
    log.error(e.getMessage());
    return "MAMA, YA SLOMALSIA";
  }
}
