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
