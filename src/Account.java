
public class Account {
    int accountNo;
    double balance;
    Atm atmCard;
    Transaction transDetails;
    void setAccountNo(int data) {
        accountNo=data;
    }
    void setAtmCard(Atm temp) {
        atmCard=temp;
        transDetails=temp.atmUsed;
    }
}
