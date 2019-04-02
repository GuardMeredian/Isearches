package com.bcode.Isearches.domain;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String textMessage;

    private String tagMessage;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User authorMessage;

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Message() {
    }

    public Message(String textMessage, String tagMessage, User user) {
        this.authorMessage=user;
        this.textMessage = textMessage;
        this.tagMessage = tagMessage;
    }

    public String getAuthorName(){
        return authorMessage != null ? authorMessage.getUsername() : "<none>";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getTagMessage() {
        return tagMessage;
    }

    public void setTagMessage(String tagMessage) {
        this.tagMessage = tagMessage;
    }

    public User getAuthorMessage() {
        return authorMessage;
    }

    public void setAuthorMessage(User authorMessage) {
        this.authorMessage = authorMessage;
    }
}
