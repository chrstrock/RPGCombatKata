import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class RPGCharacter {

    private List<String> factions;
    private int level;
    private int maxHealth;
    protected boolean isAlive;
    private int health;
    RPGCharacter() {
        this.health = 1000;
        this.level = 1;
        this.isAlive = true;
        this.maxHealth = 1000;
        this.factions = new ArrayList<>();
    }

    public static boolean isAlly(RPGCharacter ally) {
        for(String faction : ally.factions) {
            if (ally.factions.contains(faction)) {
                return true;
            }
        }
        return false;
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
        }
        else if(isAlly(target)) {
            throw new UnsupportedOperationException("Allies cannot be attacked.");
        }
        else {
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
            this.health += Math.min(healingAmount, this.maxHealth - health);
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

    public List<String> getFactions() {
        return this.factions;
    }

    public void assignFaction(String faction) {
        this.factions.add(faction);
    }

    public void leaveFaction(String warriors) {
        this.factions.remove(warriors);
    }
}
