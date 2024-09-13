import Bank_ATM_Project.BankX;
import Bank_ATM_Project.Client;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        BankX client1 = new Client("Adriana", 0);

        client1.addRON(3500);
        client1.withdraw(500);
        client1.seeBalanceInRON();

        client1.exchangeEuroToRON(5);
        client1.exchange$ToRON(10);
        client1.seeBalanceInRON();


//        client1.loan();
        client1.seeBalanceInRON();

        List<BankX> clientList= new ArrayList<>(Arrays.asList(
                new Client("Ana",125,19),
                new Client("Ion",310,42),
                new Client("Randi",2000,22),
                new Client("Tudor",2650,50),
                new Client("Razvan",1000,16),
                new Client("Cata",10,19),
                new Client("Irina",512,21),
                new Client("Nicolae",4400,22),
                new Client("Didi",3400,19),
                new Client("Mimi",5000,40),
                new Client("Mimi",5000,40),//duplicated data
                new Client("Mimi",5000,40),//duplicated data
                new Client("Mimi",5000,40),//duplicated data
                new Client("Riri",5130,31),
                new Client("Sam",4560,31),
                new Client("Dan",9950,28)));
        System.out.println();

        Set<BankX> cSet = new HashSet<>();
        cSet.addAll(clientList);
//        System.out.println(cSet);






/*
Balance comparison between "people 'in DB'"
 */

        Collections.sort(clientList, new Comparator<BankX>() {

            @Override
            public int compare(BankX o1, BankX o2) {
                if (o1.getBalance()> o2.getBalance()){
                    return -1;
                    
                } else if (o1.getBalance() < o2.getBalance()) {
                    return 1;

                }else {
                    return 0;
                }
            }
        });
//        System.out.println(clientList);





































    }
}