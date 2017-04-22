package Modelo;

import java.util.*;

/**
 * Created by Guillem on 19/04/2017.
 */
public class Usuario {

    private int id;
    private String nombre;
    private List<Objeto> objetos;

    public Usuario(){}

    public Usuario(String nombre){
        this.nombre=nombre;
        objetos = new ArrayList<Objeto>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public void anadirObjeto(Objeto o){
        objetos.add(o);
    }

    @Override
    public String toString() {
        return "Usuario [Id ="+id+", Nombre=" + nombre + "]";
    }
}
