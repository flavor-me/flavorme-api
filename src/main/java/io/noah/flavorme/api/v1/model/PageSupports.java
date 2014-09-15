package io.noah.flavorme.api.v1.model;

import java.io.Serializable;

/**
 * Created by chanwook on 2014. 9. 5..
 */
//TODO 다른 구조로 개선
public class PageSupports implements Serializable {

    private int page;

    private int itemSize;

    public PageSupports() {
    }

    public PageSupports(int page, int itemSize) {
        this.page = page;
        this.itemSize = itemSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getItemSize() {
        return itemSize;
    }

    public void setItemSize(int itemSize) {
        this.itemSize = itemSize;
    }
}
