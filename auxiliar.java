/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auxiliares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;

/**
 *
 * @author WILLIAM
 */
public class auxiliar {
    public void change_jf(JFrame show, JFrame hide) {
        show.setVisible(true);
        hide.setVisible(false);
        hide.dispose();
    }
    
    
    public boolean Number (String texto){
        return texto.matches("[0-9]+");
    }
    
    public boolean Letras(String texto) {
        return texto.matches("[a-zA-Z]+");
    }

    public boolean validarLetrasEspacios(String input) {
        String regex = "^[a-zA-ZÁÉÍÓÚáéíóúÑñ\\s]+$";
        return input.matches(regex);
    }
    
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com$";
    
    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public boolean validarLetraMayuscula(String texto) {
        return texto.length() == 1 && texto.matches("[A-Z]");
    }

}
