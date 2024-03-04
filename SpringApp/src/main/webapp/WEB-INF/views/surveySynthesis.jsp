<%-- 
    Document   : surveySynthesis
    Created on : 4 mars 2024, 11:17:42
    Author     : Alex
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
                <div class="container-fluid px-5">
                    <div class="row d-flex justify-content-center text-center">
                        <div class="col-xl-10">
                            <h1>PGROU</h1>
                            <hr>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="subjectName" class="col-lg-2 col-form-label">Titre de la matière</label>
                        <div class="col-lg-3">
                            <input name="subjectName" type="text" readonly class="form-control" id="subjectName" value="PGROU">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="subjectCursus" class="col-lg-2 col-form-label">Cursus</label>
                        <div class="col-lg-3">
                            <input name="subjectCursus" type="text" readonly class="form-control" id="subjectCursus" value="INGE GEN">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="subjectYear" class="col-lg-2 col-form-label">Année</label>
                        <div class="col-lg-3">
                            <input name="subjectYear" type="text" readonly class="form-control" id="subjectYear" value="2022-2023">
                        </div>
                    </div>

                    <div class="row pt-2">
                        <div class="col-xl-5">
                            <h4>I. Synthèse de l'évaluation</h4>
                            <hr>



                        </div>
                    </div>

                    <div class="row pt-3">
                        <div class="col-xl-12">
                            <h5 class="font-weight-bold">Taux de réponse
                                <br>
                                <small class="text-muted">(moyenne,  sur l'ensemble des questions, du nombre de réponses exprimées / nombre d'inscrits dans la matière)</small>
                            </h5>

                            <div>Le taux de réponse à l'enquête est de (pour un total de 188 étudiants inscrits) :
                                <ul>
                                    <li>41 % pour les réponses complètes.</li>
                                    <li>44 % pour les réponses partielles.</li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="row pt-3">
                        <div class="col-xl-12">
                            <h5 class="font-weight-bold">Appréciation globale</h5>

                            <div>Qualité globale de l'enseignement : <span id="satisfactoryPercentage">77</span> % des étudiants sont satisfaits.</div>
                        </div>
                    </div>

                    <div class="row pt-3">
                        <div class="col-xl-12">
                            <h5 class="font-weight-bold">Les points positifs
                                <br>
                                <small class="text-muted">(% : réponses tout à fait d'accord et plutôt d'accord sur les réponses exprimées)</small>
                            </h5>

                            <div>Le taux de réponse à l'enquête est de (pour un total de 188 étudiants inscrits) :
                                <ul>
                                    <li>Cette matière est utile à la formation d'ingénieur généraliste (87 %)</li>
                                    <li>Le niveau des connaissances exigé en projet est approprié (87 %)</li>
                                    <li>L'enseignement est bien adapté à mes connaissances préalables (85 %)</li>
                                    <li>Les interactions avec l'équipe enseignante sont satisfaisantes (85 %)</li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="row pt-3">
                        <div class="col-xl-12">
                            <h5 class="font-weight-bold">Propositons d'améliorations</h5>

                            <!-- If the synthesis is on v0 : the teacher as to write the improvements points for the subject -->
                            <form action="saveSynthesis.do">
                                <div class="form-group">
                                    <label for="improvementPoints">Saissez les points d'améliorations</label>
                                    <textarea class="form-control" id="improvementPoints" rows="3"></textarea>
                                  </div>
                                  <button type="submit" class="btn btn-success">Enregistrer</button>
                            </form>
                        </div>
                    </div>


                    <div class="row pt-2">
                        <div class="col-xl-5">
                            <h4>II. Réponse de l'enseignant·e responsable de la matière</h4>
                            <hr>
                        </div>
                    </div>


                </div>
            </div>
            <!-- End Page content -->
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

