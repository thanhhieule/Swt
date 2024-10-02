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
    
    private static final boolean debug = true;

    private FilterConfig filterConfig = null;
    
    public AdminFilter() {
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("LoginFilter:DoBeforeProcessing");
        }
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("LoginFilter:DoAfterProcessing");
        }
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
            if (managerPageRequest && acc.getIsAdmin() != 1) {
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

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {        
    }

    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("LoginFilter:Initializing filter");
            }
        }
    }

    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("LoginFilter()");
        }
        StringBuffer sb = new StringBuffer("LoginFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
}
