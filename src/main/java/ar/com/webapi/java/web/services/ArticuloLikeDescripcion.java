package ar.com.webapi.java.web.services;

import ar.com.webapi.java.web.jdbc.connectors.Connector;
import ar.com.webapi.java.web.repositories.I_ArticuloRepository;
import ar.com.webapi.java.web.repositories.jdbc.ArticuloRepository;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArticuloLikeDescripcion extends HttpServlet{
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //I_ArticuloRepository ar=ArticuloRepositoryFactory.getRepository();
            //Gson gson=new Gson();
            //out.println(gson.toJson(ar.getAll()));
            String descripcion=request.getParameter("descripcion");
            if(descripcion==null || descripcion.isEmpty())
                out.println(
                    new Gson()
                            .toJson(new ArticuloRepository(Connector.getConnection())
                                    .getAll()));
            else
                                out.println(
                    new Gson()
                            .toJson(new ArticuloRepository(Connector.getConnection())
                                    .getLikeDescripcion(descripcion)));
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

// </editor-fold>

}