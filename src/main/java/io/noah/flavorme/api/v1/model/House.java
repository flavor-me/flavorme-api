package io.noah.flavorme.api.v1.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chanwook on 2014. 9. 5..
 */
@Document(collection = "HOUSE")
public class House implements Serializable, HouseGrade, HouseCategory {

    @org.springframework.data.annotation.Id
    private long houseId;

    private String houseName;

    private String houseAddress;

    private String category;

    private String grade;

    private String description;

    private List<HouseImage> images = new ArrayList<>();

    public House() {
    }

    public House(String houseName, String houseAddress, String category, String description, String grade, List<HouseImage> images) {
        this.houseName = houseName;
        this.houseAddress = houseAddress;
        this.category = category;
        this.description = description;
        this.grade = grade;
        this.images = images;
    }

    public long getHouseId() {
        return houseId;
    }

    public void setHouseId(long houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<HouseImage> getImages() {
        return images;
    }

    public void setImages(List<HouseImage> images) {
        this.images = images;
    }
}
