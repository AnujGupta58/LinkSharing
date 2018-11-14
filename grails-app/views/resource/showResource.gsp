<!DOCTYPE html>
<html lang="en">
<head>
    <title>Show Resource</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    %{--<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">--}%
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js" integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    <meta name="layout" content="main">
</head>

<body>
<div class="row">
    <div class="col-lg-7">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body no-padding">

                        <div class="col-lg-5">

                                <div class="col-lg-5" >
                                    <asset:image src="Avatar.png" class="img-responsive" height="60px" width="60px"/>
                                </div>
                                <div class="col-lg-7">
                                    ${session.user}
                                    <span class="text-muted">@${session.user.email}</span>
                                </div>

                        </div>
                      %{--  <div class="col-lg-3" style="white-space:normal">

                        </div>--}%
                        <div class="col-lg-7">
                            <div class="col-lg-12">
                                Topic Name
                            </div>
                            <div class="col-lg-12">
                                <div class="row">
                                    <g:if test="${session.user}">
                                    <div class="form-group" id="rating-ability-wrapper">
                                        <g:form controller="resourceRating" action="save" method="post">
                                        <label class="control-label">
                                            <span class="field-label-info"></span>
                                            <input type="hidden" id="selected_rating" name="selected_rating" value="" required="required">
                                        </label>
                                        <button type="button" class="btnrating btn btn-default btn-lg" data-attr="1" id="rating-star-1">
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btnrating btn btn-default btn-lg" data-attr="2" id="rating-star-2">
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btnrating btn btn-default btn-lg" data-attr="3" id="rating-star-3">
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btnrating btn btn-default btn-lg" data-attr="4" id="rating-star-4">
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btnrating btn btn-default btn-lg" data-attr="5" id="rating-star-5">
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                        </button>
                                        </g:form>
                                    </div>
                                    </g:if>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-12">
                            <div class="col-lg-6">
                                Description
                            </div>
                            <div class="col-lg-6">
                                <i class="fa fa-facebook-square fa-lg" aria-hidden="true"></i>
                                <i class="fa fa-google-plus fa-lg" aria-hidden="true"></i>
                                <i class="fa fa-twitter-square fa-lg" aria-hidden="true"></i>
                                <span class="pull-right" style="margin-right: 0px;color: #007efc">
                                    <g:if test="${session.user}">
                                            <a href="${createLink(controller:'resource',action:'viewLink',id:id)}">View Link</a>
                                            <a href="${createLink(controller:'resource',action:'downloadDocument',id:id)}">Download</a>
                                            <a href="${createLink(controller:'resource',action:'delete',id:id)}">Delete</a>
                                    </g:if>
                                </span>
                            </div>
                        </div>

                </div>
            </div>
        </div>

    </div>
    <div class="col-lg-5">
        <div class="col-lg-12">
            <g:render template="/topic/trendingTopic">
            </g:render>
        </div>
    </div>
</div>
</body>
</html>