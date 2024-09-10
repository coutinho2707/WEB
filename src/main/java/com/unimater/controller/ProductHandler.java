package com.unimater.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.unimater.dao.ProductDAO;
import com.unimater.dao.ProductTypeDAO;
import com.unimater.model.Product;
import com.unimater.model.ProductType;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;

public class ProductHandler implements HttpHandler {
    ProductDAO productDAO;

    private Connection connection;

    public ProductHandler(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        productDAO = new ProductDAO(connection);
        if (exchange.getRequestMethod().equals("GET")){
            Product product = productDAO.getById(1);
            System.out.println(product);
            exchange.sendResponseHeaders(200,-1);
        } else {
            exchange.sendResponseHeaders(405, -1);
        }
    }
}
