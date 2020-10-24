package com.lobanova.electroniclibrary.enums;

public enum UserType {

    ADMIN("admin"),
    USER("user");

    private final String name;

    UserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static UserType getUserType(String userType) {
        return UserType.ADMIN.getName().equals(userType) ? ADMIN : USER;
    }
}
