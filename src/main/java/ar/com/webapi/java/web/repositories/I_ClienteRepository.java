package ar.com.webapi.java.web.repositories;

import ar.com.webapi.java.web.entities.Cliente;
import ar.com.webapi.java.web.enums.TipoCliente;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_ClienteRepository {
    void save(Cliente cliente);
    void remove(Cliente cliente);
    void update(Cliente cliente);
    List<Cliente>getAll();
    default Cliente getById(int id){
        return getAll()
                .stream()
                .filter(c->c.getId()==id)
                .findAny()
                .orElse(new Cliente());
    }
    default List<Cliente>getLikeApellido(String apellido){
        if(apellido==null) return new ArrayList<Cliente>();
        return getAll()
                .stream()
                .filter(c->c.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    };
    default List<Cliente>getByTipoCliente(TipoCliente tipoCliente){
        if(tipoCliente==null) return new ArrayList<Cliente>();
        return getAll()
                .stream()
                .filter(c->c.getTipoCliente()==tipoCliente)
                .collect(Collectors.toList());
    };
}