package de.ait.app;

import de.ait.dto.GroomingDto;
import de.ait.repositories.*;
import de.ait.service.GroomingsService;
import de.ait.service.GroomingsServiceImpl;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
//        groomingTextFileRepository.addGrooming("hygiene|SPITZ|2.0|80.0");
        Scanner scanner = new Scanner(System.in);
        int command;

        while (true) {
            System.out.println("1. Вход для клиента.\nНажмите \"1\", если Вы клиент");
            System.out.println();
            System.out.println("2. Вход для администратора\nНажмите \"2\", если Вы администратор");
            command = scanner.nextInt();// считываем команду
            scanner.nextLine();
            switch (command) {
                case 1 -> {
                    System.out.println("Выберите пункт меню");
                    clientAPI();
                }
                case 2 -> {
                    String adminIDFromScanner = "";
                    String passwordFromScanner = "";
                    System.out.println("Введите имя пользователя");
                    adminIDFromScanner = scanner.nextLine();
                    System.out.println("Введите пароль");
                    passwordFromScanner = scanner.nextLine();
                    if (authenticate(adminIDFromScanner, passwordFromScanner)) {
                        adminAPI();
                    } else System.out.println("неверное имя пользователя или пароль");
                }
            }
        }
    }
        public static void clientAPI () {
            GroomingsRepository groomingTextFileRepository = new GroomingsRepositoryTextImpl("groomings.txt");
            GroomingsService groomingsService = new GroomingsServiceImpl(groomingTextFileRepository);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Вывести список услуг");
                System.out.println("2. Вывести список пород");
                System.out.println("3. Поиск по породе");
                System.out.println("4. Поиск по услуге");
                System.out.println("5. Вывести весь прейскурант");
                System.out.println("0. Выход");
                int command = scanner.nextInt();
                scanner.nextLine();
                switch (command) {
                    case 1:
                        System.out.println("1. Список услуг: ");
                        System.out.println(groomingsService.getTitles());
                        break;
                    case 2:
                        System.out.println("2. Список пород: ");
                        System.out.println(groomingsService.getBreads());
                        break;
                    case 3:
                        System.out.println("3. Поиск по породе. Введите породу");
                        System.out.println(groomingsService.findBread(scanner.nextLine().toUpperCase()));
                        break;
                    case 4:
                        System.out.println("4. Поиск по услуге. Введите услугу");
                        System.out.println(groomingsService.findGroomingType(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.println("Прейскурант:");
                        groomingTextFileRepository.findAll().stream().forEach(s -> System.out.println(s));
                        break;

                    case 0:
                        System.out.println("...");
                        System.exit(0); // выходим из программы
                        break;
                    default:
                        System.out.println("Нет такой команды");
                }
            }
        }

        public static void adminAPI () {
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
                        System.out.println(groomingsService.findGroomingType(scanner.nextLine()));
                    }
                    case 5 -> {
                        System.out.println("Прейскурант:");
                        groomingTextFileRepository.findAll().forEach(System.out::println);
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
        public static boolean authenticate (String adminID, String password){
            AdminRepositoryTextImpl adminRepositoryText = new AdminRepositoryTextImpl("admin_credentials.txt");
            if (adminID.equals(adminRepositoryText.getAdminID()) && password.equals(adminRepositoryText.getPassword())) {
                return true;
            } else return false;
        }
    }
