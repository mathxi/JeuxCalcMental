<html>
<head>
    <title>T0p 10 des réponses</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%= request.getContextPath() %>/vendor/foundation-6.5.1/css/foundation.min.css"/>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/home.css"/>
</head>
<body>

<h1>Top 10 des résultats</h1>
<div class="result-Container">

        <c:forEach var="result" items="${ sessionScope.topTenResult }" >
            <ul class="stats-list">
                <li>
                    <span class="stats-list-label">Utilisateur</span>
                        ${result.id_user.login}
                </li>
                <li class="stats-list-positive">
                    <span class="stats-list-label">Points</span>
                        ${result.result}
                </li>
                <li class="stats-list-negative">
                    <span class="stats-list-label">Date</span>
                        ${result.date_result}
                </li>
            </ul>
        </c:forEach>
</div>
<a class="button primary" href="<c:url value="/questions"/>" >Nouveau questionnaire</a>




</body>
</html>
