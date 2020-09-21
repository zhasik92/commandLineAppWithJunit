package rvlt;

import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 Register provider instances to the
Load Balancer – the max number of accepted providers from the load balancer is 10.
Each provider should have a unique address.
*/

public class Dispatcher implements Endpoint {

    private static Dispatcher INSTANCE;

    private Map<URL, Node> nodes = new ConcurrentHashMap<URL, Node>();

    @Override
    public void handleRequest(String request) {
    }

    public Map<URL, Node> getNodes() {
        return Collections.unmodifiableMap(nodes) ;
    }

    public void setNodes(Map<URL, Node> nodes) {
        this.nodes = nodes;
    }

    public void register(Node node) {
        validate(node);
        Map<URL, Node> nodes = this.nodes;
        if (nodes.size() >= 10) {
            throw new RuntimeException("Rbeeached the limit");
        }
        nodes.put(node.getUrl(), node);
    }

    private void validate(Node node) {
        if (node == null || node.getUrl() == null) {
            throw new IllegalArgumentException("broken node");
        }
    }

    public static synchronized Dispatcher getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Dispatcher();
        }
        return INSTANCE;
    }

    public void refresh(){
       nodes.clear();
    }

}
