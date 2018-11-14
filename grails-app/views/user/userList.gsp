<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User list</title>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="container">
    <div class="col-lg-12">
        <g:each in="${}" var="users">
            <div class="panel">
                <div class="panel-body">
                    <div class="col-lg-4">
                        ${users.email}
                    </div>
                    <div class="col-lg-4">
                        ${users.firstName}
                    </div>

                </div>
            </div>
        </g:each>
    </div>
</div>
</body>
</html>