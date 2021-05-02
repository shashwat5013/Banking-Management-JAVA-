import java.io.File;
import java.util.Scanner;

public class dijkstraCode extends login {
    static int numberOfEdges=0;
    static Scanner in=new Scanner(System.in);
    class Node{
        String s;
        double number1;
        double number2;
        Node(String s,double x,double y){
            this.s=s;
            number1=x;
            number2=y;
        }
        String returnString() {
            return s;
        }
        double returnnumber() {
            return number1;
        }
        double returnnumber2() {
            return number2;
        }

    }
    static Node a[];
    private Scanner x;
    public void openNodefile() {
        try {
            x=new Scanner(new File("C:\\Users\\Akshat\\Desktop\\node.txt"));
        }
        catch(Exception e) {
            System.out.println("error node file");
        }
    }
    public Node[] readNodeFile() {
        Node arr[]=new Node[11];                       //change number of nodes
        int i=0;
        while(x.hasNext()) {
            String s=x.next();
            double number1=x.nextDouble();
            double number2=x.nextDouble();
            numberOfEdges++;
            arr[i]=new Node(s,number1,number2);
            i++;
        }
        x.close();
        return arr;

    }
    public void openEdgeFile() {
        try {
            x=new Scanner(new File("C:\\Users\\Akshat\\Desktop\\Edge.txt"));
        }
        catch(Exception e) {
            System.out.println("error in Edges file");
        }
    }
    public int returnIndex(String s,Node a[]) {
        for(int i=0;i<a.length;i++) {
            if(a[i].returnString().equals(s)) {
                return i;
            }
        }
        return -1;
    }
    public double[][] readEdgeFile(double graph[][],Node a[]){
        double g[][]=graph;
        while(x.hasNext()) {
            String first=x.next();
            String second=x.next();
            int firstIndex=returnIndex(first,a);
            int secondIndex=returnIndex(second,a);
            g[firstIndex][secondIndex]=distance(a[firstIndex],a[secondIndex]);
            g[secondIndex][firstIndex]=distance(a[firstIndex],a[secondIndex]);
        }
        x.close();
        return g;
    }
    Scanner y;
    public void openAtmFile() {
        try {
            y=new Scanner(new File("C:\\Users\\Akshat\\Desktop\\atm.txt"));
        }
        catch(Exception e) {
            System.out.println("error node file");
        }
    }
    public  String[] readAtmFile() {
        String arr[]=new String[3];					//change here number of atm n nodes
        int i=0;
        while(y.hasNext()) {
            String s=y.next();
            arr[i]=new String(s);
            i++;
        }
        //System.out.println(i);
        return arr;
    }
    public double distance(Node first,Node second) {
        double result=0.0;
        result=Math.sqrt(Math.pow(first.returnnumber()-second.returnnumber(), 2)+Math.pow(first.returnnumber2()-second.returnnumber2(),2))*10;
        return result;
    }
    public void display(double graph[][]) {
        for(int row=0;row<graph.length;row++) {
            for(int col=0;col<graph.length;col++) {
                System.out.print(graph[row][col]+"         ");
            }
            System.out.println();
        }
    }
    public static void mainDriver() {
        dijkstraCode c=new dijkstraCode();
        c.openNodefile();
        a=c.readNodeFile();
        double graph[][]=new double[a.length][a.length];
        for(int row=0;row<a.length;row++) {
            for(int col=0;col<a.length;col++) {
                graph[row][col]=0;
            }
        }
        c.openEdgeFile();
        graph=c.readEdgeFile(graph, a);
        for(int i=0;i<5;i++) {
            //System.out.println(a[i].returnString());
        }
        //c.display(graph);
        diAlgorithm dk=new diAlgorithm();
        c.openAtmFile();
        String atmNodes[]=c.readAtmFile();
        c.readAtmFile();
        int counter=0;
        System.out.println("enter place where you are now");
        String presentPlace=in.nextLine();
        int start=c.returnIndex(presentPlace, a);
        while(counter<atmNodes.length) {
            int destination= c.returnIndex(atmNodes[counter], a);
            dk.dijkstra(graph, start, destination,counter);
            counter++;
        }
        dk.sortingDistance();
        dk.printDistance();

    }
}
