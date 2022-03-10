package ar.com.webapi.java.web.managed.bean;

import ar.com.webapi.java.web.enums.TipoCliente;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named()
@SessionScoped
public class TipoClienteMB implements Serializable{
    public List<TipoCliente> getTipoCliente(){
        return Arrays.asList(TipoCliente.values());
    }
}