import java.io.*;
import java.util.*;
public class AppendingCustomerInJava{
    static Scanner in=new Scanner(System.in);
    public static void writeCustomer(Customer cust) throws IOException {

        File happyFile=new File("C:\\Users\\Akshat\\Desktop\\customer.txt");
        FileWriter writer =  new FileWriter(happyFile,true);
        BufferedWriter buffer=new BufferedWriter(writer);
        PrintWriter  printWriter=new PrintWriter(buffer);

        if(happyFile.exists()==false) {
            happyFile.createNewFile();
            System.out.println("new file is created");
        }
        printWriter.println(cust.name+" "+cust.DOB.day+" "+cust.DOB.month+" "+cust.DOB.year+" "+cust.branchName+" "+cust.phoneNo+" "+cust.accountDetails.accountNo+" "+cust.accountDetails.balance);
        printWriter.close();
    }
}