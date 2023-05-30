package com.laba.solvd.militaryProject.threads;
import java.util.concurrent.*;
import java.util.concurrent.BlockingQueue;

class Connection {
    private String connectionId;

    public Connection(String connectionId) {
        this.connectionId = connectionId;
    }

    public String getConnectionId() {
        return connectionId;
    }
}

class ConnectionPool {
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

class ConnectionUser implements Runnable {
    private int id;

    public ConnectionUser(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            Connection connection = connectionPool.getConnection();
            System.out.println("Thread " + id + " acquired connection: " + connection.getConnectionId());
            Thread.sleep(2000);
            connectionPool.releaseConnection(connection);
            System.out.println("Thread " + id + " released connection: " + connection.getConnectionId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
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
