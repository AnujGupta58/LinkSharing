<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:form class="LinkSharing" url="controller:'resource',action:'show';">
    </g:form>
</head>

<body>
%{--<div class="col-md-6">--}%
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
                    <span class="text-primary">50</span>
                </div>

                <div class="col-lg-3">
                    <span class="text-muted">Topics</span>
                    <span class="text-primary">50</span>
                </div>
            </div>
        </div>
    </div>
%{--</div>--}%
</body>
</html>