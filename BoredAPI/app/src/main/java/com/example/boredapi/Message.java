package com.example.boredapi;

import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("activity")
    private String activity;

    @SerializedName("type")
    private String type;

    @SerializedName("participants")
    private int participants;

    @SerializedName("price")
    private double price;

    @SerializedName("link")
    private String link;

    @SerializedName("key")
    private long key;

    @SerializedName("accessibility")
    private double accessibility;

    private boolean liked = false;

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public double getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(double accessibility) {
        this.accessibility = accessibility;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
}

