<%-- 
    Document   : login
    Created on : 5 févr. 2024, 10:11:44
    Author     : alex4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xml:lang>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>
    <body>
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
                                <h2>Bienvenue !</h1>
                            </div>
                        </div>
                        <div class="row d-flex justify-content-center pb-4">
                            <div class="col-md-11 mx-4">
                                <hr>
                                <h5>Professeurs :</h5>
                                <form>
                                    <div class="form-group">
                                      <label for="InputUser">Identifiant</label>
                                      <input type="id" class="form-control" id="InputUser" aria-describedby="userHelp" placeholder="Identifiant">
                                      <small id="emailHelp" class="form-text text-muted">We'll never share your username with anyone else.</small>
                                    </div>
                                    <div class="form-group">
                                      <label for="InputPassword">Mot de passe</label>
                                      <input type="password" class="form-control" id="InputPassword" placeholder="Mot de passe">
                                    </div>
                                    <button type="submit" class="btn btn-primary w-100">Se connecter</button>
                                </form>
                                <hr>
                                <h5>Etudiants :</h5>
                                <a href="homepage.do"><button class="btn btn-primary w-100">Accéder aux synthèses</button></a>
                                <h5>Test mail :</h5>
                                <a href="testmail.do"><button class="btn btn-primary w-100">Accéder aux mails</button></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
