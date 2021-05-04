public abstract class Person {

    private static final String HELLO_MESSAGE_IN_BULGARIAN = "Здравей";
    private static final String HELLO_MESSAGE_IN_EUROPEAN = "Hello";
    private static final String HELLO_MESSAGE_IN_CHINESE = "Djydjybydjy";
    private static final String BULGARIAN_CLASS_NAME = "Bulgarian";
    private static final String EUROPEAN_CLASS_NAME = "European";

    private String name;

    protected Person(String name) {
        this.setName(name);
    }

    // Getter
    protected String getName() {
        return this.name;
    }

    // Setter
    private void setName(String name) {
        this.name = name;
    }

    protected String sayHello() {
        return this.getClass().getSimpleName().equals(BULGARIAN_CLASS_NAME) ?
                HELLO_MESSAGE_IN_BULGARIAN :
                this.getClass().getSimpleName().equals(EUROPEAN_CLASS_NAME) ?
                        HELLO_MESSAGE_IN_EUROPEAN : HELLO_MESSAGE_IN_CHINESE;
    }
}
