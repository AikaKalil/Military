package com.laba.solvd.militaryProject.threads.runnable;
public class ConnectionUser implements Runnable {

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
