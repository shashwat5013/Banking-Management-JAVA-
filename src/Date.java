import java.util.*;

public class Date {
    static Scanner in=new Scanner(System.in);
    static Random r=new Random();
    int day;
    int month;
    int year;
    String makeDate(){
        int n=0;
        while(n==0) {
            n=r.nextInt(32);

        }
        day=n;

        n=0;
        while(n==0) {
            n=r.nextInt(10);
        }
        month=n;

        n=0;
        while(n<2015 || n>2018 ) {
            n=r.nextInt(2018);
        }
        year=n;
        return( day+"\\"+month+"\\"+year);

    }
    void setDateOfBirth(){
        System.out.println("Enter DOB in dd mm yy");

        day=in.nextInt();
        month=in.nextInt();
        year=in.nextInt();
    }
    public String returnDate() {
        String date=day+"\\"+month+"\\"+year;
        return date;
    }
}
