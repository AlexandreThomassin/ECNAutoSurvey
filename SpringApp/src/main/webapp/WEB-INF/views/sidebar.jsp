<%-- 
    Document   : navbar
    Created on : 16 févr. 2024, 15:39:35
    Author     : Alex
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="MainSidebar" class="sidebar" aria-label="Main sidebar containing navigation links and some information" aria-hidden="false">
    <div class="sidebar__content">
        <div id="AdministratifMenu">
            <li><h5 class="pt-3 text-secondary">Administratif</h5></li>
            <li> 
                <a href="#">
                    <div class="row">
                        <div class="col-12"><span>Dashboard</span></div>
                        
                    </div>
                </a>
            </li>
            <li> 
                <a href="/SpringApp/admin/subjects.do">
                    <div class="row">
                        <div class="col-12"><span>Liste des matières</span></div>

                    </div>
                </a>
            </li>
            <li> 
                <a href="#">
                    <div class="row">
                        <div class="col-12"><span>Liste des synthèses</span></div>
                        
                    </div>
                </a>
            </li>
        </div>
        <hr>
        <div id="MatièresMenu">
            <li><h5 class="text-secondary">Syntèses</h5></li>
            <c:forEach var="type" items="${types}">
                <li> 
                    <a href="#" data-toggle-sidebar="${type}" onclick="return false;">
                        <div class="row">
                            <div class="col-8"><span>${type}</span></div>
                            <div class="col-4"><span class="fa fa-chevron-right mr-3"></span></div>
                        </div>
                    </a>
                </li>
            </c:forEach>
            
        </div>
    </div>
</div>

<c:forEach var="type" items="${types}">
    <!-- Sub Sidebar : Shown when we select a menu in the main sidebar -->
    <div id="${type}" class="sidebar" aria-label="Main sidebar containing navigation links and some information" aria-hidden="true">
        <div class="sidebar__content">
            <div id="AdministratifMenu">
                <li>
                    <a href="#" data-toggle-sidebar="${type}" onclick="return false;">
                        <div class="row pt-3">
                            <div class="col-2"><span class="fa fa-chevron-left arrow text-secondary"></span></div>
                            <div class="col-10"><h5 class="text-secondary arrow">${type}</h5></div>
                            
                        </div>
                    </a>
                </li>
                <c:forEach var="group" items="${groupsByTypes[type]}">
                    <li> 
                        <a href="/SpringApp/synthesis.do?group=${group}">
                            <div class="row">
                                <div class="col-12"><span>${group}</span></div>
                            </div>
                        </a>
                    </li>
                </c:forEach>
            </div>
        </div>
    </div>
</c:forEach>

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

