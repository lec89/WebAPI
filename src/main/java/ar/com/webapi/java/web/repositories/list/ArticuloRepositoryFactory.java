package ar.com.webapi.java.web.repositories.list;

public class ArticuloRepositoryFactory {
    private static ArticuloRepository ar=new ArticuloRepository();
    public static ArticuloRepository getRepository(){
        return ar;
    }
}