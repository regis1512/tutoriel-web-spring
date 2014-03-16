<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form:form method="post" modelAttribute="modification" action="modifierModificationListeCourses">
	<table border="1">
		<thead>
			<tr>
				<th><spring:message code="colonne.identifiant"/></th>
				<th><spring:message code="colonne.libelle"/></th>
				<th><spring:message code="colonne.quantite"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${modification.listeCourses}" var="course" varStatus="status">
				<tr>
					<td>
						<c:out value="${course.id}"/>
						<input type="hidden" name="listeCourses[${status.index}].id" value="${course.id}"/>
					</td>
					<td>
						<c:out value="${course.libelle}"/>
						<input type="hidden" name="listeCourses[${status.index}].libelle" value="${course.libelle}"/>
					</td>
					<td>
						<input type="text" name="listeCourses[${status.index}].quantite" value="${course.quantite}"/><br/>
						<b><i><form:errors path="listeCourses[${status.index}].quantite" /></i></b>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>		
	<input type="submit"/>
</form:form>