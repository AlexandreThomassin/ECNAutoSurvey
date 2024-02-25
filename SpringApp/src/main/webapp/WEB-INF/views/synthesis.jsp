<%-- 
    Document   : synthesis
    Created on : 5 févr. 2024, 16:03:54
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
        <link rel="stylesheet" href="/SpringApp/fontawesome/css/all.css">

        <script src="/SpringApp/js/test.js"></script>

        <script type="text/javascript" src="/SpringApp/js/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script type="text/javascript" src="/SpringApp/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/tableexport.jquery.plugin/tableExport.min.js"></script>

        <link rel="shortcut icon" href="favicon.ico">
    </head>
    <body>
        

        <%@ include file="navbar.jspf" %>

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
                    
                    <div id="toolbar">
                        <h2>Liste des matières : ${group}</h2>
                    </div>
                    <table
                        id="table"
                        data-toggle="table"
                        data-url="/SpringApp/json/jsonSynthesis.do?group=${group}"
                        data-locale="fr-FR"
                        data-toolbar="#toolbar"
                        data-pagination="true"
                        data-page-size="10"
                        data-show-refresh="true"
                        data-show-columns="true"
                        data-search="true"
                        data-show-export="true"
                        data-export-data-type="all"
                        data-buttons-order="['refresh', 'toggle', 'fullscreen', 'export']"
                        >
                        <thead>
                            <tr>
                                <th data-field="subjectAcronym" data-sortable="true">Acronyme</th>
                                <th data-field="subjectName" data-sortable="true">Nom</th>
                                <th data-field="subjectNbStudents" data-sortable="true">Nombre d'étudiants</th>
                                <th data-field="actions" data-formatter="actionFormatter" data-align="center">Synthèse</th>
                                
                            </tr>
                        </thead>
                    </table>
                    
                </div>
            </div>
            <!-- End Page content -->
        </div>
        

        

        <script type="module" src="/SpringApp/bootstrap-table/dist/bootstrap-table.min.js"></script>
        <script type="module" src="/SpringApp/bootstrap-table/dist/bootstrap-table-locale-all.min.js"></script>
        <script type="module" src="/SpringApp/bootstrap-table/dist/extensions/export/bootstrap-table-export.min.js"></script>
    </body>

    <script>
        function actionFormatter(value, row) {
            return '<div> </button> <button class="btn btn-info"> <i class="fa fa-solid fa-eye"></i> </button> </div'
        }

        function cellNameStyleFormatter(){
            return {
                classes: 'custom-cell-name'
            }
        }
    </script>

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
