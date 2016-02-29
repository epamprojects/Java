package quiz;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Created by Mykolai_Lytvyn on 22.02.2016.
 */
@WebServlet(name="quiz.QuizController", urlPatterns = {"/quiz"})
public class QuizController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        out.println("start");
        out.close();
    }
}
