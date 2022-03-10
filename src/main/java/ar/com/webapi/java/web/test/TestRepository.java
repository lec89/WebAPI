package ar.com.webapi.java.web.test;

import ar.com.webapi.java.web.entities.Articulo;
import ar.com.webapi.java.web.entities.Cliente;
import ar.com.webapi.java.web.enums.TipoCliente;
import ar.com.webapi.java.web.jdbc.connectors.Connector;
import ar.com.webapi.java.web.repositories.I_ArticuloRepository;
import ar.com.webapi.java.web.repositories.I_ClienteRepository;
import ar.com.webapi.java.web.repositories.jdbc.ArticuloRepository;
import ar.com.webapi.java.web.repositories.jdbc.ClienteRepository;

public class TestRepository {
    public static void main(String[] args) {
        I_ArticuloRepository ar=new ArticuloRepository(Connector.getConnection());
        ar.save(new Articulo(1, "Mouse", 20));
        ar.save(new Articulo(2, "Teclado", 30));
        ar.save(new Articulo(3, "Monitor", 40));
        ar.save(new Articulo(4, "Parlante USB", 50));
        ar.save(new Articulo(5, "PadMouse", 60));
        
        //ar.remove(new Articulo(1,"",0));
        
        ar.getAll().forEach(System.out::println);
        System.out.println("*************************************************");
        ar.getLikeDescripcion("mo").forEach(System.out::println);
        System.out.println("*************************************************");
        I_ClienteRepository cr=new ClienteRepository(Connector.getConnection());
        cr.save(new Cliente("Josefina", "Rodriguez", TipoCliente.MINORISTA));
        cr.save(new Cliente("Fernando", "Gutierrez", TipoCliente.MAYORISTA));
        cr.save(new Cliente("Sebastian", "Hernandez", TipoCliente.MINORISTA));
        cr.save(new Cliente("Leandro", "Poncio", TipoCliente.EMPRESA));
        System.out.println("*************************************************");
        cr.getAll().forEach(System.out::println);
        System.out.println("*************************************************");
        cr.getLikeApellido("he").forEach(System.out::println);
    }
}