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
        target.receiveDamage(damage);
        if (damage >= target.health) {
            target.isAlive = false;
            target.health = 0;
        }
    }

    public void receiveDamage(int damage) {
        if(damage >= this.health) {
            isAlive = false;
            this.health = 0;
        }
        else {
            this.health -= damage;
        }
    }
}
