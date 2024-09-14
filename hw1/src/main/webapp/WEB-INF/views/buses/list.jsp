<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<c:forEach items="${buses}" var="bus">
    <p>
        Manufacturer: ${bus.manufacturer}, Driver: ${bus.driver}, City: ${bus.city}, Route: ${bus.route} <a href="/newBus?depot=${depot}">Add new bus</a>
    </p>
</c:forEach>
</body>
</html>