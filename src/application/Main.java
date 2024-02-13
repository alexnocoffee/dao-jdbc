package application;

import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("TEST #1 ==> seller findById");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("TEST #2 ==> seller findByDepartment");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        list.forEach(System.out::println);

        System.out.println("TEST #3 ==> seller findAll");
        list = sellerDao.findAll();
        list.forEach(System.out::println);

        System.out.println("TEST #4 ==> seller insert");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", LocalDate.now(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("TEST #5 ==> seller update");
        seller = sellerDao.findById(1);
        seller.setName("Test NameUP");
        sellerDao.update(seller);
        System.out.println("Update completed!");

        System.out.println("TEST #6 ==> seller delete");
        sellerDao.deleteById(10);
        System.out.println("Id deleted!");
    }
}
