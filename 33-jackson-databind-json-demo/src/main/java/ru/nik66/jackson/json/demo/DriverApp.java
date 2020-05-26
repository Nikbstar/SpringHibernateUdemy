package ru.nik66.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class DriverApp {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File json = new File(DriverApp.class.getClassLoader().getResource("sample-full.json").getFile());
            Student student = mapper.readValue(json, Student.class);
            System.out.println("First name: " + student.getFirstName());
            System.out.println("Last name: " + student.getLastName());
            System.out.println("Active: " + student.isActive());
            System.out.println("Id: " + student.getId());
            System.out.println("Address: " + student.getAddress());
            System.out.println("Languages: " + student.getLanguages());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
