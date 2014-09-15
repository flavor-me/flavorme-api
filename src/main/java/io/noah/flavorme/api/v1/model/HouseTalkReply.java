package io.noah.flavorme.api.v1.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chanwook on 2014. 9. 13..
 */
public class HouseTalkReply implements Serializable {

    private long replyId;

    private String text;

    private Date updated;

    public HouseTalkReply() {
    }

    public HouseTalkReply(long replyId, String text, Date updated) {
        this.replyId = replyId;
        this.text = text;
        this.updated = updated;
    }

    public long getReplyId() {
        return replyId;
    }

    public void setReplyId(long replyId) {
        this.replyId = replyId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
