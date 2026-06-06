public class RPGCharacter {

    private final int level;
    private int health;
    RPGCharacter() {
        this.health = 1000;
        this.level = 1;
    }


    public int getHealth() {
        return this.health;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    public void receiveDamage(int damage) {
        //Damage subtracts from health. Health can't go below zero
        if(damage > this.health) health = 0;
        else health -= damage;
    }

    public void heal(int healthPoints) {
        if(level < 6 && health < 1000){
            health+=healthPoints;
        }
    }
}
