<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:form class="LinkSharing" url="controller:'resource',action:'show';">
    </g:form>
</head>

<body>
<div class="col-lg-12">
<g:if test="${session.user}">
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="col-lg-3">
                <asset:image src="Avatar.png" class="img-responsive"/>
            </div>

            <div class="col-lg-9">
                <div class="text">
                    <h4>${session.user.getFullName()}</h4>
                </div>

                <div class="text-muted">
                    ${session.user.email}
                </div>

                <div class="col-lg-4" style="    padding-left: 0px;">
                    <span class="text-muted">Subscriptions</span>
                    <ls:subscriptionCount userId="${session.user.id}"/>
                </div>

                <div class="col-lg-3">
                    <span class="text-muted">Topics</span>
                    <ls:topicCount userID="${session.user.id}"/>
                </div>
            </div>
        </div>
    </div>
</g:if>
</div>
</body>
</html>