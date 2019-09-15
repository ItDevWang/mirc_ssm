package com.mirc.ssm.test;

import com.mirc.ssm.dao.IProductDao;
import com.mirc.ssm.domain.Product;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.List;

public class Test {


    @Autowired
    private IProductDao productDao;

    @org.junit.Test
    public void testFindAll() throws Exception {



        List<Product> products = productDao.findAll();
        for (Product p : products) {
            System.out.println(p);
        }
    }

    @org.junit.Test
    public void testConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ssm", "ssm");

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM product WHERE productNum=?");

            ps.setObject(1,"mirc-002");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getString("cityname"));
            }

            resultSet.close();
            ps.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
