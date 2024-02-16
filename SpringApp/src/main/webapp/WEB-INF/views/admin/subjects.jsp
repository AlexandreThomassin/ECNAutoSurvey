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
        <title>Test page</title>

        <link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
        <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="../css/main.css">
        <!-- Mandatory to use the sidebar -->
        <link rel="stylesheet" href="../css/sidebar.css">
        <link rel="stylesheet" href="../fontawesome/css/all.css">

        <script src="../js/test.js"></script>

        <!-- Bootstrap Table -->
        <link rel="stylesheet" href="../bootstrap-table/dist/bootstrap-table.min.css">
        
    </head>
    <body>
        
        

        <nav class="navbar navbar-dark d-flex justify-content-space-between sticky-top">
            <a class="navbar-brand" href="${pageContext.request.scheme}://${pageContext.request.localName}:${pageContext.request.serverPort}/SpringApp/homepage.do">
                <button id="menu-toggle" class="navbar-toggler mr-3 text-white" type="button" aria-label="Toggle navigation" data-toggle-sidebar="MainSidebar">
                    <span class="navbar-toggler-icon text-white"></span>
                </button>
                <img src="../img/logo.png" height="40" alt="">
            </a>
        
            <a class="navbar-brand" href="#">
                <i class="fa fa-user icon"></i>
            </a>
        </nav>

        <div id="page" class="active">
            <div id="Sidebar">
                <!-- 
                    DO NOT CHANGE DIV ID
                    The content of the sidebar will be loaded here
                    See navbar.jsp to modify the sidebar -->
            </div>
            
            
            <!-- Page content : YOU MUST PUT THE CONTENT OF THE PAGE HERE -->
            <div class="page-content">
                <div class="container-fluid">
                    
                    <div id="toolbar">
                        <h2>Liste des matières</h2>
                    </div>
                    
                    <table
                        data-toggle="table"
                        data-url="../json/jsonSubjects.do"
                        data-toolbar="#toolbar"
                        data-pagination="true"
                        data-page-size="25"
                        data-show-refresh="true"
                        data-show-columns="true"
                        data-height="800"
                        >
                        <thead>
                            <tr>
                                <th data-field="idSubject" data-visible="false">ID</th>
                                <th data-field="subjectAcronym">Acronyme</th>
                                <th data-field="subjectName">Nom</th>
                                <th data-field="subjectCode">Code</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <!-- End Page content -->
        </div>
        

        

    <script type="module" src="../bootstrap-table/dist/bootstrap-table.min.js"></script>
    </body>

      <script>
        $.ajax({
            'url': '${pageContext.request.scheme}://${pageContext.request.localName}:${pageContext.request.serverPort}/SpringApp/sidebar.do',
            'type': 'get',
            'dataType': 'html'
        })
        .done(function (response) {
            $('#Sidebar').append(response);
        })
      </script>

</html>
