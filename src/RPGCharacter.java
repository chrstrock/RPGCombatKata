import java.security.InvalidParameterException;

public class RPGCharacter {

    private final int level;
    protected boolean isAlive;
    private int health;
    RPGCharacter() {
        this.health = 1000;
        this.level = 1;
        this.isAlive = true;
    }


    public int getHealth() {
        return this.health;
    }

    public int getLevel() {
        return this.level;
    }

    public void attack(RPGCharacter target, int damage) {
        if(target!=this) {
            target.receiveDamage(damage);
        }
        else{
            throw new InvalidParameterException("Target character cannot be self.");
        }
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
        int result = 1000;
        if (this.level >= 6 ){
            result = 1500;
        }
        return result;
    }
}
