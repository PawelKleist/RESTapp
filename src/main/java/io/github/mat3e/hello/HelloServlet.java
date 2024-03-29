package io.github.mat3e.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Hello", urlPatterns = {"/api"})
public class HelloServlet extends HttpServlet {
    private static String NAME_PARAM = "name";
    private static String LANG_PARAM = "lang";
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    private HelloService service;

    /*
     * Servlet container needs it
     */
    @SuppressWarnings("unused")
    HelloServlet(HelloService service) {
        this.service = service;
    }

    public HelloServlet() {
        this(new HelloService());
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Request got with parameters" + req.getParameterMap());
        String name = req.getParameter(NAME_PARAM);
        String lang = req.getParameter(LANG_PARAM);

        resp.getWriter().write(service.prepareGreeting(name,lang));



    }

}
