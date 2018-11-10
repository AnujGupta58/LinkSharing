<!doctype html>
<html>
<head>
    <title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
    <meta name="layout" content="main">
    <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
    <g:form class="LinkSharing" url="controller:'login',action:'index';">
    </g:form>
</head>

<body>
<div class="col-md-6">
    <g:render template="/login/recentShare"/>
    <g:render template="/login/topPost"/>
</div>

<div class="col-md-6">
    <g:render template="/login/login"/>
    <g:render template="/login/register"/>

</div>
</body>
</html>
