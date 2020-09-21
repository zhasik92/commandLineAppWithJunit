package playgroung.mockito;

public class Formatter {
    private final String format;

    public Formatter(String format) {
        this.format = format;
    }

    public String format(int arg){
        return format + arg;
    }
}
