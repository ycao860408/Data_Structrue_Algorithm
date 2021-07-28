package Graph.classicalSearchingMethod;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int label;
    public List<GraphNode> neighbors;

    public GraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<>();
    }
}
