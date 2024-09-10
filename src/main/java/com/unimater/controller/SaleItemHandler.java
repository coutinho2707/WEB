package com.unimater.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.unimater.dao.SaleitemDAO;
import com.unimater.model.SaleItem;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;

public class SaleItemHandler implements HttpHandler {
    SaleitemDAO saleitemDAO;
    private Connection connection;

    public SaleItemHandler(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        saleitemDAO = new SaleitemDAO(connection);
        if (exchange.getRequestMethod().equals("200")){
            SaleItem saleItem = saleitemDAO.getById(1);
            System.out.println(saleItem);
            exchange.sendResponseHeaders(200, -1);
        } else {
            exchange.sendResponseHeaders(405, -1);
        }
    }
}
