package com.lobanova.electroniclibrary.enums;

public enum UserRole {

    ADMIN("admin", "ROLE_ADMIN"),
    USER("user", "ROLE_USER");

    private final String name;
    private final String authorityRole;

    UserRole(String name, String authorityRole) {
        this.name = name;
        this.authorityRole = authorityRole;
    }

    public String getName() {
        return name;
    }

    public String getAuthorityRole() {
        return authorityRole;
    }

    public static UserRole getUserType(String userType) {
        return UserRole.ADMIN.getName().equals(userType) ? ADMIN : USER;
    }

    public static String getUserAuthorityRole(String role) {
        return UserRole.ADMIN.getName().equals(role) ? ADMIN.authorityRole : USER.authorityRole;
    }
}
