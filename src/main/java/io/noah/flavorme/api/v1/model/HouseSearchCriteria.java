package io.noah.flavorme.api.v1.model;

import java.io.Serializable;

/**
 * Created by chanwook on 2014. 9. 5..
 */
public class HouseSearchCriteria extends PageSupports implements Serializable {
    private String query;

    private String grade;

    private String category;

    private int itemSizePerPage;

    private int pageCount;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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

    public int getItemSizePerPage() {
        return itemSizePerPage;
    }

    public void setItemSizePerPage(int itemSizePerPage) {
        this.itemSizePerPage = itemSizePerPage;
    }

    public int getPage() {
        return pageCount;
    }

    public void setPage(int pageCount) {
        this.pageCount = pageCount;
    }
}
