import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    @Test
    void catSleepShouldReturnString() {

        Cat cat = new Cat("Persian", "white", 4);
        assertEquals(cat.sleep(), "I'm sleeping. Mrr");
    }
    @Test
    void catHuntShouldReturnString() {

        Cat cat = new Cat("Persian", "black", 3);
        assertEquals(cat.hunt(), "I'm hunting. Hold on mice");
    }

    @Test
    void catTigidikShouldReturnString() {

        Cat cat = new Cat("Persian", "black", 3);
        assertEquals(cat.tigidik(), "Tigidik-tigidik");
    }

    @Test
    void catlickBallsShouldReturnString() {

        Cat cat = new Cat("Persian", "black", 3);
        assertEquals(cat.tigidik(), "Tigidik-tigidik");
    }

    @ParameterizedTest(name = "{index} => dayOfWeek=''{0}''")
    @EnumSource(value = DaysOfWeek.class, names = {"MON", "WED", "FRI"})
    void catOccupationOnDaysWhenSleeping(DaysOfWeek dayOfWeek) {
        Cat cat = new Cat("Persian", "black", 3);
        assertEquals(cat.occupation(dayOfWeek), cat.sleep());
    }

    @ParameterizedTest(name = "{index} => dayOfWeek=''{0}''")
    @EnumSource(value = DaysOfWeek.class, names = {"THU", "TUE", "SAT"})
    void catOccupationOnDaysWhenHunting(DaysOfWeek dayOfWeek) {
        Cat cat = new Cat("Persian", "black", 3);
        assertEquals(cat.occupation(dayOfWeek), cat.hunt());
    }

    @ParameterizedTest(name = "{index} => dayOfWeek=''{0}''")
    @EnumSource(value = DaysOfWeek.class, names = {"SUN"})
    void catOccupationOnDaysWhenTigidik(DaysOfWeek dayOfWeek) {
        Cat cat = new Cat("Persian", "black", 3);
        assertEquals(cat.occupation(dayOfWeek), cat.tigidik());
    }

    @ParameterizedTest(name = "{index} => dayOfWeek=''{0}''")
    @EnumSource(value = DaysOfWeek.class, names = {"NONE"})
    void catOccupationOnDaysWhenLickingBalls(DaysOfWeek dayOfWeek) {
        Cat cat = new Cat("Persian", "black", 3);
        assertEquals(cat.occupation(dayOfWeek), cat.lickBalls());
    }

    @ParameterizedTest(name = "{index} => dayOfWeek=''{0}''")
    @NullSource
    void catOccupationOnNull(DaysOfWeek dayOfWeek) {
        Cat cat = new Cat("Persian", "black", 3);

        Exception exception = assertThrows(NullPointerException.class, () ->
                cat.occupation(dayOfWeek));
        assertEquals("Cannot invoke \"DaysOfWeek.ordinal()\" because \"daysOfWeek\" is null", exception.getMessage());

    }


}