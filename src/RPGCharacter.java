public class RPGCharacter {

    private final int level;
    private final int health;
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
}
