<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    %{--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">--}%
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    %{--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js "></script>--}%
    <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js" integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ" crossorigin="anonymous"></script>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>

<body>
<div class="container">
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

            %{--<g:render template="/user/shareLink"/>--}%

            <g:render template="/resource/linkResource"/>

            <g:render template="/resource/documentResource"/>

       %{--     <div class="col-lg-3 dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                    ${session.user}
                </button>
                <div class="dropdown-menu">
                    <li><g:link controller="login" action="logout">profile</g:link></li>
                    <li><g:link controller="user" action="showAllUsers">users</g:link></li>
                    <li><g:link controller="topic" action="show">topic</g:link></li>
                    <li><g:link controller="resource" action="show">Resources</g:link></li>
                    <li><g:link controller="login" action="logout">post</g:link></li>
                    <li><g:link controller="login" action="logout">logout</g:link></li>
                </div>
            </div>--}%
            <div class="dropdown  col-lg-3" style="padding: 0px">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="fa fa-user"
                                                                              style="font-size:24px"></i>
                    ${session.user.getFullName()}
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><g:link controller="user" action="profile">Profile</g:link></li>
                    %{--<li><g:link controller="topic" action="show">topic</g:link></li>--}%
                    %{--<li><g:link controller="resource" action="show">Resources</g:link></li>--}%
                    %{--<li><g:link controller="login" action="logout">post</g:link></li>--}%
                    <g:if test="${session.user.admin}">
                        <li><g:link controller="user" action="showAllUsers">Users</g:link></li>
                    %{--<li><g:link controller="user" action="showTopics">Topic</g:link></li>--}%
                    %{--<li><g:link controller="resource" action="showPosts">Post</g:link></li>--}%
                    </g:if>
                    <li><g:link controller="login" action="logout">Logout</g:link></li>
                </ul>
            </div>

        </g:if>
    </div>
</header>
</div>

<div style="color: green">${flash.message}</div>
<div style="color: red">${flash.error}</div>
<div class="body">

    <g:layoutBody/>
</div>

<div class="footer" role="contentinfo">
    Powered By TTN
</div>
<asset:javascript src="application.js"/>
</body>
</html>
