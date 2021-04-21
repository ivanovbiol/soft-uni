public class Pokemon {

    private String name;
    private String element;
    private int health;
    private boolean isDead;

    public Pokemon(String name, String element, int health) {
        this.setName(name);
        this.setElement(element);
        this.setHealth(health);
        this.setIsDead(false);
    }

    //Getters
    public String getElement() {
        return this.element;
    }
    private int getHealth() {
        return this.health;
    }
    public boolean getIsDead() {
        return this.isDead;
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setElement(String element) {
        this.element = element;
    }
    private void setHealth(int health) {
        this.health = health;
    }
    private void setIsDead(boolean dead) {
        this.isDead = dead;
    }

    public void decreaseHealth() {
        this.setHealth(this.getHealth() - 10);

        if(this.getHealth() <= 0) {
            this.setIsDead(true);
        }
    }
}
