/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 * @author Gustavo F. Vetter 30/08/2022
 */
public class ProjectController {

    public void insert(Project project) {
        String sqlPI = "Insert into project (name, "
                + "description, "
                + "createdAt, "
                + "updatedAt) "
                + "values (?, ?, ?, ?)";
        Connection connPI = null;
        PreparedStatement statement = null;
        try {
            connPI = ConnectionFactory.getConnection();
            // Criando uma conexão com o banco de dados
            // connPI.prepareStatement(sqlPI);
            // Criando um statement para executar uma query
            statement = connPI.prepareStatement(sqlPI);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            //int Date = 30082022;
            // Executa a sql para inserção dos dados informados
            statement.execute();

        } catch (SQLException ePI) {
            throw new RuntimeException("Erro ao inserir o projeto "
                    + ePI.getMessage(), ePI);
        } finally {
            ConnectionFactory.closeConnection(connPI, statement);
        }

    }

    public void update(Project project) {
        String sqlPU = "Update project set "
                + "name = ?, "
                + "description = ?, "
                + "createdAt = ?, "
                + "updatedAt = ? "
                + "where id = ?";

        Connection connPU = null;
        PreparedStatement statement = null;

        try {
            // Estabelecendo a conexão com o banco de dados
            connPU = ConnectionFactory.getConnection();
            // Preparando a query
            statement = connPU.prepareStatement(sqlPU);
            // Setando os valores do statement
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            // Executando a query
            statement.execute();

        } catch (SQLException ePU) {
            throw new RuntimeException("Erro ao atualizar o projeto "
                    + ePU.getMessage() + ePU);
        } finally {
            ConnectionFactory.closeConnection(connPU, statement);
        }
    }
    
    public List<Project> getAll(){
        String sqlALL = "select * from project";
        
        List<Project> projectALL = new ArrayList<>();
        
        Connection connALL = null;
        PreparedStatement statement = null;
        
        // Classe que vai retornar as informações do banco de dados
        ResultSet resALL = null;
        
        try {
            // Fazendo a conexão com o banco de dados
            connALL = ConnectionFactory.getConnection();
            // Preparando a query para executar
            statement = connALL.prepareStatement(sqlALL);
            // Armazenando os dados da consulta executada
            resALL = statement.executeQuery();
            
            while (resALL.next()){
                Project project = new Project();
                
                project.setId(resALL.getInt("id"));
                project.setName(resALL.getString("name"));
                project.setDescription(resALL.getString("description"));
                project.setCreatedAt(resALL.getDate("createdAt"));
                project.setUpdatedAt(resALL.getDate("updatedAt"));
                // Adicionando a lista de projetos a Projetos
                projectALL.add(project);
            }
            
            
        } catch (SQLException eALL) {
            throw new RuntimeException("Erro ao selecionar a lista de projetos " 
                    + eALL.getMessage() + eALL);
        } finally{
            ConnectionFactory.closeConnection(connALL, statement, resALL);
        }
        return projectALL;
    }
    
    public void removeById(int IdProject) {
        String sqlRBI = "Delete from project where id = ?";
        Connection connRBI = null;
        PreparedStatement statement = null;
        try {
            // Fazendo a conexão com o banco de dados
            connRBI = ConnectionFactory.getConnection();
            // Preparando a query
            statement = connRBI.prepareStatement(sqlRBI);
            // Setando/mudando a informação coletada na String sqlA
            statement.setInt(1, IdProject);
            statement.execute();
        } catch (SQLException eRBI) {
            throw new RuntimeException("Erro ao deletar o projeto "
                    + eRBI.getMessage() + eRBI);
        } finally {
            ConnectionFactory.closeConnection(connRBI, statement);
        }
    }
    
    
}
