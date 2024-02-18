package monster;

public abstract class Monster {

    private String name;
    private int id;
    private int damage;
    private int health;

    private int reward;


    public Monster(String name, int id, int damage, int health,int reward) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
