import java.util.ArrayList;

final class Node {

//
    Node single_came_from;
    ArrayList<Node> came_from;

//

    boolean EEX;
    double fugit;
    double fairValue = 0;
    int n;

    public Node(double fairValue, int n) {
//        this.fugit = fugit;
        this.fairValue = fairValue;
        this.n = n;
    }
}
