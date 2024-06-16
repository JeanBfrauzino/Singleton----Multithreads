/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package databaseaccessthread;

import java.util.concurrent.CountDownLatch;

public class DatabaseAccessThread {

    public static void main(String[] args) throws InterruptedException {

        int countThreads = 10;
        CountDownLatch readyLatch = new CountDownLatch(countThreads);
        CountDownLatch startLatch = new CountDownLatch(1);

        for (int i = 0; i < countThreads; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readyLatch.countDown();
                    try {
                        startLatch.await();
                        DatabaseConnectionManager instancia = DatabaseConnectionManager.getInstancia();
                        instancia.accessDatabase();
                        System.out.println("Instância de N°: " + instancia.hashCode());
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }
        readyLatch.await();
        startLatch.countDown();
    }
}
