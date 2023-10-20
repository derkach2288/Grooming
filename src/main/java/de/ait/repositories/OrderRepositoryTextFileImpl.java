package de.ait.repositories;

import de.ait.models.Order;
import de.ait.models.User;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryTextFileImpl implements OrderRepository {
    String fileName;

    public OrderRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                Order order = parsLine(line);
                orders.add(order);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
        return orders;
    }


    public static Order parsLine(String str) {
        String[] parsed = str.split("\\|");
        String orderId = parsed[0];
        String groomingId = parsed[1];
        String userId = parsed[2];
        String dateTime = parsed[3];
        return new Order(orderId, groomingId, userId, dateTime);
    }

    @Override
    public void save(Order order) {
        try(FileWriter fileWriter = new FileWriter(fileName, true); // append true - добавляет в конец файла, не
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.newLine();
            bufferedWriter.write(convert(order));

        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
    }
    private String convert(Order order) {
        DateTimeFormatter formatterDate =
                DateTimeFormatter.ofPattern("dd-MM-yyy");
        DateTimeFormatter formatterTime =
                DateTimeFormatter.ofPattern("HH-mm");

        String line = order.getOrderId() + "|" + order.getGroomingId() + "|"
                + order.getUserId() + "|" + formatterDate.format(order.getDateTime()) + ", " + formatterTime.format(order.getDateTime());
        return line;
    }

}
