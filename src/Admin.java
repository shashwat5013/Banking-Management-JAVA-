import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
public class Admin extends login{
    static AdminRights j=new AdminRights();
    public static void adminaccess() throws IOException {
        @SuppressWarnings("resource")
        Scanner in=new Scanner(System.in);
        Vector<Customer> c=new Vector<Customer>();
        int userInput ;
        String ending="start";
        j.root = root ;
        //static  AdminRights shashwat=j.root;
        while(ending.charAt(0)!='e' && ending.charAt(0)!='E')
        {
            System.out.println("                                 ENTER THE RESPECTIVE DIGIT FROM THE GIVEN LIST");
            System.out.println("                                        1 : FOR ADDING CUSTOMER ACCOUNT ");
            System.out.println("                                        2 : DELETING CUSTOMER ACCOUNT");
            System.out.println("                                        3 : SEARCHING CUSTOMER ACCOUNT");
            System.out.println("                                        4 : PRINT THE DATA FOR PRESENT CUSTOMERS");
            System.out.println("                                        5 : PRINT THE TOTAL MONEY IN BANK'S VAULT");
            System.out.println("                                        6 : EXIT ");
            userInput=in.nextInt();
            switch(userInput) {
                case 1:
                    char userChoice='y';
                    AppendingCustomerInJava obj = new AppendingCustomerInJava();
                    while(userChoice=='y') {
                        System.out.println("                            enter name of customer");
                        String name=in.next();
                        Customer temp=new Customer(name); //Add them into a file
                        temp.DOB =new Date();
                        temp.DOB.setDateOfBirth();

                        obj.writeCustomer(temp);
                        c.add(temp);
                        System.out.println("                             type  'Y' to add more customeres");
                        userChoice=in.next().charAt(0);
                    }
                    j.root=j.insert(j.root,c.get(0));
                    for(int i=1;i<c.size();i++) {
                        j.insert(j.root,c.get(i));
                    }
                    System.out.println("Adding accounts successful!");
                    break;

                case 2:

                        System.out.println("                            enter account number of customer");
                        int ac_no=in.nextInt();
                        j.deleteRec(j.root,ac_no);
                        j.inorder(j.root);
                    break;

                case 3 :
                    System.out.println("                            enter account number of customer");
                    int k = in.nextInt();
                    nodeC xyz = j.search(j.root,k);
                    if(xyz == null && j.root == null)
                        System.out.println("No data available to search on!");
                    else if (xyz == null)
                        System.out.println("Account not found!");
                    else
                        System.out.println(xyz.c.name+" "+xyz.c.accountDetails.accountNo);
                    break;

                case 4:
                    j.inorder(j.root);
                    break;

                case 5:
                    double balance = j.TotalBalanceInBank(j.root);
                    if( balance == 0)
                    {
                        System.out.println("There are no accounts");
                    }
                    else

                        System.out.println("Total Money in bank's vault is "+ balance);
                    break;

                case 6:
                    ending="e";
            }
        }
    }
}
