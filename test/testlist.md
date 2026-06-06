# 1.  All Characters, when created, have:
        Health, starting at 1000
        May be Alive or Dead, starting Alive
# 2.  Characters can Deal Damage to Characters.
        Damage is subtracted from Health
        When damage received exceeds current Health, Health becomes 0 and the character dies
        A Character cannot Deal Damage to itself
# 3.  A Character can Heal themselves.
        Dead characters cannot heal

Levels
All characters have a Level, starting at 1
A Character cannot have a health above 1000 until they reach level 6, when the maximum increases to 1500
When dealing damage:
If the target is 5 or more Levels above the attacker, Damage is reduced by 50%
If the target is 5 or more Levels below the attacker, Damage is increased by 50%
