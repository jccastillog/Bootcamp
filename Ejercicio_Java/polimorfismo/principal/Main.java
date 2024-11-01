package polimorfismo.principal;

import polimorfismo.modelo.Admin;
import polimorfismo.modelo.Cliente;
import polimorfismo.modelo.Invitado;
import polimorfismo.modelo.Usuario;

public class Main {
    public static void main(String[] args) {

        Usuario[] usuarios = new Usuario[4];

        usuarios[0] = new Usuario("maria@gmail.com ", "Maria");
        usuarios[1] = new Invitado("jose@gmail.com", "Jose");
        usuarios[2] = new Cliente("gladys@gmail.com", "Gladys", "Calle 50");
        usuarios[3] = new Admin("Admin", "pepe@gmail.com", "pepe");

        for (Usuario usuario : usuarios) {
            usuario.mostrarInfo();
            System.out.println("|------------------------|");
            usuario.definirPermisos();
            System.out.println("------------------------");
            usuario.definirPermisos("admin");
        }

    }
}
