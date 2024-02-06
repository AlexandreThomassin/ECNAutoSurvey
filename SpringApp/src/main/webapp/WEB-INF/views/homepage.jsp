<%-- 
    Document   : homepage
    Created on : 5 févr. 2024, 16:03:54
    Author     : alex4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>homepage</title>

        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>



        <link rel="stylesheet" href="css/main.css">
        <script src="https://kit.fontawesome.com/019ac265ff.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-dark">
            <div class="container d-flex justify-content-space-between">
                <a class="navbar-brand" href="#">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler" aria-controls="navbarToggler" aria-expanded="true" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <img src="img/logo.png" height="40" alt="">
                </a>
            
                <a class="navbar-brand" href="#">
                    <i class="fa-solid fa-user fa-lg icon"></i>
                </a>
            </div>
        </nav>
        <div class="collapse navbar-collapse show" id="navbarToggler">
            <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px; height: 100%;">
                <p>Test</p>
            </div>
        </div>
    </body>
</html>
