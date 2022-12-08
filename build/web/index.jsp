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
            <div class="col-md-12">
                <div class="fb-heading">
                    Catégories
                </div>
                <hr class="style-three">
                <div class="row">
                    <div class="col-md-6 margin-bottom-20">
                        <div class="fat-heading-abb">
                            <a href="">
                                <i class="fa fa-folder"></i> Production
                            </a>
                        </div>
                        <div class="fat-content-small padding-left-30">
                            <ul>
                            <%
                               ArrayList<String> rowGeneral = new ArrayList<String>();

                                if (request.getAttribute("listGeneralPannes") != null) {
                                    rowGeneral = (ArrayList) request.getAttribute("listGeneralPannes");
                                }
                                for (int i = 0; i < rowGeneral.size(); i++) {
                                    String date =  rowGeneral.get(i).substring(rowGeneral.get(i).indexOf("[")); 
                                    date = date.substring(1,11);
                                    String quest = rowGeneral.get(i);
                                    quest = quest.substring(0, quest.indexOf("["));
                                    String question = URLEncoder.encode(quest, "UTF-8");
                            %>
                            
                                <li>
                                    <a href="question?q=<%=question%>&d=<%=date%>">
                                        <i class="fa fa-file-text-o"></i><%=quest%></a>
                                </li>
                            
                            <%
                               }
                            %>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6 margin-bottom-20">
                        <div class="fat-heading-abb">
                            <a href="">
                                <i class="fa fa-folder"></i> Informatique
                        </div>
                        <div class="fat-content-small padding-left-30">
                            <ul>
                            <%
                               ArrayList<String> rows = new ArrayList<String>();

                                if (request.getAttribute("listInformatiquePannes") != null) {
                                    rows = (ArrayList) request.getAttribute("listInformatiquePannes");
                                }
                                for (int i = 0; i < rows.size(); i++) {
                                    String date =  rows.get(i).substring(rows.get(i).indexOf("[")); 
                                    date = date.substring(1,11);
                                    String quest = rows.get(i);
                                    quest = quest.substring(0, quest.indexOf("["));
                                    String question = URLEncoder.encode(quest, "UTF-8");
                            %>
                            
                                <li>
                                    <a href="question?q=<%=question%>&d=<%=date%>">
                                        <i class="fa fa-file-text-o"></i><%=quest%></a>
                                </li>
                            
                            <%
                               }
                            %>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6 margin-bottom-20">
                        <div class="fat-heading-abb">
                            <a href="">
                                <i class="fa fa-folder"></i> Mécanique
                            </a>
                        </div>
                        <div class="fat-content-small padding-left-30">
                            <ul>
                            <%
                               ArrayList<String> rowMecanique = new ArrayList<String>();

                                if (request.getAttribute("listMecaniquePannes") != null) {
                                    rowMecanique = (ArrayList) request.getAttribute("listMecaniquePannes");
                                }
                                for (int i = 0; i < rowMecanique.size(); i++) {
                                    String date =  rowMecanique.get(i).substring(rowMecanique.get(i).indexOf("[")); 
                                    date = date.substring(1,11);
                                    String quest = rowMecanique.get(i);
                                    quest = quest.substring(0, quest.indexOf("["));
                                    String question = URLEncoder.encode(quest, "UTF-8");
                            %>
                            
                                <li>
                                   <a href="question?q=<%=question%>&d=<%=date%>">
                                        <i class="fa fa-file-text-o"></i><%=quest%></a>
                                </li>
                            
                            <%
                               }
                            %>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6 margin-bottom-20">
                        <div class="fat-heading-abb">
                            <a href="">
                                <i class="fa fa-folder"></i> Electrique
                            </a>
                        </div>
                        <div class="fat-content-small padding-left-30">
                            <ul>
                            <%
                               ArrayList<String> rowElectrique = new ArrayList<String>();

                                if (request.getAttribute("listElectriquePannes") != null) {
                                    rowElectrique = (ArrayList) request.getAttribute("listElectriquePannes");
                                }
                                for (int i = 0; i < rowElectrique.size(); i++) {
                                    String date =  rowElectrique.get(i).substring(rowElectrique.get(i).indexOf("[")); 
                                    date = date.substring(1,11);
                                    String quest = rowElectrique.get(i);
                                    quest = quest.substring(0, quest.indexOf("["));
                                    String question = URLEncoder.encode(quest, "UTF-8");
                            %>
                            
                                <li>
                                    <a href="question?q=<%=question%>&d=<%=date%>">
                                        <i class="fa fa-file-text-o"></i><%=quest%></a>
                                </li>
                            
                            <%
                               }
                            %>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END MAIN SECTION -->

    <!-- FOOTER -->
<%@include file="footer.jsp" %>