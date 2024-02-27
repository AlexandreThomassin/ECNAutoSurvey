<%-- 
    Document   : dashboard
    Created on : 23 févr. 2024, 18:23:04
    Author     : Chloe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>

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
            
        <div class="py-5">
        <div class="container">
            <div class="row mb-3">
                <div class="col-md-12  d-flex justify-content-center">
                    <img src="img/logo.png" alt="" class="logo">
                </div>

            </div>
                <div class="row d-flex justify-content-center">
                    <div class="box pt-2 mw-100 mx-4">

                        <div class="row d-flex justify-content-center pt-2">
                            <div class="col-md-12">
                                <h2>Bienvenue dans votre dashboard !</h1>
                            </div>
                        </div>
                        <div class="row d-flex justify-content-center pb-4">
                            <div class="col-md-11 mx-4">
                                <hr>
                                <h5>Ajoutez des synthèses en sélectionnant le dossier contenant les fichiers .json</h5>
                                <form method="POST" action="uploadMultipleFile" enctype="multipart/form-data">
                                    Fichier 1 <input type="file" name="file"><br /> 
                                    Nom du fichier 1 : <input type="text" name="name"><br /> <br /> 
                                    Fichier 2 <input type="file" name="file"><br /> 
                                    Nom du fichier 2 : <input type="text" name="name"><br /> <br />
                                    <input type="submit" value="Upload">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
        

        

        
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