import java.util.Random;

public class Enemy {

    private Random rand;
    private String name;
    private int hp;
    private int attack;


    public Enemy(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        rand = new Random();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
    public int getAttack() { return attack; }
    public void setAttack(int attack) { this.attack = attack; }

    public void attack(Player player) {
        player.setHp(player.getHp() - attack);
        System.out.println(name + " attacks " + player.getName() + " and deals " + attack + " damage!");
    }
}
