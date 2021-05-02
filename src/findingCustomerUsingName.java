
public class findingCustomerUsingName {
    public static int arrange(String s1,String s2) {
        int i=0;
        int length=Math.min(s1.length(), s2.length());

        int result=0;
        while(i<length)
        {
            int j=0;
            if(((int)s1.charAt(i)-(int)s2.charAt(j))>0)
                return -1;
            if(((int)s1.charAt(i)-(int)s2.charAt(j))<0)
                return 1;
            else {
                if(s1.equalsIgnoreCase(s2))
                    return 0;
                while(((int)s1.charAt(i)-(int)s2.charAt(j))==0)
                {
                    j++;
                }

            }
            i++;
        }
        return 0;
    }
    nodeC root;
    int height(nodeC node) {
        if(node==null)
            return 0;

        return node.height;
    }
    int max(int a,int b) {
        return (a>b)?a:b;
    }

    int getBalanced(nodeC node) {
        if(node==null)
            return 0;
        return height(node.left)-height(node.right);
    }
    nodeC rightRotate(nodeC y) {
        nodeC x=y.left;
        nodeC x2=x.right;

        x.right=y;
        y.left=x2;
        y.height=1+max(height(y.left),height(y.right));
        x.height=1+max(height(x.left),height(x.right));

        return x;
    }
    nodeC leftRotate(nodeC x) {
        nodeC y=x.right;
        nodeC y2=y.left;

        y.left=x;
        x.right=y2;

        return y;
    }
    nodeC insert(nodeC node,Customer c) {
        if(node==null) {
            return(new nodeC(c));}
        if(arrange(c.name,node.c.name)==-1)
            node.left=insert(node.left,c);
        if(arrange(c.name,node.c.name)==1)
            node.right=insert(node.right,c);
        else {
            nodeC aks =  new nodeC(c);
        }


        node.height = 1+ max(height(node.left),height(node.right));

        int balance=getBalanced(node);
        if(balance>1 && c.accountDetails.accountNo<node.left.c.accountDetails.accountNo)
            return rightRotate(node);
        if(balance<-1 && c.accountDetails.accountNo>node.right.c.accountDetails.accountNo)
            return leftRotate(node);

        if(balance>1 && c.accountDetails.accountNo>node.left.c.accountDetails.accountNo)
        {
            node.left=leftRotate(node);
            return rightRotate(node);
        }
        if(balance<-1 && c.accountDetails.accountNo<node.right.c.accountDetails.accountNo)
        {
            node.right=rightRotate(node);
            return leftRotate(node);
        }
        return node;
    }
}
