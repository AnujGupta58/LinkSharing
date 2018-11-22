<!DOCTYPE html>
<html lang="en">
<head>
    <title>Show Resource</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
    <meta name="layout" content="main">
</head>
<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:500,100,300,700,400);
</style>

<body>
<div class="container">
    <div class="col-lg-6">
        <div class="panel panel-default">
            <div class="panel-body">
                <g:each in="${resourceDisplay}" var="posts">
                    <div class="row" style="padding-bottom: 10px">
                        <div class="col-lg-2">
                            <asset:image src="Avatar.png" class="img-responsive"/>
                        </div>

                        <div class="col-lg-10">
                            <div class="text">${posts.createdByName}
                                <p class="text-muted">@${posts.createdByEmail}</p>

                                <g:form controller="resourceRating" action="save" method="post">
                                    <div class="stars">
                                        <input class="star star-1" id="star-1" type="radio" name="star"
                                               value="1"/>
                                        <label class="star star-1" for="star-1"></label>
                                        <input class="star star-2" id="star-2" type="radio" name="star"
                                               value="2"/>
                                        <label class="star star-2" for="star-2"></label>
                                        <input class="star star-3" id="star-3" type="radio" name="star"
                                               value="3"/>
                                        <label class="star star-3" for="star-3"></label>
                                        <input class="star star-4" id="star-4" type="radio" name="star"
                                               value="2"/>
                                        <label class="star star-4" for="star-4"></label>
                                        <input class="star star-5" id="star-5" type="radio" name="star"
                                               value="5"/>
                                        <label class="star star-5" for="star-5"></label>
                                        <g:hiddenField name="id" value="${posts.resourceId}"/>
                                        <input type="submit" value="Rate">

                                    </div>
                                </g:form>
                            </div>
                            <span class="text-primary" style="float: right">${posts.topicName}</span>

                            <div class="text">
                                <p>
                                    ${posts.description}
                                </p>
                            </div>

                            <div>
                                <div class="col-lg-4" style="padding-left: 0px;padding-right: 0px">
                                    <!-- <i class="fab fa-facebook fa-2x"> </i> -->
                                    <!-- <i class="fab fa-tumblr fa-2x"> </i> -->
                                    <span style="padding-left: 1px"><i class="fab fa-facebook fa-2x"></i></span>
                                    <span style="padding-left: 10px"><i class="fab fa-tumblr fa-2x"></i></span>
                                    <span style="padding-left: 10px"><i class="fab fa-google-plus-g fa-2x"></i></span>
                                </div>

                                <div class="col-lg-8">
                                    %{--<g:if test="${posts.isLink}">--}%
                                    <div class="col-lg-2 col-lg-offset-2"
                                         style="padding-left: 0px;padding-right: 0px;">
                                        <a href="#" class="text-primary"
                                           style="text-decoration: underline;">View Full Size</a>
                                    </div>
                                    %{--</g:if>--}%
                                    %{--<g:else>--}%
                                    <div class="col-lg-2"
                                         style="padding-left: 0px;padding-right: 0px;">
                                        <a href="#" class="text-primary"
                                           style="text-decoration: underline;">Download</a>
                                    </div>
                                    %{--</g:else>--}%

                                    <div class="col-lg-2" style="padding-left: 20px;padding-right: 0px;">
                                        <a href="#" class="text-primary"
                                           style="text-decoration: underline;">Mark As Read</a>
                                    </div>

                                    <div class="col-lg-2" style="padding-left: 20px;padding-right: 0px;">
                                        <a href="#" class="text-primary"
                                           style="text-decoration: underline;">View Post</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr>
                </g:each>
            </div>
        </div>
    </div>

    <div class="col-lg-6">

    </div>
</div>
</body>
</html>