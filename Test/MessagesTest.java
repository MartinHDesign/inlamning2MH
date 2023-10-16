import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MessagesTest {
    Messages m = new Messages();

    @Test
    public final void printStartTextTest(){
        m.test = true;
        String expectedText = "Ange namn eller personnummer: (Skriv avsluta för att sluta):";
        String actualText = m.getStartText();

        Assertions.assertEquals(expectedText,actualText);
    }

    @Test
    public final void printCancelTextTest(){
        m.test = true;
        String expectedText = "Programmet avslutas.";
        String actualText = m.getUserCancelInput();

        Assertions.assertEquals(expectedText,actualText);
    }

    @Test
    public final void printUserMustWriteInputTest(){
        m.test = true;
        String expectedText = "Du måste skriva något.";
        String actualText = m.getUserMustWriteInput();

        Assertions.assertEquals(expectedText,actualText);
    }

    @Test
    public final void printInvalidNameInputTest(){
        m.test = true;
        String expectedText = "Ogiltigt namn.";
        String actualText = m.getInvalidNameInput();

        Assertions.assertEquals(expectedText,actualText);
    }

    @Test
    public final void printInvalidSocialSecurityNumberTest(){
        m.test = true;
        String expectedText = "Personnumret måste ha 10 siffror.";
        String actualText = m.getInvalidSocialSecurityNumber();

        Assertions.assertEquals(expectedText,actualText);
    }

    @Test
    public final void printExistingCustomerWithActiveMembershipTest(){
        m.test = true;
        String expectedText = "Kunden är en nuvarande medlem.";
        String actualText = m.getExistingCustomerWithActiveMembership();

        Assertions.assertEquals(expectedText,actualText);
    }

    @Test
    public final void printExistingCustomerWithoutActiveMembershipTest(){
        m.test = true;
        String expectedText = "Kunden är en före detta kund.";
        String actualText = m.getExistingCustomerWithoutActiveMembership();

        Assertions.assertEquals(expectedText,actualText);
    }

    @Test
    public final void printUnauthorizedPersonTest(){
        m.test = true;
        String expectedText = "Personen är obehörig.";
        String actualText = m.getUnauthorizedPerson();

        Assertions.assertEquals(expectedText,actualText);
    }

}