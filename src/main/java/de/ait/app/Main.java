package de.ait.app;

import de.ait.repositories.UsersRepository;
import de.ait.repositories.UsersRepositoryListImpl;
import de.ait.repositories.UsersRepositoryTextFileImpl;
import de.ait.service.UsersService;
import de.ait.service.UsersServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // конфигурируем приложение - с какими имплементациями будем работать

//        UsersRepository testRepository = new UsersRepositoryListImpl();
//        UsersService usersService = new UsersServiceImpl(testRepository);

//
        UsersRepository userTextFileRepository = new UsersRepositoryTextFileImpl("users.txt");
        UsersService usersService = new UsersServiceImpl(userTextFileRepository);


        while (true){
            System.out.println("1. Вывести имена всех пользователей");
            System.out.println("2. Вывести фамилию самого взрослого пользователя");
            System.out.println("3. Сохранить нового пользователя");
            System.out.println("4. Вывести средний возраст всех пользователей");
            System.out.println("5. Вывести возраст самого высокого");
            System.out.println("6. Вывести имя и фамилию самого низкого пользователя");
            System.out.println("7. Выход");
            int command = scanner.nextInt(); // считываем команду
            scanner.nextLine(); // чтобы не было бага со сканером

            // вызываем соответсвующие процессы в нашей пограмме
            switch (command){
                case 1:
                    System.out.println("Выводим имена пользователей...");
                    System.out.println(usersService.getNames());
                    break;
                case 2:
                    System.out.println("Выводим фамилию самого старшего пользователя...");
                    System.out.println(usersService.getSecondNameOfOldest());
                    break;
                case 3:
                    System.out.println("...");
                    // здесь пишем код
                    break;
                case 4:
                    System.out.println("...");
                    // здесь пишем код
                    break;
                case 5:
                    System.out.println("...");
                    // здесь пишем код
                    break;
                case 6:
                    System.out.println("...");
                    // здесь пишем код
                    break;
                case 7:
                    System.out.println("...");
                    System.exit(0); // выходим из программы
                    break;
                default:
                    System.out.println("Нет такой команды");

            }

        }
    }
}