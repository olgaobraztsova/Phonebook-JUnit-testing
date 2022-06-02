import java.time.LocalDateTime;
import java.util.NavigableMap;
import java.util.TreeMap;


public class MissedCalls {

    private final NavigableMap<LocalDateTime, String> missedCalls = new TreeMap<>();

    //метод добавления пропущенных звонков
    public void addMissedCall(String number) {
        missedCalls.put(LocalDateTime.now(), number);
    }

    //метод вывода пропущенных звонков на экран
    public void printMissedCalls(Phonebook phonebook) {

        while (!missedCalls.isEmpty()) {
            String number = missedCalls.firstEntry().getValue();

            //если по номеру находится контакт, то выводим его имя
            if (phonebook.findByPhone(number) != null) {
                String name = phonebook.findByPhone(number).getName();
                System.out.println(missedCalls.pollFirstEntry().getKey() + " : контакт " + name);
            } else {
                //иначе выводим просто номер
                System.out.println(missedCalls.pollFirstEntry().getKey() + " : номер " + number);
            }
        }

    }

    @Override
    public String toString() {
        return missedCalls.firstEntry().getKey() + " : " + missedCalls.firstEntry().getValue();
    }
}
