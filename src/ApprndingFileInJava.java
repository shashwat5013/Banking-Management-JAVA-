import java.io.*;
import java.util.*;
public class ApprndingFileInJava{
    static Scanner in=new Scanner(System.in);
    public static void writeCustomerDetails(Customer cust,double number,char ch) throws IOException {

        File happyFile=new File("C:\\Users\\Akshat\\Desktop\\atmShortest.txt");
        FileWriter writer =  new FileWriter(happyFile,true);
        BufferedWriter buffer=new BufferedWriter(writer);
        PrintWriter  printWriter=new PrintWriter(buffer);

        if(happyFile.exists()==false) {
            happyFile.createNewFile();
            System.out.println("new file is created");
        }
        printWriter.println(cust.name+" "+" "+ch+" "+number+" "+cust.DOB.day+" "+cust.DOB.month+" "+cust.DOB.year+" "+cust.accountDetails.accountNo);
        printWriter.close();
    }
}