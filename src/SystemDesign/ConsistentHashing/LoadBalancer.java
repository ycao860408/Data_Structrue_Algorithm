package SystemDesign.ConsistentHashing;

import java.util.HashMap;

public interface LoadBalancer {

    public void addServerNode(String serverNodeName);

    public void deleteServerNode(String serverNodeName);

    public String selectServerNode(String requestURL);
}
