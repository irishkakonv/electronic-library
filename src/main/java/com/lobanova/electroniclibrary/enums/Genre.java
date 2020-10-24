package com.lobanova.electroniclibrary.enums;

public enum Genre {

    CLASSIC("classic"),
    DETECTIVE("detectiv"),
    HISTORY("history"),
    SCIENCE("science"),
    UNKNOWN("unknown");

    private final String name;

    Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Genre getGenre(String name) {
        for (Genre genre : values()) {
            if (genre.name.equals(name)) {
                return genre;
            }
        }
        return UNKNOWN;
    }
}
