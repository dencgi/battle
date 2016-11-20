package dad.battle;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dad.battle.character.AllCharacterTests;
import dad.battle.die.AllDieTests;

@RunWith(Suite.class)
@SuiteClasses({AllDieTests.class, AllCharacterTests.class})
public class AllBattleTests {

}
