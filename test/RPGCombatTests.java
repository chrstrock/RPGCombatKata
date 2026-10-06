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
        attacker.attack(attacker, 100);
        assertThrows(InvalidParameterException.class, () -> {});
    }
}
