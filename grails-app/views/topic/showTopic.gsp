<%@ page import="com.ttn.linksharing.VO.TopicVO" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:form class="LinkSharing" url="controller:'topic',action:'show';">
    </g:form>
</head>
<div class="container">
    <div class="col-lg-6">
        <div class="col-lg-12">
            <div class=" panel panel-default">
                <div class="panel-heading">
                    <p>
                    <h3 style="color:white">"${topicVO}"</h3>
                </div>

                <div class="panel-body  ">
                    <div class="col-lg-12">
                        <div class="col-sm-3">
                            topicVO.createdBy
                        </div>
                        <div class="col-lg-9">
                            <div class="col-lg-12">
                                <h5><a href="#">${TopicVO.getName()}</a> %{--<span>(${T  opicVO.visibility})</span>--}%</h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>