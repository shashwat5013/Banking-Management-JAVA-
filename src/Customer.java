import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Customer extends dijkstraCode  {
    String name;
    Date DOB;
    String branchName;
    double phoneNo;
    Account accountDetails;

    Customer(String name) {
        this.name = name;
        Random r = new Random();
        int number = 20280000;
        int n = r.nextInt(10000);
        number += n;
        accountDetails = new Account();
        accountDetails.setAccountNo(number);
        Scanner k = new Scanner(System.in);
        System.out.println("Enter 'Bank,Branch(city)'");
        this.branchName = in.nextLine();
        System.out.println("Enter mobile number");
        this.phoneNo = in.nextDouble();
    }
    Customer(String name,int dd,int mm,int yy,String branch,double phone,int accnum,double balance){
        this.name=name;
        DOB=new Date();
        DOB.day=dd;
        DOB.month=mm;
        DOB.year=yy;
        branchName=branch;
        accountDetails=new Account();
        accountDetails.accountNo=accnum;
        accountDetails.balance=balance;
        accountDetails.atmCard=new Atm();
    }

     public void access() throws IOException {
        Scanner in = new Scanner(System.in);
        int userInput;
        String ending = "start";
        CustomerRights j = new CustomerRights();
        while (ending.charAt(0) != 'e' || ending.charAt(0) != 'E') {
            System.out.println("                                 ENTER THE RESPECTIVE DIGIT FROM THE GIVEN LIST");
            System.out.println("                                        1 : FOR ADDING AMOUNT INTO  ACCOUNT ");
            System.out.println("                                        2 : FOR WITHDRAWING AMOUNT FROM ACCOUNT");
            System.out.println("                                        3 : FOR TRANSFERRING AMOUNT TO ANOTHER ACCOUNT");
            System.out.println("                                        6 : FIND NEAREST ATMS ");
            System.out.println("                                        7 : CHECK BALANCE");
            System.out.println("                                        8 : EXIT");
            userInput = in.nextInt();
            switch (userInput) {
                case 1:
                    System.out.println("Enter amount");
                    double amt1 = in.nextDouble();
                    int x = j.Add_Sub_Money_self(this, amt1, '+');
                    if (x == 1) {
                        System.out.println("Successful!");
                    } else {
                        System.out.println("Failed!");
                    }
                    break;

                case 2:
                    System.out.println("Enter amount");
                    double amt2 = in.nextDouble();
                    int y = j.Add_Sub_Money_self(this, amt2, '-');
                    if (y == 1) {
                        System.out.println("Successful!");
                    } else {
                        System.out.println("Failed!");
                    }
                    break;

                case 3:
                    System.out.println("Enter Account number of the receiver");
                    int acno = in.nextInt();
                    System.out.println("Enter money");
                    double money = in.nextDouble();
                    int d = j.transfer(this,acno,money);
                    if(d!=1)
                    {
                        System.out.println("Failed!");
                    }
                    else
                    {
                        System.out.println("Transaction Successful");
                    }
                    break;

                case 6 :
                        mainDriver();
                    break;

                case 7 :
                    System.out.println(j.Balance(this));
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}
