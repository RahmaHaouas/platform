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
                        <a>Leoni </a>
                    </li>
                    <li>
                        <a href="questions">Question</a>
                    </li>
                    <li>
                        <a href="articles.html">Général</a>
                    </li>
                    <li>
                        <a href="faq.html">Informatique</a>
                    </li>
                    <li>
                        <a href="knowledge-base.html">Mécanique</a>
                    </li>
                    <li>
                        <a href="articles.html">Eléctrique</a>
                    </li>
                    <li style="float: right">
                        <a href="#">
                            <i class="fa fa-key"></i> Login</a>
                    </li>
                    <li style="float: right">
                        <a href="#">
                            <i class="fa fa-pencil"></i> Sign Up</a>
                    </li>
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
                <a class="buttonsearch btn btn-info btn-lg" type="submit">Search</a>
            </form>
        </div>
    </div>
    <!-- END SEARCH FIELD AREA -->