package ar.com.webapi.java.web.managed.bean;

import ar.com.webapi.java.web.entities.Articulo;
import ar.com.webapi.java.web.jdbc.connectors.Connector;
import ar.com.webapi.java.web.repositories.I_ArticuloRepository;
import ar.com.webapi.java.web.repositories.jdbc.ArticuloRepository;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named()
@SessionScoped
public class ArticuloMB implements Serializable {

    private Articulo articulo = new Articulo();
    private String mensaje = "";
    private String buscarDescripcion = "";
    private I_ArticuloRepository ar = new ArticuloRepository(Connector.getConnection());

    public void save() {
        try {
            if (articulo.getId() <= 0
                    || articulo.getDescripcion() == null
                    || articulo.getDescripcion().isEmpty()
                    || articulo.getPrecio() <= 0) {
                mensaje = "Datos incorrectos, no se pudo guardar el artículo!";
                addMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Datos incorrectos, no se pudo guardar el artículo!");
            } else {
                ar.save(articulo);
                mensaje = "Se guardo el artículo!";
                addMessage(FacesMessage.SEVERITY_INFO, "Operación éxitosa", "Se guardo un artículo!");
                articulo = new Articulo();
            }
        } catch (Exception e) {
            mensaje = "No se pudo guardar el artículo!";
            addMessage(FacesMessage.SEVERITY_ERROR, "Error!", "No se pudo guardar el articulo!");
            System.out.println("*********************************************");
            System.out.println(e);
        }
    }

    public List<Articulo> getAll() {
        return ar.getAll();
    }

    public List<Articulo> getLikeDescripcion() {
        return ar.getLikeDescripcion(buscarDescripcion);
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getBuscarDescripcion() {
        return buscarDescripcion;
    }

    public void setBuscarDescripcion(String buscarDescripcion) {
        this.buscarDescripcion = buscarDescripcion;
    }

    public I_ArticuloRepository getAr() {
        return ar;
    }

    public void setAr(I_ArticuloRepository ar) {
        this.ar = ar;
    }

}
