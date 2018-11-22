<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:form class="LinkSharing" url="controller:'resource',action:'topPost';">
    </g:form>
</head>
<body>
<div class="col-sm-12"><div class="panel panel-primary">
    <div class="panel-heading">Top Posts<p>
        <div class="dropdown" style="float: right; margin-top: -25px;">
            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                Dropdown button
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Link 1</a><br>
                <a class="dropdown-item" href="#">Link 2</a><br>
                <a class="dropdown-item" href="#">Link 3</a><br>
            </div>
        </div>
    </div>
    <div class="panel-body">
        <g:each in="${topPosts}" var="topPost">
        <div class="media">
            <div class="media-left">
                <asset:image src="Avatar.png" class="media-object" style="width:90px; border: 1px solid black;"/>
            </div>
            <div class="media-body">
                <h4 class="media-heading">${topPost.topicName}</h4>
                <p>${topPost.description}</p>
                <div><a href="#" style="  color: red; "> <i class="fab fa-google-plus-g"></i></a>   <a href="#" style="  color: blue; "><i class="fab fa-facebook-square"></i></a>    <a href="#" style="  color: blue; "><i class="fab fa-twitter"></i></a>
                    <p style="text-align: right;margin-top: -20px"><a>View post</a></p> </div>
            </div>
        </div>
        <br>

        </g:each>
    </div>
</div>
</div>
</body>
</html>
