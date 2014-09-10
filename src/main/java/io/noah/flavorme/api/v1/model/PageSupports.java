package io.noah.flavorme.api.v1.model;

import java.io.Serializable;

/**
 * Created by chanwook on 2014. 9. 5..
 */
//TODO 다른 구조로 개선
public abstract class PageSupports implements Serializable {

    private int pageCount;

    private int itemSize;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getItemSize() {
        return itemSize;
    }

    public void setItemSize(int itemSize) {
        this.itemSize = itemSize;
    }
}
