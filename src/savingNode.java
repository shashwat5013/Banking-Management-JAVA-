import java.util.Vector;

public class savingNode {
    double distance;
    Vector<Integer> v=new Vector<Integer>();
    void addDistance(double distances) {
        distance=distances;
    }
    void addingNode(int n) {
        v.add(n);
    }
}
