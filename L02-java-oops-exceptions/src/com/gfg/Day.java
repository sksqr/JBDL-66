package com.gfg;

public enum Day {
    SUNDAY(1,"SUN"), MONDAY(2,"MON"), TUESDAY(3,"TUE"),
    WEDNESDAY(4,"WED"), THURSDAY(5,"THU"),
    FRIDAY(6,"FRI"), SATURDAY(7,"SAT");

    private int noOfWeekDay;
    private String day;

    Day(int noOfWeekDay, String day) {
        this.noOfWeekDay = noOfWeekDay;
        this.day = day;
    }

    public int getNoOfWeekDay() {
        return noOfWeekDay;
    }

    public String getDay() {
        return day;
    }
}
