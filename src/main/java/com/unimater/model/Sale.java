package com.unimater.model;

import java.sql.*;
import java.util.Collection;
import java.util.List;

public class Sale implements Entity {

    private int id;
    private Timestamp insertAt;

    public Sale(ResultSet rs) throws SQLException {
        super();
        this.id = rs.getInt("id");
        this.insertAt = rs.getTimestamp("insert_at");
    }

    public Sale(int id, List<SaleItem> saleItems, Timestamp insertAt) {
        this.id = id;
        this.insertAt = insertAt;
    }

    public Sale() {

    }

    @Override
    public Entity constructFromResultSet(ResultSet rs) throws SQLException {
        return new Sale(rs);
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setTimestamp(1, getInsertAt());
        return preparedStatement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getInsertAt() {
        return insertAt;
    }

    public void setInsertAt(Timestamp insertAt) {
        this.insertAt = insertAt;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", insertAt=" + insertAt +
                '}';
    }
}
