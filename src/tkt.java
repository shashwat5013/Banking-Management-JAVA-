import java.util.*;
import java.io.*;
public class tkt {
    static Scanner x;
    public static void openFiile(){
        try{
            x=new Scanner(new File("C:\\Users\\Akshat\\Desktop\\atmShortest.txt"));
        }
        catch(Exception e){
            System.out.println("file not found");
        }
    }
    public static double readFile() {
        double total = 0;
        while (x.hasNext()) {
            String name = x.next();
            char ch = x.next().charAt(0);
            double number = x.nextDouble();
            int dd=x.nextInt();
            int mm=x.nextInt();
            int yy=x.nextInt();
            int accno=x.nextInt();

            if (ch == '-')
                total -= number;
            else
                total += number;
        }
        x.close();
        return total;
    }
    public static void main(String args[]) throws  IOException{
        openFiile();
        double
                total=readFile();
        System.out.println(total);
    }

    }
