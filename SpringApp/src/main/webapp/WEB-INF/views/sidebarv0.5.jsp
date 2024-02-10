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
        <link rel="stylesheet" href="css/sidebar2.css">
        <link rel="stylesheet" href="fontawesome/css/all.css">
    </head>
    <body>
        

        <nav class="navbar navbar-dark d-flex justify-content-space-between">
            <a class="navbar-brand" href="#">
                <button id="menu-toggle" class="navbar-toggler mr-3 text-white" type="button" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon text-white"></span>
                </button>
                <img src="img/logo.png" height="40" alt="">
            </a>
        
            <a class="navbar-brand" href="#">
                <i class="fa-solid fa-user fa-lg icon"></i>
            </a>
        </nav>

        <!-- From : https://bootsnipp.com/tags/sidebar/4#google_vignette  -->
        <div id="wrapper" class="toggled">
            <!-- Sidebar -->
            <div id="sidebar-wrapper">
                
                <ul class="sidebar-nav">
                    <!-- Sidebar menu -->
                    <div id="AdministratifMenu">
                        <li><h5 class="pt-3 text-secondary">Administratif</h5></li>
                        <li> 
                            <a href="#">
                                <div class="row">
                                    <div class="col-8"><span>Dashboard</span></div>
                                    <div class="col-4"><span class="fa fa-chevron-right mr-3"></span></div>
                                    
                                </div>
                            </a>
                        </li>
                        <li> 
                            <a href="#">
                                <div class="row">
                                    <div class="col-8"><span>Liste des matières</span></div>
                                    <div class="col-4"><span class="fa fa-chevron-right mr-3"></span></div>

                                </div>
                            </a>
                        </li>
                        <li> 
                            <a href="#">
                                <div class="row">
                                    <div class="col-8"><span>Liste des synthèses</span></div>
                                    <div class="col-4"><span class="fa fa-chevron-right mr-3"></span></div>
                                    
                                </div>
                            </a>
                        </li>
                    </div>
                    <hr>
                    <div id="MatièresMenu">
                        <li><h5 class="text-secondary">Options disciplinaires</h5></li>
                        <li> 
                            <a href="#">
                                <div class="row">
                                    <div class="col-8"><span>INFO-SI</span></div>
                                    <div class="col-4"><span class="fa fa-chevron-right mr-3"></span></div>
                                </div>
                            </a>
                            <div id="INFO-SI" class="collapse">
                                <a href="#">
                                    <div class="row">
                                        <div class="col-8"><span>INFO-IA</span></div>
                                        <div class="col-4"><span class="fa fa-chevron-right mr-3"></span></div>  
                                    </div>
                                </a>
                            </div>
                        </li>
                        <li> 
                            <a href="#">
                                <div class="row">
                                    <div class="col-8"><span>INFO-IA</span></div>
                                    <div class="col-4"><span class="fa fa-chevron-right mr-3"></span></div>  
                                </div>
                            </a>
                        </li>
                    </div>
                    
                    
                </ul>


            </div> <!-- /#sidebar-wrapper -->
            <!-- Page Content -->
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <h1>Simple Sidebar</h1>
                    <p>This template has a responsive menu toggling system. The menu will appear collapsed on smaller screens, and will appear non-collapsed on larger screens. When toggled using the button below, the menu will appear/disappear. On small screens, the page content will be pushed off canvas.</p>
                    <p>Make sure to keep all page content within the <code>#page-content-wrapper</code>.</p>
                </div>
            </div> <!-- /#page-content-wrapper -->
        </div> <!-- /#wrapper -->

        

        
    </body>

    <script>
        $(function(){
          $("#menu-toggle").click(function(e) {
              e.preventDefault();
              $("#wrapper").toggleClass("toggled");
          });

          $(window).resize(function(e) {
            if($(window).width()<=768){
              $("#wrapper").removeClass("toggled");
            }else{
              $("#wrapper").addClass("toggled");
            }
          });
        });
         
      </script>
</html>
