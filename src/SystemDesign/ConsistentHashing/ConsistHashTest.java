package SystemDesign.ConsistentHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsistHashTest {
    private static ConsistentHashingWithVirtualNode ch = new ConsistentHashingWithVirtualNode();
    private static List<String> servers = new ArrayList<>();
    private static final int SEVERS_NUM = 100;
    private static final int VN_NUM = 100;

    private static void init() {

        for (int i = 0; i < SEVERS_NUM; i++) {
            String s = new StringBuilder().append("192.168.0.").append(i).toString();
            servers.add(s);
        }

        for (String server : servers) {
            for (int i = 0; i < VN_NUM; i++) {
                String VNName = server + "&&VN" + i;
                ch.addServerNode(VNName);
            }
        }
    }

    public static void main(String[] args) {
        init();
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, List<String>> buckets = new HashMap<>();
        String[] nodes = new IPAddressGenerate().getIPAddress(10000);
        for (int i = 0; i < nodes.length; i++) {
            String serverIP = ch.selectServerNode(nodes[i]);
            map.put(nodes[i], serverIP);
            //System.out.println(serverIP);
            /*buckets.putIfAbsent(serverIP, new ArrayList<>());
            buckets.get(serverIP).add(nodes[i]);*/
        }

        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("node : " + entry.getKey() + " server: " + entry.getValue());
        }
        /*for(String key : buckets.keySet()) {
            System.out.println("ServerIP: " + key + ", number: " + buckets.get(key).size());
        }
        System.out.println("====================================================");
        String removeIP = "192.168.0.77";
        for (int i = 0; i < VN_NUM; i++) {
            String VNName = removeIP + "&&VN" + i;
            ch.deleteServerNode(VNName);
        }

        for (String removeNode : buckets.get(removeIP)) {
            String serverIP = ch.selectServerNode(removeNode);
            buckets.get(serverIP).add(removeNode);
        }

        buckets.remove(removeIP);

        for(String key : buckets.keySet()) {
            System.out.println("ServerIP: " + key + ", number: " + buckets.get(key).size());
        }*/
    }
}
