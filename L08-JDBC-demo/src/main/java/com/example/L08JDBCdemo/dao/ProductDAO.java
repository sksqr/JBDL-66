package com.example.L08JDBCdemo.dao;



import com.example.L08JDBCdemo.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductDAO {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductDAO.class);

    @Value("${db.url}")
    private String dbUrl;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    private Map<Long, Product> dataStore = new HashMap<>();
    private Long nextId=0l;
    public List<Product> getAllData(){
        List<Product> productList = new ArrayList<>();
        Connection con = null;
        try {
            con = DriverManager.getConnection(dbUrl, username, password);
            String sqlQuery = "Select id, name, cost from product";
            Statement stmt = con.createStatement();
            ResultSet resultSet =  stmt.executeQuery(sqlQuery);
            while (resultSet.next()){
                productList.add(new Product(resultSet.getLong("id"),resultSet.getString("name"),
                        resultSet.getDouble("cost")));
            }
            LOGGER.info("Connection created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return productList;
    }
    public Long createProduct(Product product){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
            Statement statement = connection.createStatement();
            String sql = "insert into product values (null,'"+product.getName()+"',"+product.getCost()+")";
            int affectedRow = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            if(affectedRow == 0){
                throw new SQLException("Creating Product Failed");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                product.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return product.getId();
    }

    public Long createProductWithPS(Product product){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
            String sql = "insert into product values (null,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setDouble(2,product.getCost());
            int affectedRow = statement.executeUpdate();
            if(affectedRow == 0){
                throw new SQLException("Creating Product Failed");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                product.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return product.getId();
    }


    public Long createProductWithPSWithTxn(Product product){
        Connection connection = null;
        boolean autocommit = false;
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
            autocommit = connection.getAutoCommit();
            connection.setAutoCommit(false);
            String sql = "insert into product values (null,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setDouble(2,product.getCost());
            int affectedRow = statement.executeUpdate();
            if(affectedRow == 0){
                throw new SQLException("Creating Product Failed");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                product.setId(generatedKeys.getLong(1));
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        finally {
            if(connection != null){
                try {
                    connection.setAutoCommit(autocommit);
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return product.getId();
    }

    public Product updateProduct(Product product, Long id){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
            String sql = "update product set name=?, cost=? where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setDouble(2,product.getCost());
            statement.setLong(3,product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return product;
    }
    public Product getProductById(Long id){
        Product product = null;
        Connection con = null;
        try {
             con = DriverManager.getConnection(dbUrl, username, password);
            String sqlQuery = "Select id, name, cost from product where id="+id;
            Statement stmt = con.createStatement();
            ResultSet resultSet =  stmt.executeQuery(sqlQuery);
            while (resultSet.next()){
                product = new Product(resultSet.getLong("id"),resultSet.getString("name"),
                        resultSet.getDouble("cost"));
            }
            LOGGER.info("Connection created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return  product;
    }

    public Product deleteProduct(Long id){
        Product exitingProduct = dataStore.get(id);
        if(exitingProduct != null){
            dataStore.remove(id);
        }
        return exitingProduct;
    }
}
