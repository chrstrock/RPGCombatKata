import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void isAliveTest(){
        assertTrue(testCharacter.isAlive());
    }

    @Test
    void isDeadTest(){
        testCharacter.receiveDamage(1000);
        assertFalse(testCharacter.isAlive());
    }

    @Test
    void ifDamageExceedsHealthHealthAtZero(){
        testCharacter.receiveDamage(1001);
        assertEquals(0, testCharacter.getHealth());
    }

    @Test
    void newCharacterCantGoAbove1000() {
        testCharacter.heal(1);
        assertEquals(1000, testCharacter.getHealth());
    }

    @Test
    void aCharacterCantDamageHimself(){
        testCharacter.attack(testCharacter, 10);
        assertEquals(1000, testCharacter.getHealth());
    }
}
