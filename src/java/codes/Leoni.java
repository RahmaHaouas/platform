/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import sparql.Queries;
@WebServlet(name = "Pannes", urlPatterns = {""})
public class Leoni extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset-UTF-8");
        ArrayList<String> rowGeneral = new ArrayList<>();
        ArrayList<String> rowAll = new ArrayList<>();
        ArrayList<String> rowInformatique = new ArrayList<>();
        ArrayList<String> rowMecanique = new ArrayList<>();
        ArrayList<String> rowElectrique = new ArrayList<>();
        rowAll = Queries.getRecentPannes();
        rowGeneral = Queries.getGeneralPannes();
        rowInformatique = Queries.getInformatiquePannes();
        rowMecanique = Queries.getMecaniquePannes();
        rowElectrique = Queries.getElectriquePannes();
        request.setAttribute("listRecentPannes", rowAll);
        request.setAttribute("listGeneralPannes", rowGeneral);
        request.setAttribute("listInformatiquePannes", rowInformatique);
        request.setAttribute("listMecaniquePannes", rowMecanique);
        request.setAttribute("listElectriquePannes", rowElectrique);
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("index.jsp").include(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
