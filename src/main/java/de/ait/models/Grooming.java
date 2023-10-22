package de.ait.models;

import java.util.Objects;

public class Grooming {
    String title;
    String breed;
    String period;
    double price;
    String groomingId;

    public Grooming(String title, String breed, String period, double price) {
        this.title = title;
        this.breed = breed;
        this.period = period;
        this.price = price;
    }
    public Grooming(String title, String breed, String period, double price, String groomingId) {
        this.title = title;
        this.breed = breed;
        this.period = period;
        this.price = price;
        this.groomingId = groomingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGroomingId() {
        return groomingId;
    }

    public void setGroomingId(String groomingId) {
        this.groomingId = groomingId;
    }

    @Override
    public String toString() {
        return "Grooming{" +
                "title='" + title + '\'' +
                ", breed='" + breed + '\'' +
                ", period='" + period + '\'' +
                ", price=" + price +
                ", groomingId='" + groomingId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grooming grooming = (Grooming) o;

        if (Double.compare(grooming.price, price) != 0) return false;
        if (!Objects.equals(title, grooming.title)) return false;
        if (!Objects.equals(breed, grooming.breed)) return false;
        if (!Objects.equals(period, grooming.period)) return false;
        return Objects.equals(groomingId, grooming.groomingId);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        result = 31 * result + (breed != null ? breed.hashCode() : 0);
        result = 31 * result + (period != null ? period.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (groomingId != null ? groomingId.hashCode() : 0);
        return result;
    }
}
