<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:form class="LinkSharing" url="controller:'login',action:'register';">
    </g:form>
</head>

<body>
<div class="col-sm-12">
    <div class="panel panel-primary">
        <div class="panel-heading">Register</div>

        <div class="panel-body" style="height: 500px; width: auto;">
            <g:form controller="login" action="register">
                <div class="form-group col-sm-12">

                    <label for="firstName">First Name*</label>
                    <input type="text" value="${firstName}" class="form-control" id="firstName"
                           placeholder="Enter First Name">
                </div>

                <div class="form-group col-sm-12">
                    <label for="lastName">Last Name*</label>
                    <input type="text" value="${lastName}" class="form-control" id="lastName"
                           placeholder="Enter last Name">
                </div>

                <div class="form-group col-sm-12">
                    <label for="email">Email*</label>
                    <input type="email" value="${email}" class="form-control" id="email" placeholder="Enter Email">
                </div>

                <div class="form-group col-sm-12">
                    <label for="password">Password*</label>
                    <input type="password" value="${password}" class="form-control" id="password"
                           placeholder="Enter Password">
                </div>

                <div class="form-group col-sm-12">
                    <label for="confirmpassword">Confirm Password*</label>
                    <input type="password" value="${confirmpassword}" class="form-control" id="confirmpassword"
                           placeholder="Enter Confirm Password">
                </div>

                <div class="form-group col-sm-12">
                    Photo:<br>
                    <input type="file" name="fileupload" value="fileupload" id="fileupload"><br><br>
                </div>

                <div class="form-group col-sm-12">
                    <button type="submit" class="btn btn-primary"
                            style="float: right; margin-top: -30px;">Submit</button>
                </div>

            </g:form>
        </div>
    </div>
</div>
</body>
</html>



