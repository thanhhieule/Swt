package Filter;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

public class AdminFilter implements Filter {

    private FilterConfig filterConfig = null;
    
    public AdminFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/error.jsp";
        String requestURI = req.getRequestURI();
        boolean loggedIn = session != null && session.getAttribute("acc") != null;
        boolean loginRequest = requestURI.equals(loginURI);

        boolean managerPageRequest = requestURI.contains("/managerOrder") ||
                                     requestURI.contains("/managerAccount") ||
                                     requestURI.contains("/managerCategory") ||
                                     requestURI.contains("/manager");

        if (loggedIn) {
            Account acc = (Account) session.getAttribute("acc");
            // Thêm kiểm tra null để tránh lỗi NPE
            if (acc != null && managerPageRequest && acc.getIsAdmin() != 1) {
                res.sendRedirect(loginURI);
            } else {
                chain.doFilter(request, response);
            }
        } else if (loginRequest) {
            chain.doFilter(request, response);
        } else if (managerPageRequest) {
            res.sendRedirect(loginURI);
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        // Optional cleanup code if needed
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            log("AdminFilter: Initializing filter");
        }
    }

    public void log(String msg) {
        // Không còn kiểm tra `debug` ở đây, luôn ghi log
        filterConfig.getServletContext().log(msg);
    }
}
