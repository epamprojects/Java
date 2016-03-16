<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ml</title>
</head>
<body>
  <div>All Quiz</div>
  <c:forEach items="${Quiz}" var="quiz">
        <%-- in JSP getter without 'get' become value.
         quiz.getName => quiz.name
         --%>
       <div>${quiz.name}</div>

  </c:forEach>
</body>
</html>
