package Bank_ATM_Project;

public interface Bank {
     double EURO_EXCHANGE_RATE = 4.95d;
     double DOLLAR_EXCHANGE_RATE = 3.2d;

     Double addRON(double RON);
     Double withdraw(double RON);
     void seeBalanceInRON();
     void loan();
     Double yearlyInterest();

}
