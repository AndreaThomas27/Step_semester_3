
public class Character {

    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }

        health = (int) Math.max(0L,
                (long) health - amount);
    }

    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }

        health = (int) Math.min((long) maxHealth,
                (long) health + amount);
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {

        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("After damage: "
                + c.getHealth());

        c.heal(50);
        System.out.println("After healing: "
                + c.getHealth());

        c.takeDamage(150);
        System.out.println("After extra damage: "
                + c.getHealth());
    }
}
