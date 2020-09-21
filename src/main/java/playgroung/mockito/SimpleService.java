package playgroung.mockito;

public class SimpleService {
    private Formatter formatter;

    public SimpleService(Formatter formatter) {
        this.formatter = formatter;
    }

    public String getResult(int input) {
        return formatter.format(input);
    }
}
