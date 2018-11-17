%{--
<%@ page import="com.ttn.linksharing.VO.TopicVO" %>
<div class="panel panel-default">
    <div class="panel panel-heading col-lg-12">
        <h3>${TopicVO.name}</h3>
    </div>

    <div class="panel-body">
        <g:each in="">

        </g:each>

    </div>

</div>--}%
<g:if test="${session.user}">
<div class="panel panel-default">
    <div class="panel-heading">
        Trending Topics
    </div>
    <div class="panel-body">
        <div class="row" style="padding-bottom:10px">
            <div class="col-lg-2">
                <asset:image src="Avatar.png" class="img-responsive"/>
            </div>
            <div class="col-lg-10">
                <div class="text-primary">
                    <a class="hyperlink" href="#">Grails</a>
                </div>
                <div class="col-lg-4" style="padding-left: 0px">
                    <span class="text-muted">${session.user.email}</span>
                    <a href="#" class="hyperlink">Unsubscribe</a>
                </div>
                <div class="col-lg-4">
                    <span class="text-muted">Subscriptions</span>
                    <span class="text-primary">50</span>
                </div>
                <div class="col-lg-2">
                    <span class="text-muted">Topics</span>
                    <span class="text-primary">50</span>
                </div>
            </div>
        </div>
        <hr>
      %{--  <div class="row">
            <div class="col-lg-2">
                <asset:image src="Avatar.png" class="img-responsive"/>
            </div>
            <div class="col-lg-10">
                <div class="col-lg-6" style="padding-left: 0px">
                    <input type="text" placeholder="Grails">
                </div>
                <div class="col-lg-3">
                    <button type="submit">save</button>
                </div>
                <div class="col-lg-3">
                    <button type="reset">cancel</button>
                </div>
                <div class="text-primary">
                    <a class="hyperlink" href="#">Grails</a>
                </div>
                <div class="col-lg-4" style="padding-left: 0px">
                    <span class="text-muted">@Anuj</span>
                    <a href="#" class="hyperlink">Unsubscribe</a>
                </div>
                <div class="col-lg-4">
                    <span class="text-muted">Subscriptions</span>
                    <span class="text-primary">50</span>
                </div>
                <div class="col-lg-2">
                    <span class="text-muted">Topics</span>
                    <span class="text-primary">50</span>
                </div>
            </div>
            <div class="col-lg-7 col-lg-offset-1">
                <span class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Seriousness
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Very Serious</a></li>
                        <li><a href="#">Serious</a></li>
                        <li><a href="#">Less Serious</a></li>
                    </ul>
                </span>
                <span class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Scope
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Private</a></li>
                        <li><a href="#">Public</a></li>
                    </ul>
                </span>
            </div>
            <div class="col-lg-4">
                <span style="padding-left: 1px"><i class="far fa-envelope fa-2x"></i></span>
                <span style="padding-left: 10px"><i class="far fa-file fa-2x"></i></span>
                <span style="padding-left: 10px"><i class="far fa-trash-alt fa-2x"></i></span>

            </div>
        </div>--}%
    </div>
</div>
    </g:if>