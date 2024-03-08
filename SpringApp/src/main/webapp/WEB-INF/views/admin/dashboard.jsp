<%-- 
    Document   : dashboard
    Created on : 23 févr. 2024, 18:23:04
    Author     : Chloe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <link rel="stylesheet" href="/SpringApp/fontawesome/css/all.min.css">

        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/css/select2.min.css" rel="stylesheet" />

        <script src="/SpringApp/js/test.js"></script>

        <script type="text/javascript" src="/SpringApp/js/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script type="text/javascript" src="/SpringApp/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/tableexport.jquery.plugin/tableExport.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/js/select2.min.js"></script>

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
            
            <!-- Page content : YOU MUST PUT THE CONTENT OF THE PAGE HERE -->
            <div class="page-content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 pt-3">
                            <div class="row ">
                                <div class="col-lg-12 d-flex justify-content-center">
                                    <img src="img/logo.png" alt="" class="logo" width="200px">
                                </div>
                                
                            </div>
                            
                            <div class="row d-flex justify-content-center pt-2 text-center">
                                <div class="col-xl-7">
                                    <h2>Bienvenue dans votre dashboard !</h2>
                                    <hr>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="row d-flex justify-content-center">
                        <div class="col-xl-5 pt-3">
                            <div class="box pt-2 mx-4">
                                <div class="row d-flex justify-content-center pb-4 mx-2">
                                    <div class="col-lg-12">
                                        
                                        <h4>Import des fichiers .json</h4>
                                        <form method="POST" action="uploadMultipleFiles.do" enctype="multipart/form-data">
                                            <div class="form-group pt-2">
                                                <!-- <label for="exampleInputEmail1">Fichiers à ajouter</label> -->
                                                <input type="file" class="form-control" id="file_upload" name="file" multiple aria-describedby="uploadHelp">
                                                <small id="uploadHelp" class="form-text text-muted">Sélectionnez tous les fichiers .json que vous voulez importer</small>
                                            </div>

                                            <button type="submit" class="btn btn-primary w-100">Upload</button>

                                        </form>
                                    </div>
                                </div>
                            </div>
                            
                        </div>


                        <div class="col-xl-5 pt-3">
                            <div class="box pt-2 mx-4">
                                <div class="row d-flex justify-content-center pb-4 mx-2">
                                    <div class="col-lg-12">
                                        
                                        <h4>Génération des synthèses</h4>
                                        <div class="alert alert-warning" role="alert">
                                            Il faut importer les fichiers json avant de générer les synthèses !
                                        </div>
                                        <button type="button" class="btn btn-primary w-100" onclick="generateSynthesis()">Générer</button>
                                        <div id="synthesis_loader" class="py-3" hidden>
                                            <div class="spinner-border text-secondary" role="status">
                                                <span class="sr-only">Loading...</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                    <div class="row d-flex justify-content-center">
                        <div class="col-xl-10 pt-3">
                            <div class="box pt-2 mx-4">
                                <div class="row d-flex justify-content-center pb-4 mx-2">
                                    <div class="col-lg-12">
                                        
                                        <h4>Envois des mails</h4>
                                        <div class="alert alert-warning" role="alert">
                                            Il faut importer les fichiers json et générer les synthèses avant d'envoyer les mails !
                                        </div>
                                        
                                        <form class="needs-validation" novalidate   >
                                            <div class="form-group row">
                                                <label for="destinataire" class="col-lg-4 col-form-label">Adresse e-mail du destinataire:</label>
                                                <div class="col-lg-8">
                                                    <input type="email" id="destinataire" name="destinataire" class="form-control" required>
                                                    <div class="invalid-feedback">
                                                        Veuillez renseignez une adresse mail valide.
                                                    </div>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="form-group row">
                                                <label for="username" class="col-lg-4 col-form-label">Adresse e-mail :</label>
                                                <div class="col-lg-8">
                                                    <input type="email" id="username" name="username" class="form-control" required>
                                                    <div class="invalid-feedback">
                                                        Veuillez renseignez une adresse mail valide.
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="password" class="col-lg-4 col-form-label">Mot de passe :</label>
                                                <div class="col-lg-8">
                                                    <input type="password" id="password" name="password" class="form-control" required>
                                                    <div class="invalid-feedback">
                                                        Le mot de passe est requis.
                                                    </div>
                                                </div>
                                                
                                            
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <label for="subjectGroup" class="col-lg-4 col-form-label my-auto">Option(s) concernée(s)</label>
                                                <div class="col-lg-8">
                                                    <select name="subjectGroup" class="js-select2" class="custom-select mb-0" multiple>
                                                        <c:forEach var="group" items="${subjectGroups}">
                                                            <option value="${group.idGroup}" data-badge="">
                                                                ${group.groupName}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="form-group">
                                                <label for="mailObject">Objet</label>
                                                <input type="text" class="form-control" id="mailObject" placeholder="">
                                              </div>
                                            
                                            <div class="form-group">
                                                <label for="mailContent">Contenu du mail</label>
                                                <textarea class="form-control" id="mailContent" rows="3">Template to be defined ...</textarea>
                                            </div>
                                            <button type="submit" class="btn btn-primary w-100">Envoyer les mails</button>
                                        </form>
                                        
                                        <div id="mails_loader" class="py-3" hidden>
                                            <div class="spinner-border text-secondary" role="status">
                                                <span class="sr-only">Loading...</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        
        <script type="text/javascript" src="../js/multiple-select.js"></script>

    </body>

    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function() {
          'use strict';
          window.addEventListener('load', function() {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
              form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                  event.preventDefault();
                  event.stopPropagation();
                }
                form.classList.add('was-validated');
              }, false);
            });
          }, false);
        })();
    </script>

    <script>
        function generateSynthesis() {
            console.log("test");
            $.ajax({
                'url': '/SpringApp/admin/generateSynthesis.do',
                'type': 'post',
                'datatype': 'html',
                beforeSend: function() {
                    $("#synthesis_loader").show();
                },
                success: function(msg) {
                    $("#sidebar_loader").hide();
                }
            })
            .done(function (response) {
                console.log(response);
            })
            return true
        }

        function sendMails() {
            console.log("test");
            $.ajax({
                'url': '/SpringApp/admin/sendMails.do',
                'type': 'post',
                'datatype': 'html',
                beforeSend: function() {
                    $("#mails_loader").show();
                },
                success: function(msg) {
                    $("#mails_loader").hide();
                }
            })
            return true
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