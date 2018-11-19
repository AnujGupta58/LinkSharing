<!DOCTYPE html>
<html lang="en">
<head>
    <title>Show Resource</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <meta name="layout" content="main">
</head>

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

                            <div class="form-group" id="rating-ability-wrapper">
                                <g:form controller="resourceRating" action="save" method="post">
                                    <label class="control-label">
                                        <span class="field-label-info"></span>
                                        <input type="hidden" id="selected_rating" name="selected_rating" value="score"
                                               required="required">
                                    </label>
                                    <button type="button" class="btnrating btn btn-default btn-lg" data-attr="1"
                                            name="score" value="1">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </button>
                                    <button type="button" class="btnrating btn btn-default btn-lg" data-attr="2"
                                            name="score" value="2">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </button>
                                    <button type="button" class="btnrating btn btn-default btn-lg" data-attr="3"
                                             name="score" value="3">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </button>
                                    <button type="button" class="btnrating btn btn-default btn-lg" data-attr="4"
                                             name="score" value="4">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </button>
                                    <button type="button" class="btnrating btn btn-default btn-lg" data-attr="5"
                                             name="score" value="5">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </button>
                                    <g:hiddenField name="score" value="${posts.resourceId}"/>
                                    <input type="submit" value="score">
                                </g:form>
                            </div>
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