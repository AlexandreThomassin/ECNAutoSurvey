<%-- 
    Document   : modifySubject.do
    Created on : 21 févr. 2024, 13:55:36
    Author     : alex4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="scheme" value="${pageContext.request.scheme}"/>
<c:set var="baseURL" value="${pageContext.request.localName}"/>
<c:set var="serverPort" value="${pageContext.request.serverPort}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>

        <link rel="stylesheet" href="/SpringApp/bootstrap/css/bootstrap.css">
        <!-- Bootstrap Table -->
        <link rel="stylesheet" href="/SpringApp/bootstrap-table/dist/bootstrap-table.min.css">
        <link rel="stylesheet" href="/SpringApp/bootstrap-icons/font/bootstrap-icons.css">


        <link rel="stylesheet" href="/SpringApp/css/main.css">
        <!-- Mandatory to use the sidebar -->
        <link rel="stylesheet" href="/SpringApp/css/sidebar.css">
        <link rel="stylesheet" href="/SpringApp/fontawesome/css/all.min.css">

        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/css/select2.min.css" rel="stylesheet" />

        <script src="/SpringApp/js/test.js"></script>

        <script type="text/javascript" src="/SpringApp/js/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script type="text/javascript" src="/SpringApp/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/tableexport.jquery.plugin/tableExport.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/js/select2.min.js"></script>

        <link rel="shortcut icon" href="../favicon.ico">
    </head>
    <body>
        

        <%@ include file="../navbar.jspf" %>

        <div id="page" class="active">
            <div id="Sidebar">
                <!-- 
                    DO NOT CHANGE DIV ID
                    The content of the sidebar will be loaded here
                    See navbar.jsp to modify the sidebar -->
                    <div id="sidebar_loader" class="sidebar pt-5 d-flex justify-content-center" aria-label="Main sidebar containing navigation links and some information" aria-hidden="false">
                        <div class="sidebar__content">
                            <div class="spinner-border" role="status">
                                <span class="sr-only">Loading...</span>
                            </div>
                        </div>
                    </div>
                
            </div>
            
            <!-- Page content : YOU MUST PUT THE CONTENT OF THE PAGE HERE -->
            <div class="page-content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-10">
                            <div class="row">
                                <div class="col-lg-12 d-flex justify-content-between">
                                    <a href="/SpringApp/admin/subjects.do"><button class="btn btn-info mt-1"> <i class="fas fa-arrow-left pr-1"></i> Retour</button></a>
                                    <h2>${subject.subjectName}</h2>
                                    <div></div>
                                </div>
                            </div>
                            <br>
                            <form action="/SpringApp/admin/modifySubject.do" method="post">
        
                                <div class="form-group row">
                                    <label for="idSubject" class="col-lg-3 col-form-label">ID</label>
                                    <div class="col-lg-9">
                                        <input name="idSubject" type="text" readonly class="form-control" id="idSubject" value="${subject.idSubject}">
                                    </div>
                                </div>
        
                                <div class="form-group row">
                                    <label for="subjectName" class="col-lg-3 col-form-label">Nom</label>
                                    <div class="col-lg-9">
                                        <input name="subjectName" type="text" class="form-control" id="subjectName" value="${subject.subjectName}">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="subjectAcronym" class="col-lg-3 col-form-label">Acronyme</label>
                                    <div class="col-lg-9">
                                        <input name="subjectAcronym" type="text" class="form-control" id="subjectAcronym" value="${subject.subjectAcronym}">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="subjectCode" class="col-lg-3 col-form-label">Code</label>
                                    <div class="col-lg-9">
                                        <input name="subjectCode" type="text" class="form-control" id="subjectCode" value="${subject.subjectCode}">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="subjectNbStudents" class="col-lg-3 col-form-label">Nombre d'étudiant</label>
                                    <div class="col-lg-9">
                                        <input name="subjectNbStudents" type="number" class="form-control" id="subjectNbStudents" value="${subject.subjectNbStudents}">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="subjectSemester" class="col-lg-3 col-form-label">Semestre concerné</label>
                                    <div class="col-lg-9">
                                        <input name="subjectSemester" type="number" class="form-control" id="subjectSemester" value="${subject.subjectSemester}">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="hasProject" class="col-lg-3 col-form-label">Possède un projet</label>
                                    <div class="col-lg-9">
                                        <select name="hasProject" class="custom-select">
                                            <c:choose>
                                                <c:when test = "${subject.hasProject}">
                                                    <option value="false">Non</option>
                                                    <option value="true" selected>Oui</option>
                                                </c:when>

                                                <c:otherwise>
                                                    <option value="false" selected>Non</option>
                                                    <option value="true">Oui</option>
                                                </c:otherwise>
                                            </c:choose>
                                            
                                            </select>
                                    </div>
                                </div>

                                <div class="row">
                                    <label for="subjectGroup" class="col-lg-3 col-form-label">Option</label>
                                    <div class="col-lg-9">
                                        <select name="subjectGroup" class="js-select2" class="custom-select" multiple>
                                            <c:forEach var="group" items="${subjectGroups}">
                                                <c:choose>
                                                    <c:when test = "${not empty map[group.idGroup]}">
                                                        <option value="${group.idGroup}" data-badge="" selected>
                                                            ${group.groupName}
                                                        </option>
                                                    </c:when>

                                                    <c:otherwise>
                                                        <option value="${group.idGroup}" data-badge="">
                                                            ${group.groupName}
                                                        </option>
                                                    </c:otherwise>
                                                </c:choose>

                                                
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <br>
                                <button type="submit" class="btn btn-info"> <i class="fas fa-save pr-1"></i> Enregistrer</button>
                            </form>
                        </div>
                    </div>
                    
                </div>
            </div>
            <!-- End Page content -->
        </div>
        

        
        <script type="text/javascript" src="../js/multiple-select.js"></script>
        
    </body>

    <script>
        $.ajax({
            'url': '/SpringApp/sidebar.do',
            'type': 'get',
            'dataType': 'html',
            beforeSend: function() {
            $("#sidebar_loader").show();
            $("#sidebar_loader").attr('aria-hidden', false);
            },
            success: function(msg) {
            $("#sidebar_loader").hide();
            $("#sidebar_loader").attr('aria-hidden', true);
            }
        })
        .done(function (response) {
            $('#Sidebar').append(response);
        })
    </script>


        
</html>

