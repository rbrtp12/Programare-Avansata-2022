import java.util.ArrayList;
import java.util.List;

public class Network {
    public List<Node> nodeList;

    void addNode(Node node) {
        nodeList.add(node);
    }

    public Network() {
        this.nodeList = new ArrayList<>();
    }

    void printNodeList() {
        for (Node node : this.nodeList) System.out.print(node.getName() + ' ');
        System.out.println("\n");
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    void addNodeList(List<Node> nodeList) {
        this.nodeList.addAll(nodeList);
    }
}
