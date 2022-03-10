package ar.com.webapi.java.web.services;

import ar.com.webapi.java.web.entities.Articulo;
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

public class ArticuloAlta extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            try {
                I_ArticuloRepository ar=new ArticuloRepository(Connector.getConnection());
                int id=Integer.parseInt(request.getParameter("id"));
                String descripcion=request.getParameter("descripcion");
                float precio=Float.parseFloat(request.getParameter("precio"));
                ar.save(new Articulo(id, descripcion, precio));
                out.println("true");
            } catch (Exception e) {
                out.println("false");
            }
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