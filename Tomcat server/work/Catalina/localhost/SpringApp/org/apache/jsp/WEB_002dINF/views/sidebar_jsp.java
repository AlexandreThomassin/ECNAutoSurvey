/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.85
 * Generated at: 2024-02-21 14:09:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sidebar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1707120780687L));
    _jspx_dependants.put("jar:file:/C:/Users/alex4/Desktop/COURS/EI3/PGROU/ECNAutoSurvey/SpringApp/target/SpringApp-1.0/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153377882000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("<div id=\"MainSidebar\" class=\"sidebar\" aria-label=\"Main sidebar containing navigation links and some information\" aria-hidden=\"false\">\r\n");
      out.write("    <div class=\"sidebar__content\">\r\n");
      out.write("        <div id=\"AdministratifMenu\">\r\n");
      out.write("            <li><h5 class=\"pt-3 text-secondary\">Administratif</h5></li>\r\n");
      out.write("            <li> \r\n");
      out.write("                <a href=\"#\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-12\"><span>Dashboard</span></div>\r\n");
      out.write("                        \r\n");
      out.write("                    </div>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li> \r\n");
      out.write("                <a href=\"/SpringApp/admin/subjects.do\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-12\"><span>Liste des matières</span></div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li> \r\n");
      out.write("                <a href=\"#\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-12\"><span>Liste des synthèses</span></div>\r\n");
      out.write("                        \r\n");
      out.write("                    </div>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </div>\r\n");
      out.write("        <hr>\r\n");
      out.write("        <div id=\"MatièresMenu\">\r\n");
      out.write("            <li><h5 class=\"text-secondary\">Syntèses</h5></li>\r\n");
      out.write("            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    function toggleAllSidebar(){\r\n");
      out.write("        document.querySelectorAll('[data-toggle-sidebar]').forEach(toggle => {\r\n");
      out.write("            const sidebarID = toggle.dataset.toggleSidebar;\r\n");
      out.write("            // check if there is an element on the doc with the id\r\n");
      out.write("            const sidebarElement = sidebarID ? document.getElementById(sidebarID) : undefined;\r\n");
      out.write("            // if there is a sidebar with the passed id (data-toggle-sidebar)\r\n");
      out.write("            if (sidebarElement) {\r\n");
      out.write("                // toggle the aria-hidden state of the given sidebar\r\n");
      out.write("                let sidebarState = sidebarElement.getAttribute('aria-hidden');\r\n");
      out.write("                sidebarElement.setAttribute('aria-hidden', true); \r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    // Catch all the `[data-toggle-sidebar]` elements on the document.\r\n");
      out.write("    document.querySelectorAll('[data-toggle-sidebar]').forEach(toggle => {\r\n");
      out.write("        // Add an event listener on those elements \"click\" event\r\n");
      out.write("        toggle.addEventListener('click', e => {\r\n");
      out.write("        // get the sidebar ID from the current element data attribute\r\n");
      out.write("        const sidebarID = toggle.dataset.toggleSidebar;\r\n");
      out.write("        // check if there is an element on the doc with the id\r\n");
      out.write("        const sidebarElement = sidebarID ? document.getElementById(sidebarID) : undefined;\r\n");
      out.write("        // if there is a sidebar with the passed id (data-toggle-sidebar)\r\n");
      out.write("        if (sidebarElement) {\r\n");
      out.write("            // toggle the aria-hidden state of the given sidebar\r\n");
      out.write("            let sidebarState = sidebarElement.getAttribute('aria-hidden');\r\n");
      out.write("            sidebarElement.setAttribute('aria-hidden', sidebarState == 'true' ? false : true); \r\n");
      out.write("\r\n");
      out.write("            // If we toggle MainSidebar we want all sidebar to close\r\n");
      out.write("            if (sidebarID == \"MainSidebar\"){\r\n");
      out.write("                if (sidebarState == 'false'){\r\n");
      out.write("                    toggleAllSidebar();\r\n");
      out.write("                }\r\n");
      out.write("            \r\n");
      out.write("                $(\"#page\").toggleClass(\"active\")\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("     \r\n");
      out.write("    $(function(){\r\n");
      out.write("\r\n");
      out.write("      $(window).resize(function(e) {\r\n");
      out.write("        if($(window).width()<=768){\r\n");
      out.write("            document.querySelectorAll('[data-toggle-sidebar]').forEach(toggle => {\r\n");
      out.write("                // get the sidebar ID from the current element data attribute\r\n");
      out.write("                const sidebarID = toggle.dataset.toggleSidebar;\r\n");
      out.write("                // check if there is an element on the doc with the id\r\n");
      out.write("                const sidebarElement = sidebarID ? document.getElementById(sidebarID) : undefined;\r\n");
      out.write("                \r\n");
      out.write("                // toggle the aria-hidden state of the given sidebar\r\n");
      out.write("                let sidebarState = sidebarElement.getAttribute('aria-hidden');\r\n");
      out.write("                sidebarElement.setAttribute('aria-hidden', true); \r\n");
      out.write("                \r\n");
      out.write("            });\r\n");
      out.write("            $(\"#page\").removeClass(\"active\");\r\n");
      out.write("            \r\n");
      out.write("        }else{\r\n");
      out.write("            document.querySelectorAll('[data-toggle-sidebar]').forEach(toggle => {\r\n");
      out.write("                // get the sidebar ID from the current element data attribute\r\n");
      out.write("                const sidebarID = toggle.dataset.toggleSidebar;\r\n");
      out.write("\r\n");
      out.write("                if (sidebarID == \"MainSidebar\"){\r\n");
      out.write("                    // check if there is an element on the doc with the id\r\n");
      out.write("                    const sidebarElement = sidebarID ? document.getElementById(sidebarID) : undefined;\r\n");
      out.write("                    \r\n");
      out.write("                    // toggle the aria-hidden state of the given sidebar\r\n");
      out.write("                    let sidebarState = sidebarElement.getAttribute('aria-hidden');\r\n");
      out.write("                    sidebarElement.setAttribute('aria-hidden', false); \r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("            $(\"#page\").addClass(\"active\");\r\n");
      out.write("        }\r\n");
      out.write("      });\r\n");
      out.write("    });\r\n");
      out.write("  </script>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/sidebar.jsp(40,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("type");
      // /WEB-INF/views/sidebar.jsp(40,12) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/sidebar.jsp(40,12) '${types}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${types}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                <li> \r\n");
            out.write("                    <a href=\"#\" data-toggle-sidebar=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${type}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" onclick=\"return false;\">\r\n");
            out.write("                        <div class=\"row\">\r\n");
            out.write("                            <div class=\"col-8\"><span>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${type}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</span></div>\r\n");
            out.write("                            <div class=\"col-4\"><span class=\"fa fa-chevron-right mr-3\"></span></div>\r\n");
            out.write("                        </div>\r\n");
            out.write("                    </a>\r\n");
            out.write("                </li>\r\n");
            out.write("            ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f1_reused = false;
    try {
      _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f1.setParent(null);
      // /WEB-INF/views/sidebar.jsp(55,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setVar("type");
      // /WEB-INF/views/sidebar.jsp(55,0) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/sidebar.jsp(55,0) '${types}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${types}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
        if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("    <!-- Sub Sidebar : Shown when we select a menu in the main sidebar -->\r\n");
            out.write("    <div id=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${type}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" class=\"sidebar\" aria-label=\"Main sidebar containing navigation links and some information\" aria-hidden=\"true\">\r\n");
            out.write("        <div class=\"sidebar__content\">\r\n");
            out.write("            <div id=\"AdministratifMenu\">\r\n");
            out.write("                <li>\r\n");
            out.write("                    <a href=\"#\" data-toggle-sidebar=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${type}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" onclick=\"return false;\">\r\n");
            out.write("                        <div class=\"row pt-3\">\r\n");
            out.write("                            <div class=\"col-2\"><span class=\"fa fa-chevron-left arrow text-secondary\"></span></div>\r\n");
            out.write("                            <div class=\"col-10\"><h5 class=\"text-secondary arrow\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${type}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</h5></div>\r\n");
            out.write("                            \r\n");
            out.write("                        </div>\r\n");
            out.write("                    </a>\r\n");
            out.write("                </li>\r\n");
            out.write("                ");
            if (_jspx_meth_c_005fforEach_005f2(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
              return true;
            out.write("\r\n");
            out.write("            </div>\r\n");
            out.write("        </div>\r\n");
            out.write("    </div>\r\n");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f1.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
      _jspx_th_c_005fforEach_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f2_reused = false;
    try {
      _jspx_th_c_005fforEach_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
      // /WEB-INF/views/sidebar.jsp(69,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f2.setVar("group");
      // /WEB-INF/views/sidebar.jsp(69,16) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f2.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/sidebar.jsp(69,16) '${groupsByTypes[type]}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${groupsByTypes[type]}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f2 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f2 = _jspx_th_c_005fforEach_005f2.doStartTag();
        if (_jspx_eval_c_005fforEach_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                    <li> \r\n");
            out.write("                        <a href=\"/SpringApp/synthesis.do?group=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${group}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("                            <div class=\"row\">\r\n");
            out.write("                                <div class=\"col-12\"><span>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${group}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</span></div>\r\n");
            out.write("                            </div>\r\n");
            out.write("                        </a>\r\n");
            out.write("                    </li>\r\n");
            out.write("                ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f2.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f2[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f2.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f2.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f2);
      _jspx_th_c_005fforEach_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f2_reused);
    }
    return false;
  }
}
