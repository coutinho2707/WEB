package com.unimater.model;

import com.unimater.dao.ProductTypeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Product implements Entity {

    private int id;
    private ProductType productType;
    private String description;
    private double value;

    public Product(ResultSet rs) throws SQLException {
        super();
        this.id = rs.getInt("id");
        this.description = rs.getString("description");
        this.value = rs.getDouble("value");
    }

    public Product(int id, ProductType productType, String description, double value) {
        this.id = id;
        this.productType = productType;
        this.description = description;
        this.value = value;
    }

    public Product() {

    }

    @Override
    public Entity constructFromResultSet(ResultSet rs) throws SQLException {
        return new Product(rs);
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement preparedStatement) throws SQLException {

        preparedStatement.setString(2, getDescription());
        preparedStatement.setDouble(3, getValue());
        return preparedStatement;
    }

    public int getId() {
        return id;
    }

    public ProductType getProductype (Connection connection, int productTypeId){
        ProductTypeDAO dao = new ProductTypeDAO(connection);
        return dao.getById(productTypeId);
    }

    public ProductType getProductType() {
        return productType;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

}
