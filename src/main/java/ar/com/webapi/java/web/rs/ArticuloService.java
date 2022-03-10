package ar.com.webapi.java.web.rs;

import ar.com.webapi.java.web.entities.Articulo;
import ar.com.webapi.java.web.jdbc.connectors.Connector;
import ar.com.webapi.java.web.repositories.I_ArticuloRepository;
import ar.com.webapi.java.web.repositories.jdbc.ArticuloRepository;
import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("articulos/v1")
public class ArticuloService {
    
    private I_ArticuloRepository ar=new ArticuloRepository(Connector.getConnection());
    
    @GET
    public String info(){
        return "Servicio Articulos Activo";
    }
    
    @GET
    @Path("alta")
    @Produces(MediaType.TEXT_PLAIN)
    public String alta( @QueryParam("id") int id,
                        @QueryParam("descripcion") String descripcion,
                        @QueryParam("precio") float precio){
        try {
            if(descripcion==null || descripcion.length()<3 || precio <= 0) return "false";
            Articulo articulo = new Articulo();
            ar.save(articulo);
            return "true";
        } catch (Exception e) {
            System.out.println("*********************************************");
            System.out.println(e);
            System.out.println("*********************************************");
            return "false";
        }
    }
    
    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll(){
        return new Gson().toJson(ar.getAll());
    }
       
    @GET
    @Path("likeDescripcion")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLikeDescripcion(@QueryParam("descripcion") String descripcion){
        return new Gson().toJson(ar.getLikeDescripcion(descripcion));
    }
}