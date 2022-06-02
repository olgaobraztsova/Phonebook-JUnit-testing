import java.util.Objects;

public class Contact {

    final private String name;
    final private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || !obj.getClass().equals(this.getClass())) {
            return false;
        }
        Contact altContact = (Contact) obj;
        return phoneNumber.equals(altContact.phoneNumber) || name.equals(altContact.name);
    }

    @Override
    public String toString() {
        return name + " : " + phoneNumber;
    }
}
