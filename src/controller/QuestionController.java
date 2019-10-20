package controller;

import model.LoginBean;
import bo.*;
import model.QuestionBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

@WebServlet( urlPatterns = {"/questions"} )
public class QuestionController extends HttpServlet {
    private static final String PAGE_QUESTIONS_JSP = "/WEB-INF/jsp/questions.jsp";
    private static final String PAGE_HOME_JSP = "/WEB-INF/jsp/home.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(PAGE_QUESTIONS_JSP).forward(request, response);

        List<Equation> listeEquation = new ArrayList<>();


        Equation eq1 = new Equation("37 5 + 8 *", "( 37 + 5 ) * 8");
        request.setAttribute("Equation1", eq1);
        Equation eq2 = new Equation("42 9 - 7 *", "( 42 - 9 ) * 7");
        Equation eq3 = new Equation("100 10 / 10 *", "100 / 10 * 10");
        Equation eq4 = new Equation("60 30 * 90 +", "60 * 30 + 90");
        Equation eq5 = new Equation("9876 36 * 9 -", "9876 * 36 / 9");
        Equation eq6 = new Equation("3 3 / 65291 *", "3 / 3 * 65291");
        Equation eq7 = new Equation("36 9 * 8 *", "36 * 9 / 8");
        Equation eq8 = new Equation("69 94 + 6 *", "(69 + 94) * 6");
        Equation eq9 = new Equation("6 9 + 8 + 3 +", "6+9+8+3");
        Equation eq10 = new Equation("1 2 + 3 +", " 1 + 2 + 3 + 4 + 5");
        listeEquation.add(eq1);
        listeEquation.add(eq2);
        listeEquation.add(eq3);
        listeEquation.add(eq4);
        listeEquation.add(eq5);
        listeEquation.add(eq6);
        listeEquation.add(eq7);
        listeEquation.add(eq8);
        listeEquation.add(eq9);
        listeEquation.add(eq10);

        int cptBonneReponse = 0;
        Stack<Double> pile = new Stack<>();
        double chiffre1, chiffre2;
        for (int i = 0; i < listeEquation.size(); i++) {
            String tab[] = listeEquation.get(i).getEquation().split(" ");
            Operator operator;
            for (String item : tab) {
                operator = Operator.valueOfLabel(item);
                if (null == operator) {
                    pile.push(Double.valueOf(item));
                } else {
                    if (operator.getType() == 2) {
                        chiffre1 = pile.pop();
                        chiffre2 = pile.pop();
                        pile.push(operator.eval(chiffre1, chiffre2));
                    } else if (operator.getType() == 1) {

                    }
                }
            }
        }
        request.getRequestDispatcher(PAGE_QUESTIONS_JSP).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionBean model = new QuestionBean();
        List<Equation> listeEquation = new ArrayList<>();


        Equation eq1 = new Equation("37 5 + 8 *", "( 37 + 5 ) * 8");
        request.setAttribute("Equation1", eq1);
        Equation eq2 = new Equation("42 9 - 7 *", "( 42 - 9 ) * 7");
        Equation eq3 = new Equation("100 10 / 10 *", "100 / 10 * 10");
        Equation eq4 = new Equation("60 30 * 90 +", "60 * 30 + 90");
        Equation eq5 = new Equation("9876 36 * 9 -", "9876 * 36 / 9");
        Equation eq6 = new Equation("3 3 / 65291 *", "3 / 3 * 65291");
        Equation eq7 = new Equation("36 9 * 8 *", "36 * 9 / 8");
        Equation eq8 = new Equation("69 94 + 6 *", "(69 + 94) * 6");
        Equation eq9 = new Equation("6 9 + 8 + 3 +", "6+9+8+3");
        Equation eq10 = new Equation("1 2 + 3 +", " 1 + 2 + 3 + 4 + 5");
        listeEquation.add(eq1);
        listeEquation.add(eq2);
        listeEquation.add(eq3);
        listeEquation.add(eq4);
        listeEquation.add(eq5);
        listeEquation.add(eq6);
        listeEquation.add(eq7);
        listeEquation.add(eq8);
        listeEquation.add(eq9);
        listeEquation.add(eq10);

        int cptBonneReponse = 0;
        Stack<Double> pile = new Stack<>();
        double chiffre1, chiffre2;
        for (int i = 0; i < listeEquation.size(); i++) {
            String tab[] = listeEquation.get(i).getEquation().split(" ");
            Operator operator;
            for (String item : tab) {
                operator = Operator.valueOfLabel(item);
                if (null == operator) {
                    pile.push(Double.valueOf(item));
                } else {
                    if (operator.getType() == 2) {
                        chiffre1 = pile.pop();
                        chiffre2 = pile.pop();
                        pile.push(operator.eval(chiffre1, chiffre2));
                    } else if (operator.getType() == 1) {

                    }
                }
            }
        }

        try {
            model.Verif(request, pile);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher(PAGE_HOME_JSP).forward(request, response);
        }
    }

