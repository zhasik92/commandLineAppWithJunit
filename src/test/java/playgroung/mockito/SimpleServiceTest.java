package playgroung.mockito;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class SimpleServiceTest {

    @Test
    public void getResult() {
        Formatter formatter = Mockito.mock(Formatter.class);
        Mockito.when(formatter.format(Mockito.anyInt())).thenReturn("mock");
        SimpleService simpleService = new SimpleService(formatter);
        assertEquals("mock", simpleService.getResult(5));
    }
}