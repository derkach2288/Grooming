package de.ait.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class OrderDto {
    private String groomingId;
    private String userId;
    private String dateTime;

    public OrderDto(String groomingId, String userId, String dateTime) {
        this.groomingId = groomingId;
        this.userId = userId;
        this.dateTime = dateTime;
        ;
    }
//    private LocalDateTime localDateTime(String dateTime) {
//        // нужно принять строку в таком формате: dd-MM-yyyy, HH-mm
//        String[] temp = dateTime.split(", ");
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH-mm");
//        LocalDate date = LocalDate.parse(temp[0], dateFormatter);
//        LocalTime time = LocalTime.parse(temp[1], timeFormatter);
//        return LocalDateTime.of(date, time);
//    }


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

    public String getDateTime() {
        return dateTime;
    }


    @Override
    public String toString() {
        return "OrderDto{" +
                "groomingId='" + groomingId + '\'' +
                ", userId='" + userId + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
