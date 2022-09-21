/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Gustavo F. Vetter 9/09/2022
 */
public class ButtonColumnCellRenderer extends DefaultTableCellRenderer{
    // Atributo para poder selecionar o bot�o a renderizar
    private String buttonType;
    
    public ButtonColumnCellRenderer(String buttonType){
        this.buttonType = buttonType;
    }

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, 
                          int row, int column){
        // Comando que vai criar e devolver o objeto que ser� renderizado,
        // antes de ser customizado.
        // Este objeto � label, do tipo JLabel.
        // O comando SUPER � para chamar o m�todo da classe pai.
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, 
                value, isSelected, hasFocus, row, column);
        // Comando para centralizar dentro da c�lula o texto mostrado
        label.setHorizontalAlignment(CENTER);
        // Caminho para buscar o �cone a ser customizado
        label.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/" + buttonType + ".png")));
        // // Retorna a label que foi customizada
        return label;
    }
    
}
