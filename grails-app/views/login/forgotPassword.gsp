<!DOCTYPE html>
<html lang="en">
<head>

    <title></title>
    <meta name="layout" content="main">

</head>

<body>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading" style="background: #2e6da4">
            <h3>Forgot Password</h3>
        </div>
        <div class="panel-body">
            <g:form controller="login" action="forgotPassword">
                <div class="form-group col-lg-10">
                    <label>Enter your Username</label>
                    <input class="form-control" type="text" name="email" placeholder="Enter your Username">
                </div>

                <div class="form-group col-lg-10">
                    <label>Enter your Password</label>
                    <input class="form-control" type="password" name="password" placeholder="Confirm new Password">
                </div>

                <div class="form-group col-lg-10">
                    <label>Confirm new Password</label>
                    <input class="form-control" type="password" name="confirmPassword" placeholder="Confirm new Password">
                </div>

                <div class="form-group col-lg-10">
                    <input type="submit" class="form-control btn-primary" style="background:#007efc">
                </div>

            </g:form>
        </div>
    </div>
</div>
</body>
</html>
