
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tumam
 */
@WebServlet(urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String perroge = request.getParameter("perrog");
        String perrope = request.getParameter("perrop");
        String perrome = request.getParameter("perrom");
        String horase = request.getParameter("horas");
        
        if (perroge == null || perroge.isEmpty()
                || perrope == null || perrope.isEmpty()
                || perrome == null || perrome.isEmpty()
                || horase == null || horase.isEmpty()) {

           
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 class='error'>Error: Faltan valores en el formulario.</h1>");
            out.println("</body>");
            out.println("</html>");
            return;
        }
        int costoP = Integer.parseInt(request.getParameter("perrog")) * 10000
                + Integer.parseInt(request.getParameter("perrop")) * 3000
                + Integer.parseInt(request.getParameter("perrom")) * 5000;

        int total = costoP * Integer.parseInt(request.getParameter("horas"));
        int descuento = total - (total / 10);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Paseo de perros</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 id='titulo' >Muchas gracias por usar el servicio de paseo de perros</h1>");
        out.println("<head>");

        if (Integer.parseInt(request.getParameter("perrog")) + Integer.parseInt(request.getParameter("perrom"))
                + Integer.parseInt(request.getParameter("perrop")) == 1) {
            out.println("<h3>Usted ha digitado solo un perro, no se le hara descuento.<br>"
                    + "El costo del paseo sin descuento es de: </h3>" + total);
        }

        if (Integer.parseInt(request.getParameter("perrog")) + Integer.parseInt(request.getParameter("perrom"))
                + Integer.parseInt(request.getParameter("perrop")) > 1) {
            out.println("Usted ha paseado a mas de un perro.<br>"
                    + "Se le hara el descuento del 10%.\n"
                    + "Total a pagar:" + descuento);
        }

        out.println("<h1></h1>");
        out.println("</body>");
        out.println("</html>");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
