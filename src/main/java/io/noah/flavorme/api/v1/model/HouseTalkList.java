package io.noah.flavorme.api.v1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chanwook on 2014. 9. 13..
 */
public class HouseTalkList extends PageSupports {

    private long houseId;

    private List<HouseTalk> talkList = new ArrayList<>();

    public HouseTalkList() {
    }

    public HouseTalkList(long houseId, List<HouseTalk> talkList) {
        this.talkList = talkList;
        this.houseId = houseId;
    }

    public long getHouseId() {
        return houseId;
    }

    public void setHouseId(long houseId) {
        this.houseId = houseId;
    }

    public List<HouseTalk> getTalkList() {
        return talkList;
    }

    public void setTalkList(List<HouseTalk> talkList) {
        this.talkList = talkList;
    }
}
