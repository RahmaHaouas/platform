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
            <!-- ARTICLE OVERVIEW SECTION -->
            <div class="col-md-8 padding-20">
                <div class="row">
                    
                    <!-- ARTICLES -->
                    <div class="fb-heading">
                        Tout les questions
                    </div>
                    <hr class="style-three">
                    <%
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
                     %>
                    <div class="panel panel-default">
                        <div class="article-heading-abb">
                            <a href="question?q=<%=question%>&d=<%=date%>">
                                <i class="fa fa-pencil-square-o"></i><%=quest%>
                            </a>
                        </div>
                        <div class="article-info">
                            <div class="art-date">
                                <a href="#">
                                    <i class="fa fa-calendar-o"></i> </i><%=date%> </a>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                     %>
                    <!-- END ARTICLES -->

                    <!-- PAGINATION -->
                    <nav class="text-center">
                        <ul class="pagination">
                            <li class="disabled">
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">
                                        <i class="fa fa-arrow-circle-left"></i> Previous</span>
                                </a>
                            </li>
                            <li class="active">
                                <a href="#">1
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="enabled">
                                <a href="#">2
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="enabled">
                                <a href="#">3
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="enabled">
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">Next
                                        <i class="fa fa-arrow-circle-right"></i>
                                    </span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                    <!-- END PAGINATION -->
                </div>
            </div>
            <!-- END ARTICLES OVERVIEW SECTION-->
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
                                 String question = URLEncoder.encode(rowRecent.get(i).toString(), "UTF-8");
                            %>
                            
                                <li>
                                    <a href="question?q=<%=question%>"><%=rowRecent.get(i).toString()%></a>
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