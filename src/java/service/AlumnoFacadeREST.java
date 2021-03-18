/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entity.Alumno;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jesus
 */
@Stateless
@Path("entity.alumno")
public class AlumnoFacadeREST extends AbstractFacade<Alumno> {

    @PersistenceContext(unitName = "fasdfPU")
    private EntityManager em;
    
    
    public AlumnoFacadeREST() {
        super(Alumno.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Alumno entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Alumno entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Alumno find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    
    @GET
    @Path("nombre/{nombre}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findByName(@PathParam("nombre") String nombre) {
        List<Alumno> lista = em.createNamedQuery("Alumno.findByNombre").setParameter("nombre", nombre).getResultList();
        return Response.ok().entity(lista).build();
    }
    
    @GET
    @Path("apellido/{apellido}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findByApellido(@PathParam("apellido") String apellido) {
        List<Alumno> lista = em.createNamedQuery("Alumno.findByApellido").setParameter("apellido", apellido).getResultList();
        return Response.ok().entity(lista).build();
    }
 
    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Alumno> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Alumno> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
