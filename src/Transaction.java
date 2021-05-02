import java.io.*;
public class Transaction extends ApprndingFileInJava{
    String D;
    String place;
    void used() {
        Date d = new Date();
        D=d.makeDate();
        place="Noida";
    }
    String returnDate()
    {
        return D;
    }
}
