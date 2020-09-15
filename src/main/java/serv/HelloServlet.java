package serv;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    private String book_string = "<html>\n"
            +"<body>"
            + "<form action='/japp/sample' method='POST'><input name='book' placeholder='type in the name of book' >"
            + "<input type='submit'></form></body>\n"
            + "</html>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        get_process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.print(request.getParameter("data"));
        post_process(request, response, request.getParameter("data"));
    }

    private void post_process(HttpServletRequest request, HttpServletResponse response, String data) throws IOException {
        response.setStatus(200);
        response.getWriter().write("The book is " + data);
    }

    private void get_process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.getWriter().write(book_string);
    }
}

