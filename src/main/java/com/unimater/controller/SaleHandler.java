package com.unimater.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.unimater.dao.SaleDAO;
import com.unimater.model.Sale;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;

public class SaleHandler implements HttpHandler {
    SaleDAO saleDAO;

    private Connection connection;


    public SaleHandler(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        saleDAO = new SaleDAO(connection);
        if (exchange.getRequestMethod().equals("GET")) {
            Sale sale = saleDAO.getById(1);
            System.out.println(sale);
            exchange.sendResponseHeaders(200,-1);
        } else {
            exchange.sendResponseHeaders(405, -1);
        }
    }
}
