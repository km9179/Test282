package com.example.tenx.test272.ListItems;

public class HeaderItem extends ListItem{
    String name;

    public HeaderItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getType() {
        return ListItem.TYPE_HEADER;
    }
}
