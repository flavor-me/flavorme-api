package io.noah.flavorme.api.v1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chanwook on 2014. 9. 5..
 */
public class HouseList extends PageSupports {

    private List<House> houseList = new ArrayList<>();

    public HouseList(HouseSearchCriteria c, List<House> houseList) {
        super.setItemSize(c.getItemSizePerPage());
        super.setPageCount(c.getPageCount());
        this.houseList = houseList;
    }

    public List<House> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<House> houseList) {
        this.houseList = houseList;
    }
}
