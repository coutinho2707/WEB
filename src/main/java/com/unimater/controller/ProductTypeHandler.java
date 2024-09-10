package com.unimater.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.unimater.dao.ProductTypeDAO;
import com.unimater.dao.SaleitemDAO;
import com.unimater.model.ProductType;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;

public class ProductTypeHandler implements HttpHandler {
    ProductTypeDAO productTypeDAO;
    private Connection connection;

    public ProductTypeHandler(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        productTypeDAO = new ProductTypeDAO(connection);
        if (exchange.getRequestMethod().equals("GET")){
            ProductType productType = productTypeDAO.getById(1);
            System.out.println(productType);
            exchange.sendResponseHeaders(200,-1);
        } else {
            exchange.sendResponseHeaders(405, -1);
        }
    }
}
