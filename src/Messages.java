public class Messages {
    private final String startText = "Ange namn eller personnummer: (Skriv avsluta för att sluta):";
    private final String userMustWriteInput = "Du måste skriva något.";
    private final String userCancelInput = "Programmet avslutas.";

    private final String invalidNameInput = "Ogiltigt namn.";
    private final String invalidSocialSecurityNumber = "Personnumret måste ha 10 siffror.";
    private final String existingCustomerWithActiveMembership = "Kunden är en nuvarande medlem.";
    private final String existingCustomerWithoutActiveMembership = "Kunden är en före detta kund.";
    private final String unauthorizedPerson = "Personen är obehörig.";
    Boolean test = false;

    public String getStartText() {
        if (!test)
            System.out.println(this.startText);
        return startText;
    }

    public String getUserMustWriteInput() {
        if (!test)
            System.out.println(this.userMustWriteInput);
        return userMustWriteInput;
    }

    public String getUserCancelInput() {
        if (!test)
            System.out.println(this.userCancelInput);
        return userCancelInput;
    }

    public String getInvalidNameInput() {
        if (!test)
            System.out.println(this.invalidNameInput);
        return invalidNameInput;
    }

    public String getInvalidSocialSecurityNumber() {
        if (!test)
            System.out.println(this.invalidSocialSecurityNumber);
        return invalidSocialSecurityNumber;
    }

    public String getExistingCustomerWithActiveMembership() {
        if (!test)
            System.out.println(this.existingCustomerWithActiveMembership);
        return existingCustomerWithActiveMembership;
    }

    public String getExistingCustomerWithoutActiveMembership() {
        if (!test)
            System.out.println(this.existingCustomerWithoutActiveMembership);
        return existingCustomerWithoutActiveMembership;
    }

    public String getUnauthorizedPerson() {
        if (!test)
            System.out.println(this.unauthorizedPerson);
        return unauthorizedPerson;
    }
}
