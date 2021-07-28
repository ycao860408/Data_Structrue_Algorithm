package SystemDesign.ConsistentHashing;

import java.util.Map;
import java.util.TreeMap;

public class ConsistentHashingWithVirtualNode implements LoadBalancer{
    private TreeMap<Integer, String> treeMapHash;

    public ConsistentHashingWithVirtualNode() {
        this.treeMapHash =  new TreeMap<>();
    }

    @Override
    public void addServerNode(String serverNodeName) {
        int hash = new GetHashCode().getHashCode(serverNodeName);
        treeMapHash.put(hash, serverNodeName);
    }

    @Override
    public void deleteServerNode(String serverNodeName) {
        int hash = new GetHashCode().getHashCode(serverNodeName);
        treeMapHash.remove(hash);
    }

    @Override
    public String selectServerNode(String requestURL) {
        int hash = new GetHashCode().getHashCode(requestURL);
        Map.Entry<Integer, String> subEntry = treeMapHash.ceilingEntry(hash);
        subEntry = subEntry== null ? treeMapHash.firstEntry() : subEntry;
        String VNNode = subEntry.getValue();
        return VNNode.substring(0, VNNode.indexOf("&&"));
    }
}
