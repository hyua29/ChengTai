<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Page Not Found</title>

    <style media="screen">
        body { background: #ECEFF1; color: rgba(0,0,0,0.87); font-family: Roboto, Helvetica, Arial, sans-serif; margin: 0; padding: 0; }
        #message { background: white; max-width: 360px; margin: 100px auto 16px; padding: 32px 24px 16px; border-radius: 3px; }
        #message h3 { color: #888; font-weight: normal; font-size: 16px; margin: 16px 0 12px; }
        #message h2 { color: #ffa100; font-weight: bold; font-size: 16px; margin: 0 0 8px; }
        #message h1 { font-size: 22px; font-weight: 300; color: rgba(0,0,0,0.6); margin: 0 0 16px;}
        #message p { line-height: 140%; margin: 16px 0 24px; font-size: 14px; }
        #message a { display: block; text-align: center; background: #039be5; text-transform: uppercase; text-decoration: none; color: white; padding: 16px; border-radius: 4px; }
        #message, #message a { box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24); }
        #load { color: rgba(0,0,0,0.4); text-align: center; font-size: 13px; }
        @media (max-width: 600px) {
            body, #message { margin-top: 0; background: white; box-shadow: none; }
            body { border-top: 16px solid #ffa100; }
        }
    </style>
</head>
<body>
<div id="message">
    <h2>${errorCode}</h2>
    <h1>${errorMsg}</h1>
    <h3>Why am I seeing this?</h3>
    <p>Because you just broke our app. CONGRATS!!!</p>
</div>
</body>
</html>