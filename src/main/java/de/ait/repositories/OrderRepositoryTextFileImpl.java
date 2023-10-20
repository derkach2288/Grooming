package de.ait.repositories;

import de.ait.models.Order;
import de.ait.models.User;

import java.io.*;
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

    private String convert(Order order) {
        String line = order.getOrderId() + "|" + order.getGroomingId() + "|"
                + order.getUserId() + "|" + order.getDateTime();
        return line;
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
        try (FileWriter fileWriter = new FileWriter(fileName, true);
             // перезаписывает
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.newLine();
            bufferedWriter.write(convert(order));

        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
    }
}
