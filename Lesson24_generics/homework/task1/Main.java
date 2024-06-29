package Lesson24_generics.homework.task1;

import java.util.Scanner;

public class Main {

    // Дополните объявление поля friendsContactBook, которое будет хранить в себе список номеров телефонов друзей
    private static ContactBook friendsContactBook = new ContactBook();
    private static ContactBook colleaguesContactBook = new ContactBook();
    private static ContactBook classmatesContactBook = new ContactBook();
    private static ContactBook relativesContactBook = new ContactBook();

    public static void main(String[] args) {
        fillBooks();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Сегодня Новый Год! 1 - Отправить поздравление, 0 - Напомнить позднее");
            int mainCommand = scanner.nextInt();
            if (mainCommand == 1) {
                System.out.println("Какую книгу контактов открыть?");
                System.out.println("1 - Друзья, 2 - Коллеги, 3 - Одногруппники, 4 - Родственники");

                int bookIndex = scanner.nextInt();
                if (bookIndex == 1) {
                    friendsContactBook.printList();
                } else if (bookIndex == 2) {
                    colleaguesContactBook.printList();
                } else if (bookIndex == 3) {
                    classmatesContactBook.printList();
                } else if (bookIndex == 4) {
                    relativesContactBook.printList();
                }

                System.out.println("Кого вы хотите поздравить? Введите имя:");
                String name = scanner.next();
                if (bookIndex == 1) {
                    friendsContactBook.congratulate(name);
                } else if (bookIndex == 2) {
                    colleaguesContactBook.congratulate(name);
                } else if (bookIndex == 3) {
                    classmatesContactBook.congratulate(name);
                } else if (bookIndex == 4) {
                    relativesContactBook.congratulate(name);
                }
            } else if (mainCommand == 0) {
                break;
            }
        }
    }

    private static void fillBooks() {
        friendsContactBook.addContact(new Phone("Асылбек", "+7-707-000-11-22"));
        friendsContactBook.addContact(new Phone("Малика", "+7-777-555-11-22"));
        friendsContactBook.addContact(new Phone("Куандык", "+7-702-698-00-22"));

        colleaguesContactBook.addContact(new Email("Александр", "sasha@sasha.org"));
        colleaguesContactBook.addContact(new Email("Павел", "pasha@pasha.org"));
        colleaguesContactBook.addContact(new Email("Олег", "oleg@oleg.com"));

        classmatesContactBook.addContact(new SocialNetworkContact("Анита", "НаСвязи", "anita"));
        classmatesContactBook.addContact(new SocialNetworkContact("Жека", "Фотопризма", "zheka"));

        relativesContactBook.addContact(new Address("Бабуля", "Астана", "Кабанбай батыра, 58"));
        relativesContactBook.addContact(new Address("Дедуля", "Алматы", "Ленина, д.10"));
    }

}
