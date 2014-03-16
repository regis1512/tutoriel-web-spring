<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><spring:message code="titre.application"/></title>
	</head>
	<body>
		<table>
			<tbody>
				<tr>
					<td valign="top">
						<table>
							<tbody>
								<tr><td>
									<c:url value="/afficherListeCourses" var="url" />
									<a href="${url}">
										<spring:message code="titre.listecourses"/>
									</a>
								</td></tr>
								<tr><td>
									<c:url value="/afficherCreationListeCourses" var="url" />
									<a href="${url}">
										<spring:message code="titre.creation.elementcourses"/>
									</a>
								</td></tr>
								<tr><td>
									<c:url value="/afficherSuppressionListeCourses" var="url" />
									<a href="${url}">
										<spring:message code="titre.suppression.elementcourses"/>
									</a>
								</td></tr>
								<tr><td>
									<c:url value="/afficherModificationListeCourses" var="url" />
									<a href="${url}">
										<spring:message code="titre.modification.elementcourses"/>
									</a>
								</td></tr>
							</tbody>
						</table>
					</td>
					<td valign="top">
						<tiles:insertAttribute name="principal" />
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>