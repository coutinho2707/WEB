package com.unimater.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleItem implements Entity {
    private int id;
    private int product;
    private int quantity;
    private double percentualDiscount;

    public SaleItem(ResultSet rs) throws SQLException {
        super();
        this.id = rs.getInt("id");
        this.product = rs.getInt("product_id");
        this.quantity = rs.getInt("quantity");
        this.percentualDiscount = rs.getDouble("percentual_discount");
    }


    public SaleItem(int id, int product, int quantity, double percentualDiscount) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.percentualDiscount = percentualDiscount;
    }

    public SaleItem() {

    }

    @Override
    public Entity constructFromResultSet(ResultSet rs) throws SQLException {
        return new SaleItem(rs);
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, getProduct());
        preparedStatement.setInt(2, getQuantity());
        preparedStatement.setDouble(3, getPercentualDiscount());
        return preparedStatement;
    }

    public int getId() {
        return id;
    }

    public int getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPercentualDiscount() {
        return percentualDiscount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPercentualDiscount(double percentualDiscount) {
        this.percentualDiscount = percentualDiscount;
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", percentualDiscount=" + percentualDiscount +
                '}';
    }
}
