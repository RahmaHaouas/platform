<%@page import="java.net.URLEncoder"%>
<%@page import="org.apache.jena.base.Sys"%>
<%@page import="org.apache.jena.base.Sys"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="sparql.Queries"
    import="java.util.ArrayList" import="java.util.Iterator"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Leoni Base de Connaissance</title>
    <!-- LOADING STYLESHEETS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<%  if(session.getAttribute("login")== null){%>
    <script>window.location.replace("login.jsp");</script>
<%  }%>
<%
ArrayList<String> sol = new ArrayList<String>();

if (request.getAttribute("solutions") != null) {
    sol = (ArrayList) request.getAttribute("solutions");
}
String question = request.getAttribute("question").toString();
String d = request.getAttribute("d").toString();
%>
<body>
    <!-- TOP NAVIGATION -->
    <div class="container-fluid">
        <div class="navigation">
            <div class="row">
                <ul class="topnav">
                    <li>
                        <a href="index.jsp">Leoni </a>
                    </li>
                    <li>
                        <a href="questions">Question</a>
                    </li>
                    <li>
                        <a href="general">Général</a>
                    </li>
                    <li>
                        <a href="informatique">Informatique</a>
                    </li>
                    <li>
                        <a href="mecanique">Mécanique</a>
                    </li>
                    <li>
                        <a href="electrique">Eléctrique</a>
                    </li>
                    <li>
                        <a href="production">Production</a>
                    </li>
                    <% if(session.getAttribute("login") == null){%>
                    <li style="float: right">
                        <a href="login.jsp">
                            <i class="fa fa-key"></i> Login</a>
                    </li>
                    <%}else{%>
                    <li style="float: right">
                        <a href="Logout">
                            <i class="fa fa-sign-out"></i>
                    </li>
                    <li style="float: right">
                        <a href="#"><%= session.getAttribute("nom")%> <%= session.getAttribute("prenom")%></a>
                    </li>
                    <%}%>
                </ul>
            </div>
        </div>
    </div>
    <!-- END TOP NAVIGATION -->
    <!-- SEARCH FIELD AREA -->
    <div class="searchfield bg-hed-six">
        <div class="container" style="padding-top: 20px; padding-bottom: 20px;">
            <div class="row text-center margin-bottom-20">
                <h1 class="white"> Base de Connaissance Leoni</h1>
            </div>
            <br>
            <form class="row search-row" method="GET" action="resultat" enctype="application/x-www-form-urlencoded">
                <input type="text" class="search" placeholder="What do you need help with?" name="res">
                <button class="buttonsearch btn btn-info btn-lg" type="submit">Chercher</button>
            </form>
        </div>
    </div>
    <!-- END SEARCH FIELD AREA -->
    <!-- MAIN SECTION -->
    <div class="container featured-area-default padding-30">
        <div class="row">
            <div class="col-md-8 padding-20">
                <div class="row">
                    <!-- ARTICLE  -->
                    <div class="panel panel-default">
                        <div class="article-heading margin-bottom-5">
                            <a href="#">
                                <i class="fa fa-pencil-square-o"></i><%= question%></a>
                        </div>
                        <div class="article-info">
                            <div class="art-date">
                                <a href="#">
                                    <i class="fa fa-calendar-o"></i> <%=d%> </a>
                            </div>
                            <div class="art-comments">
                                <a href="#">
                                    <i class="fa fa-comments-o"></i> <%=sol.size()%> commentaires </a>
                            </div>
                        </div>
                    </div>
                    <!-- END ARTICLE -->

                    <!-- COMMENTS  -->
                    <div class="panel panel-default">
                        <div class="article-heading">
                            <i class="fa fa-comments-o"></i> Commentaires (<%=sol.size()%>)
                        </div>
                    <%
                        
                         for (int i = 0; i < sol.size(); i++) {
                    %>

                    
                        <!-- FIRST LEVEL COMMENT 1 -->
                        <div class="article-content">
                            <div class="article-comment-top">
                                <div class="comments-user">
                                    <img src="images/user.png" alt="gomac user">
                                    <div class="user-name">Rahma Houas</div>
                                    <div class="comment-post-date">Publié En
                                        <% 
                                           String date =  sol.get(i).substring(sol.get(i).indexOf("[")); 
                                           date = date.substring(1,11);
                                           String commentaire = sol.get(i);
                                           commentaire = commentaire.substring(0, commentaire.indexOf("["));
                                        %>
                                        <span class="italics"><%=date%></span>
                                    </div>
                                </div>
                                <div class="comments-content">
                                    <p>
                                        <%=commentaire%>.
                                    </p>
                                </div>
                            </div>
                        </div>
                        <!-- END FIRST LEVEL COMMENT 1 -->
                    <%
                        }
                     %>   
                        
                        <hr class="style-three">
                        <!-- LEAVE A REPLY SECTION -->
                        <div class="panel-transparent">
                            <div class="article-heading">
                                <i class="fa fa-comment-o"></i> Leave a Reply
                            </div>
                            <form method="post" class="comment-form">
                                <label>Name:</label>
                                <input type="text" name="name">
                                <br>
                                <label>Email:</label>
                                <input type="text" name="email">
                                <br>
                                <label>Website (Optional):</label>
                                <input type="text" name="website">
                                <br>
                                <label>Comment:</label>
                                <textarea rows="5" cols="2" name="comment"></textarea>

                                <button type="submit" value="Submit" class="btn btn-wide btn-primary">Post Comment</button>
                            </form>
                        </div>
                        <!-- END LEAVE A REPLY SECTION -->
                    </div>
                    <!-- END COMMENTS -->
                </div>

            </div>

            <!-- SIDEBAR STUFF -->
            <div class="col-md-4 padding-20">
                <div class="row margin-top-20">
                    <div class="col-md-12">
                        <div class="fb-heading-small">
                            Latest Articles
                        </div>
                        <hr class="style-three">
                        <div class="fat-content-small padding-left-10">
                            <ul>
                            <%
                               ArrayList<String> rowRecent = new ArrayList<String>();

                                if (request.getAttribute("listRecentPannes") != null) {
                                    rowRecent = (ArrayList) request.getAttribute("listRecentPannes");
                                }
                                Iterator iteratorR = rowRecent.iterator();
                                for (int i = 0; i < rowRecent.size(); i++) {
                                 String ques = URLEncoder.encode(rowRecent.get(i).toString(), "UTF-8");
                            %>
                            
                                <li>
                                    <a href="question?q=<%=ques%>"><%=rowRecent.get(i).toString()%></a>
                                </li>
                            
                            <%
                               }
                            %>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
            <!-- END SIDEBAR STUFF -->
        </div>
    </div>
    <!-- END MAIN SECTION -->

    <!-- FOOTER -->
<%@include file="footer.jsp" %>