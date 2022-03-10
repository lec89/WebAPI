package ar.com.webapi.java.web.rs;

import ar.com.webapi.java.web.entities.Cliente;
import ar.com.webapi.java.web.enums.TipoCliente;
import ar.com.webapi.java.web.jdbc.connectors.Connector;
import ar.com.webapi.java.web.repositories.I_ClienteRepository;
import ar.com.webapi.java.web.repositories.jdbc.ClienteRepository;
import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("clientes/v1")
public class ClienteService {
    
    private I_ClienteRepository cr=new ClienteRepository(Connector.getConnection());
    
    @GET
    public String info(){
        return "Servicio Clientes Activo";
    }
    
    @GET
    @Path("alta")
    @Produces(MediaType.TEXT_PLAIN)
    public String alta( @QueryParam("nombre")String nombre,
                        @QueryParam("apellido")String apellido,
                        @QueryParam("tipoCliente")String tipoCliente){
        try {
            if(apellido==null || apellido.length()<3 || nombre==null || nombre.length()<3) return "0";
            Cliente cliente=new Cliente(nombre,apellido,TipoCliente.valueOf(tipoCliente));
            cr.save(cliente);
            return cliente.getId()+"";
        } catch (Exception e) {
            System.out.println("*********************************************");
            System.out.println(e);
            System.out.println("*********************************************");
            return "0";
        }
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll(){
        return new Gson().toJson(cr.getAll());
    }
       
    @GET
    @Path("likeApellido")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLikeApellido(@QueryParam("apellido") String apellido){
        return new Gson().toJson(cr.getLikeApellido(apellido));
    }
}