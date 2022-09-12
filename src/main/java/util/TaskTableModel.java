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

    // Cria��o das colunas que aparecer�o na table Tarefas
    String[] columns = {"Nome", "Descri��o", "Prazo",
        "Tarefa Conclu�da", "Editar", "Excluir"};
    //Cria��o de uma lista que guardar� a lista de tarefas.
    // Esta lista j� � inicializada vazia
    List<Task> tasks = new ArrayList();

    @Override
    // M�todo para dizer quais tarefas existem para o projeto
    public int getRowCount() {
        // Vai retornar a quant. de linhas que existirem em Tarefas
        return tasks.size();
    }

    @Override
    // M�todo para dizer quantas colunas existem na table
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
    // M�todo que retorna qual a classe (String, boolean, etc...) 
    // de um compomente que est� em determinada coluna.
    // Por padr�o, na classe pai, esse m�todo retorna uma String
    public Class<?> getColumnClass(int columnIndex) {
        if (tasks.isEmpty()) {
            // Caso a lista esteja vazia pode retornar qualquer tipo de classe
            // � s� para fazer um return v�lido
            return Object.class;
        }
        // else (n�o � obrigat�rio escrever else)
        // Chama o m�todo getValueAt e
        // retorna a classe do tipo de dado da coluna selecionada
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    // M�todo para retornar qual valor existe em determnada linha e coluna
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            // Para coluna 1 (0 no vetor), retornar o nome da tarefa
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                // Cria��o de um dateFormat com o formato desejado para nosso padr�o
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                // Retorno da informa��o no formato desejado
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
                return "Dados n�o encontrados";

        }
    }

    @Override
    // M�todo para receber um object na linha x e coluna y 
    // e informar se � true ou false
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // recebe a informa��o da lista de tarefas, converte para 
        // a classe boolean e seta se � true ou false
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
