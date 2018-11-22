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
            <g:each in="${trendingTopics}" var="topic">
                <div class="row" style="padding-bottom:10px">
                    <div class="col-lg-2">
                        <asset:image src="Avatar.png" class="img-responsive"/>
                    </div>

                    <div class="col-lg-10">
                        <div class="text-primary">
                            <a class="hyperlink" href="#">${topic.name}</a>
                        </div>

                        <div class="col-lg-4" style="padding-left: 0px">
                            <span class="text-muted">${topic.createdBy}</span>
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
            </g:each>
        </div>
    </div>
</g:if>