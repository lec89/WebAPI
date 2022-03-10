package ar.com.webapi.java.web.managed.bean;

import ar.com.webapi.java.web.entities.Cliente;
import ar.com.webapi.java.web.jdbc.connectors.Connector;
import ar.com.webapi.java.web.repositories.I_ClienteRepository;
import ar.com.webapi.java.web.repositories.jdbc.ClienteRepository;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named()
@SessionScoped
public class ClienteMB implements Serializable {

    private I_ClienteRepository cr = new ClienteRepository(Connector.getConnection());
    private Cliente cliente = new Cliente();
    private String mensaje = "";
    private String buscarApellido = "";

    public void save() {
        try {
            if (cliente.getNombre() == null
                    || cliente.getNombre().length() < 4
                    || cliente.getApellido() == null
                    || cliente.getApellido().length() < 4) {
                mensaje = "Datos incorrectos, No se pudo guardar el cliente!";
                addMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Datos incorrectos, No se pudo guardar el Cliente!");
            } else {
                cr.save(cliente);
                mensaje = "Se guardo el cliente, id: " + cliente.getId();
                addMessage(FacesMessage.SEVERITY_INFO, "Operación éxitosa", "Se guardo un cliente, id: " + cliente.getId());
                cliente = new Cliente();
            }
        } catch (Exception e) {
            mensaje = "No se pudo guardar el cliente!";
            addMessage(FacesMessage.SEVERITY_ERROR, "Error!", "No se pudo guardar el Cliente!");
            System.out.println("*********************************************");
            System.out.println(e);
            System.out.println("*********************************************");
        }
    }

    public List<Cliente> getAll() {
        return cr.getAll();
    }

    public List<Cliente> getLikeApellido() {
        return cr.getLikeApellido(buscarApellido);
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getBuscarApellido() {
        return buscarApellido;
    }

    public void setBuscarApellido(String buscarApellido) {
        this.buscarApellido = buscarApellido;
    }

}