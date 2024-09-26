package Bank_ATM_Project;

import java.util.Scanner;

public abstract class ATM extends BankX {



//constructor!
    public ATM(String name, double balance) {
        super(name,balance);
    }

    //Methods

    /**
     *This method handles the conversion of US dollars to Romanian leu (RON). I
     * mount of dollars inserted is less than 10, the method prompts the user to retry with a higher amount and exits.
     * Otherwise, the method prints the current exchange rate for 1 US dollar and calculates the total exchanged amount.
     * It then updates the user's balance by adding the exchanged amount of RON to their existing balance.
     *
     */
    public void exchange$ToRON(double insertedDollars){
        if (insertedDollars<10){
            System.out.println("Unaccepted $ amount, please retry. \n" );
            return;
        }

    System.out.print("1$ Exchange rate : "  + DOLLAR_EXCHANGE_RATE + getCurrency()
            + "\n\tTotal exchanged: " + insertedDollars + " Dollar's at: " +  ldt.format(dateTimeFormatter));

    insertedDollars*= DOLLAR_EXCHANGE_RATE;

    double newBalanceAfterExchange = insertedDollars;

    System.out.println( ", for: " +newBalanceAfterExchange + " " + getCurrency());

     newBalanceAfterExchange= getBalance() + insertedDollars;

    setBalance(newBalanceAfterExchange);
}

    /**
     *
     * This method is responsible for converting Euros to Romanian leu (RON).
     * It first checks if the amount of Euros inserted is at least 10. If not, it displays an error message and exits.
     * If the amount is valid, the method prints the current exchange rate for 1 Euro and calculates the total exchanged amount in RON.
     * The user's balance is then updated by adding the exchanged RON to the current balance.
     */
    public void exchangeEuroToRON(double insertedEuros){
        if (insertedEuros < 10){
            System.out.println("Unaccepted € amount, please retry. \n" );
            return;
        }

        System.out.print("1€ Exchange rate : "  + EURO_EXCHANGE_RATE + getCurrency()
                + "\n\tTotal exchanged: " + insertedEuros + " Euro at: " +  ldt.format(dateTimeFormatter));

        insertedEuros *= EURO_EXCHANGE_RATE;

         double newBalanceAfterExchange = insertedEuros;

    System.out.println( ", for: " +newBalanceAfterExchange + " " + getCurrency());

     newBalanceAfterExchange = getBalance() + insertedEuros;

    setBalance(newBalanceAfterExchange);
}

    /**
     * This method facilitates a loan request by giving the user two options: to receive a loan offer either through a bank call or via text.
     * The method continuously prompts the user to select an option by entering 1 (for a bank call) or 2 (for text communication).
     * If the bank call option is chosen, the user is asked to provide their phone number, which is validated to match a Romanian mobile number format.
     * Upon successful validation, the method initiates the loan process via a call.
     * If the text option is selected, the loan process is initiated through messaging. The method loops until a valid option is chosen.
     */
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
            }else {
                System.out.println("Invalid option");
            }
        }
    }




    @Override
    public String toString() {
        return "{ Name: " +getName()+
                ", Balance= " + getBalance() +
                " " +  getCurrency() + '\'' +
                "}\n";
    }
}
