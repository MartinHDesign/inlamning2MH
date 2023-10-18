import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertEquals;


class BestGymEverTest {
    BestGymEver bge = new BestGymEver();
    Person mockPerson = new Person("7703021234",
            "Alhambra Aromes","2023-07-01");

    @Test
    public final void takeUserInputTest(){
        bge.test = true;
        String mockInput = "martin h";

        String expectedInput = "martin h";
        String actualInput = bge.takeUserInput(mockInput);

        String unexpectedInput = "hej";


        Assertions.assertEquals(expectedInput,actualInput);
        Assertions.assertNotEquals(unexpectedInput,actualInput);
    }

    @Test
    public final void checkIfInputIsNumbersTest(){
        String mockInput = "12345";
        String wrongMockInput = "142354a";
        boolean expectedValue = true;
        boolean unExpectedValue = false;
        boolean actualValue = bge.checkIfInputIsNumbers(mockInput);
        boolean actualValueWrongInput = bge.checkIfInputIsNumbers(wrongMockInput);

        Assertions.assertEquals(expectedValue,actualValue);
        Assertions.assertEquals(unExpectedValue,actualValueWrongInput);
    }

    @Test
    public final void checkIfInputIsCorrectSSNTest(){
        String mockCorrectInput = "1122334444";
        String mockWrongInput = "1234";

        boolean expectedValue = true;
        boolean expectedWrongValue = false;

        boolean actualCorrectInput = bge.checkIfInputIsCorrectSSN(mockCorrectInput);
        boolean actualWrongInput = bge.checkIfInputIsCorrectSSN(mockWrongInput);

        Assertions.assertEquals(expectedValue,actualCorrectInput);
        Assertions.assertEquals(expectedWrongValue,actualWrongInput);
    }

    @Test
    public final void checkIfInputIsCorrectFullName(){
        String mockCorrectInput = "Martin Harrysson";
        String mockWrongInput = "abc2asd";

        boolean expectedValue = true;
        boolean expectedWrongValue = false;

        boolean actualCorrectInput = bge.checkIfInputIsCorrectFullName(mockCorrectInput);
        boolean actualWrongInput = bge.checkIfInputIsCorrectFullName(mockWrongInput);

        Assertions.assertEquals(expectedValue,actualCorrectInput);
        Assertions.assertEquals(expectedWrongValue,actualWrongInput);
    }

    @Test
    public final void correctInputTest(){
        String mockUserInput = "1234567890";
        String wrongMockInput = "abc2";
        boolean expectedValue = true;
        boolean expectedWrongValue = false;
        boolean actualValue = bge.correctInput(mockUserInput);
        boolean actualWrongValue = bge.correctInput(wrongMockInput);

        Assertions.assertEquals(expectedValue,actualValue);
        Assertions.assertEquals(expectedWrongValue,actualWrongValue);
    }
    @Test
    public final void personExistInDataBaseTest(){

        boolean expectedValue = false;
        boolean actualValue = bge.personExistInDataBase(mockPerson);

        assertEquals(expectedValue,actualValue);
    }

    @Test
    public final void readFromFileCreateNewPersonTest(){
        Path testReadFilePath = Paths.get("Test/testReadFile");

        String expectedName = "Alhambra Aromes";
        String expectedSSN = "7703021234";
        String expectedDate = "2023-07-01";

        Person testPerson = bge.readFromFileCreateNewPerson(testReadFilePath,expectedName);
        String actualName = testPerson.getName();
        String actualSSN = testPerson.getSSN();
        String actualDate = testPerson.getDatePaidMembership();

        Assertions.assertEquals(expectedName,actualName);
        Assertions.assertEquals(expectedSSN,actualSSN);
        Assertions.assertEquals(expectedDate,actualDate);
    }


    @Test
    public final void checkIfActiveMembershipTest(){
        String date = LocalDate.now().toString();
        boolean expectedValue = true;
        boolean unExpectedValue = false;
        boolean actualValue = bge.checkIfActiveMembership(date);

        Assertions.assertEquals(expectedValue,actualValue);
        Assertions.assertNotEquals(unExpectedValue,actualValue);
    }


    @Test
    public final void writeToPtFileTest(){
        Path writerTestFile = Paths.get("Test/testWriteFile");
        String expectedText = "7703021234, Alhambra Aromes";
        Person mockPerson = new Person("7703021234",
                "Alhambra Aromes","2023-07-01");
        try {
            Files.createFile(writerTestFile);
        } catch (FileAlreadyExistsException e){
            System.out.println("Filen finns redan");
        } catch (IOException e){
            System.out.println("oväntat fel");
        }


        bge.writeToPtFile(mockPerson,writerTestFile);

        String actualTextRead = "";

        try(BufferedReader readFile = Files.newBufferedReader(writerTestFile)){
            actualTextRead = readFile.readLine();
        } catch (IOException e){
            System.out.println("IO Error");
        }

        assertEquals(expectedText,actualTextRead);

        try {
            Files.delete(writerTestFile);
        } catch (NoSuchFileException e) {
            System.out.println("Filen finns inte och går inte att ta bort");
        }catch (DirectoryNotEmptyException e) {
            System.out.println("Katalogen är inte tom");
        }catch (IOException e) {
            System.out.println("IO Error");
        }
    }
}