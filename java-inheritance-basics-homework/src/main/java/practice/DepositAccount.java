package practice;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
   protected LocalDate lastIncome;

   @Override
   public void put(double amountToPut) {
      super.put(amountToPut);
      lastIncome = LocalDate.now();
   }

   @Override
   public void take(double amountToTake) {
      LocalDate date = LocalDate.now();
      if (date.isAfter(lastIncome.plusMonths(1))) {
         super.take(amountToTake);
      }



   }

}
