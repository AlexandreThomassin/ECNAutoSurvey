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
        <title>Test page</title>

        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>



        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/sidebar.css">
        <link rel="stylesheet" href="fontawesome/css/all.css">

        <script src="js/test.js"></script>
    </head>
    <body>
        

        <nav class="navbar navbar-dark d-flex justify-content-space-between">
            <a class="navbar-brand" href="#">
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
            <div id="MainSidebar" class="sidebar" aria-label="Main sidebar containing navigation links and some information" aria-hidden="false">
                <div class="sidebar__content">
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
                            <a href="#" data-toggle-sidebar="INFO-SI">
                                <div class="row">
                                    <div class="col-8">
                                        <span>Cliquez ici !!!!!</span>
                                    </div>
                                    <div class="col-4"><span class="fa fa-chevron-right mr-3"></span></div>
                                </div>
                            </a>
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
                </div>
            </div>
            
            <!-- Sub Sidebar : Shown when we select a menu in the main sidebar -->
            <div id="INFO-SI" class="sidebar" aria-label="Main sidebar containing navigation links and some information" aria-hidden="true">
                <div class="sidebar__content">
                    <div id="AdministratifMenu">
                        <li>
                            <a href="#" data-toggle-sidebar="INFO-SI">
                                <div class="row pt-3">
                                    <div class="col-2"><span class="fa fa-chevron-left arrow text-secondary"></span></div>
                                    <div class="col-10"><h5 class="text-secondary arrow">INFO-SI - Matières</h5></div>
                                    
                                </div>
                            </a>
                        </li>
                        <li> 
                            <a href="#">
                                <div class="row">
                                    <div class="col-8"><span>PRWEB</span></div>
                                    <div class="col-4"><span class="fa fa-chevron-right mr-3"></span></div>
                                    
                                </div>
                            </a>
                        </li>
                        <li> 
                            <a href="#">
                                <div class="row">
                                    <div class="col-8"><span>DEVMO</span></div>
                                    <div class="col-4"><span class="fa fa-chevron-right mr-3"></span></div>
    
                                </div>
                            </a>
                        </li>
                        <li> 
                            <a href="#">
                                <div class="row">
                                    <div class="col-8"><span>TLANG</span></div>
                                    <div class="col-4"><span class="fa fa-chevron-right mr-3"></span></div>
                                    
                                </div>
                            </a>
                        </li>
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
        function toggleAllSidebar(){
            document.querySelectorAll('[data-toggle-sidebar]').forEach(toggle => {
                const sidebarID = toggle.dataset.toggleSidebar;
                // check if there is an element on the doc with the id
                const sidebarElement = sidebarID ? document.getElementById(sidebarID) : undefined;
                // if there is a sidebar with the passed id (data-toggle-sidebar)
                if (sidebarElement) {
                    // toggle the aria-hidden state of the given sidebar
                    let sidebarState = sidebarElement.getAttribute('aria-hidden');
                    sidebarElement.setAttribute('aria-hidden', true); 
                }
            });
        }

        // Catch all the `[data-toggle-sidebar]` elements on the document.
        document.querySelectorAll('[data-toggle-sidebar]').forEach(toggle => {
            // Add an event listener on those elements "click" event
            toggle.addEventListener('click', e => {
            // get the sidebar ID from the current element data attribute
            const sidebarID = toggle.dataset.toggleSidebar;
            // check if there is an element on the doc with the id
            const sidebarElement = sidebarID ? document.getElementById(sidebarID) : undefined;
            // if there is a sidebar with the passed id (data-toggle-sidebar)
            if (sidebarElement) {
                // toggle the aria-hidden state of the given sidebar
                let sidebarState = sidebarElement.getAttribute('aria-hidden');
                sidebarElement.setAttribute('aria-hidden', sidebarState == 'true' ? false : true); 

                // If we toggle MainSidebar we want all sidebar to close
                if (sidebarID == "MainSidebar"){
                    if (sidebarState == 'false'){
                        toggleAllSidebar();
                    }
                
                    $("#page").toggleClass("active")
                }
            }
            });
        });
         
        $(function(){

          $(window).resize(function(e) {
            if($(window).width()<=768){
                document.querySelectorAll('[data-toggle-sidebar]').forEach(toggle => {
                    // get the sidebar ID from the current element data attribute
                    const sidebarID = toggle.dataset.toggleSidebar;
                    // check if there is an element on the doc with the id
                    const sidebarElement = sidebarID ? document.getElementById(sidebarID) : undefined;
                    
                    // toggle the aria-hidden state of the given sidebar
                    let sidebarState = sidebarElement.getAttribute('aria-hidden');
                    sidebarElement.setAttribute('aria-hidden', true); 
                    
                });
                $("#page").removeClass("active");
                
            }else{
                document.querySelectorAll('[data-toggle-sidebar]').forEach(toggle => {
                    // get the sidebar ID from the current element data attribute
                    const sidebarID = toggle.dataset.toggleSidebar;

                    if (sidebarID == "MainSidebar"){
                        // check if there is an element on the doc with the id
                        const sidebarElement = sidebarID ? document.getElementById(sidebarID) : undefined;
                        
                        // toggle the aria-hidden state of the given sidebar
                        let sidebarState = sidebarElement.getAttribute('aria-hidden');
                        sidebarElement.setAttribute('aria-hidden', false); 
                    }
                });
                $("#page").addClass("active");
            }
          });
        });
      </script>
</html>
