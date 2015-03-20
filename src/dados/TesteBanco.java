/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Medeiros
 */
public class TesteBanco {
    public static void main (String args[]){
        try {
            ConexaoBanco banco = new ConexaoBanco();
            Statement stm = banco.conectar();
            JOptionPane.showMessageDialog(null,"conectar");
        banco.desconectar();
            JOptionPane.showMessageDialog(null,"Desconectar");
        
        } catch (Exception e) {
        }
    }
}
