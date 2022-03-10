package ar.com.webapi.java.web.repositories.list;

import ar.com.webapi.java.web.entities.Articulo;
import ar.com.webapi.java.web.repositories.I_ArticuloRepository;
import java.util.ArrayList;
import java.util.List;

public class ArticuloRepository implements I_ArticuloRepository{

    private List<Articulo>list = new ArrayList();
    
    @Override
    public void save(Articulo articulo) {
        list.add(articulo);
    }

    @Override
    public void remove(Articulo articulo) {
        list.add(articulo);
    }

    @Override
    public List<Articulo> getAll() {
        return list;
    }
    
}