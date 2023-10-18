package de.ait.models;

public class Grooming {
    String title;
    String breed;
    String period;
    double price;

    public Grooming(String title, String breed, String period, double price) {
        this.title = title;
        this.breed = breed;
        this.period = period;
        this.price = price;
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

    @Override
    public String toString() {
        return "Grooming{" +
                "title='" + title + '\'' +
                ", breeds='" + breed + '\'' +
                ", period='" + period + '\'' +
                ", price=" + price +
                '}';
    }
}
