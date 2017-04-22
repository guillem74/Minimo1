package Controlador;

import Modelo.Usuario;
import Modelo.Objeto;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/json")
@Singleton
public class JSONservice {

    protected  EtakemonManagerImpl em;

    public JSONservice() {
        em=EtakemonManagerImpl.getEtakemonManagerImpl();
    }

    //Añadir Usuario
    @POST
    @Path("/Usuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUsuario(Usuario user) {
        em.anadirUsuario(user);
        return Response.status(201).entity("Añadido: ").build();
    }

    //Añadir un objeto a un usuario
    @POST
    @Path("/Objeto/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Objetonuevo (@PathParam("id") int id, Objeto obj) {
        em.anadirObjUsuario(id, obj );
        return Response.status(201).entity("Objeto añadido: ").build();
    }

    //Modificar usuario
    @POST
    @Path("/Usuario/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modificarUsuario(@PathParam("id") int id,Usuario user) {
        em.modificarUsuario(id, user.getNombre());
        return Response.status(201).entity("Usuario modificado: ").build();
    }

    //Lista de usuarios
    @GET
    @Path("/Usuarios")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Usuario> listaObjetos(){
        List<Usuario> lista = new ArrayList<Usuario>();
        lista = em.listarUsuariosAlf();
        return lista;
    }

    //Lista de objetos de un usuario
    @GET
    @Path("/Objetos/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Objeto> listaObjetos(@PathParam("id") int id){
        List<Objeto> lista = new ArrayList<Objeto>();
        lista=em.consultarObjUsuario(id);
        return lista;
    }

    //obtener usuario
    @GET
    @Path("/Usuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuario(@PathParam("id") int id) {
        Usuario u = new Usuario();
        u = em.consultarInfUsuario(id);
        System.out.println(u.toString());
        return u;
    }
}
