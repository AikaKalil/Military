package com.laba.solvd.militaryProject.threads.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ConnectionUser implements Runnable{

    private int id;

    public ConnectionUser(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            CompletableFuture<Connection> future = connectionPool.getConnection();
            Connection connection = future.get();
            System.out.println("Thread " + id + " acquired connection: " + connection.getConnectionId());
            Thread.sleep(2000);
            connectionPool.releaseConnection(connection);
            System.out.println("Thread " + id + " released connection: " + connection.getConnectionId());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    }
