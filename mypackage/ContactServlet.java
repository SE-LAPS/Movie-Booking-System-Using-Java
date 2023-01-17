
package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LapZ
 */
@WebServlet(name = "ContactServlet", urlPatterns = {"/ContactServlet"})
public class ContactServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContactServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContactServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        //processRequest(request, response);
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        String title = "Contact Details";
        
        String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        
        out.println(docType +
                 "<html>\n" +
                 "<head><title>" + title + "</title></head>\n"+
                 "<body bgcolor = \"#fdf5e6\">\n" +
                 "<h1 align = \"center\">" + title + "</h1>\n" +
                 "<table width = \"100%\" border = \"1\" align = \"center\">\n" + 
                 "<tr bgcolor = \"#ffad00\">\n" +
                 "<th>Form  Inputs</th><th>Form Outputs</th>\n"
         
                );
        
        Enumeration paramNames = request.getParameterNames();
        
              while(paramNames.hasMoreElements()) {
                String paramName = (String)paramNames.nextElement();
                  out.println("<tr><td>" + paramName  + "\n<td>");
                  
                String[] paramValues = request.getParameterValues(paramName);
                
                  if (paramValues.length == 1){
                      String paramValue = paramValues[0];
                      
                  if(paramValue.length() ==0)
                       out.print("<i>No Value</i>");
                  
                  else
                       out.print(paramValue);
                      }
                  
                  else{
                      out.print("<ul>");
                      for(int i=0; i<paramValues.length; i++){
                          out.println("<li>" + paramValues[i]);
                      }
                      
                        out.println("<ul>");
                  }        
                  
              }
        
            out.println("<table> \n </body> </html>"); 
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
        doGet(request, response);
        
        String bname = request.getParameter("name");
        String bemail = request.getParameter("email");
        String bsubject = request.getParameter("subject");
        String bmessage = request.getParameter("message");
        //processRequest(request, response);
        
        contact b = new contact();
        b.details(bname,bemail,bsubject,bmessage);   
        
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
