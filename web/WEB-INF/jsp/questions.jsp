<%@ page import="bo.Equation" %>
<%@ page import="java.util.Scanner" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Stack" %>
<%@ page import="bo.Operator" %>
<html>
<head>
    <title>Questionnaire</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%= request.getContextPath() %>/vendor/foundation-6.5.1/css/foundation.min.css"/>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/questionnaire.css"/>
</head>
<body>
<%
    Scanner sc = new Scanner(System.in);
    List<Equation> listeEquation = new ArrayList<>();



    Equation eq1 = new Equation("37 5 + 8 *", "( 37 + 5 ) * 8");
    request.setAttribute("Equation1", eq1);
    Equation eq2 = new Equation("42 9 - 7 *", "( 42 - 9 ) * 7");
    Equation eq3 = new Equation("100 10 / 10 *", "100 / 10 * 10");
    Equation eq4 = new Equation("60 30 * 90 +", "60 * 30 + 90");
    Equation eq5 = new Equation("9876 36 * 9 -", "9876 * 36 / 9");
    Equation eq6 = new Equation ("3 3 / 65291 *", "3 / 3 * 65291");
    Equation eq7 = new Equation("36 9 * 8 *", "36 * 9 / 8");
    Equation eq8 = new Equation("69 94 + 6 *","(69 + 94) * 6");
    Equation eq9 = new Equation("6 9 + 8 + 3 +","6+9+8+3");
    Equation eq10 = new Equation("1 2 + 3 +"," 1 + 2 + 3 + 4 + 5");
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

    int cptBonneReponse= 0;
    Stack<Double> pile = new Stack<>();
    double chiffre1, chiffre2;
    for(int i= 0; i< listeEquation.size(); i++) {
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
    request.setAttribute("pile", pile);
%>
    <h1>Questions</h1>
    <h3>Réponse arrondis a l'entier inférieur</h3>
    <form method="POST" action="questions">
        <div class="question-container">
            <label for="question1">Combien font: <strong><%= eq1.getTrueEquation()%></strong></label>
            <input id="question1" type="number" name="quest1">
        </div>
        <div class="question-container">
            <label for="question2">Combien font:<strong><%= eq2.getTrueEquation()%></strong></label>
            <input id="question2" type="number" name="quest2">
        </div>
        <div class="question-container">
            <label for="question3">Combien font:<strong> <%= eq3.getTrueEquation()%></strong></label>
            <input id="question3" type="number" name="quest3">
        </div>
        <div class="question-container">
            <label for="question4">Combien font: <strong> <%= eq4.getTrueEquation()%></strong></label>
            <input id="question4" type="number" name="quest4">
        </div>
        <div class="question-container">
            <label for="question5">Combien font: <strong> <%= eq5.getTrueEquation()%></strong></label>
            <input id="question5" type="number" name="quest5">
        </div>
        <div class="question-container">
            <label for="question6">Combien font: <strong> <%= eq6.getTrueEquation()%></strong></label>
            <input id="question6" type="number" name="quest6">
        </div>
        <div class="question-container">
            <label for="question7">Combien font: <strong> <%= eq7.getTrueEquation()%></strong></label>
            <input id="question7" type="number" name="quest7">
        </div>
        <div class="question-container">
            <label for="question8">Combien font: <strong> <%= eq8.getTrueEquation()%></strong></label>
            <input id="question8" type="number" name="quest8">
        </div>
        <div class="question-container">
            <label for="question9">Combien font: <strong> <%= eq9.getTrueEquation()%></strong></label>
            <input id="question9" type="number" name="quest9">
        </div>
        <div class="question-container">
            <label for="question10">Combien font: <strong> <%= eq10.getTrueEquation()%></strong></label>
            <input id="question10" type="number" name="quest10">
        </div>
        <button type="submit" class="button primary">Resultats</button>

    </form>



</body>
</html>
