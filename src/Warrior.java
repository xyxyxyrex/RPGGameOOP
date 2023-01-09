import java.util.Random;

public class Warrior extends Player {
    private Random rand;

    public Warrior(String name, int hp, int gold, int numHealthPotions) {
        super(name, hp, gold, numHealthPotions);
        rand = new Random();
    }
    @Override
    public void fight(Enemy enemy) {
        int randomDamage = rand.nextInt(8) + 18;
        enemy.setHp(enemy.getHp() - randomDamage);
        System.out.println(getName() + " attacks enemy and deals " + randomDamage + " damage!");
    }

    @Override
    public void useItem() {
        int newHp = getHp() + 25;
        setHp(newHp);
        setNumHealthPotions(getNumHealthPotions() - 1);
        System.out.println(getName() + " uses a health potion and restores 25 HP!");
    }
}
