
public class AdminRights extends login{
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
        if(c.accountDetails.accountNo<node.c.accountDetails.accountNo)
            node.left=insert(node.left,c);
        if(c.accountDetails.accountNo>node.c.accountDetails.accountNo)
            node.right=insert(node.right,c);
        else {
            return node;
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
    int heightTree(nodeC node) {
        if(node==null)
            return 0;
        else {
            int lheight=heightTree(node.left);
            int rheight=heightTree(node.right);
            if(lheight>rheight)
                return lheight+1;
            else
                return rheight+1;
        }
    }
    void preorder(nodeC node) {
        if(node!=null) {
            System.out.println(node.c.name+" "+node.c.accountDetails.accountNo);
            preorder(node.left);
            preorder(node.right);
        }
    }
    void inorder(nodeC  node) {
        if(node!=null) {
            inorder(node.left);
            System.out.println("Name :"+ node.c.name+" ------/------ Account Number : "+node.c.accountDetails.accountNo+" ------/------ Balance : "+node.c.accountDetails.balance);
            inorder(node.right);
        }
    }

    nodeC deleteRec(nodeC root, int key)
    {

        if (root == null)  return root;


        if(key<root.c.accountDetails.accountNo)
            root.left=deleteRec(root.left,key);

        if(key>root.c.accountDetails.accountNo)
            root.right=deleteRec(root.right,key);

        else {
            if (root.left == null || root.right == null) {
                nodeC temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;

            } else {
                nodeC temp = minValue(root.right);

                root.c.accountDetails.accountNo = temp.c.accountDetails.accountNo;
                root.c.name = temp.c.name;

                root.right = deleteRec(root.right, temp.c.accountDetails.accountNo);
            }
        }

        if(root == null)
            return root;

        root.height = 1+ max(height(root.left),height(root.right));

        int balance = getBalanced(root);

        if (balance > 1 && getBalanced(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalanced(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalanced(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalanced(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    nodeC minValue(nodeC root)
    {
        while (root.left != null)
        {
            root = root.left;
        }
        return root;
    }

    void inorderRec(nodeC root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.println(root.c.name+" "+root.c.accountDetails.accountNo);
            inorderRec(root.right);
        }
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
    static double total = 0.0;
    Double TotalBalanceInBank(nodeC temp)
    {
        if(temp == null)
            return 0.0;
        return (temp.c.accountDetails.balance+TotalBalanceInBank(temp.left)+TotalBalanceInBank(temp.right));
    }
}