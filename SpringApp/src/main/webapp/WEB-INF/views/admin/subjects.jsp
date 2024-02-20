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
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/tableexport.jquery.plugin/tableExport.min.js"></script>

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
                        <h2>Liste des matières</h2>
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
                                <th data-field="subjectCode">Code</th>
                                <th data-field="actions" data-formatter="actionFormatter" data-align="center">Actions</th>
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
            function actionFormatter(value, row) {
                return '<div> <button class="btn btn-primary"> <i class="fa fa-solid fa-pen"></i> </button> <button class="btn btn-danger"> <i class="fa fa-solid fa-trash"></i> </button> </div'
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
