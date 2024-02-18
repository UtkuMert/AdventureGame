package tools.armors;

public class Armor {
    private String name;
    private int id;
    private int block;
    private int price;

    public Armor(String name, int id, int ignoreDamage, int price) {
        this.name = name;
        this.id = id;
        this.block = ignoreDamage;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorList = {new LowLevel(), new MediumLevel(),new HighLevel()};
        return armorList;
    }

    public static Armor getArmorById(int id){
        for (Armor a : Armor.armors()){
            if (a.getId() == id){
                return a;
            }
        }
        return null;
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
