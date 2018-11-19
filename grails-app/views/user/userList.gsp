<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User list</title>
    <meta name="layout" content="main"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <div class="col-lg-12">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>topicCount</th>
                <th>resourceCount</th>
                <th>subscriptionCount</th>
                <th>Active</th>
                <th>Manage</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${userList}" var="users">
                <tr>
                    <td>${users.name}</td>
                    <td>${users.email}</td>
                    <td>${users.topicCount}</td>
                    <td>${users.resourceCount}</td>
                    <td>${users.subscriptionCount}</td>
                    <td>${users.isActive}</td>
                    <td><a href="${createLink(controller: 'user', action: 'changeActive', id: "${users.id}")}">
                        <g:if test="${users.isActive}">
                            Deactivate
                        </g:if>
                        <g:else>
                            Activate
                        </g:else>
                    </a></td>
                </tr>
            </g:each>
            </tbody>
        </table>

    </div>
</div>
</body>
</html>
%{--
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta name="layout" content="main"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Bordered Table</h2>
    <p>The .table-bordered class adds borders to a table:</p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>John</td>
            <td>Doe</td>
            <td>john@example.com</td>
        </tr>
        <tr>
            <td>Mary</td>
            <td>Moe</td>
            <td>mary@example.com</td>
        </tr>
        <tr>
            <td>July</td>
            <td>Dooley</td>
            <td>july@example.com</td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>
--}%


%{--<div class="panel">
         <div class="panel-body">
             <div class="col-lg-2">
                 ${users.name}
             </div>
             <div class="col-lg-2">
                 ${users.email}
             </div>
             <div class="col-lg-2">
                 ${users.isActive}
             </div>
             <div class="col-lg-2">
                 ${users.topicCount}
             </div>
             <div class="col-lg-2">
                 ${users.subscriptionCount}
             </div>
             <div class="col-lg-2">
                 ${users.resourceCount}
             </div>

         </div>
     </div>--}%