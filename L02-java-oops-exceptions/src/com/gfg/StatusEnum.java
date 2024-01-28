package com.gfg;

public enum StatusEnum {
    LIVE("Live"), UPCOMING("Upcoming"), CANCEL("Cancel");

    private String val;

    StatusEnum(String val) {
        this.val = val;
    }

}
