package io.noah.flavorme.api.v1.model;

import java.io.Serializable;

/**
 * Created by chanwook on 2014. 9. 11..
 */
public class HouseImage implements Serializable {
    private int index;
    private String url;
    private String alt;

    public HouseImage() {
    }

    public HouseImage(int index, String url, String alt) {
        this.index = index;
        this.url = url;
        this.alt = alt;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
