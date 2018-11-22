<%@ page import="com.ttn.linksharing.VO.TopicVO" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta name="layout" content="main">
</head>

<div class="container">
    <div class="col-lg-6">
        <div class="col-lg-12">
            <div class=" panel panel-default">
                <div class="panel-heading">
                    <p>

                    <h3 style="color:black">Topic : "${topicVO.name}"</h3>
                </div>

                <div class="panel-body  ">
                    <div class="col-lg-3">
                        <asset:image src="Avatar.png" class="img-responsive"/>
                    </div>

                    <div class="col-lg-9">
                        <div class="col-lg-12">
                            <div class="col-lg-6">
                                ${topicVO.name}(${topicVO.visibility})
                            </div>

                            <div class="col-lg-6">
                                ${topicVO.createdBy}
                            </div>
                        </div>


                        <div class="col-lg-12">
                            %{--<div class="row">--}%
                            <h6 class="text-muted col-sm-6">Subscriptions
                                <p class="text-primary">${topicVO.subscriptionsCount}</p>
                            </h6>
                            <h6 class="text-muted col-sm-6">Resources
                                <p class="text-primary">${topicVO.resourcesCount}</p>
                            </h6>
                            %{--</div>--}%
                        </div>
                        %{--<div class="col-lg-12">
                            <g:if test="${topicVO.isSubscribed}">
                                <g:link controller="subscription" action="delete" id="${topicVO}">Unsubscribe</g:link>
                            </g:if>
                            <g:else>
                                <g:link controller="subscription" action="delete">Unsubscribe</g:link>
                            </g:else>
                        </div>--}%

                    </div>
                </div>
            </div>
        </div>


        <div class="col-lg-12">
            <div class=" panel panel-default">
                <div class="panel-heading">
                    <p>

                    <h3 style="color:black">Users : "${topicVO.name}"</h3>
                </div>

                <div class="panel-body  ">
                    <div class="col-lg-3">
                        <asset:image src="Avatar.png" class="img-responsive"/>
                    </div>
                    <g:each in="${subscribedUsersList}" var="users">
                        <div class="col-lg-9">
                            <div class="col-lg-12">
                                <div class="col-lg-6">
                                    <h4 class="text-primary">${users.name}
                                        <p class="text-muted">@${users.email}</p>
                                    </h4>
                                </div>

                                <div class="col-lg-6">

                                </div>
                            </div>


                            <div class="col-lg-12">
                                %{--<div class="row">--}%
                                <h6 class="text-muted col-sm-6">Subscriptions
                                    <p class="text-primary">${users.subscriptionCount}</p>
                                </h6>
                                <h6 class="text-muted col-sm-6">Resources
                                    <p class="text-primary">${users.resourceCount}</p>
                                </h6>
                                %{--</div>--}%
                            </div>
                            %{--<div class="col-lg-12">
                                <g:if test="${topicVO.isSubscribed}">
                                    <g:link controller="subscription" action="delete" id="${topicVO}">Unsubscribe</g:link>
                                </g:if>
                                <g:else>
                                    <g:link controller="subscription" action="delete">Unsubscribe</g:link>
                                </g:else>
                            </div>--}%

                        </div>
                    </g:each>
                </div>
            </div>
        </div>
    </div>


    <div class="col-lg-6">
        <g:if test="${session.user}">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Post : ${topicVO.name}
                </div>

                <div class="panel-body">
                    <g:each in="${topicResource}" var="posts">
                        <div class="row" style="padding-bottom: 10px">
                            <div class="col-lg-2">
                                <asset:image src="Avatar.png" class="img-responsive"/>
                            </div>

                            <div class="col-lg-10">
                                <span class="text">${posts.createdByName}
                                    <p class="text-muted">@${posts.createdByEmail}</p></span>
                                <span class="text-primary" style="float: right">Topic : ${posts.topicName}</span>

                                <div class="text">
                                    <p>
                                        Description : ${posts.description}
                                    </p>
                                </div>

                                <div>
                                    <div class="col-lg-4" style="padding-left: 0px;padding-right: 0px">
                                        <!-- <i class="fab fa-facebook fa-2x"> </i> -->
                                        <!-- <i class="fab fa-tumblr fa-2x"> </i> -->
                                        <span style="padding-left: 1px"><i class="fab fa-facebook fa-2x"></i></span>
                                        <span style="padding-left: 10px"><i class="fab fa-tumblr fa-2x"></i></span>
                                        <span style="padding-left: 10px"><i class="fab fa-google-plus-g fa-2x"></i>
                                        </span>
                                    </div>

                                    <div class="col-lg-8">
                                        <g:if test="${posts.isLink}">
                                            <div class="col-lg-2 col-lg-offset-2"
                                                 style="padding-left: 0px;padding-right: 0px;">
                                                <a href="#" class="text-primary"
                                                   style="text-decoration: underline;">View Link</a>
                                            </div>
                                        </g:if>
                                        <g:else>
                                            <div class="col-lg-2"
                                                 style="padding-left: 0px;padding-right: 0px;">
                                                <a href="#" class="text-primary"
                                                   style="text-decoration: underline;">Download</a>
                                            </div>
                                        </g:else>

                                        <div class="col-lg-2" style="padding-left: 20px;padding-right: 0px;">
                                            <a href="#" class="text-primary"
                                               style="text-decoration: underline;">Mark As Read</a>
                                        </div>

                                        <div class="col-lg-2" style="padding-left: 20px;padding-right: 0px;">
                                            <a href="${createLink(controller: 'resource', action: 'show', id: "${posts.resourceId}")}">View Post</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>
                    </g:each>
                </div>
            </div>
        </g:if>
    </div>
</div>