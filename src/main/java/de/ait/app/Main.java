package de.ait.app;

import de.ait.repositories.*;
import de.ait.service.GroomingsService;
import de.ait.service.GroomingsServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // конфигурируем приложение - с какими имплементациями будем работать

//        UsersRepository testRepository = new UsersRepositoryListImpl();
//        UsersService usersService = new UsersServiceImpl(testRepository);
//        GroomingsRepository testRepositiry = new GroomingsRepositoryListImpl();
//        GroomingsService groomingsService = new GroomingsServiceImpl(testRepositiry);

//

        GroomingsRepository groomingTextFileRepository = new GroomingsRepositoryTextImpl("groomings.txt");
        GroomingsService groomingsService = new GroomingsServiceImpl(groomingTextFileRepository);


        while (true){
            System.out.println("1. Вывести список услуг");
            System.out.println("2. Вывести список пород");
            System.out.println("3. Поиск по породе");
            System.out.println("4. Поиск по улуге");
            System.out.println("0. Выход");
            int command = scanner.nextInt(); // считываем команду
            scanner.nextLine(); // чтобы не было бага со сканером

            // вызываем соответсвующие процессы в нашей пограмме
            switch (command){
                case 1:
                    System.out.println("Вывести список услуг...");
                    System.out.println(groomingsService.getTitles());
                    break;
                case 2:
                    System.out.println("Вывести список пород...");
                    System.out.println(groomingsService.gerBreads());
                    break;
                case 3:
                    System.out.println("Введите породу");
                    System.out.println(groomingsService.findBread(scanner.nextLine().toUpperCase()));
                    break;
                case 4:
                    System.out.println("Введите услугу");
                    System.out.println(groomingsService.findGroomingType(scanner.nextLine()));
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
}