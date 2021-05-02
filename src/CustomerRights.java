import java.io.IOException;

public class CustomerRights extends login
{
char ch;
    int Add_Sub_Money_self(Customer cust, double money,char c) throws IOException
    {
        ApprndingFileInJava obj = new ApprndingFileInJava();
        if(c=='+') {
            ch='+';
            cust.accountDetails.balance += money;
        }
            else {
            if(money > cust.accountDetails.balance)
            {
                System.out.println("Withdrawal amount greater than current balance");
                return 0;
            }
            ch='-';
            cust.accountDetails.balance -= money ;



        }
        obj.writeCustomerDetails(cust,money,ch);
        return 1;
    }
    nodeC search(nodeC root, int key)
    {
        if(root == null || root.c.accountDetails.accountNo == key)
            return root;

        if(key > root.c.accountDetails.accountNo)
            return search(root.right, key);

        else if(key < root.c.accountDetails.accountNo)
            return search(root.left,key);

        return null;
    }
    double Balance(Customer c)
    {
        return c.accountDetails.balance;
    }
    int transfer(Customer c, int d, double money)throws IOException
    { ApprndingFileInJava obj = new ApprndingFileInJava();
        nodeC k = search(root,d);
        if(k == null)
        {
            System.out.println("No receiver with this account number exists");
            return 0;
        }
        else
        {
            if(money > c.accountDetails.balance)
            {
                System.out.println("Amount greater than current balance");
                return 0;
            }
            k.c.accountDetails.balance += money;
            c.accountDetails.balance -= money;
        }
        obj.writeCustomerDetails(c,money,'-');
        obj.writeCustomerDetails(k.c,money,'+');
        return 1;
    }

}
