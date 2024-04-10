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

        System.out.println("\n=== Teste 3: seller findByDepartment===");
        list = sellerDao.findAll();

        for (Seller obj: list){
            System.out.println(obj);
        }

    }
}
