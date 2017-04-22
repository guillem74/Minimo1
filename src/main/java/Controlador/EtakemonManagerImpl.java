package Controlador;

import Modelo.Objeto;
import Modelo.Usuario;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.Hashtable;
import java.util.List;
import java.util.*;

/**
 * Created by Guillem on 19/04/2017.
 */
public class EtakemonManagerImpl implements EtakemonManager {

    final static Logger logger = Logger.getLogger(EtakemonManagerImpl.class);
    private static EtakemonManagerImpl em;
    private Hashtable<Integer, Usuario> tablaUsuarios;
    private List<Objeto> objetos;
    private int usuarioId;

    //Constructor
    private EtakemonManagerImpl(){
            tablaUsuarios = new Hashtable();
            objetos = new ArrayList<Objeto>();
    }

    public static EtakemonManagerImpl getEtakemonManagerImpl(){
        if (em==null){
            em=new EtakemonManagerImpl();
        }

        return em;
    }

    //Función para añadir usuario
    public void anadirUsuario(Usuario u){
        logger.info("METODO: añadir usuario: "+u);
        u.setId(usuarioId);
        tablaUsuarios.put(usuarioId, u);
        usuarioId++;
        logger.info("RESULTADO: Usuario añadido; "+"Tamaño tabla usuarios: "+tablaUsuarios.size());
    }

    //funcion para modificar un usuario según el ID
    public void modificarUsuario(int idUsuario, String nombre){
        logger.info("METODO: modificar usuario: "+tablaUsuarios.get(idUsuario).getNombre());
        tablaUsuarios.get(idUsuario).setNombre(nombre);
        logger.info("RESULTADO: Usuario modificado: "+ tablaUsuarios.get(idUsuario).getNombre());
    }

    //función para consultar la información de un usuario
    public Usuario consultarInfUsuario(int idUsuario){
        logger.info("METODO: consultar información usuario: "+idUsuario);
        Usuario utemp = tablaUsuarios.get(idUsuario);
        if (utemp == null) {
            logger.info("RESULTADO: usuario no existente");
        }else{
            logger.info("RESULTADO: "+utemp.toString());
        }
        return utemp;
    }

    //función para consultar los objetos de un usuario
    public List<Objeto> consultarObjUsuario(int idUsuario){
        logger.info("METODO: obtener objetos");
        Usuario utemp = tablaUsuarios.get(idUsuario);
        List<Objeto> otemp = utemp.getObjetos();
        if (otemp.size()==0){
            logger.info("RESULTADO: No tiene objetos");

        }else {
            StringBuffer buff = new StringBuffer();
            for (Objeto o : otemp) {
                buff.append(o.getNombre() + ",");
            }
            buff.deleteCharAt(buff.length() - 1);
            logger.info("RESULTADO: Usuario: " + utemp.getNombre() + "; Objetos: " + buff.toString());
        }

        return otemp;
    }

    //función para añadir un objeto a un usuario
    public void anadirObjUsuario(int idUsuario, Objeto o){
        logger.info("METODO: añadir objeto: "+o);
        Usuario utemp = tablaUsuarios.get(idUsuario);
        utemp.anadirObjeto(o);
        objetos.add(o);
        logger.info("RESULTADO: Objeto añadido "+o.toString()+"; Usuario: "+
                        utemp.getNombre()+"; Objetos:"+utemp.getObjetos().size());
    }

    //función para listar los usuarios alfabéticamente
    public List<Usuario> listarUsuariosAlf(){
        logger.info("METODO: Listar usuarios alfabéticamente");
        List<Usuario> listTemp = Collections.list(tablaUsuarios.elements());
        Collections.sort (listTemp, new Comparator<Usuario> (){
            @Override
            public int compare (final Usuario a, final Usuario b){
                return (a.getNombre().compareTo(b.getNombre())); }});

        logger.info("RESULTADO: "+listTemp.toString());

        return listTemp;
    }
}
