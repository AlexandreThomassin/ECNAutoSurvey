/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.85
 * Generated at: 2024-02-12 10:01:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Les JSPs ne permettent que GET, POST ou HEAD. Jasper permet aussi OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Test page</title>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.css\">\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/sidebar.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"fontawesome/css/all.css\">\r\n");
      out.write("\r\n");
      out.write("        <script src=\"js/test.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        <nav class=\"navbar navbar-dark d-flex justify-content-space-between\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">\r\n");
      out.write("                <button id=\"menu-toggle\" class=\"navbar-toggler mr-3 text-white\" type=\"button\" aria-label=\"Toggle navigation\" data-toggle-sidebar=\"MainSidebar\">\r\n");
      out.write("                    <span class=\"navbar-toggler-icon text-white\"></span>\r\n");
      out.write("                </button>\r\n");
      out.write("                <img src=\"img/logo.png\" height=\"40\" alt=\"\">\r\n");
      out.write("            </a>\r\n");
      out.write("        \r\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">\r\n");
      out.write("                <i class=\"fa fa-user icon\"></i>\r\n");
      out.write("            </a>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"page\" class=\"active\">\r\n");
      out.write("            <div id=\"MainSidebar\" class=\"sidebar\" aria-label=\"Main sidebar containing navigation links and some information\" aria-hidden=\"false\">\r\n");
      out.write("                <div class=\"sidebar__content\">\r\n");
      out.write("                    <div id=\"AdministratifMenu\">\r\n");
      out.write("                        <li><h5 class=\"pt-3 text-secondary\">Administratif</h5></li>\r\n");
      out.write("                        <li> \r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-8\"><span>Dashboard</span></div>\r\n");
      out.write("                                    <div class=\"col-4\"><span class=\"fa fa-chevron-right mr-3\"></span></div>\r\n");
      out.write("                                    \r\n");
      out.write("                                </div>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li> \r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-8\"><span>Liste des matières</span></div>\r\n");
      out.write("                                    <div class=\"col-4\"><span class=\"fa fa-chevron-right mr-3\"></span></div>\r\n");
      out.write("    \r\n");
      out.write("                                </div>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li> \r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-8\"><span>Liste des synthèses</span></div>\r\n");
      out.write("                                    <div class=\"col-4\"><span class=\"fa fa-chevron-right mr-3\"></span></div>\r\n");
      out.write("                                    \r\n");
      out.write("                                </div>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <hr>\r\n");
      out.write("                    <div id=\"MatièresMenu\">\r\n");
      out.write("                        <li><h5 class=\"text-secondary\">Options disciplinaires</h5></li>\r\n");
      out.write("                        <li> \r\n");
      out.write("                            <a href=\"#\" data-toggle-sidebar=\"INFO-SI\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-8\">\r\n");
      out.write("                                        <span>Cliquez ici !!!!!</span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-4\"><span class=\"fa fa-chevron-right mr-3\"></span></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li> \r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-8\"><span>INFO-IA</span></div>\r\n");
      out.write("                                    <div class=\"col-4\"><span class=\"fa fa-chevron-right mr-3\"></span></div>  \r\n");
      out.write("                                </div>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <!-- Sub Sidebar : Shown when we select a menu in the main sidebar -->\r\n");
      out.write("            <div id=\"INFO-SI\" class=\"sidebar\" aria-label=\"Main sidebar containing navigation links and some information\" aria-hidden=\"true\">\r\n");
      out.write("                <div class=\"sidebar__content\">\r\n");
      out.write("                    <div id=\"AdministratifMenu\">\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"#\" data-toggle-sidebar=\"INFO-SI\">\r\n");
      out.write("                                <div class=\"row pt-3\">\r\n");
      out.write("                                    <div class=\"col-2\"><span class=\"fa fa-chevron-left arrow text-secondary\"></span></div>\r\n");
      out.write("                                    <div class=\"col-10\"><h5 class=\"text-secondary arrow\">INFO-SI - Matières</h5></div>\r\n");
      out.write("                                    \r\n");
      out.write("                                </div>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li> \r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-8\"><span>PRWEB</span></div>\r\n");
      out.write("                                    <div class=\"col-4\"><span class=\"fa fa-chevron-right mr-3\"></span></div>\r\n");
      out.write("                                    \r\n");
      out.write("                                </div>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li> \r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-8\"><span>DEVMO</span></div>\r\n");
      out.write("                                    <div class=\"col-4\"><span class=\"fa fa-chevron-right mr-3\"></span></div>\r\n");
      out.write("    \r\n");
      out.write("                                </div>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li> \r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-8\"><span>TLANG</span></div>\r\n");
      out.write("                                    <div class=\"col-4\"><span class=\"fa fa-chevron-right mr-3\"></span></div>\r\n");
      out.write("                                    \r\n");
      out.write("                                </div>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <!-- Page content : YOU MUST PUT THE CONTENT OF THE PAGE HERE -->\r\n");
      out.write("            <div class=\"page-content\">\r\n");
      out.write("                <div class=\"container-fluid\">\r\n");
      out.write("                    <h1>Page Template</h1>\r\n");
      out.write("                    <p>This template has a responsive menu toggling system. The menu will appear collapsed on smaller screens, and will appear non-collapsed on larger screens. When toggled using the button below, the menu will appear/disappear. On small screens, the page content will be pushed off canvas.</p>\r\n");
      out.write("                    <p>Make sure to keep all page content within the <code>#page-content</code>.</p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- End Page content -->\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        function toggleAllSidebar(){\r\n");
      out.write("            document.querySelectorAll('[data-toggle-sidebar]').forEach(toggle => {\r\n");
      out.write("                const sidebarID = toggle.dataset.toggleSidebar;\r\n");
      out.write("                // check if there is an element on the doc with the id\r\n");
      out.write("                const sidebarElement = sidebarID ? document.getElementById(sidebarID) : undefined;\r\n");
      out.write("                // if there is a sidebar with the passed id (data-toggle-sidebar)\r\n");
      out.write("                if (sidebarElement) {\r\n");
      out.write("                    // toggle the aria-hidden state of the given sidebar\r\n");
      out.write("                    let sidebarState = sidebarElement.getAttribute('aria-hidden');\r\n");
      out.write("                    sidebarElement.setAttribute('aria-hidden', true); \r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        // Catch all the `[data-toggle-sidebar]` elements on the document.\r\n");
      out.write("        document.querySelectorAll('[data-toggle-sidebar]').forEach(toggle => {\r\n");
      out.write("            // Add an event listener on those elements \"click\" event\r\n");
      out.write("            toggle.addEventListener('click', e => {\r\n");
      out.write("            // get the sidebar ID from the current element data attribute\r\n");
      out.write("            const sidebarID = toggle.dataset.toggleSidebar;\r\n");
      out.write("            // check if there is an element on the doc with the id\r\n");
      out.write("            const sidebarElement = sidebarID ? document.getElementById(sidebarID) : undefined;\r\n");
      out.write("            // if there is a sidebar with the passed id (data-toggle-sidebar)\r\n");
      out.write("            if (sidebarElement) {\r\n");
      out.write("                // toggle the aria-hidden state of the given sidebar\r\n");
      out.write("                let sidebarState = sidebarElement.getAttribute('aria-hidden');\r\n");
      out.write("                sidebarElement.setAttribute('aria-hidden', sidebarState == 'true' ? false : true); \r\n");
      out.write("\r\n");
      out.write("                // If we toggle MainSidebar we want all sidebar to close\r\n");
      out.write("                if (sidebarID == \"MainSidebar\"){\r\n");
      out.write("                    if (sidebarState == 'false'){\r\n");
      out.write("                        toggleAllSidebar();\r\n");
      out.write("                    }\r\n");
      out.write("                \r\n");
      out.write("                    $(\"#page\").toggleClass(\"active\")\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("         \r\n");
      out.write("        $(function(){\r\n");
      out.write("\r\n");
      out.write("          $(window).resize(function(e) {\r\n");
      out.write("            if($(window).width()<=768){\r\n");
      out.write("                document.querySelectorAll('[data-toggle-sidebar]').forEach(toggle => {\r\n");
      out.write("                    // get the sidebar ID from the current element data attribute\r\n");
      out.write("                    const sidebarID = toggle.dataset.toggleSidebar;\r\n");
      out.write("                    // check if there is an element on the doc with the id\r\n");
      out.write("                    const sidebarElement = sidebarID ? document.getElementById(sidebarID) : undefined;\r\n");
      out.write("                    \r\n");
      out.write("                    // toggle the aria-hidden state of the given sidebar\r\n");
      out.write("                    let sidebarState = sidebarElement.getAttribute('aria-hidden');\r\n");
      out.write("                    sidebarElement.setAttribute('aria-hidden', true); \r\n");
      out.write("                    \r\n");
      out.write("                });\r\n");
      out.write("                $(\"#page\").removeClass(\"active\");\r\n");
      out.write("                \r\n");
      out.write("            }else{\r\n");
      out.write("                document.querySelectorAll('[data-toggle-sidebar]').forEach(toggle => {\r\n");
      out.write("                    // get the sidebar ID from the current element data attribute\r\n");
      out.write("                    const sidebarID = toggle.dataset.toggleSidebar;\r\n");
      out.write("\r\n");
      out.write("                    if (sidebarID == \"MainSidebar\"){\r\n");
      out.write("                        // check if there is an element on the doc with the id\r\n");
      out.write("                        const sidebarElement = sidebarID ? document.getElementById(sidebarID) : undefined;\r\n");
      out.write("                        \r\n");
      out.write("                        // toggle the aria-hidden state of the given sidebar\r\n");
      out.write("                        let sidebarState = sidebarElement.getAttribute('aria-hidden');\r\n");
      out.write("                        sidebarElement.setAttribute('aria-hidden', false); \r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("                $(\"#page\").addClass(\"active\");\r\n");
      out.write("            }\r\n");
      out.write("          });\r\n");
      out.write("        });\r\n");
      out.write("      </script>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
