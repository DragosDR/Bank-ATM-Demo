package Bank_ATM_Project;

import java.util.*;

public class Client extends ATM{


    public int age;


    public Client(String name, double balance) {
        super(name, balance);
    }
    public Client(String name, double balance,int age){
        super(name,balance);
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;}

        if (!(o instanceof Client)){
            return false;}

        Client client = (Client) o;
        if(client.age == this.age) {
            return true;
        }
        return false ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);

    }


}
