    <%@page import="java.net.URLEncoder"%>
<%@page import="org.apache.jena.base.Sys"%>
<%@page import="org.apache.jena.base.Sys"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="sparql.Queries"
	import="java.util.ArrayList" import="java.util.Iterator"%>
<div class="container-fluid footer marg30">
        <div class="container">
            <!-- FOOTER COLUMN ONE -->
            <div class="col-xs-12 col-sm-4 col-md-4 margin-top-20">
                <div class="panel-transparent">
                    <div class="footer-heading">En Plus</div>
                    <div class="footer-body">
                        <ul>
                            <li>
                                <a href="single-category.html">Qui sommes nous?</a>
                            </li>
                            <li>
                                <a href="single-category.html">Conditions générales d'utilisation</a>
                            </li>
                            <li>
                                <a href="single-category.html">Politique de protection des données personnelles</a>
                            </li>
                            <li>
                                <a href="single-category.html">Guides</a>
                               
                            <li>
                                <a href="single-category.html">Confidentialité et cookies</a>
                            </li>
                            <li>
                                <a href="single-category.html">Blog</a>
                            </li>
                          
                        </ul>
                    </div>
                </div>
            </div>
            <!-- END FOOTER COLUMN ONE -->
            <!-- FOOTER COLUMN TWO -->
            <div class="col-xs-12 col-sm-4 col-md-4 margin-top-20">
                <div class="panel-transparent">
                    <div class="footer-heading">Categories</div>
                    <div class="footer-body">
                        <ul>
                            <li>
                                <a href="single-category.html">Informatique</a>
                            </li>
                            <li>
                                <a href="single-category.html">Mécanique</a>
                            </li>
                            <li>
                                <a href="single-category.html">Electrique</a>
                            </li>
                            <li>
                                <a href="single-category.html">Production</a>
                            </li>
                          
                        </ul>
                    </div>
                </div>
            </div>
            <!-- END FOOTER COLUMN TWO -->
            <!-- FOOTER COLUMN THREE -->
            <div class="col-xs-12 col-sm-4 col-md-4 margin-top-20">
                <div class="panel-transparent">
                    <div class="footer-heading">Popular Articles</div>
                    <div class="footer-body">
                        <ul>
                            <%
                               ArrayList<String> row = new ArrayList<String>();

                                if (request.getAttribute("listRecentPannes") != null) {
                                    row = (ArrayList) request.getAttribute("listRecentPannes");
                                }
                                for (int i = 0; i < row.size(); i++) {
                                 String ques = URLEncoder.encode(row.get(i).toString(), "UTF-8");
                            %>
                            
                                <li>
                                    <a href="question?q=<%=ques%>"><%=row.get(i).toString()%></a>
                                </li>
                            
                            <%
                               }
                            %>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- END FOOTER COLUMN THREE -->
        </div>
    </div>
    <!-- END FOOTER -->

    <!-- COPYRIGHT INFO -->
    <div class="container-fluid footer-copyright marg30">
        <div class="container">
            <div class="pull-left">
                Copyright © 2020 LEONI</a>
            </div>
            <div class="pull-right">
                <i class="fa fa-facebook"></i> &nbsp;
                <i class="fa fa-twitter"></i> &nbsp;
                <i class="fa fa-linkedin"></i>
            </div>
        </div>
    </div>
    <!-- END COPYRIGHT INFO -->

    <!-- LOADING MAIN JAVASCRIPT -->
    <script src="js/jquery-2.2.4.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src='https://cdn.rawgit.com/VPenkov/okayNav/master/app/js/jquery.okayNav.js'></script>
</body>

</html>