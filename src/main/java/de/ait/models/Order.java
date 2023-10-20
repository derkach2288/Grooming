package de.ait.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private String orderId;
    private String groomingId;
    private String userId;
    private LocalDateTime dateTime;

    public Order(String orderId, String groomingId, String userId, String dateTime) {
        this.orderId = orderId;
        this.groomingId = groomingId;
        this.userId = userId;
        this.dateTime = localDateTime(dateTime);
    }
    private LocalDateTime localDateTime(String dateTime) {
        String[] temp = dateTime.split(", ");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH-mm");
        LocalDate date = LocalDate.parse(temp[0], dateFormatter);
        LocalTime time = LocalTime.parse(temp[1], timeFormatter);
        return LocalDateTime.of(date, time);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGroomingId() {
        return groomingId;
    }

    public void setGroomingId(String groomingId) {
        this.groomingId = groomingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", groomingId='" + groomingId + '\'' +
                ", userId='" + userId + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
