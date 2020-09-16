package serv;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class FifthServlet extends HttpServlet {

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
        String book_parameter = request.getParameter("book");
        String delete_parameter = request.getParameter("delete");
        if(book_parameter != null){
            post_process(request, response, request.getParameter("book"));
        }
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String name = parameterNames.nextElement();
//            System.out.println(name+":"+request.getParameter(name));
//        }
        else if(delete_parameter != null){
            delete_process(request, response, request.getParameter("book"));
        }
    };

    private void post_process(HttpServletRequest request, HttpServletResponse response, String data) throws IOException {
        response.setStatus(200);
        response.getWriter().write("<html>\n"
                +"<body> <p>the book is</p>" + data + "<form action='/japp/sample' method='POST'>" +
                "<button type='submit' name='delete' value='delete'>Delete</button>");
    }

    private void get_process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.getWriter().write(book_string);
    }

    private void delete_process(HttpServletRequest request, HttpServletResponse response, String data) throws IOException {
        response.setStatus(200);
        response.getWriter().write("the book's been deleted");
    }
}

