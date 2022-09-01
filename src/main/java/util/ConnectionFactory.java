/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gustavo
 */
public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoApp";
    public static final String USER = "root";
    public static final String PASS = "";
    
        public static Connection getConnection () {
            try {
                // Comando para carregar o driver de nome DRIVER
                Class.forName(DRIVER);
                // Atenção DriverManager: faça uma conexão usando os 
                // parâmetros entre parênteses
                return DriverManager.getConnection(URL, USER, PASS);
            } catch (Exception exc) {
                throw new RuntimeException ("Erro na conexao com bando de bados " + exc);
            }        
}
        public static void closeConnection (Connection connection){
            try {
                if (connection != null){
                    connection.close();
                }
            } catch (Exception exc) {
                throw new RuntimeException("Erro ao fechar a conexao com o "
                        + "banco de dados " + exc);
            }
        }
        
        public static void closeConnection (Connection connection, 
                PreparedStatement statement){
            try {
                if (connection != null){
                    connection.close();
                }
                
                if (statement != null){
                    statement.close();
                }
                
            } catch (Exception exc) {
                throw new RuntimeException("Erro ao fechar a conexao com o "
                        + "banco de dados " + exc);
            }
        }
        
        public static void closeConnection (Connection connection, 
                PreparedStatement statement, ResultSet result){
            try {
                if (connection != null){
                    connection.close();
                }
                
                if (statement != null){
                    statement.close();
                }
                
                if (result != null){
                    result.close();
                }
                
            } catch (Exception exc) {
                throw new RuntimeException("Erro ao fechar a conexao com o "
                        + "banco de dados " + exc);
            }
        }
    
}
