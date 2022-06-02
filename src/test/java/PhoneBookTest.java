import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookTest {

    private static Phonebook phonebook;

    // перед запуском тестов создаем экземпляр класса Phonebook и заполняем его данными
    @BeforeAll
    public static void before(){
        phonebook = new Phonebook();
        phonebook.addGroup("Family");
        phonebook.addGroup("Work");
        phonebook.addContactToGroup(
                Phonebook.createContact("Вася", "987654321"),
                "Family");
        phonebook.addContactToGroup(
                Phonebook.createContact("Коля", "123456789"),
                "Friends", "Work");
        phonebook.addContactToGroup(
                Phonebook.createContact("Петя", "9999999"),
                "Family");
    }

    // тест для поиска по номеру телефона
    @Test
    public void TestFindByPhone(){

        // arrange:
        String phoneNumber = "123456789";
        Contact expectedResult = new Contact("Коля", "123456789");

        // act:
        Contact result = phonebook.findByPhone(phoneNumber);

        // assert:
        Assertions.assertEquals(expectedResult, result);
        Assertions.assertNotNull(result);

    }

    // тест на поиск по названию группы
    @Test
    public void TestFindByGroup(){
        // arrange
        List<Contact> testList = new ArrayList<>();
        testList.add(new Contact("Вася", "987654321"));
        testList.add(new Contact("Петя", "9999999"));
        Object[] expectedResult = testList.toArray();

        // act
        Object[] result = phonebook.findByGroup("Family").toArray();

        // assert
        Assertions.assertArrayEquals(expectedResult, result);

    }

    // тест создания нового контакта
    @Test void TestCreateContact(){
        // arrange

        String name = "Петя";
        String phoneNumber = "111";
        Contact expectedResult = new Contact("Петя", "111");

        // act
        Contact result = Phonebook.createContact(name, phoneNumber);

        //assert

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedResult, result);
    }

}

