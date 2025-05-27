public class Character {
    protected String name;
    protected int age;
    protected String affiliation;
    protected int health;

    public Character(String name, int age, String affiliation) {
        this.name = name;
        this.age = age;
        this.affiliation = affiliation;
        this.health = 100;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    public void heal(int amount) {
        health += amount;
        if (health > 100) health = 100;
    }
}