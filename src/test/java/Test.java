/**
 * Created by Mikel on 19/04/2017.
 */

import Controlador.EtakemonManagerImpl;
import Modelo.Objeto;
import Modelo.Usuario;


import org.junit.After;
import org.junit.Before;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class Test {

    static EtakemonManagerImpl em;

    @Before
    public void setUp() throws Exception {//parametros iniciales antes de testear
        em = EtakemonManagerImpl.getEtakemonManagerImpl();
        em.anadirUsuario(new Usuario("Mikel"));
        em.anadirUsuario(new Usuario("Aleix"));
        em.anadirUsuario(new Usuario("Jose"));
        em.anadirObjUsuario(1, new Objeto("Palo"));
        em.anadirObjUsuario(1, new Objeto("Tijeras"));
    }

    @After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void anadirUsuarioAlSistema(){
        Usuario u = new Usuario("Guillem");
        em.anadirUsuario(u);
    }

    @org.junit.Test
    public void anadirObjeto(){
        Objeto o = new Objeto("Bici");
        em.anadirObjUsuario(1, o);
        em.consultarObjUsuario(1);
    }

    @org.junit.Test
    public void buscarUsuario(){
        em.consultarInfUsuario(10);
        em.listarUsuariosAlf();
    }

}
