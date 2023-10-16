import java.time.LocalDate;

public class Person {
    protected String socialSecurityNumber = "0";
    protected String name;
    protected String datePayedMembership;
    protected boolean activeMembership;


    public Person() {}

    public Person(String socialSecurityNumber, String name, String datePayedMembership) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.name = name;
        this.datePayedMembership = datePayedMembership;
    }

    public String getSSN() {
        return this.socialSecurityNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getDatePaidMembership() {
        return this.datePayedMembership;
    }

    public Boolean getActiveMembership() {
        return this.activeMembership;
    }
    public void setActiveMembership(boolean activeMembership) {
        this.activeMembership = activeMembership;
    }
}
