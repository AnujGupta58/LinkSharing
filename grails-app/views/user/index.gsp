<!doctype html>
<html>
<head>
    <title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
    <meta name="layout" content="main">
    <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
    <g:form class="LinkSharing" url="controller:'user',action:'index';">
    </g:form>
</head>
<body>
<div class="col-md-4">
    <g:render template="info"/>
</div>
<div class="col-md-8">
 %{--   <g:render template="/topic/showTopic"/>--}%
    <g:render template="/topic/trendingTopic"/>
</div>
</body>
</html>
