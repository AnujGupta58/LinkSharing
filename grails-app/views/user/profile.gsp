<!<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <meta name="layout" content="main">
</head>

<body>
<div class="container">
    <div class="col-lg-6">
        <div class="panel panel-primary col-lg-12">
            <div class="panel-body">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-3">
<asset:image src="Avatar.png" class="img-responsive"/>
</div>

<div class="col-lg-9">
    ${userInfo.name}
    <span class="text-muted col-lg-12">@${userInfo.email}</span>

    <div class="row">
        <h6 class="text-muted col-sm-6">Subscriptions
            <p class="text-primary">${userInfo.subscriptionCount}</p>
        </h6>
        <h6 class="text-muted col-sm-6">Topics
            <p class="text-primary">${userInfo.topicCount}</p>
        </h6>
    </div>
</div>
</div>
</div>
</div>
</div>

<div class="col-lg-12">
<div class="panel panel-primary">
<div class="panel-heading">
Topics
</div>

<div class="panel-body">
<g:each in="${(userTopicList)}" var="topic">
    <div class="row">
        <div class="col-lg-2">
    <asset:image src="Avatar.png" class="img-responsive"/>
    </div>

    <div class="col-lg-10">
    <g:form controller="topic" action="editTopic">
        <div class="col-lg-6" style="padding-left: 5px">
            <input type="text" class="form-control" placeholder="Topic Name" name="name">
            <input type="hidden" class="form-control" name="id" value="${topic.id}"/>
        </div>

        <div class="col-lg-3">
            <button type="submit">save</button>
        </div>

        <div class="col-lg-3">
            <button type="reset">cancel</button>
        </div>

        <div class="text-primary col-lg-12">
            <a class="hyperlink" href="#">${topic.name}</a>
        </div>

        <div class="col-lg-5" style="padding-left: 0px">
            <span class="text-muted">@${topic.email}</span>
            %{--<a href="#" class="hyperlink">Unsubscribe</a>--}%
        </div>

        <div class="col-lg-3">
            <span class="text-muted">Subscriptions</span>
            <span class="text-primary">${topic.subscriptionsCount}</span>
        </div>

        <div class="col-lg-2">
            <span class="text-muted">Resources</span>
            <span class="text-primary">${topic.resourcesCount}</span>
        </div>


        <div class="col-lg-12">
            <div class="col-lg-4">
                <span class="text-muted">Visibilty</span>
    %{--<span class="text-primary">${topic.visibility}</span>--}%
    %{--<g:form controller="topic" action="editTopic">--}%
            <g:select name="visibility" value="${topic}"
                      from="${com.ttn.linksharing.enumeration.Visibility.values()}"/>

            </div>

        %{--<span class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button"
                    data-toggle="dropdown">Seriousness
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="#">Very Serious</a></li>
                <li><a href="#">Serious</a></li>
                <li><a href="#">Less Serious</a></li>
            </ul>
        </span>--}%
        %{--<span class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button"
                    data-toggle="dropdown">Scope
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="#">Private</a></li>
                <li><a href="#">Public</a></li>
            </ul>
        </span>--}%
            <div class="col-lg-4">
                <g:render template="/user/sendInvitation"/>
                <g:render template="/resource/documentResource"/>
                <g:form controller="topic" action="delete">
                    <div class="form-group form-inline">
                        <input type="hidden" name="id" value="${topic.id}"/>
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </div>
                </g:form>
            </div>
          %{--  <div class="col-lg-4">
                <span class="text-muted">Visibilty</span>
                <g:select name="visibility" value="${topic.visibility}"
                          from="${com.ttn.linksharing.enumeration.Visibility.values()}"/>
            </div>--}%
            </div>
        </g:form>

        </div>

        </div>
        <hr>
    </g:each>
    </div>
</div>
</div>

    <div class="col-lg-12">
        <div class="panel panel-primary">
            <div class="panel-heading">
                Resource/Post
            </div>

            <div class="panel-body">
                <div class="col-lg-12">
                    <g:each in="${(userResourceList)}" var="resource">
                        <div class="col-lg-9">
                            <div class="col-lg-6">
                                <asset:image src="Avatar.png" class="img-responsive" height="40px" width="40px"/>
                            </div>

                            <div class="col-lg-3">
                                <a href="${createLink(controller: 'topic', action: 'show', id: "${resource.topicId}")}">${resource.topicName}</a>
                            </div>
                        </div>

                        <div class="col-lg-3">
                            ${resource.createdBy}
                        </div>

                        <div class="col-lg-12 pull-right">
                            <g:form controller="resource" action="updateDescription" id="${resource.resourceId}">
                                <textarea class="col-lg-offset-2" name="description">
                                    ${resource.description}
                                </textarea>
                                <button type="submit" class="btn btn-default">Save</button>
                            </g:form>
                        </div>
                        <hr>
                    </g:each>

                </div>
            </div>

        </div>
    </div>
    </div>

    <div class="col-lg-6">
        <div class="col-sm-12">
            <div class="panel panel-primary">
                <div class="panel-heading">Profile Update</div>

                <div class="panel-body" style=" width: auto;">
                    <g:form controller="user" action="updateUserInfo">
                        <div class="form-group col-sm-12">

                            <label for="firstName">First Name*</label>
                            <input type="text" name="firstName" value="${firstName}" class="form-control" id="firstName"
                                   placeholder="Enter First Name">
                        </div>

                        <div class="form-group col-sm-12">
                            <label for="lastName">Last Name*</label>
                            <input type="text" name="lastName" value="${lastName}" class="form-control" id="lastName"
                                   placeholder="Enter last Name">
                        </div>

                        <div class="form-group col-sm-12">
                            Photo:<br>
                            <input type="file" name="fileupload" value="fileupload" id="fileupload"><br><br>
                        </div>

                        <div class="form-group col-sm-12">
                            <button type="submit" class="btn btn-primary"
                                    style="float: right; margin-top: -30px;">Update</button>
                        </div>

                    </g:form>
                </div>
            </div>
        </div>

        <div class="col-lg-12">
            <div class="panel panel-primary">
                <div class="panel-heading">Change Password</div>

                <div class="panel-body" style=" width: auto;">
                    <g:form controller="user" action="changePassword">
                        <div class="form-group col-sm-12">
                            <label for="password">Password*</label>
                            <input type="password" name="password" value="${password}" class="form-control"
                                   id="password"
                                   placeholder="Enter Password">
                        </div>

                        <div class="form-group col-sm-12">
                            <label for="confirmpassword">Confirm Password*</label>
                            <input type="password" name="confirmpassword" value="${confirmpassword}"
                                   class="form-control" id="confirmpassword"
                                   placeholder="Enter Confirm Password">
                        </div>

                        <div class="form-group col-sm-12">
                            <button type="submit" class="btn btn-primary"
                                    style="float: right ;">Update</button>
                        </div>

                    </g:form>
                </div>
            </div>
        </div>
    </div>
    </div>

    </body>
    </html>
