package application;

import Db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = new SellerDaoJDBC(DB.getConnection());
        System.out.println("=== Teste 1: seller findByID ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Teste 2: seller findByDepartment===");
        Department department = new Department(2,null);
        List<Seller>list = sellerDao.findByDepartment(department);

        System.out.println("\n=== Teste 3: seller findAll===");
        list = sellerDao.findAll();

        for (Seller obj: list){
            System.out.println(obj);
        }

        System.out.println("\n=== Teste 4: seller Insert===");
        Seller newSeller = new Seller(null,"Greg","greg@gmail.com", new Date(),4000.00,department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted!! New Id= " + newSeller.getId());

        System.out.println("\n=== Teste 5: seller Update===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed!");
    }
}
