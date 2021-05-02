import java.io.File;
import java.io.IOException;
import java.util.*;
public class login  {

    static Scanner x;
    static nodeC root;
    public static void openFile() {
        try {
            x=new Scanner( new File("C:\\Users\\Akshat\\Desktop\\customer.txt") );
        }
        catch(Exception e) {
            System.out.println("customer ");
        }
    }
    public static void readFile() {
        AdminRights k =new AdminRights();
        while(x.hasNext()) {
            String name=x.next();
            int dd=x.nextInt();
            int mm=x.nextInt();
            int yy=x.nextInt();
            String branch=x.next();
            double phone=x.nextDouble();
            int accnum=x.nextInt();
            double balance=x.nextDouble();
            Customer cust=new Customer(name,dd,mm,yy,branch,phone,accnum,balance);
            root = k.insert(root, cust);
        }
        x.close();
    }

    public static void openAdminFile() {
        try {
            x = new Scanner(new File("C:\\Users\\Akshat\\Desktop\\Admins.txt"));
        } catch (Exception e) {
            System.out.println("error node file");
        }
    }

    static String SearchAdmin(String name, int pass) {
        while (x.hasNext()) {
            String rname = x.next();
            int rpass = x.nextInt();
            if (rname.equals(name) && rpass == pass)
                return rname;
        }
        return null;
    }

    public static void openCustomerFile() {
        try {
            x = new Scanner(new File("C:\\Users\\Akshat\\Desktop\\Customer.txt"));
        } catch (Exception e) {
            System.out.println("error node file");
        }
    }

    static Customer SearchCustomer(int acno, int pass) {
        while (x.hasNext()) {
            String rname = x.next();
            int raccno = x.nextInt();
            int rpass = x.nextInt();
            if (raccno == acno && rpass == pass)
            {
                Customer x =null;
            }
        }
        return null;
    }


    public static void main(String args[]) throws IOException {
        openFile();
        readFile();
        Scanner k = new Scanner(System.in);

        System.out.println("Enter 'A' to login as a admin \n Enter 'C' to login as a customer");

        char c = k.next().charAt(0);

        if (c == 'A' || c =='a') {
            System.out.println("Enter username and password");

            String name = k.next();
            int pass = k.nextInt();
            openAdminFile();
            String admin = SearchAdmin(name, pass);
            if (admin != null) {
                System.out.println("Login Successful, Welcome "+admin);
                Admin obj = new Admin();
                obj.adminaccess();
            }
            else
            {
                System.out.println("Not an Admin");
            }
        }
        if (c == 'C' || c=='c') {
            System.out.println("Enter account number");
            int acno = k.nextInt();
            AdminRights avl = new AdminRights();
            avl.root = root;
            nodeC customer =avl.search(avl.root, acno);
            if (customer != null) {
                System.out.println("Login Successful, Welcome "+customer.c.name);

                customer.c.access();

            }
            else
            {
                System.out.println("not a customer");
            }
        }
    }
}
