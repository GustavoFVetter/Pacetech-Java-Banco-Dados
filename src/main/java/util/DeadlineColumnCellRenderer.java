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

// M�todo para colorir determinadas c�lulas na jTable, na coluna Deadline
public class DeadlineColumnCellRenderer extends DefaultTableCellRenderer{
    
    // M�todo que devolve um componente que ser� mostrado na c�lula determinada
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, 
                          int row, int column){
        // Comando que vai criar e devolver o objeto que ser� renderizado
        // Este objeto � label, do tipo JLabel
        // O comando SUPER � para chamar o m�todo da classe pai
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, 
                value, isSelected, hasFocus, row, column);
        // Comando para centralizar dentro da c�lula o texto mostrado
        label.setHorizontalAlignment(CENTER);
        // Pegando a tarefa que ser� renderizada
        TaskTableModel taskModel = (TaskTableModel) table.getModel();
        Task task = taskModel.getTasks().get(row);
        // Se o deadline da tarefa selecionada for depois de agora (hoje), fa�a...
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
