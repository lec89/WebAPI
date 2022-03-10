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

public class ArticuloAll extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
            try ( PrintWriter out = response.getWriter()) {
                //I_ArticuloRepository ar=ArticuloRepositoryFactory.getRepository();
                //Gson gson=new Gson();
                //out.println(gson.toJson(ar.getAll()));
                out.println(new Gson()
                        .toJson(new ArticuloRepository(Connector.getConnection())
                                .getAll()));
            }
        }

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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}