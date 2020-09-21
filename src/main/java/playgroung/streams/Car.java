package playgroung.streams;

import java.util.List;

class Car {

    private String model; // get; set
    private List<String> parameters; // get; set

    public Car(String model, List<String> params) {
        this.model = model;
        this.parameters = params;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }
}
