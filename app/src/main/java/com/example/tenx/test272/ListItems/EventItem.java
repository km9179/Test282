package com.example.tenx.test272.ListItems;

public class EventItem extends ListItem{
    private String name;
    private String url;
    private String desc;



    public EventItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
    public String getDesc() {
        return desc;
    }

    @Override
    public int getType() {
        return ListItem.TYPE_EVENT;
    }
}