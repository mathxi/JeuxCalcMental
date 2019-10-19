
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
    <h1>Questions</h1>
    <h3>Réponse arrondis a l'entier inférieur</h3>
    <div class="question-container">
        <label for="question1">Combien font: <strong>10 * 2 / 10</strong></label>
        <input id="question1" type="number" >
    </div>
    <div class="question-container">
        <label for="question2">Combien font:<strong> 10 * 2 / 10</strong></label>
        <input id="question2" type="number" >
    </div>
    <div class="question-container">
        <label for="question3">Combien font:<strong> 10 * 2 / 10</strong></label>
        <input id="question3" type="number" >
    </div>
    <div class="question-container">
        <label for="question4">Combien font: <strong> 10 * 2 / 10</strong></label>
        <input id="question4" type="number" >
    </div>
    <a class="button primary" href="<c:url value="/accueil"/>" >Resultats</a> <!-- le faire aller aux résultats-->
</body>
</html>
