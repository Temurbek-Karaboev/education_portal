package org.example.entity;

public class DataSingleton {
    private static final DataSingleton instance = new DataSingleton();

    private String username;

    private String[] universityFaculties;

    public String[] getUniversityFaculties() {
        return universityFaculties;
    }

    public void setUniversityFaculties(String[] universityFaculties) {
        this.universityFaculties = universityFaculties;
    }

    private DataSingleton(){}

    public static DataSingleton getInstance(){
        return instance;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }
}
