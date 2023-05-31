package com.laba.solvd.militaryProject.threads.runnable;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static final int POOL_SIZE = 5;
    private final BlockingQueue<Connection> connections;

    private ConnectionPool() {
        connections = new LinkedBlockingQueue<>(POOL_SIZE);
        initializeConnections();
    }

    private void initializeConnections() {
        for (int i = 0; i < 5; i++) {
            String connectionId = "Connection " + (i + 1);
            Connection connection = new Connection(connectionId);
            connections.offer(connection);
        }
    }

    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }

    public void releaseConnection(Connection connection) {
        connections.offer(connection);
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.INSTANCE;
    }

    private static class ConnectionPoolHolder {
        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }
}
