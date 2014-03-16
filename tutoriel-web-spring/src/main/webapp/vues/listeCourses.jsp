<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<table border="1">
	<thead>
		<tr>
			<th><spring:message code="colonne.identifiant"/></th>
			<th><spring:message code="colonne.libelle"/></th>
			<th><spring:message code="colonne.quantite"/></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listeCourses}" var="course">
			<tr>
				<td><c:out value="${course.id}"/></td>
				<td><c:out value="${course.libelle}"/></td>
				<td><c:out value="${course.quantite}"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>