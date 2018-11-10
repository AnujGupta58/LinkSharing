<!doctype html>
<html lang="en" class="no-js">
<head>
    %{--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>--}%
    %{--<meta http-equiv="X-UA-Compatible" content="IE=edge"/>--}%
    %{--<title>--}%
        %{--<g:layoutTitle default="Grails"/>--}%
    %{--</title>--}%
    %{--<meta name="viewport" content="width=device-width, initial-scale=1"/>--}%
    %{--<asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>--}%
    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="customstyle.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js" integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ" crossorigin="anonymous"></script>

    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="customstyle.css"/>

    <g:layoutHead/>
</head>

<body>
<header class="page-header well" style="padding-bottom: 50px;margin-left: 10px;margin-right: 10px;">
    <div class="col-lg-4">
        <span>
            <a class="text-primary" href="${createLink(controller: 'login',action:'index')}" style="text-decoration: underline"><h3>Link Sharing</h3></a>
        </span>

    </div>
    <div class="col-lg-8">
        <div class="col-lg-5">
            <span class="search">
                <span>
                    <i class=" fa fa-times"></i>
                </span>
                <span class="fa fa-search"></span>
                <input placeholder="Search term">
            </span>
        </div>

        <g:if test="${session.user}">
            <g:render template="/topic/createTopic"/>

            <g:render template="/user/sendInvitation"/>

            <g:render template="/resource/linkResource"/>

            <g:render template="/resource/documentResource"/>

            <span class="col-lg-3 dropdown">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="fas fa-user" style="font-size:24px"></i>
                        ${session.user}
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">profile</a></li>
                    <li><a href="#">users</a></li>
                    <li><a href="#">Topic</a></li>
                    <li><a href="#">post</a></li>
                    <li><a href="#">logout</a></li>
                </ul>
            </span>
            </div>

        </g:if>

</header>

<div class="body">

    <g:layoutBody/>
</div>

<div class="footer" role="contentinfo">
    Powered By TTN
</div>
<asset:javascript src="application.js"/>
</body>
</html>
