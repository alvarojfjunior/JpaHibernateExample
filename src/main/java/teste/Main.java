package teste;

import dao.UsuarioDAO;
import model.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setPrimeiroNome("alvaro");
        new UsuarioDAO().adicionar(usuario);
    }
    
}
