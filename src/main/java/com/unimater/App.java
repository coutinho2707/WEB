package com.unimater;

import com.sun.net.httpserver.HttpServer;
import com.unimater.controller.*;
import com.unimater.dao.ProductDAO;
import com.unimater.dao.ProductTypeDAO;
import com.unimater.dao.SaleDAO;
import com.unimater.dao.SaleitemDAO;
import com.unimater.model.ProductType;
import com.unimater.model.SaleItem;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main( String[] args ){
        try {
            HttpServer servidor = HttpServer.create(
                    new InetSocketAddress(8080),0
            );


            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_db", "root", "sdb162sw"
            );
            System.out.println("Sevidor rodiando na porca 8080");

            servidor.createContext("/Product", new ProductHandler(connection));

            servidor.createContext("/ProductType", new ProductTypeHandler(connection));

            servidor.createContext("/Sale", new SaleHandler(connection));

            servidor.createContext("/Sale Item", new SaleItemHandler(connection));


            servidor.setExecutor(null);
            servidor.start();
        } catch (IOException e) {
            System.out.println(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
