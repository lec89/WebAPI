package ar.com.webapi.java.web.repositories.jdbc;

import ar.com.webapi.java.web.entities.Articulo;
import ar.com.webapi.java.web.repositories.I_ArticuloRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticuloRepository implements I_ArticuloRepository{
    
    private Connection conn;

    public ArticuloRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Articulo articulo) {
        if(articulo==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
                "insert into articulos (id,descripcion,precio) values (?,?,?)")){
            ps.setInt(1, articulo.getId());
            ps.setString(2, articulo.getDescripcion());
            ps.setFloat(3, articulo.getPrecio());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Articulo articulo) {
        if(articulo==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from articulos where id=?")){
            ps.setInt(1, articulo.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Articulo> getAll() {
        List<Articulo>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from articulos")){
            while(rs.next()){
                list.add(new Articulo(
                        rs.getInt("id"),
                        rs.getString("descripcion"),
                        rs.getFloat("precio")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public List<Articulo> getLikeDescripcion(String descripcion) {
        List<Articulo>list=new ArrayList();
        if(descripcion==null) return list;
        try (ResultSet rs=conn.createStatement().executeQuery(
                "select * from articulos where descripcion like '%"+descripcion+"%'")){
            while(rs.next()){
                list.add(new Articulo(
                        rs.getInt("id"),
                        rs.getString("descripcion"),
                        rs.getFloat("precio")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}