package Bank_ATM_Project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class BankX implements Bank{
    private String name;
    private double balance;
    private final String CURRENCY= "RON";

    LocalDateTime ldt = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

//constructor
    public BankX(){

    }
    public BankX(String name,double balance){
        this.name=name;
        this.balance=balance;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return CURRENCY;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * With this method, Bank's clients can view their current available balance.
     */
    public final void seeBalanceInRON(){
        System.out.println("Total balance is : " + getBalance() + " " +  getCurrency());
    }

    /**
     * A final method, meaning, that when this abstract class will be inherited (extended), the logic applied will be found within this class.
     * That aspect helps in detail hiding & data hiding, two fundamental OOP concepts.
     * The use of  @param RON, helps the customer, adding money to its account (balance).
     */
    public final Double addRON(double RON){
        if(RON <= 0){
            return 0d;
        }else {
            this.balance += RON;
            System.out.println(RON + " " + getCurrency() + " Added successfully to account at: " + ldt.format(dateTimeFormatter));
            return RON;
        }
    }

    /**
     * A final method, meaning, that when this abstract class will be inherited (extended), the logic applied will be found within this class.
     * That aspect helps in detail hiding & data hiding, two fundamental OOP concepts.
     * The use of  @param RON, helps the customer, withdrawing money from its account (balance).
     */
    public final Double withdraw(double RON){
        if (RON < 10){
            System.out.println("Amount to be withdrawn too low please retry.");

        }else if ( RON > this.balance){
            System.out.println("Amount to be withdrawn exceeds balance! [" + this.balance +" " + getCurrency() + "] Please Retry.");

        }else {
            this.balance -= RON;
            System.out.println(RON + " " + getCurrency()+ " Withdrawn successfully from account at: " +  ldt.format(dateTimeFormatter));
        }
        return RON;
    }



    /**
     * This method is implemented form the Bank Interface.
     * I used the JAVA keyword final, so the method cannot be overridden by subclasses.
     * When a method is declared as the final method in the parent class, then any child class cannot override or modify the final method in java.
     * @return
     */
    public final Double yearlyInterest(){

            double yearlyBalanceInterestApplied = getBalance()  +  getBalance() * 5 /100;

            this.balance = yearlyBalanceInterestApplied;
            return yearlyBalanceInterestApplied;
    }


    /**
     * This method is called from ATM class and reflects the interaction between a client and a Bank Text-Robot.
     * I used the JAVA keyword, final so the method cannot be overridden by subclasses.
     *      * When a method is declared as the final method in the parent class, then any child class cannot override or modify the final method in java.
     */
    public final void loanedThroughText(){
        Scanner scanner = new Scanner(System.in);
        int count =0;

        System.out.println("Hello, please insert amount you would like to loan:  ");

        while (true) {

            int option = scanner.nextInt();

            if (option >= 100 && option < 10000) {
                setBalance(getBalance() + option);
                System.out.println(option+ " " + getCurrency() + " were added to your account. \nThank you for using this ATM service.");
                return;
            } else {
                System.out.println("Amount unaccepted please re-insert amount or contact the bank for further support.");
                count++;
            }

            if (count > 2){
                System.out.println("Unsupported operation- Session expired");
                break;
            }
        }

    }

    /**
     *This method is called from ATM class and reflects the interaction between a client and a Bank Robot.
     *I used the JAVA keyword, final so the method cannot be overridden by subclasses.
     *      * When a method is declared as the final method in the parent class, then any child class cannot override or modify the final method in java.
     */

    public final void loanThroughCall() {
        Scanner scanner = new Scanner(System.in);
        int count =0;
        System.out.println("Hello, please specify the " + getCurrency() + " amount you would like to loan:  ");


        while (true) {

            int option = scanner.nextInt();

            if (option >= 100 && option < 10000) {
                setBalance(getBalance() + option);
                System.out.println(option+ " " + getCurrency() + " were added to your account. \nThank you for using this ATM service.");
                return;
            } else {
                System.out.println("Amount unaccepted.");
                count++;
            }

            if (count > 2){
                System.out.println("Unsupported operation- Session expired");
                break;
            }
        }

    }


    /**
     * exchange$ToRON method, will only be found and defined within the ATM subclass.
     * Find the logic of the method there.
     * @param insertedDollars is a parameter that reflects the amount of dollars( in this specific case) that the client exchanges through this functionality, at the specific rate.
     */
    public abstract  void exchange$ToRON(double insertedDollars);

    /**
     * exchangeEuroToRON method, will only be found and defined within the ATM subclass.
     * Find the logic of the method there.
     * @param insertedEuros is a parameter that reflects the amount of euros ( in this specific case) that the client exchanges through this functionality, at the specific rate.
     */
    public abstract void exchangeEuroToRON(double insertedEuros);




}
