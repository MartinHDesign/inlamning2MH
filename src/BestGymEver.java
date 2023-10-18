import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Scanner;

public class BestGymEver {
    protected boolean test = false;
    protected final Path pathFileToRead = Paths.get("src/kunderBestGymEver.txt");
    protected final Path pathFileToWrite = Paths.get("src/PTsStalkerFile");
    protected String userInput;
    Messages m = new Messages();

    public void BestGymEverRun(){
        m.getStartText();

        while (true){

            userInput = takeUserInput(null);

            if(correctInput(userInput)){
                Person newPerson = readFromFileCreateNewPerson(pathFileToRead,userInput);

                if (personExistInDataBase(newPerson)){
                    m.getUnauthorizedPerson();

                } else if (newPerson.getActiveMembership()){

                    writeToPtFile(newPerson,pathFileToWrite);
                    m.getExistingCustomerWithActiveMembership();

                }else
                    m.getExistingCustomerWithoutActiveMembership();

            }else if(checkIfInputIsNumbers(userInput)){
                m.getInvalidSocialSecurityNumber();
            }else
                m.getInvalidNameInput();
        }
    }

    public String takeUserInput(String mockInput) {
        Scanner input;
        if (test){
            input = new Scanner(mockInput);
        }else{
            input = new Scanner(System.in);
        }

        String userInput;
        while ((userInput = input.nextLine()).equalsIgnoreCase("")) {
            m.getUserMustWriteInput();
            m.getStartText();
        }

        if (userInput.equalsIgnoreCase("Avsluta")){
            m.getUserCancelInput();
            System.exit(0);
        }
        return userInput.trim();
    }

    public boolean checkIfInputIsNumbers(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfInputIsCorrectSSN(String userInput) {
        return (userInput.length() == 10);
    }

    public boolean checkIfInputIsCorrectFullName(String userInput) {
        if (!userInput.contains(" "))
            return false;
        for (int i = 0; i < userInput.length(); i++){
            if(Character.isDigit(userInput.charAt(i)))
                return false;
        }
        return true;
    }
    public boolean correctInput(String userInput){
        return checkIfInputIsNumbers(userInput) && checkIfInputIsCorrectSSN(userInput)
                || checkIfInputIsCorrectFullName(userInput);
    }
    public boolean personExistInDataBase(Person newPerson){
        return newPerson.getSSN().equals("0");
    }

    public Person readFromFileCreateNewPerson(Path readFilePath, String userInput) {
        Person newPerson = new Person();
        String personSSNAndName;
        String dateCustomerPaid;
        String readLine;

        try(BufferedReader readFile = Files.newBufferedReader(readFilePath)){
            while((readLine = readFile.readLine()) != null){
                String readLineLower = readLine.toLowerCase();
                if (readLineLower.contains(userInput.toLowerCase())) {

                    personSSNAndName = readLine;
                    dateCustomerPaid = readFile.readLine();

                    Person newExistingPerson = new Person(personSSNAndName.substring(0, personSSNAndName.indexOf(",")),
                            personSSNAndName.substring(personSSNAndName.indexOf(",") + 2), dateCustomerPaid);

                    if (checkIfActiveMembership(dateCustomerPaid)) {
                        newExistingPerson.setActiveMembership(true);
                    }

                    return newExistingPerson;
                }
            }

        } catch (IOException e){
            System.out.println("Fel vid läsning av fil.");
            if (!test) {
                System.out.println("Programmet avslutas");
                System.exit(0);
            }
        }

        return newPerson;
    }

    public boolean checkIfActiveMembership(String dateMemberPaid) {
        LocalDate memberDate = LocalDate.parse(dateMemberPaid);
        return memberDate.isAfter(LocalDate.now().minusYears(1));
    }

    public void writeToPtFile(Person person, Path filePath) {
        if (!Files.exists(filePath)){
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                System.out.println("Error cant create File");
                System.exit(0);
            }
        }
        try (BufferedWriter write = Files.newBufferedWriter(filePath,
                StandardCharsets.UTF_8, StandardOpenOption.APPEND)){


            write.write(person.getSSN()+","+" "+person.name);
            write.newLine();
            write.write(LocalDate.now().toString());
            write.newLine();

        } catch (IllegalArgumentException e) {
            System.out.println("Ogiltig kombination av alternativ");
        }catch (UnsupportedOperationException e) {
            System.out.println("Alternativet stöds ej");
        }catch (IOException e) {
            System.out.println("IO fel");
        }
    }
}
