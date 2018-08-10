package net.stelmaszak.homeworkcms.filter;

import net.stelmaszak.homeworkcms.repository.ReqInfoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@Component
@Order(1)
public class LogFilter implements Filter {

    @Autowired
    private ReqInfoRespository reqInfoRespository;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        Date date = new Date();

        String browserDetails = httpReq.getHeader("User-Agent");
        String user = browserDetails.toLowerCase();
        String os;


        if (user.indexOf("windows") >= 0) {
            os = "Windows";
        } else if (user.indexOf("x11") >= 0) {
            os = "Unix";
        } else if (user.indexOf("android") >= 0) {
            os = "Android";
        } else if (user.indexOf("iphone") >= 0) {
            os = "IPhone";
        } else if (user.indexOf("mac") >= 0) {
            os = "Mac";
        } else {
            os = "UnKnown";
        }


        String browser;
        if (browserDetails.contains("Chrome")) {
            browser = "Chrome";
        } else if (browserDetails.contains("Firefox")) {
            browser = "FireFox";
        } else if (browserDetails.contains("Opera")) {
            browser = "Opera";
        } else if (browserDetails.contains("Safari")) {
            browser = "Safari";
        } else {
            browser = "UnKnown";
        }

        String przeglad = os + " - " + browser;
        String dateTime = date.toString();
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long stopTime = System.currentTimeMillis();
        int czasZadania = (int) (stopTime - startTime);
        String ipAddress = httpReq.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        reqInfoRespository.save(new ReqInfo(przeglad, dateTime, czasZadania, ipAddress));

    }

    @Override
    public void destroy() {

    }
}
