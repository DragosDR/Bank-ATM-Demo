import Bank_ATM_Project.BankX;
import Bank_ATM_Project.Client;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        BankX client1 = new Client("Adriana", 100);

        client1.addRON(10);
        client1.withdraw(10);
        client1.seeBalanceInRON();


        client1.loan();
        client1.seeBalanceInRON();







/*
Balance comparison between "people in DB"
 */
//        List<BankX> clientList= new ArrayList<>(Arrays.asList(client1,
//                new Client("Ana",125),
//                new Client("Ion",310),
//                new Client("Randi",2000),
//                new Client("Tudor",2650),
//                new Client("Razvan",1000),
//                new Client("Cata",10),
//                new Client("Irina",512),
//                new Client("Nicolae",4400),
//                new Client("Didi",3400),
//                new Client("Mimi",5000),
//                new Client("Riri",5130),
//                new Client("Sam",4560),
//                new Client("Dan",9950)));
//        System.out.println(clientList);
//
//        Collections.sort(clientList, new Comparator<BankX>() {
//            @Override
//            public int compare(BankX o1, BankX o2) {
//                if (o1.getBalance()> o2.getBalance()){
//                    return -1;
//                } else if (o1.getBalance() < o2.getBalance()) {
//                    return 1;
//                }else {
//                    return 0;
//                }
//            }
//        });
//        System.out.println(clientList);
//        System.out.println();




































    }
}