import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class RPGCombatTests {

    RPGCharacter testCharacter;
    @BeforeEach
    void setup() {
        testCharacter = new RPGCharacter();
    }

    @Test
    void CharacterHas1000HealthWhenCreated() {
        assertEquals(1000, testCharacter.getHealth());
    }

    @Test
    void CharacterStartsAtLevel1() {
        assertEquals(1, testCharacter.getLevel());
    }

    @Test
    void attackTest(){
        RPGCharacter attacker = new RPGCharacter();
        attacker.attack(testCharacter, 200);
        assertEquals(800, testCharacter.getHealth());
    }

    @Test
    void deadAfterAttackTest(){
        RPGCharacter attacker = new RPGCharacter();
        attacker.attack(testCharacter, 1100);
        assertEquals(0, testCharacter.getHealth());
        assertFalse(testCharacter.isAlive);
    }

    @Test
    void aCharacterCannotAttackThemselvesTest(){
        RPGCharacter attacker = new RPGCharacter();
        assertThrows(InvalidParameterException.class,()->attacker.attack(attacker, 100),
                "Target character cannot be self.");
    }

    @Test
    void aCharacterCanHealThemselvesTest(){
        RPGCharacter attacker = new RPGCharacter();
        attacker.attack(testCharacter, 200);
        testCharacter.heal(100);
        assertEquals(900, testCharacter.getHealth());
    }

    @Test
    void deadCharacterCannotHealThemselvesTest(){
        RPGCharacter attacker = new RPGCharacter();
        attacker.attack(testCharacter, 1100);
        assertEquals(0, testCharacter.getHealth());
        assertThrows(UnsupportedOperationException.class, () -> testCharacter.heal(100),
                "Dead characters cannot heal themselves.");
    }

    @Test
    void maxHealthDefaultsAt1000Test(){
        assertEquals(1000, testCharacter.getMaxHealth());
    }

    @Test
    void maxHealthAtLevel6Is1500Test(){
        for(int i = 0; i < 6; i++){
            this.testCharacter.levelUp();
        }
        assertEquals(1500, testCharacter.getMaxHealth());
    }

    @Test
    void targetAtLeast5LevelsAboveDamageTest(){
        //increase level of test character to 6
        for(int i = 0; i < 6; i++){
            testCharacter.levelUp();
        }
        RPGCharacter attacker = new RPGCharacter();
        attacker.attack(testCharacter, 200);
        assertEquals(900, testCharacter.getHealth());
    }

    @Test
    void targetAtLeast5LevelsBelowDamageTest(){
        RPGCharacter attacker = new RPGCharacter();
        for(int i = 0; i < 6; i++){
            attacker.levelUp();
        }
        attacker.attack(testCharacter, 200);
        assertEquals(600, testCharacter.getHealth());
    }

    @Test
    void Level10ToLevel1Test(){
        RPGCharacter attacker = new RPGCharacter();
        for(int i = 0; i < 10; i++){
            testCharacter.levelUp();
        }
        attacker.attack(testCharacter, 500);
        assertEquals(750, testCharacter.getHealth());
    }
}
