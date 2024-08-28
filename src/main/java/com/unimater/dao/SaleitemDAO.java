package com.unimater.dao;

import com.unimater.model.SaleItem;

import java.sql.*;
import java.util.List;

public class SaleitemDAO extends GenericDAOImpl<SaleItem> implements GenericDAO<SaleItem> {

    private Connection connection;
    private final String TABLE_NAME = "sale_item";

    private final List<String> COLUMNS = List.of("product_id", "quantity", "percentual_discount", "sale_id");

    public SaleitemDAO(Connection connection) {
        super(SaleItem::new, connection);
        super.tableName = TABLE_NAME;
        super.columns = COLUMNS;
    }

    @Override
    public String toString() {
        return "SaleitemDAO{" +
                "connection=" + connection +
                ", TABLE_NAME='" + TABLE_NAME + '\'' +
                ", COLUMNS=" + COLUMNS +
                '}';
    }
}
