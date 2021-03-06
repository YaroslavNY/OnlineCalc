package Controller;

import Model.CalculationModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstNumber = req.getParameter("firstNumber");
        String secondNumber = req.getParameter("secondNumber");
        String operator = req.getParameter("action");


        CalculationModel calculationModel = new CalculationModel(firstNumber,secondNumber,operator);


        String message;
        String url;

        if (firstNumber.length() == 0 || secondNumber.length() == 0 || operator == null){
            message = "Please fill all boxes and choose an action ";
            url = "/WEB-INF/View/calculation_page.jsp";
        }
        else{
            message = "";
            url = "/WEB-INF/View/result_page.jsp";

        }
        req.setAttribute("calculationModel", calculationModel);
        req.setAttribute("message", message);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(req,resp);


    }
}
