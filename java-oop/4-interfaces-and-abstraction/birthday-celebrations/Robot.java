public class Robot implements Identifiable {

    private String model;
    private String id;

    public Robot(String model, String id) {
        this.setModel(model);
        this.setId(id);
    }

    // Getters
    public String getModel() {
        return this.model;
    }
    @Override
    public String getId() {
        return this.id;
    }

    // Setters
    private void setModel(String model) {
        this.model = model;
    }
    private void setId(String id) {
        this.id = id;
    }
}
