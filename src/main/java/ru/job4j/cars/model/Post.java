package ru.job4j.cars.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long price;
    private int productionYear;
    private long mileage;
    private String color;
    private String driveUnit;
    private String description;

    @UpdateTimestamp
    private LocalDateTime created;

    private boolean isSale;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;


    @ManyToOne
    @JoinColumn(name = "carBoby_id")
    private CarBoby carBoby;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "transmission_id")
    private Transmission transmission;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos = new ArrayList<>();

    public static Post of(long price, int productionYear, long mileage, String color, String driveUnit,
                          String desc, boolean isSale, Model model, CarBoby body, Transmission transmission, User user) {
        Post post = new Post();
        post.price = price;
        post.productionYear = productionYear;
        post.mileage = mileage;
        post.color = color;
        post.driveUnit = driveUnit;
        post.description = desc;
        post.isSale = isSale;
        post.model = model;
        post.carBoby = body;
        post.transmission = transmission;
        post.user = user;
        return post;
    }

    public void addPhoto(Photo photo) {
        this.photos.add(photo);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public CarBoby getCarBoby() {
        return carBoby;
    }

    public void setCarBoby(CarBoby carBoby) {
        this.carBoby = carBoby;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean getSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDriveUnit() {
        return driveUnit;
    }

    public void setDriveUnit(String driveUnit) {
        this.driveUnit = driveUnit;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Post.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("price=" + price)
                .add("productionYear=" + productionYear)
                .add("mileage=" + mileage)
                .add("color='" + color + "'")
                .add("driveUnit='" + driveUnit + "'")
                .add("description='" + description + "'")
                .add("created=" + created)
                .add("isSale=" + isSale)
                .add("model=" + model)
                .add("carBoby=" + carBoby)
                .add("user=" + user)
                .add("transmission=" + transmission)
                .add("photos=" + photos)
                .toString();
    }
}
