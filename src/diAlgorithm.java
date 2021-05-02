import java.util.Formatter;

class diAlgorithm extends dijkstraCode {
    static savingNode akash[]=new savingNode[3];
    static savingNode sn[]=new savingNode[3];
    private static final int NO_PARENT = -1;
    private static Formatter c;
    diAlgorithm(){
        for(int i=0;i<akash.length;i++) {
            akash[i]=new  savingNode();
        }
    }
   /* public static void  openFile() {

        try{
            c=new Formatter("C:\\Users\\Akshat\\Desktop\\atmShortest.txt");
        }
        catch(Exception e) {
            System.out.println("shashwat");
        }
    }
    public static void addData(double data) {
        c.format("%s",data);
    }*/
    void dijkstra(double[][] graph, int startVertex,int destination,int counter)
    {
        sn[counter]=new savingNode();
        int nVertices = graph[0].length;

        double[] shortestDistances = new double[nVertices];


        boolean[] added = new boolean[nVertices];


        for (int vertexIndex = 0; vertexIndex < nVertices;
             vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        shortestDistances[startVertex] = 0;


        int[] parents = new int[nVertices];


        parents[startVertex] = NO_PARENT;


        for (int i = 1; i < nVertices; i++)
        {


            int nearestVertex = -1;
            double shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                if (!added[vertexIndex] &&
                        shortestDistances[vertexIndex] <
                                shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }


            added[nearestVertex] = true;


            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                int edgeDistance = (int) graph[nearestVertex][vertexIndex];

                if (edgeDistance > 0
                        && ((shortestDistance + edgeDistance) <
                        shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance +
                            edgeDistance;
                }
            }
        }

        printSolution(startVertex, shortestDistances, parents,destination,counter);
    }


    private static void printSolution(int startVertex,
                                      double[] distances,
                                      int[] parents,int destination,int counter)
    {
        int nVertices = distances.length;


        for (int vertexIndex = 0;
             vertexIndex < nVertices;
             vertexIndex++)
        {
            if (vertexIndex != startVertex && vertexIndex==destination)
            {
                // System.out.print("\n" + startVertex + " -> ");
                // System.out.print(vertexIndex + " \t\t ");
                System.out.println(" ");
                //  System.out.print(distances[vertexIndex] + "\t\t");
                //System.out.println("\nshashwat");
                akash[counter].addDistance(distances[vertexIndex]);
                printPath(vertexIndex,startVertex, parents,counter);
            }
        }
    }


    private static void printPath(int currentVertex, int startVertex,
                                  int[] parents,int counter)
    {


        if (currentVertex == NO_PARENT)
        {
            return;
        }
        printPath(parents[currentVertex],startVertex, parents,counter);
        if(currentVertex==startVertex)
        {
            akash[counter].addingNode(currentVertex);
            //System.out.print(currentVertex+" ");
        }
        else {
            akash[counter].addingNode(currentVertex);
            //System.out.print("--->"+currentVertex + " ");
        }
    }
    public void sortingDistance() {
        for(int j=0;j<akash.length;j++) {
            //System.out.println(akash[j].distance);
        }
        for(int i=0;i<akash.length-1;i++) {
            //System.out.print(akash[i].distance+" ");
            if( akash[i].distance>akash[i+1].distance) {
                savingNode temp=new savingNode();
                temp=akash[i];
                akash[i]=akash[i+1];
                akash[i+1]=temp;
            }
        }
    }
    public void printDistance() {
        System.out.println("\tDISTANCE\t\tPREFERRED PATH");
        for(int i=0;i<3;i++) {					//change here atmnodes
            System.out.print("("+(i+1)+")"+"   "+akash[i].distance+"\t\t");

            for(int j=0;j<akash[i].v.size();j++) {
                if(j==0)
                    System.out.print(a[akash[i].v.get(j)].s+"---------->");
                else
                    System.out.print("---------->"+a[akash[i].v.get(j)].s);
            }
            System.out.println();
        }
    }

   /* public static void main(String[] args)
    {
        int[][] adjacencyMatrix = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                    { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                    { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                    { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                    { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                    { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
                                    { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
                                    { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                    { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        dijkstra(adjacencyMatrix, 0);
    }*/
}
