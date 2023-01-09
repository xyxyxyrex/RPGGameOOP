public abstract class Player {
    // Encapsulation: private fields and public getters/setters
    private String name;
    private int hp;
    private int gold;
    private int numHealthPotions;

    // Constructor: initialize fields using parameters
    public Player(String name, int hp, int gold, int numHealthPotions) {
        this.name = name;
        this.hp = hp;
        this.gold = gold;
        this.numHealthPotions = numHealthPotions;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
    public int getGold() { return gold; }
    public void setGold(int gold) { this.gold = gold; }
    public int getNumHealthPotions() { return numHealthPotions; }
    public void setNumHealthPotions(int numHealthPotions) { this.numHealthPotions = numHealthPotions; }

    public abstract void fight(Enemy enemy);
    public abstract void useItem();
}