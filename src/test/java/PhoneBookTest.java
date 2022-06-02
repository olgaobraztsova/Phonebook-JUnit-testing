import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PhoneBookTest {

    @Test
    public void TestFindByPhone(){


        // arrange:
        Phonebook phonebook = new Phonebook();
        phonebook.addGroup("Family");
        phonebook.addGroup("Work");
        phonebook.addContactToGroup(
                Phonebook.createContact("Вася", "987654321"),
                "Family", "Family");
        phonebook.addContactToGroup(
                Phonebook.createContact("Коля", "123456789"),
                "Friends", "Work");

        Contact expectedResult = new Contact("Коля", "123456789");


        // act:

        Contact result = phonebook.findByPhone("123456789");

        // then:

        Assertions.assertEquals(expectedResult, result);

    }

}

