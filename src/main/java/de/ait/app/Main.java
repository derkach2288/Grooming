package de.ait.app;

import de.ait.dto.GroomingDto;
import de.ait.dto.OrderDto;
import de.ait.dto.UserDto;
import de.ait.models.Grooming;
import de.ait.models.User;
import de.ait.models.UserCredential;
import de.ait.repositories.*;
import de.ait.service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int command;
        UserCredentialsRepository userCredentialsRepositoryTextFile =
                new UserCredentialsRepositoryTextFileImpl("users_credentials.txt");
        UserCredentialsService userCredentialsService = new UserCredentialsServiceImpl(userCredentialsRepositoryTextFile);

        while (true) {
            System.out.println("1. Вход для клиента.\nНажмите \"1\", если Вы клиент");
            System.out.println();
            System.out.println("2. Вход для администратора\nНажмите \"2\", если Вы администратор");
            command = scanner.nextInt(); // считываем команду
            scanner.nextLine();
            switch (command) {
                case 1 -> {
                    while (true) {
                        System.out.println("Если вы новый клиент нажмите \"1\"");
                        System.out.println("Если вы уже наш клиент нажмите \"2\"");
                        command = scanner.nextInt();
                        switch (command) {
                            case 1 -> {
                                clientRegistration();
                                System.out.println("Создайте свои уникальные логин и пароль:");
                                clientCredentialsCreation(userCredentialsService);
                                clientAuthentication(userCredentialsService);
                            }
                            case 2 -> {
                                clientAuthentication(userCredentialsService);
                            }
                        }
                    }
                }
                case 2 -> {
                    String loginFromScanner = "";
                    String passwordFromScanner = "";
                    System.out.println("Введите имя пользователя");
                    loginFromScanner = scanner.nextLine();
                    System.out.println("Введите пароль");
                    passwordFromScanner = scanner.nextLine();
                    if (adminAuthentication(loginFromScanner, passwordFromScanner)) {
                        adminAPI();
                    } else System.out.println("неверное имя пользователя или пароль");
                }
            }
        }
    }
    static void clientCredentialsCreation(UserCredentialsService userCredentialsService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Создайте имя пользователя");
        String newLogin = scanner.nextLine();
        System.out.println("Создайте пароль");
        String newPassword = scanner.nextLine();
        UserCredential userCredential = new UserCredential(newLogin, newPassword);
        userCredentialsService.add(userCredential);
    }
    static void clientAuthentication(UserCredentialsService userCredentialsService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для входа на сайт введите логин и пароль:");
        String loginFromScanner = "";
        String passwordFromScanner = "";
        System.out.println("Введите имя пользователя");
        loginFromScanner = scanner.nextLine();
        System.out.println("Введите пароль");
        passwordFromScanner = scanner.nextLine();
        if (checkUserCredentials(loginFromScanner, passwordFromScanner, userCredentialsService)) {
            System.out.println("Выберите пункт меню");
            clientAPI();
        } else System.out.println("неверное имя пользователя или пароль");
    }

    static void clientRegistration() {
        UsersRepository usersRepositoryTextFile = new UsersRepositoryTextFileImpl("users.txt");
        UsersService usersService = new UsersServiceImpl(usersRepositoryTextFile);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите свои данные: ");
        String firstName = "";
        String secondName = "";
        String breed = "";
        String nickname = "";
        String address = "";
        String eMail = "";

        System.out.println("Введите свое имя");
        firstName = scanner.nextLine();
        System.out.println("Введите свою фамилию");
        secondName = scanner.nextLine();
        System.out.println("Введите название породы");
        breed = scanner.nextLine().toUpperCase();
        System.out.println("Введите кличку собаки");
        nickname = scanner.nextLine();
        System.out.println("Введите свой адрес");
        address = scanner.nextLine();
        System.out.println("Введите адрес электронной почты для связи");
        eMail = scanner.nextLine();
        UserDto dto = new UserDto(firstName, secondName, breed, nickname, address, eMail);
        usersService.add(dto);
    }

    public static void clientAPI() {
        GroomingsRepository groomingTextFileRepository = new GroomingsRepositoryTextImpl("groomings.txt");
        GroomingsService groomingsService = new GroomingsServiceImpl(groomingTextFileRepository);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Показать список услуг");
            System.out.println("2. Показать список пород");
            System.out.println("3. Поиск по породе");
            System.out.println("4. Поиск по услуге");
            System.out.println("5. Вывести весь прейскурант");
            System.out.println("6. Заказ услуги");
            System.out.println("0. Выход");
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1 -> {
                    System.out.println("1. Список услуг: ");
                    System.out.println(groomingsService.getTitles());
                }
                case 2 -> {
                    System.out.println("2. Список пород: ");
                    System.out.println(groomingsService.getBreads());
                }
                case 3 -> {
                    System.out.println("3. Поиск по породе. Введите породу");
                    System.out.println(groomingsService.findBread(scanner.nextLine().toUpperCase()));
                }
                case 4 -> {
                    System.out.println("4. Поиск по услуге. Введите услугу");
                    groomingsService.findGroomingType(scanner.nextLine());
                }
                case 5 -> {
                    System.out.println("Прейскурант:");
                    groomingsService.printAllGroomings();
                }
                case 6 -> {
                    System.out.println("Заказать услугу из списка");
                    groomingsService.printAllGroomings();
                    newOrder();
                    newOrder2();
                }
                case 0 -> {
                    System.out.println("выход из программы");
                    System.exit(0);
                }
                default -> System.out.println("Нет такой команды");
            }
        }
    }

    private static void newOrder() {
        OrderRepository orderRepository = new OrderRepositoryTextFileImpl("orders.txt");
        OrderService orderService = new OrderServiceImpl(orderRepository);
        UsersRepository usersRepositoryTextFile = new UsersRepositoryTextFileImpl("users.txt");
        UsersService usersService = new UsersServiceImpl(usersRepositoryTextFile);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите groomingId: ");
        String groomingId = scanner.nextLine();
        System.out.println("Введите свой userId из списка: ");
        usersService.printAllUsers();
        String userId = scanner.nextLine();
        System.out.println("Введите дату и время в формате: dd-MM-yyyy, HH-mm  ");
        String dateTime = scanner.nextLine();
        OrderDto orderDto = new OrderDto(groomingId, userId, dateTime);
        orderService.add(orderDto);
        System.out.println("Ваши заказы:");
        orderService.searchByUserID(userId).forEach(order -> System.out.println(order));
    }

    private static void newOrder2() {
        OrderRepository orderRepository = new OrderRepositoryTextFileImpl("orders.txt");
        OrderService orderService = new OrderServiceImpl(orderRepository);
        GroomingsRepository groomingsRepositoryTextFile = new GroomingsRepositoryTextImpl("groomings.txt");
        GroomingsService groomingsService = new GroomingsServiceImpl(groomingsRepositoryTextFile);
        UsersRepository usersRepositoryTextFile = new UsersRepositoryTextFileImpl("users.txt");
        UsersService usersService = new UsersServiceImpl(usersRepositoryTextFile);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название породы для соответствующей желаемой услуги: ");
        String breed = scanner.nextLine();
        Grooming grooming = groomingsService.getGroomingByBreed(breed);
        System.out.println("Введите свою фамилию: ");
        String familyName = scanner.nextLine();
        User user = usersService.getUserBySecondName(familyName);
        String userId = user.getUserId();
        System.out.println("Введите дату и время в формате: dd-MM-yyyy, HH-mm  ");
        String dateTime = scanner.nextLine();
        OrderDto orderDto = new OrderDto(grooming.getGroomingId(), user.getUserId(), dateTime);
        orderService.add(orderDto);
        System.out.println("Ваши заказы:");
        orderService.searchByUserID(userId).forEach(order -> System.out.println(order));
    }

    public static void adminAPI() {
        GroomingsRepository groomingTextFileRepository = new GroomingsRepositoryTextImpl("groomings.txt");
        GroomingsService groomingsService = new GroomingsServiceImpl(groomingTextFileRepository);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Вывести список услуг");
            System.out.println("2. Вывести список пород");
            System.out.println("3. Поиск по породе");
            System.out.println("4. Поиск по услуге");
            System.out.println("5. Вывести весь прейскурант");
            System.out.println("6. Добавить услугу");
            System.out.println("0. Выход");
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1 -> {
                    System.out.println("1. Список услуг: ");
                    System.out.println(groomingsService.getTitles());
                }
                case 2 -> {
                    System.out.println("2. Список пород: ");
                    System.out.println(groomingsService.getBreads());
                }
                case 3 -> {
                    System.out.println("3. Поиск по породе. Введите породу");
                    System.out.println(groomingsService.findBread(scanner.nextLine().toUpperCase()));
                }
                case 4 -> {
                    System.out.println("4. Поиск по услуге. Введите услугу");
                    groomingsService.findGroomingType(scanner.nextLine());
                }
                case 5 -> {
                    System.out.println("Прейскурант:");
                    groomingsService.printAllGroomings();

                }
                case 6 -> {
                    System.out.println("6. Добавьте услугу");
                    String title = "";
                    String breed = "";
                    String period = "";
                    double price = 0;
                    System.out.println("Введите название услуги");
                    title = scanner.nextLine();
                    System.out.println("Введите название породы");
                    breed = scanner.nextLine().toUpperCase();
                    System.out.println("Введите продолжительность процедуры");
                    period = scanner.nextLine();
                    System.out.println("Введите цену");
                    price = scanner.nextDouble();
                    scanner.nextLine();
                    GroomingDto dto = new GroomingDto(title, breed, period, price);
                    groomingsService.add(dto);
                }
                case 0 -> {
                    System.exit(0);
                }
                default -> System.out.println("Нет такой команды");
            }
        }
    }
    public static boolean checkUserCredentials(String login, String password, UserCredentialsService userCredentialsService) {
        if (userCredentialsService.getUserLogin(login).equals(login) && userCredentialsService.getUserPassword(password).equals(password)) {
            return true;
        } else return false;
    }
    public static boolean adminAuthentication(String login, String password) {
        AdminRepositoryTextImpl adminRepositoryText = new AdminRepositoryTextImpl("admin_credentials.txt");
        if (login.equals(adminRepositoryText.getAdminID()) && password.equals(adminRepositoryText.getPassword())) {
            return true;
        } else return false;
    }
}
