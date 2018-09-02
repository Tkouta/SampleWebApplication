<%-- 
    Document   : profile
    Created on : 2018/07/10, 18:59:17
    Author     : 康太
--%>

<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Optional"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>自己紹介</title>
    <style type="text/css">
        <!--
        BODY{
            background-image:url("C:/Java_practice/background.jpg");
            background-repeat: norepeat;
            background-position: 50% 50%;
            background-attachment: fixed;
        }
        -->
    </style>
    </head>
    <body>
        <%
            // Servletのデータ受け取り
            request.setCharacterEncoding("UTF8");
            String age = (String) request.getAttribute("age");
        %>
        <br>
        <font size="7">皆様はじめまして！</font><br><br>
        HS21から出向で来た<font color="red">高橋康太</font>といいます。<br>
        よろしくお願いします。<br><br>
        <font size="5">プロフィール</font><br>
        <hr>
        <div style="float:left;">
            名前：<br><br>
            年齢：<br><br>
            出身地：<br><br>
            出身大学：<br><br>
        </div>
        <div style="float:left;">
            <font color="red">高橋康太</font><br><br>
            <font color="red"><%= age %>歳</font><br><br>
            <font color="red">千葉県柏市</font><br><br>
            <font color="red">東邦大学理学部情報科学科</font><br><br>
        </div>
        <div style="clear:both;"></div>
        <hr><br>
        以下の項目は長いので、リンクにしました。<br>
        よろしければ見ていってください。<br><br>
        <a href="http://10.230.95.136.81/~administrator/2017/takahashi/Syumi_takahashi.html">趣味<br>
        <a href="http://10.230.95.136.81/~administrator/2017/takahashi/SukiKirai_takahashi.html">好き嫌い<br>
        <a href=\http://10.230.95.136.81/~administrator/2017/takahashi/PR_takahashi.html">PR<br>
    </body>
</html>