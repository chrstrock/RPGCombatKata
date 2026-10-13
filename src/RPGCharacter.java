import java.security.InvalidParameterException;

public class RPGCharacter {

    private int level;
    private int maxHealth;
    protected boolean isAlive;
    private int health;
    RPGCharacter() {
        this.health = 1000;
        this.level = 1;
        this.isAlive = true;
        this.maxHealth = 1000;
    }


    public int getHealth() {
        return this.health;
    }

    public int getLevel() {
        return this.level;
    }

    public void attack(RPGCharacter target, int damage) {
        if (target == this) {
            throw new InvalidParameterException("Target character cannot be self.");
        } else {
            target.receiveDamage(determineDamage(target, damage));
        }
    }

    private int determineDamage(RPGCharacter target, int damage) {
        if(target.level >= this.level + 5) {
            damage /= 2;
        }
        else if(target.level <= this.level - 5) {
            damage *= 2;
        }
        return damage;
    }

    public void receiveDamage(int damage) {
        if(damage > this.health) {
            isAlive = false;
            health = 0;
        }
        else {
            this.health -= damage;
        }
    }

    public void heal(int healingAmount) {
        if(isAlive) {
            health += healingAmount;
        }
        else {
            throw new
                    UnsupportedOperationException("Dead characters cannot heal themselves.");
        }

    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public void levelUp() {
        this.level++;
        if(this.level == 6){
            this.maxHealth = 1500;
        }
    }
}
