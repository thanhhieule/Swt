package controller;

import dal.OrderDBcontext;
import dal.OrderDetailDBcontext;
import dal.ShippingDBcontext;
import dal.ProductDBContext; // Assuming this is the correct import for your ProductDBContext class
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Cart;
import model.Order;
import model.Shipping;

@WebServlet(name = "CheckOutController", urlPatterns = {"/checkout"})
public class CheckOutController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
        if (carts == null) {
            carts = new LinkedHashMap<>();
        }

        double totalMoney = 0;
        for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
            Integer productId = entry.getKey();
            Cart cart = entry.getValue();
            totalMoney += cart.getQuantity() * cart.getProduct().getPrice();
        }
        request.setAttribute("totalMoney", totalMoney);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

    HttpSession session = request.getSession();
    Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
    if (carts == null) {
        carts = new LinkedHashMap<>();
    }

    // Validate cart quantities
    StringBuilder invalidQuantityMessage = new StringBuilder();
    boolean hasInvalidQuantity = false;

    for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
        Cart cart = entry.getValue();
        if (cart.getQuantity() <= 0) {
            hasInvalidQuantity = true;
            invalidQuantityMessage.append("Invalid quantity for ")
                    .append(cart.getProduct().getName())
                    .append(". Quantity must be greater than 0.");
        }
    }

    if (hasInvalidQuantity) {
        request.setAttribute("invalidQuantityMessage", invalidQuantityMessage.toString());
        request.setAttribute("carts", carts);
        double totalMoney = 0;
        for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
            totalMoney += entry.getValue().getQuantity() * entry.getValue().getProduct().getPrice();
        }
        request.setAttribute("totalMoney", totalMoney);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
        return;
    }

    // Continue with processing the checkout
    String name = request.getParameter("name");
    String phone = request.getParameter("phone");
    String address = request.getParameter("address");
    String note = request.getParameter("note");

    // Save Shipping
    Shipping shipping = new Shipping(name, phone, address);
    int shippingId = new ShippingDBcontext().createReturnId(shipping);

    // Calculate total price
    double totalPrice = 0;
    for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
        totalPrice += entry.getValue().getQuantity() * entry.getValue().getProduct().getPrice();
    }

    // Save Order
    Account a = (Account) request.getSession().getAttribute("acc");
    Order order = new Order(a.getUid(), totalPrice, note, shippingId);
    int orderId = new OrderDBcontext().createReturnId(order);

    // Save OrderDetails
    new OrderDetailDBcontext().saveCart(orderId, carts);

    // Update product quantities
    ProductDBContext bContext = new ProductDBContext();
    for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
        bContext.updateQuantityAfterPurchase(entry.getKey(), entry.getValue().getQuantity());
    }

    session.removeAttribute("carts");
    request.setAttribute("cartss", carts);
    request.setAttribute("totalPrice", totalPrice);
    request.getRequestDispatcher("thank").forward(request, response);
}


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
