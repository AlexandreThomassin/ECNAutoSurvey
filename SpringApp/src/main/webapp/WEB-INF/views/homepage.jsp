<%-- 
    Document   : homepage
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

        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>



        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/sidebar.css">
        <link rel="stylesheet" href="fontawesome/css/all.css">

        <script src="js/test.js"></script>

        <link rel="shortcut icon" href="favicon.ico">
    </head>
    <body>
        

        <nav class="navbar navbar-dark d-flex justify-content-space-between">
            <a class="navbar-brand" href="/SpringApp/homepage.do">
                <button id="menu-toggle" class="navbar-toggler mr-3 text-white" type="button" aria-label="Toggle navigation" data-toggle-sidebar="MainSidebar">
                    <span class="navbar-toggler-icon text-white"></span>
                </button>
                <img src="img/logo.png" height="40" alt="">
            </a>
        
            <a class="navbar-brand" href="#">
                <i class="fa fa-user icon"></i>
            </a>
        </nav>

        <div id="page" class="active">
            <div id="Sidebar">

            </div>
            
            <!-- Page content : YOU MUST PUT THE CONTENT OF THE PAGE HERE -->
            <div class="page-content">
                <div class="container-fluid">
                    <h1>Page Template</h1>
                    <p>This template has a responsive menu toggling system. The menu will appear collapsed on smaller screens, and will appear non-collapsed on larger screens. When toggled using the button below, the menu will appear/disappear. On small screens, the page content will be pushed off canvas.</p>
                    <p>Make sure to keep all page content within the <code>#page-content</code>.</p>
                </div>
            </div>
            <!-- End Page content -->
        </div>
        

        

        
    </body>

    <script>
        // Load the sidebar : DO NOT TOUCH
        $.ajax({
            'url': '/SpringApp/sidebar.do',
            'type': 'get',
            'dataType': 'html'
        })
        .done(function (response) {
            $('#Sidebar').append(response);
        })
      </script>
        
</html>
