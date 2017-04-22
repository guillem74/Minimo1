package Controlador;

import Modelo.Usuario;
import Modelo.Objeto;

import java.util.List;

/**
 * Created by Guillem on 19/04/2017.
 */
public interface EtakemonManager {

    public void anadirUsuario(Usuario u);
    public void modificarUsuario(int idUsuario, String nombre);
    public Usuario consultarInfUsuario(int idUsuario);
    public List<Objeto> consultarObjUsuario(int idUsuario);
    public void anadirObjUsuario(int idUsuario, Objeto o);
    public List<Usuario> listarUsuariosAlf();
}
