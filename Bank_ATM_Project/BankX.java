package Bank_ATM_Project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class BankX implements Bank{
    private String name;

    private double balance;
    private final String currency= "RON";

    LocalDateTime ldt = LocalDateTime.now();
    //    este immutable
    DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");

//constructor
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
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public final void seeBalanceInRON(){
        System.out.println("Total balance is : " + getBalance() + " " +  getCurrency());
    }

    public final Double addRON(double RON){
        this.balance += RON;
        System.out.println(RON + " " + getCurrency()+ " Added successfully to account at: " + ldt.format(dateTimeFormatter));
        return RON;
    }

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

//From Interface!
    public final double yearlyInterest(){

            double yearlyBalanceInterestApplied = getBalance()  +  getBalance() * 5 /100;

            this.balance = yearlyBalanceInterestApplied;
            return yearlyBalanceInterestApplied;
    }



    public final void loanedThroughText(){
        Scanner scanner = new Scanner(System.in);
        int count =0;

        System.out.println("Hello, please insert amount you would like to loan:  ");

        while (true) {

            int option = scanner.nextInt();

            if (option > 100 && option < 10000) {
                setBalance(getBalance() + option);
                System.out.println(option+ " " + getCurrency() + " were added to your account. \nThank you for using this online service.");
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

    public final void loanThroughCall() {
        Scanner scanner = new Scanner(System.in);
        int count =0;
        System.out.println("Hello, please specify the " + getCurrency() + " amount you would like to loan:  ");


        while (true) {

            int option = scanner.nextInt();

            if (option > 100 && option < 10000) {
                setBalance(getBalance() + option);
                System.out.println(option+ " " + getCurrency() + " were added to your account. \nThank you for using this online service.");
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



    abstract  void exchange$ToRON(double insertedDollars);
    public abstract void exchangeEuroToRON(double insertedEuros);




}
