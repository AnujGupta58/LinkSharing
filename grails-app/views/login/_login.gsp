<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:form class="LinkSharing" url="controller:'login',action:'loginhandler';">
    </g:form>
</head>
<body>
<div class="col-sm-12"><div class="panel panel-primary">
    <div class="panel-heading">Email</div>

    <div class="panel-body">
        <g:form controller="login" action="loginhandler">
            <div class="form-group">
                <label for="username">Email address*</label>
                <input type="text" name="username" class="form-control" id="username" value="${username}"
                       placeholder="Enter email" required>
            </div>

            <div class="form-group">
                <label for="password">Password*</label>
                <input type="password" name="password" class="form-control" id="password" value="${password}"
                       placeholder="Password" required>
            </div>

            <div><a href=${createLink(controller: 'login',action: 'forgotPasswordPage')}>Forgot Password</a>
                <button type="submit" class="btn btn-primary" style="float: right; margin-top: -30px;">Submit</button>
            </div>
        </g:form>
    </div>
</div>
</div>
</body>
</html>