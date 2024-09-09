package Bank_ATM_Project;

import java.util.Scanner;

public abstract class ATM extends BankX {



//constructor!
    public ATM(String name, double balance) {
        super(name,balance);
    }

    //Methods


public void exchange$ToRON(double insertedDollars){
    System.out.print("1$ Exchange rate : "  + DOLLAR_EXCHANGE_RATE + getCurrency()
            + "\n\tTotal exchanged: " + insertedDollars + " Dollar's at: " +  ldt.format(dateTimeFormatter));

    insertedDollars*= DOLLAR_EXCHANGE_RATE;

    double newBalanceAfterExchange = insertedDollars;

    System.out.println( ", for: " +newBalanceAfterExchange + " " + getCurrency());

     newBalanceAfterExchange= getBalance() + insertedDollars;

    setBalance(newBalanceAfterExchange);
}


    public void exchangeEuroToRON(double insertedEuros){
        System.out.print("1€ Exchange rate : "  + EURO_EXCHANGE_RATE + getCurrency()
                + "\n\tTotal exchanged: " + insertedEuros + " Euro at: " +  ldt.format(dateTimeFormatter));

        insertedEuros *= EURO_EXCHANGE_RATE;

         double newBalanceAfterExchange = insertedEuros;

    System.out.println( ", for: " +newBalanceAfterExchange + " " + getCurrency());

     newBalanceAfterExchange= getBalance() + insertedEuros;

    setBalance(newBalanceAfterExchange);
}


    public final void loan(){
        System.out.println("How would you like to get the loan: \n \t 1) Through bank call ? / \n\t 2) Through text type ?");
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Type option number: ");
            String optionOne = "1";
            String optionTwo = "2";
            String storedPhoneNumber = "";

            String option = scanner.nextLine();
            if (option.equals(optionOne)){
                System.out.println("You selected option 1 - Through Bank call - we will sortly get in touch. \n \tPlease provide your phone number. Thank you.");
                storedPhoneNumber= scanner.nextLine();
//                if (storedPhoneNumber.length() >0 && storedPhoneNumber.length() > 9 && storedPhoneNumber.length() <= 10) {
                if (storedPhoneNumber.matches("^07[3-7][0-9]{7}$")){
                    System.out.println("Your phone number is : " + storedPhoneNumber);
                    loanThroughCall();
                    break;
                }else {
                    System.out.println("Invalid number, retry.");
                }
            } else if (option.equals(optionTwo)) {
                System.out.println("You selected option 2 - Through text type - we will sortly get in touch through message.");
                loanedThroughText();
                break;
            }
        }
    }




    @Override
    public String toString() {
        return "{ Name: " +getName()+
                ", Balance= " + getBalance() +
                " " +  getCurrency() + '\'' +
                '}';
    }
}
