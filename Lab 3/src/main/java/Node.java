import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter

public class Node {
    private String name;
    private Map<Node, Integer> costs = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void setCost(Node node, Integer cost) {
        this.costs.put(node, cost);
    }
}
