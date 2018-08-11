package com.example.tenx.test272.ListItems;

public class EventItem extends ListItem{
    private String name;
    private String url;

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

    @Override
    public int getType() {
        return ListItem.TYPE_EVENT;
    }
}