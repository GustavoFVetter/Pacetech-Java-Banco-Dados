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
import model.Task;
import util.ConnectionFactory;

/**
 * @author Gustavo F. Vetter 30/08/2022
 */
public class TaskController {

    public void insert(Task task) {
        String sqlX = "Insert into task (idProject, name, description,"
                + "completed, notes, deadline,createdAt,updatedAt) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connX = null;
        PreparedStatement statement = null;
        try {
            connX = ConnectionFactory.getConnection();
            statement = connX.prepareStatement(sqlX);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadLine().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();

        } catch (Exception eX) {
            throw new RuntimeException("Erro ao inserir a tarefa "
                    + eX.getMessage(), eX);
        } finally {
            ConnectionFactory.closeConnection(connX, statement);
        }

    }

    public void update(Task task) {
        String sqlG = "Update task set "
                + "idProject = ?, "
                + "name = ?, "
                + "description = ?, "
                + "notes = ?, "
                + "completed = ?, "
                + "deadline = ?, "
                + "createdAt = ?, "
                + "updatedAt = ? "
                + "where id = ?";

        Connection connG = null;
        PreparedStatement statement = null;

        try {
            // Estabelecendo a conexão com o banco de dados
            connG = ConnectionFactory.getConnection();
            // Preparando a query
            statement = connG.prepareStatement(sqlG);
            // Setando os valores do statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isIsCompleted());
            statement.setDate(6, new Date(task.getDeadLine().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            // Executando a query
            statement.execute();

        } catch (Exception eG) {
            throw new RuntimeException("Erro ao atualizar a tarefa "
                    + eG.getMessage() + eG);
        } finally {
            ConnectionFactory.closeConnection(connG, statement);
        }

    }

    public void removeById(int taskId) {
        String sqlA = "Delete from task where id = ?";
        Connection connA = null;
        PreparedStatement statement = null;
        try {
            // Fazendo a conexão com o banco de dados
            connA = ConnectionFactory.getConnection();
            // Preparando a query
            statement = connA.prepareStatement(sqlA);
            // Setando/mudando a informação coletada na String sqlA
            statement.setInt(1, taskId);
            //Executando o comando sqlA no banco de dados
            statement.execute();
        } catch (Exception eA) {
            throw new RuntimeException("Erro ao deletar a tarefa"
                    + eA.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connA, statement);
        }
    }

    public List<Task> getAll(int idProject) {
        String sqlT = "select * from task where idProject = ?";

        Connection connT = null;
        PreparedStatement statement = null;
        // O retorno do resultado da consulta ao banco de dados 
        // precisa ser armazenado num resulSet
        ResultSet resT = null;

        // Criando um arraylist para listar as tarefas
        List<Task> tasks = new ArrayList<Task>();

        try {
            // Fazendo a conexão com o banco de dados
            connT = ConnectionFactory.getConnection();
            // Preparando a query
            statement = connT.prepareStatement(sqlT);
            // Setando o valor que corresponde ao filtro de busca 
            statement.setInt(1, idProject);
            // aqui tem que ser um executeQuery para devolver a resposta do select
            // resT é a variável onde os valores são armazenados
            // Valor retornado pela execução da query
            resT = statement.executeQuery();

            // Enquanto houver valores no resultSet resT
            while (resT.next()) {
                Task taskT = new Task();
                taskT.setId(resT.getInt("id"));
                taskT.setIdProject(resT.getInt("idProject"));
                taskT.setName(resT.getString("name"));
                taskT.setDescription(resT.getString("description"));
                taskT.setNotes(resT.getString("notes"));
                taskT.setIdProject(resT.getInt("idProject"));
                taskT.setIsCompleted(resT.getBoolean("completed"));
                taskT.setDeadLine(resT.getDate("deadline"));
                taskT.setCreatedAt(resT.getDate("createdAt"));
                taskT.setUpdatedAt(resT.getDate("updatedAt"));

                tasks.add(taskT);
            }
        } catch (Exception eT) {
            throw new RuntimeException("Erro ao listar a tarefa"
                    + eT.getMessage(), eT);
        } finally {
            ConnectionFactory.closeConnection(connT, statement, resT);
        }

        // Lista de tarefas que foi criada e obtida por 
        // consulta ao banco de dados
        return tasks;
    }
}
