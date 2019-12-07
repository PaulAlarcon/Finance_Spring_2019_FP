import java.util.ArrayList;

final class Node {

//
    Node single_came_from;
    ArrayList<Node> came_from;

//

    boolean EEX;
    double fugit;
    double fairValue;

    public Node(double fairValue) {
//        this.fugit = fugit;
        this.fairValue = fairValue;
    }
}
