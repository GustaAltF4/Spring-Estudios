package conexion.es;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/conectaCRUD")
public class ConectaCRUD extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ConectaCRUD() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jdbcURL = "jdbc:mysql://localhost:3306/gestionpedidoscrud?useSSL=false";
        String usuario = "root";
        String contra = "2015guscho12345";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            PrintWriter out = response.getWriter();
            out.println("<html><body>"); 
            out.print("Nombre de la BBDD: " + jdbcURL+"<br>");
            Class.forName(driver);
            Connection miConexion = DriverManager.getConnection(jdbcURL, usuario, contra);
            out.print("Conectado...");
            miConexion.close();
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
