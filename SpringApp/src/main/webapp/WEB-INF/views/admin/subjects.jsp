<%-- 
    Document   : subjects
    Created on : 15 févr. 2024, 14:46:04
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Matières</title>

        <link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
        <!-- Bootstrap Table -->
        <link rel="stylesheet" href="../bootstrap-table/dist/bootstrap-table.min.css">
        <link rel="stylesheet" href="../bootstrap-icons/font/bootstrap-icons.css">


        <link rel="stylesheet" href="../css/main.css">
        <!-- Mandatory to use the sidebar -->
        <link rel="stylesheet" href="../css/sidebar.css">
        <link rel="stylesheet" href="../fontawesome/css/all.css">

        <script src="../js/test.js"></script>

        <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="../bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="https://unpkg.com/tableexport.jquery.plugin/tableExport.min.js"></script>

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
                    
                    <div id="toolbar">
                        <h2>Liste des matières <button class="btn btn-info mb-1 ml-1"> <i class="fas fa-plus-circle pr-2"></i> Ajouter une matière</button> </h2>
                    </div>
                    
                    <table
                        id="table"
                        data-toggle="table"
                        data-url="../json/jsonSubjects.do"
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
                                <th data-field="idSubject" data-visible="false">ID</th>
                                <th data-field="subjectAcronym">Acronyme</th>
                                <th data-field="subjectName" data-sortable="true">Nom</th>
                                <th data-field="subjectCode" data-visible="false">Code</th>
                                <th data-field="subjectGroupCollection" data-sortable="true">Option</th>
                                <th data-field="hasProject" data-sortable="true">Projet</th>
                                <th data-field="actions" data-formatter="actionFormatter" data-align="center" data-width="130">Actions</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <!-- End Page content -->
        </div>
        

        
    
    <script type="module" src="../bootstrap-table/dist/bootstrap-table.min.js"></script>
    <script type="module" src="/SpringApp/bootstrap-table/dist/bootstrap-table-locale-all.min.js"></script>
    <script type="module" src="../bootstrap-table/dist/extensions/export/bootstrap-table-export.min.js"></script>
    
    </body>

        <script>
            $(function () {
                $('[data-toggle="tooltip"]').tooltip()
            })

            function actionFormatter(value, row) {
                return '<div> <a class = "text-decoration-none" href="/SpringApp/admin/modifySubject.do?id=' + row.idSubject + '"> <button class="btn btn-primary" data-toggle="tooltip" title="Modifier"> <i class="fas fa-pen"></i> </button> </a> <button class="btn btn-danger" data-toggle="tooltip" title="Supprimer"> <i class="fas fa-trash"></i> </button> </div'
            }

            function cellNameStyleFormatter(){
                return {
                    classes: "text-truncate"
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
