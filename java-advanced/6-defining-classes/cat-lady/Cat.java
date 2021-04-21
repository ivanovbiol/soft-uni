package cat;

import static cat.StaticVariables.PRINT_TEMPLATE;

public abstract class Cat {

    private String name;
    private double doubleNumberParameter;

    public Cat(String name, double doubleNumberParameter) {
        this.setName(name);
        this.setDoubleNumberParameter(doubleNumberParameter);
    }

    // Getter
    public String getName() {
        return this.name;
    }
    protected double getDoubleNumberParameter() {
        return this.doubleNumberParameter;
    }

    // Setter
    private void setName(String name) {
        this.name = name;
    }
    private void setDoubleNumberParameter(double doubleNumberParameter) {
        this.doubleNumberParameter = doubleNumberParameter;
    }

    @Override
    public String toString() {
        return String.format(PRINT_TEMPLATE,
                this.getClass().getSimpleName(), this.getName(), this.getDoubleNumberParameter());
    }

}
