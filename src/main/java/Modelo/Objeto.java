package Modelo;

/**
 * Created by Guillem on 19/04/2017.
 */
public class Objeto {
    private String nombre;

    public Objeto(){}

    public Objeto(String nombre){
        this.nombre=nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return("Objeto: ["+nombre+"]");
    }
}
