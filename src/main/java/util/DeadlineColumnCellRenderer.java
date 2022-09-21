/*//
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

/**
 *
 * @author Gustavo F. Vetter 14/0/2022
 */

// Método para colorir determinadas células na jTable, na coluna Deadline
public class DeadlineColumnCellRenderer extends DefaultTableCellRenderer{
    
    // Método que devolve um componente que será mostrado na célula determinada
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, 
                          int row, int column){
        // Comando que vai criar e devolver o objeto que será renderizado
        // Este objeto é label, do tipo JLabel
        // O comando SUPER é para chamar o método da classe pai
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, 
                value, isSelected, hasFocus, row, column);
        // Comando para centralizar dentro da célula o texto mostrado
        label.setHorizontalAlignment(CENTER);
        // Pegando a tarefa que será renderizada
        TaskTableModel taskModel = (TaskTableModel) table.getModel();
        Task task = taskModel.getTasks().get(row);
        // Se o deadline da tarefa selecionada for depois de agora (hoje), faça...
        if (task.getDeadLine().after(new Date())){
            // Setar a cor de background como verde
            label.setBackground(Color.GREEN);
        } else {
            // Setar a cor de background como vermelho
            label.setBackground(Color.RED);
        }
    // Retorna a label que foi customizada    
    return label;
    }
    
}
