package com.laba.solvd.militaryProject.threads.future;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class ConnectionPool {
    private static final int POOL_SIZE = 5;
    private final BlockingQueue<Connection> connections;
    private final Semaphore semaphore;

    private ConnectionPool() {
        connections = new LinkedBlockingQueue<>(POOL_SIZE);
        semaphore = new Semaphore(POOL_SIZE);
        initializeConnections();
    }

    private synchronized void initializeConnections() {
        for (int i = 0; i < POOL_SIZE; i++) {
            String connectionId = "Connection " + (i + 1);
            Connection connection = new Connection(connectionId);
            connections.offer(connection);
        }
    }

    public CompletableFuture<Connection> getConnection() {
        CompletableFuture<Connection> future = new CompletableFuture<>();
        try {
            semaphore.acquire();
            Connection connection = connections.take();
            future.complete(connection);
        } catch (InterruptedException e) {
            future.completeExceptionally(e);
        }
        return future;
    }

    public synchronized void releaseConnection(Connection connection) {
        connections.offer(connection);
        semaphore.release();
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.INSTANCE;
    }

    private static class ConnectionPoolHolder {
        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }
}
