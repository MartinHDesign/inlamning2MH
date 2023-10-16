import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class PersonTest {
    Person person1 = new Person("7703021234","Alhambra Aromes", "2023-07-01");

    @Test
    public final void getSSNTest(){
        String actualSSN = person1.getSSN();
        String expectedSSN = "7703021234";
        String unExpectedSSN = "1111111111";

        Assertions.assertEquals(expectedSSN,actualSSN);
        Assertions.assertNotEquals(unExpectedSSN,actualSSN);
    }

    @Test
    public final void getNameTest(){
        String actualName = person1.getName();
        String expectedName = "Alhambra Aromes";
        String unExpectedName = "martin h";

        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertNotEquals(unExpectedName,actualName);
    }

    @Test
    public final void getDatePaidMembershipTest(){
        String actualDate = person1.getDatePaidMembership();
        String expectedDate = "2023-07-01";
        String unexpected = "1111-11-11";

        Assertions.assertEquals(expectedDate,actualDate);
        Assertions.assertNotEquals(unexpected,actualDate);
    }

    @Test
    public final void getActiveMembershipTest(){
        Boolean actualDate = person1.getActiveMembership();
        Boolean expectedDate = true;
        Boolean unexpected = false;

        Assertions.assertNotEquals(expectedDate,actualDate);
        Assertions.assertEquals(unexpected,actualDate);
    }
}
