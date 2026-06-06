import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
