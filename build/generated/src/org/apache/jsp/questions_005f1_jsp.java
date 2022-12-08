package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URLEncoder;
import org.apache.jena.base.Sys;
import org.apache.jena.base.Sys;
import sparql.Queries;
import java.util.ArrayList;
import java.util.Iterator;
import java.net.URLEncoder;
import org.apache.jena.base.Sys;
import org.apache.jena.base.Sys;
import sparql.Queries;
import java.util.ArrayList;
import java.util.Iterator;

public final class questions_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <title>Leoni Base de Connaissance</title>\n");
      out.write("    <!-- LOADING STYLESHEETS -->\n");
      out.write("    <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <!-- TOP NAVIGATION -->\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <div class=\"navigation\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <ul class=\"topnav\">\n");
      out.write("                    <li>\n");
      out.write("                        <a>Leoni </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"questions\">Question</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"articles.html\">Général</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"faq.html\">Informatique</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"knowledge-base.html\">Mécanique</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"articles.html\">Eléctrique</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"faq.html\">Logistique</a>\n");
      out.write("                    </li>\n");
      out.write("                    ");
 if(session.getAttribute("login") == null){
      out.write("\n");
      out.write("                    <li style=\"float: right\">\n");
      out.write("                        <a href=\"login.jsp\">\n");
      out.write("                            <i class=\"fa fa-key\"></i> Login</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li style=\"float: right\">\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                            <i class=\"fa fa-pencil\"></i> Sign Up</a>\n");
      out.write("                    </li>\n");
      out.write("                    ");
}else{
      out.write("\n");
      out.write("                    <li style=\"float: right\">\n");
      out.write("                        <a href=\"Logout\">\n");
      out.write("                            <i class=\"fa fa-sign-out\"></i>\n");
      out.write("                    </li>\n");
      out.write("                    <li style=\"float: right\">\n");
      out.write("                        <a href=\"#\">");
      out.print( session.getAttribute("nom"));
      out.write(' ');
      out.print( session.getAttribute("prenom"));
      out.write("</a>\n");
      out.write("                    </li>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- END TOP NAVIGATION -->\n");
      out.write("    <!-- SEARCH FIELD AREA -->\n");
      out.write("    <div class=\"searchfield bg-hed-six\">\n");
      out.write("        <div class=\"container\" style=\"padding-top: 20px; padding-bottom: 20px;\">\n");
      out.write("            <div class=\"row text-center margin-bottom-20\">\n");
      out.write("                <h1 class=\"white\"> Base de Connaissance Leoni</h1>\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <form class=\"row search-row\" method=\"GET\" action=\"resultat\" enctype=\"application/x-www-form-urlencoded\">\n");
      out.write("                <input type=\"text\" class=\"search\" placeholder=\"What do you need help with?\" name=\"res\">\n");
      out.write("                <a class=\"buttonsearch btn btn-info btn-lg\" type=\"submit\">Search</a>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- END SEARCH FIELD AREA -->\n");
      out.write("    <!-- MAIN SECTION -->\n");
      out.write("    <div class=\"container featured-area-default padding-30\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <!-- ARTICLE OVERVIEW SECTION -->\n");
      out.write("            <div class=\"col-md-8 padding-20\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    \n");
      out.write("                    <!-- ARTICLES -->\n");
      out.write("                    <div class=\"fb-heading\">\n");
      out.write("                        Tout les questions\n");
      out.write("                    </div>\n");
      out.write("                    <hr class=\"style-three\">\n");
      out.write("                    ");

                        ArrayList<String> rowAll = new ArrayList<String>();

                         if (request.getAttribute("listAllPannes") != null) {
                             rowAll = (ArrayList) request.getAttribute("listAllPannes");
                         }
                         ArrayList<String> sol = new ArrayList<String>();
                         for (int i = 0; i < rowAll.size(); i++) {
                            String date =  rowAll.get(i).substring(rowAll.get(i).indexOf("[")); 
                            date = date.substring(1,11);
                            String quest = rowAll.get(i);
                            quest = quest.substring(0, quest.indexOf("["));
                            String question = URLEncoder.encode(quest, "UTF-8");
                            sol = Queries.getSol(quest);
                     
      out.write("\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"article-heading-abb\">\n");
      out.write("                            <a href=\"question?q=");
      out.print(question);
      out.write("&d=");
      out.print(date);
      out.write("\">\n");
      out.write("                                <i class=\"fa fa-pencil-square-o\"></i>");
      out.print(quest);
      out.write("\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"article-info\">\n");
      out.write("                            <div class=\"art-date\">\n");
      out.write("                                <a href=\"#\">\n");
      out.write("                                    <i class=\"fa fa-calendar-o\"></i> </i>");
      out.print(date);
      out.write(" </a>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"art-comments\">\n");
      out.write("                                <a href=\"#\">\n");
      out.write("                                    <i class=\"fa fa-comments-o\"></i> ");
      out.print(sol.size());
      out.write(" Commentaires </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");

                        }
                     
      out.write("\n");
      out.write("                    <!-- END ARTICLES -->\n");
      out.write("\n");
      out.write("                    <!-- PAGINATION -->\n");
      out.write("                    <nav class=\"text-center\">\n");
      out.write("                        <ul class=\"pagination\">\n");
      out.write("                            <li class=\"disabled\">\n");
      out.write("                                <a href=\"#\" aria-label=\"Previous\">\n");
      out.write("                                    <span aria-hidden=\"true\">\n");
      out.write("                                        <i class=\"fa fa-arrow-circle-left\"></i> Previous</span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"active\">\n");
      out.write("                                <a href=\"#\">1\n");
      out.write("                                    <span class=\"sr-only\">(current)</span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"enabled\">\n");
      out.write("                                <a href=\"#\">2\n");
      out.write("                                    <span class=\"sr-only\">(current)</span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"enabled\">\n");
      out.write("                                <a href=\"#\">3\n");
      out.write("                                    <span class=\"sr-only\">(current)</span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"enabled\">\n");
      out.write("                                <a href=\"#\" aria-label=\"Previous\">\n");
      out.write("                                    <span aria-hidden=\"true\">Next\n");
      out.write("                                        <i class=\"fa fa-arrow-circle-right\"></i>\n");
      out.write("                                    </span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("                    <!-- END PAGINATION -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- END ARTICLES OVERVIEW SECTION-->\n");
      out.write("            <!-- SIDEBAR STUFF -->\n");
      out.write("            <div class=\"col-md-4 padding-20\">\n");
      out.write("                <div class=\"row margin-top-20\">\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <div class=\"fb-heading-small\">\n");
      out.write("                            Latest Articles\n");
      out.write("                        </div>\n");
      out.write("                        <hr class=\"style-three\">\n");
      out.write("                        <div class=\"fat-content-small padding-left-10\">\n");
      out.write("                            <ul>\n");
      out.write("                            ");

                               ArrayList<String> rowRecent = new ArrayList<String>();

                                if (request.getAttribute("listRecentPannes") != null) {
                                    rowRecent = (ArrayList) request.getAttribute("listRecentPannes");
                                }
                                Iterator iteratorR = rowRecent.iterator();
                                for (int i = 0; i < rowRecent.size(); i++) {
                                 String question = URLEncoder.encode(rowRecent.get(i).toString(), "UTF-8");
                            
      out.write("\n");
      out.write("                            \n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"question?q=");
      out.print(question);
      out.write('"');
      out.write('>');
      out.print(rowRecent.get(i).toString());
      out.write("</a>\n");
      out.write("                                </li>\n");
      out.write("                            \n");
      out.write("                            ");

                               }
                            
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- END SIDEBAR STUFF -->\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- END MAIN SECTION -->\n");
      out.write("\n");
      out.write("    <!-- FOOTER -->\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container-fluid footer marg30\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <!-- FOOTER COLUMN ONE -->\n");
      out.write("            <div class=\"col-xs-12 col-sm-4 col-md-4 margin-top-20\">\n");
      out.write("                <div class=\"panel-transparent\">\n");
      out.write("                    <div class=\"footer-heading\">How it works</div>\n");
      out.write("                    <div class=\"footer-body\">\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt\n");
      out.write("                            ut laoreet dolore magna aliquam erat volutpat.</p>\n");
      out.write("                        <p>Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip\n");
      out.write("                            ex ea commodo consequat. </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- END FOOTER COLUMN ONE -->\n");
      out.write("            <!-- FOOTER COLUMN TWO -->\n");
      out.write("            <div class=\"col-xs-12 col-sm-4 col-md-4 margin-top-20\">\n");
      out.write("                <div class=\"panel-transparent\">\n");
      out.write("                    <div class=\"footer-heading\">Categories</div>\n");
      out.write("                    <div class=\"footer-body\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"single-category.html\">General</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"single-category.html\">Getting Started</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"single-category.html\">Account Support</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"single-category.html\">Guides</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"single-category.html\">Payment &amp; Billing</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"single-category.html\">Misc</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- END FOOTER COLUMN TWO -->\n");
      out.write("            <!-- FOOTER COLUMN THREE -->\n");
      out.write("            <div class=\"col-xs-12 col-sm-4 col-md-4 margin-top-20\">\n");
      out.write("                <div class=\"panel-transparent\">\n");
      out.write("                    <div class=\"footer-heading\">Popular Articles</div>\n");
      out.write("                    <div class=\"footer-body\">\n");
      out.write("                        <ul>\n");
      out.write("                            ");

                               ArrayList<String> row = new ArrayList<String>();

                                if (request.getAttribute("listRecentPannes") != null) {
                                    row = (ArrayList) request.getAttribute("listRecentPannes");
                                }
                                for (int i = 0; i < row.size(); i++) {
                                 String ques = URLEncoder.encode(row.get(i).toString(), "UTF-8");
                            
      out.write("\n");
      out.write("                            \n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"question?q=");
      out.print(ques);
      out.write('"');
      out.write('>');
      out.print(row.get(i).toString());
      out.write("</a>\n");
      out.write("                                </li>\n");
      out.write("                            \n");
      out.write("                            ");

                               }
                            
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- END FOOTER COLUMN THREE -->\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- END FOOTER -->\n");
      out.write("\n");
      out.write("    <!-- COPYRIGHT INFO -->\n");
      out.write("    <div class=\"container-fluid footer-copyright marg30\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"pull-left\">\n");
      out.write("                Copyright © 2018 Sunny Gohil</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"pull-right\">\n");
      out.write("                <i class=\"fa fa-facebook\"></i> &nbsp;\n");
      out.write("                <i class=\"fa fa-twitter\"></i> &nbsp;\n");
      out.write("                <i class=\"fa fa-linkedin\"></i>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- END COPYRIGHT INFO -->\n");
      out.write("\n");
      out.write("    <!-- LOADING MAIN JAVASCRIPT -->\n");
      out.write("    <script src=\"js/jquery-2.2.4.min.js\"></script>\n");
      out.write("    <script src=\"js/main.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src='https://cdn.rawgit.com/VPenkov/okayNav/master/app/js/jquery.okayNav.js'></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
