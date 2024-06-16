/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseaccessthread;

public class DatabaseConnectionManager {
    private static DatabaseConnectionManager instancia;

    private DatabaseConnectionManager() {
        // Inicialização do gerenciador de conexão com o banco de dados
        System.out.println("Conexão com o banco de dados estabelecida.");
    }

    public static synchronized DatabaseConnectionManager getInstancia() {
        if (instancia == null) {
            instancia = new DatabaseConnectionManager();
        }
        return instancia;
    }

    public void accessDatabase() {
        System.out.println(Thread.currentThread().getName() + " está acessando o banco de dados.");
        // Simulação de alguma operação de banco de dados
        try {
            Thread.sleep(1000); // Simula um atraso de 1 segundo
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " terminou de acessar o banco de dados.");
    }
}
