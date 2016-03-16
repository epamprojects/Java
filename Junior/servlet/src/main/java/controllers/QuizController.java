package controllers;

import inection.QuizDaoMock;
import interfaces.Quiz;
import interfaces.QuizDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mykolai_Lytvyn on 22.02.2016.
 */
@WebServlet(name = "quiz.controller.QuizController", urlPatterns = {"/quiz"})
public class QuizController extends HttpServlet {
    public static String PARAM_ID = "id";
    public static String PAGE_OK = "quiz.jsp";
    public static String PAGE_ERROR = "error.html";
    public static String ATTRIBUTE_QUIZ = "Quiz";


    private QuizDao quizDao = new QuizDaoMock();
    //private TransactionManager txManager = new TransactionManagerMock();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request);
        String idStr = request.getParameter(PARAM_ID);
        if (idStr != null && !idStr.equals("")) {
            try {
                final Integer id = Integer.valueOf(idStr);
                Quiz quiz = selectById(id);

                if (quiz != null) {
                    // this is map using when be transmitted data between server component
                    request.setAttribute(ATTRIBUTE_QUIZ, quiz);
                    //management capabilities container (in our case Tomcat) from component
                    request.getRequestDispatcher(PAGE_OK).forward(request, response);
                }
            } catch (Exception ex) {
                System.out.println("Server exception");
            }
        }else{
            response.sendRedirect(PAGE_ERROR);
        }
    }

    protected Quiz selectById(final Integer id) {
        return quizDao.selectByID(id);

       /* return txManager.doInTransaction(new Callable<Quiz>() {
            @Override
            public Quiz call() throws Exception {

            }
        });*/
    }

    ;
}
