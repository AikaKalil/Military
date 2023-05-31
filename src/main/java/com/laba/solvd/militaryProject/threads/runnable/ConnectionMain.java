package com.laba.solvd.militaryProject.threads.runnable;

import java.util.concurrent.*;

public class ConnectionMain {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(7);

        for (int i = 1; i <= 5; i++) {
            threadPool.execute(new ConnectionUser(i));
        }

        for (int i = 6; i <= 7; i++) {
            final int threadId = i;
            threadPool.execute(() -> {
                try {
                    ConnectionPool connectionPool = ConnectionPool.getInstance();
                    Connection connection = connectionPool.getConnection();
                    System.out.println("Thread " + threadId + " acquired connection: " + connection.getConnectionId());
                    connectionPool.releaseConnection(connection);
                    System.out.println("Thread " + threadId + " released connection: " + connection.getConnectionId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        threadPool.shutdown();
    }
}
