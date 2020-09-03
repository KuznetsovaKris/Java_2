package lesson3;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов","8996584");
        phonebook.add("Иванов","8397884");
        phonebook.add("Иванов","8996584");
        phonebook.get("Сидоров");
    }
}

