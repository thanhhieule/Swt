package controller;

import dal.ProductDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Product;

@WebServlet(name = "AddProductController", urlPatterns = {"/add"})
public class AddProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Product product = new Product();
        product.setName(request.getParameter("name"));
        product.setImageUrl(request.getParameter("image"));
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setTiltle(request.getParameter("title"));
        product.setCategoryId(Integer.parseInt(request.getParameter("category")));
        product.setDescription(request.getParameter("description"));
        product.setQuantity(Integer.parseInt(request.getParameter("quantity")));

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int cid = a.getUid();
        product.setSell_ID(cid);

        if (product.getQuantity() <= 10) {
            request.setAttribute("errorMessage", "Quantity must be greater than 10.");
            request.getRequestDispatcher("managerProduct.jsp").forward(request, response);
        } else {
            ProductDBContext pdb = new ProductDBContext();
            pdb.inSertProduct(product);
            response.sendRedirect("manager");
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
    }
}
