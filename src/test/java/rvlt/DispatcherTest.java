package rvlt;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DispatcherTest {
    private final int capacity = 10;
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test()
    public void testMaxCapacity() throws MalformedURLException {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Rbeeached the limit");
        Dispatcher instance = Dispatcher.getINSTANCE();
        instance.refresh();
        for (int i = 0; i < capacity + 1; i++) {
            instance.register(new Node(new URL("http://org.com.ru/url" + i)));
        }
    }

    @Test
    public void checkRegistration() throws MalformedURLException {
        List<Node> nodeList = new ArrayList<>();
        Dispatcher instance = Dispatcher.getINSTANCE();
        instance.refresh();
        for (int i = 0; i <capacity ; i++) {
            URL url = new URL("http://org.com.ru/url" + i);
            Node node = new Node(url);
            instance.register(node);
        }
        for(Node n : nodeList){
            assertTrue(instance.getNodes().containsKey(n.getUrl()));
        }
    }

    @Test
    public void nullNodePassed(){
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("broken node");
        Dispatcher.getINSTANCE().register(null);
    }

    @Test
    public void invalidNode(){
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("broken node");
        Dispatcher.getINSTANCE().register(new Node(null));
    }

}