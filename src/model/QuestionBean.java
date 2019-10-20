package model;

import bo.Resultat;
import bo.User;
import dal.DAOFactory;
import dal.ResultatDAOJDBC;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Stack;

public class QuestionBean {

   public void Verif(HttpServletRequest request, Stack<Double> equations) throws SQLException {
       HttpSession session = request.getSession();
       User connectedUser = ( User ) session.getAttribute( "isConntected" );



       System.out.println(equations);
       int cptBonneRep = 0;
       double resultatQuest1 = Double.parseDouble(request.getParameter("quest1"));
       double resultatQuest2 =  Double.parseDouble(request.getParameter("quest2"));
       double resultatQuest3 =  Double.parseDouble(request.getParameter("quest3"));
       double resultatQuest4 =  Double.parseDouble(request.getParameter("quest4"));
       double resultatQuest5 =  Double.parseDouble(request.getParameter("quest5"));
       double resultatQuest6 =  Double.parseDouble(request.getParameter("quest6"));
       double resultatQuest7 = Double.parseDouble(request.getParameter("quest7"));
       double resultatQuest8 = Double.parseDouble(request.getParameter("quest8"));
       double resultatQuest9 =  Double.parseDouble(request.getParameter("quest9"));
       double resultatQuest10 =  Double.parseDouble(request.getParameter("quest10"));
       if(resultatQuest1 == equations.get(0)){
           cptBonneRep ++;
           System.out.println(cptBonneRep);
       }
       if(resultatQuest2 == equations.get(1)){
           cptBonneRep ++;
           System.out.println(cptBonneRep);
       }
       if(resultatQuest3 == equations.get(2)){
           cptBonneRep ++;
           System.out.println(cptBonneRep);
       }
       if(resultatQuest4 == equations.get(3)){
           cptBonneRep ++;
           System.out.println(cptBonneRep);
       }
       if(resultatQuest5 == equations.get(4)){
           cptBonneRep ++;
           System.out.println(cptBonneRep);
       }
       if(resultatQuest6 == equations.get(5)){
           cptBonneRep ++;
           System.out.println(cptBonneRep);
       }
       if(resultatQuest7 == equations.get(6)){
           cptBonneRep ++;
           System.out.println(cptBonneRep);
       }
       if(resultatQuest8 == equations.get(7)){
           cptBonneRep ++;
           System.out.println(cptBonneRep);
       }
       if(resultatQuest9 == equations.get(8)){
           cptBonneRep ++;
       }
       if(resultatQuest10 == equations.get(9)){
           cptBonneRep ++;
       }

       System.out.println(cptBonneRep);
       Resultat resultat = new Resultat();
       resultat.setId_user(connectedUser);
       resultat.setResult(cptBonneRep);

       ResultatDAOJDBC dao = ( ResultatDAOJDBC ) DAOFactory.getResultatsDAO();
       UserDAOJDBC userDAO = (UserDAOJDBC) DAOFactory.getUserDAO();
       System.out.println("L'utilisateur courant est : " + connectedUser.getId_user());
       System.out.println("Son meilleur score est : " + connectedUser.getTopResult());
       System.out.println("Le score actuel est : " + cptBonneRep);
       if(connectedUser.getTopResult() < cptBonneRep){
           System.out.println("J'update la bdd User de l'user " + connectedUser.getId_user() + "Avec le score " + cptBonneRep);
           userDAO.UpdateTopScore(connectedUser.getId_user(), cptBonneRep);
       }
       dao.create(resultat);

















   }
}