<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ml</title>
</head>
<body>
  <c:forEach items="${Quiz_ALL}" var="quiz">
       <div>${quiz.name}</div>
  </c:forEach>
</body>
</html>
