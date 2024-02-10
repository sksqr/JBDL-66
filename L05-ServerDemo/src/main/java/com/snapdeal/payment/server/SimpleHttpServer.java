package com.snapdeal.payment.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class SimpleHttpServer {

    public static void main(String[] args) {

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost",9090),0);
            server.createContext("/hello",new HelloHandler());
            server.setExecutor(Executors.newFixedThreadPool(5));
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
