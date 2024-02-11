package application;

import entities.Department;
import entities.Seller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        Department department = new Department(2, "Books");

        Seller seller = new Seller(22,
                "Alex",
                "alex@gmail.com",
                LocalDate.parse("25/08/2006", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                3000.00,
                department);

        System.out.println(seller);

    }
}
