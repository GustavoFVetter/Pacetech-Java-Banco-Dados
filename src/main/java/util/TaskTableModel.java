/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author Gustavo F. Vetter, em 11/09/2022
 */
public class TaskTableModel extends AbstractTableModel {

    // Criação das colunas que aparecerão na table Tarefas
    String[] columns = {"Nome", "Descrição", "Prazo",
        "Tarefa Concluída", "Editar", "Excluir"};
    //Criação de uma lista que guardará a lista de tarefas.
    // Esta lista já é inicializada vazia
    List<Task> tasks = new ArrayList();

    @Override
    // Método para dizer quais tarefas existem para o projeto
    public int getRowCount() {
        // Vai retornar a quant. de linhas que existirem em Tarefas
        return tasks.size();
    }

    @Override
    // Método para dizer quantas colunas existem na table
    public int getColumnCount() {
        // Vai retornar o nr de colunas que existem na table Tarefas
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
        // A linha acima poderia ser trocada pelo bloco abaixo:
        // if (columnIndex == 3)
        //    return true;
        // else
        //    return false;

    }

    @Override
    // Método que retorna qual a classe (String, boolean, etc...) 
    // de um compomente que está em determinada coluna.
    // Por padrão, na classe pai, esse método retorna uma String
    public Class<?> getColumnClass(int columnIndex) {
        if (tasks.isEmpty()) {
            // Caso a lista esteja vazia pode retornar qualquer tipo de classe
            // É só para fazer um return válido
            return Object.class;
        }
        // else (não é obrigatório escrever else)
        // Chama o método getValueAt e
        // retorna a classe do tipo de dado da coluna selecionada
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    // Método para retornar qual valor existe em determnada linha e coluna
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            // Para coluna 1 (0 no vetor), retornar o nome da tarefa
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                // Criação de um dateFormat com o formato desejado para nosso padrão
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                // Retorno da informação no formato desejado
                return dateFormat.format(tasks.get(rowIndex).getDeadLine());
            case 3:
                return tasks.get(rowIndex).isIsCompleted();
            case 4:
                return " ";
            case 5:
                return " ";
            case 6:
                return " ";
            default:
                return "Dados não encontrados";

        }
    }

    @Override
    // Método para receber um object na linha x e coluna y 
    // e informar se é true ou false
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // recebe a informação da lista de tarefas, converte para 
        // a classe boolean e seta se é true ou false
        tasks.get(rowIndex).setIsCompleted((boolean) aValue);
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
