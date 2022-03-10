package ar.com.webapi.java.web.repositories;

import ar.com.webapi.java.web.entities.Articulo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_ArticuloRepository {
    void save(Articulo articulo);
    void remove(Articulo articulo);
    List<Articulo>getAll();
    default List<Articulo>getLikeDescripcion(String descripcion){
        if(descripcion==null) return new ArrayList<Articulo>();
        return getAll()
                .stream()
                .filter(a->a.getDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                .collect(Collectors.toList());
    }
}