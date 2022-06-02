
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Phonebook phonebook = new Phonebook();

        // создаем группы и добавляем контакты
        fillGroup(phonebook);
        addContacts(phonebook);

        MissedCalls missedCalls = new MissedCalls();
        addMissedCallsMethod(missedCalls);
        missedCalls.printMissedCalls(phonebook);
    }

    private static void addMissedCallsMethod(MissedCalls missedCalls) throws InterruptedException {
        missedCalls.addMissedCall("999999");
        Thread.sleep(500);
        missedCalls.addMissedCall("999991");
        Thread.sleep(500);
        missedCalls.addMissedCall("999992");
        Thread.sleep(500);
        missedCalls.addMissedCall("999993");
        Thread.sleep(500);
        missedCalls.addMissedCall("999994");
        Thread.sleep(500);
        missedCalls.addMissedCall("999995");
    }

    //метод добавления контактов
    private static void addContacts(Phonebook phonebook) {
        phonebook.addContactToGroup(
                Phonebook.createContact("Петя", "999999"),
                "Family", "Work");
        phonebook.addContactToGroup(
                Phonebook.createContact("Коля", "890211111"),
                "Friends", "Work");
        phonebook.addContactToGroup(
                Phonebook.createContact("Сантехник", "999995"),
                "Services");
        phonebook.addContactToGroup(
                Phonebook.createContact("Вася", "999993"),
                "Friends");
        phonebook.addContactToGroup(
                Phonebook.createContact("Оля", "890244444"),
                "Family", "Friends");
    }

    //метод создания групп
    public static void fillGroup(Phonebook phonebook) {
        phonebook.addGroup("Family");
        phonebook.addGroup("Work");
        phonebook.addGroup("Friends");
        phonebook.addGroup("Services");
    }
}
