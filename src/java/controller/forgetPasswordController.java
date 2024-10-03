package controller;

import dal.AcountDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

public class forgetPasswordController extends HttpServlet {

    // Xử lý yêu cầu GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("change-newpassword.jsp").forward(request, response);
    }

    // Xử lý yêu cầu POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Lấy thông tin từ form
        String user = request.getParameter("user");
        String passOld = request.getParameter("pass");
        String pass = request.getParameter("newPassword");
        String repass = request.getParameter("confirmPassword");
        
        // Tạo instance của AcountDBContext để kiểm tra tài khoản
        AcountDBContext adb = new AcountDBContext();
        
        // Kiểm tra tính hợp lệ của tài khoản và mật khẩu
        String validationMessage = validateAccount(user, passOld, pass, repass, adb);
        
        if (validationMessage != null) {
            request.setAttribute("mess", validationMessage);
            request.getRequestDispatcher("change-newpassword.jsp").forward(request, response);
        } else {
            adb.updatePassword(pass, user);  // Cập nhật mật khẩu nếu tất cả đều hợp lệ
            request.setAttribute("mess", "Change Pass successfully!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // Phương thức kiểm tra tính hợp lệ của tài khoản
    private String validateAccount(String user, String passOld, String pass, String repass, AcountDBContext adb) {
        Account account = adb.checkAccountExistByUserPass(user, passOld);
        if (account == null) {
            return "Account does not exist or wrong password!";
        } else if (!pass.equals(repass)) {
            return "Passwords do not match!";
        }
        return null;  // Trả về null nếu không có lỗi
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
