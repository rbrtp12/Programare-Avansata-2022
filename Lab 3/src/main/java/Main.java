import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /** adding all the nodes in a list */
        List<Node> nodesList = new ArrayList<>();
        nodesList.add(new Node("v1"));
        nodesList.add(new Node("v2"));
        nodesList.add(new Node("v3"));
        nodesList.add(new Node("v4"));
        nodesList.add(new Node("v5"));
        nodesList.add(new Node("v6"));

        /** adding the node list to our network */
        Network myNetwork = new Network();
        myNetwork.addNodeList(nodesList);
        myNetwork.printNodeList();

        /** adding neighbours for each node and costs to get there */
        myNetwork.getNodeList().get(0).setCost(nodesList.get(1), 10);
        myNetwork.getNodeList().get(0).setCost(nodesList.get(2), 50);
        myNetwork.getNodeList().get(1).setCost(nodesList.get(2), 20);
        myNetwork.getNodeList().get(1).setCost(nodesList.get(3), 20);
        myNetwork.getNodeList().get(1).setCost(nodesList.get(4), 20);
        myNetwork.getNodeList().get(2).setCost(nodesList.get(3), 10);
        myNetwork.getNodeList().get(3).setCost(nodesList.get(4), 30);
        myNetwork.getNodeList().get(3).setCost(nodesList.get(5), 10);
        myNetwork.getNodeList().get(4).setCost(nodesList.get(5), 20);

        /** we go through all the nodes and print the costs to get to each one's neighbours */
        for (Node node : myNetwork.getNodeList()) {
            Map<Node, Integer> myNodeList = node.getCosts();
            for (Map.Entry<Node, Integer> element : myNodeList.entrySet()) {
                System.out.println(node.getName() + ' ' + element.getKey().getName() + ' ' + element.getValue());
            }
        }
    }
}
