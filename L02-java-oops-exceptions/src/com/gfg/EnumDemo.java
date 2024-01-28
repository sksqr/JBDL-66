package com.gfg;

public class EnumDemo {

    public static void main(String[] args) {
        Day day = Day.SUNDAY;

        System.out.println(day == Day.SUNDAY);

        System.out.println(day.getDay());

        switch (day){

            case FRIDAY -> System.out.println();
        }

        // day = "Holiday"

        Lecture lecture = new Lecture();
        lecture.setStatus(StatusEnum.LIVE);

    }
}
