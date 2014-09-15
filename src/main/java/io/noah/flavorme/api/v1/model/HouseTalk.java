package io.noah.flavorme.api.v1.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chanwook on 2014. 9. 13..
 */
@Document(collection = "HOUSE_TALK")
public class HouseTalk implements Serializable {

    @org.springframework.data.annotation.Id
    private String talkId;

    private long houseId;

    private Date created;

    private Date updated;

    private String text;

    private List<HouseImage> images = new ArrayList<>();

    private List<HouseTalkReply> replies = new ArrayList<>();

    public HouseTalk() {
    }

    public HouseTalk(long houseId, Date created, Date updated, String text, List<HouseImage> images, List<HouseTalkReply> replies) {
        this.houseId = houseId;
        this.created = created;
        this.updated = updated;
        this.text = text;
        this.images = images;
        this.replies = replies;
    }

    public long getHouseId() {
        return houseId;
    }

    public void setHouseId(long houseId) {
        this.houseId = houseId;
    }

    public String getTalkId() {
        return talkId;
    }

    public void setTalkId(String talkId) {
        this.talkId = talkId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<HouseImage> getImages() {
        return images;
    }

    public void setImages(List<HouseImage> images) {
        this.images = images;
    }

    public List<HouseTalkReply> getReplies() {
        return replies;
    }

    public void setReplies(List<HouseTalkReply> replies) {
        this.replies = replies;
    }
}
