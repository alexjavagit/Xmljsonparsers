package task2;

import java.util.List;

public class Card {
    public String name;
    public String surname;
    public List<String> phones;
    public List<String> sites;
    public Address address;

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phones=" + phones +
                ", sites=" + sites +
                ", address=" + address +
                '}';
    }
}
