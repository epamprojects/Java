package controllers;

import inection.QuizDaoMock;
import interfaces.Quiz;
import interfaces.QuizDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Mykolai_Lytvyn on 01.03.2016.
 */
@WebServlet(name = "quiz.controller.QuizAllController", urlPatterns = {"/quizall"})
public class QuizAllController extends HttpServlet {
    public static String PAGE_OK = "quizAll.jsp";
    public static String PAGE_ERROR = "error.html";
    public static String ATTRIBUTE_QUIZ = "Quiz_ALL";

    private QuizDao quizDao = new QuizDaoMock();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Quiz> quizs = selectAll();
            System.out.println(quizs);
            request.setAttribute(ATTRIBUTE_QUIZ, quizs);
            request.getRequestDispatcher(PAGE_OK).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect(PAGE_ERROR);
        }
    }

    protected List<Quiz> selectAll() {
        return quizDao.selectAll();
    }
}
