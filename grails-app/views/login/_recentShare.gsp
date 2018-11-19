%{--<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:form class="LinkSharing" url="controller:'resource',action:'topPost';">
    </g:form>
</head>--}%

<body>
<div class="col-sm-12"><div class="panel panel-primary">
    <div class="panel-heading">Recent Shares</div>

    <div class="panel-body" style="height: 130px; width: 100%;">
        <g:each in="${recentShares}" var="resource">

            <div class="media">
                <div class="media-left">
                    <asset:image src="Avatar.png" class="media-object" style="width:90px; border: 1px solid black;"/>
                </div>

                <div class="media-body">
                    <h4 class="media-heading">${resource.name}</h4>

                    <p>Java</p>

                    <div><a href="#" style="  color: red; "><i class="fab fa-google-plus-g"></i></a>  <a href="#"
                                                                                                         style="  color: blue; "><i
                                class="fab fa-facebook-square"></i></a>   <a href="#" style="  color: blue; "><i
                            class="fab fa-twitter"></i></a>

                        <p style="text-align: right;margin-top: -20px;"><a>View post</a></p></div>
                </div>
            </div>
            <br>
            <hr>
        </g:each>
    </div>
</div>
</div>

</body>
</html>