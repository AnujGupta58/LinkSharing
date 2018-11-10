%{--
<!doctype html>
<html lang="en" class="no-js">
<head>
    --}%
%{--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>--}%%{--

    --}%
%{--<meta http-equiv="X-UA-Compatible" content="IE=edge"/>--}%%{--

    --}%
%{--<title>--}%%{--

    --}%
%{--<g:layoutTitle default="Grails"/>--}%%{--

    --}%
%{--</title>--}%%{--

    --}%
%{--<meta name="viewport" content="width=device-width, initial-scale=1"/>--}%%{--

    --}%
%{--<asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>--}%%{--

    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="customstyle.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js" integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ" crossorigin="anonymous"></script>

    <g:layoutHead/>
</head>

<body>
<header class="page-header well" style="padding-bottom: 50px;margin-left: 10px;margin-right: 10px;">
    <div class="col-lg-4">
        <span>
            <a class="text-primary" href="#" style="text-decoration: underline"><h3>Link Sharing</h3></a>
        </span>
    </div>

    <div class="col-lg-8">
        <div class="col-lg-5">
            <span class="search">
                <span>
                    <i class=" fa fa-times"></i>
                </span>
                <span class="fa fa-search"></span>
                <input placeholder="Search term">
            </span>
        </div>

   --}%
%{--     TEMPLATE FOR CREATE TOPIC--}%%{--


        <g:render template="/topic/createTopic"/>

        --}%
%{--     TEMPLATE FOR SEND INVITATION--}%%{--

       <g:render template="/topic/email"/>

        --}%
%{--     TEMPLATE FOR SHARE LINK--}%%{--

        <span class="col-lg-1">
            <a href="#myModal3" data-toggle="modal" data-target="#myModal3">
                <i class="fas fa-link" style="font-size:24px"></i></a>
        </span>

        <div id="myModal3" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Share Link</h4>
                    </div>

                    <div class="modal-body">
                        <form class="form-horizontal" action="#">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="link">Link*:</label>

                                <div class="col-sm-10">
                                    <input type="url" class="form-control" id="link" placeholder="Enter link"
                                           name="link">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-2" for="descrip">Description*:</label>

                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="5" id="descrip"></textarea>
                                </div>
                            </div>

                            <div class="dropdown">
                                <label class="control-label col-sm-2" for="topic">Topic*:</label>
                                <button class="btn btn-default dropdown-toggle" type="button"
                                        data-toggle="dropdown" id="topic"
                                        style="padding-right: 10px;padding-left: 325px;">topic
                                    <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><a href="#">topictype1</a></li>
                                    <li><a href="#">topictype2</a></li>
                                    <li><a href="#">topictype3</a></li>
                                </ul>
                            </div>
                            <br>

                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-default">Share</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!--<div class="modal-footer">-->
                    <!--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>-->
                    <!--</div>-->
                </div>
            </div>
        </div>

        --}%
%{--     TEMPLATE FOR SHARING DOCUMENT--}%%{--

        <span class="col-lg-1">
            <a href="#myModal4" data-toggle="modal" data-target="#myModal4">
                <i class="far fa-file" style="font-size:24px"></i>
            </a>
        </span>

        <div id="myModal4" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Share Document</h4>
                    </div>

                    <div class="modal-body">
                        <form class="form-horizontal" action="#">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="document">Document*:</label>

                                <div class="col-sm-10">
                                    <input type="file" class="form-control" id="document" name="document">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-2" for="descrip1">Description*:</label>

                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="5" id="descrip1"></textarea>
                                </div>
                            </div>

                            <div class="dropdown">
                                <label class="control-label col-sm-2" for="topic1">Topic*:</label>
                                <button class="btn btn-default dropdown-toggle" type="button"
                                        data-toggle="dropdown" id="topic1"
                                        style="padding-right: 10px;padding-left: 325px;">topic
                                    <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><a href="#">topictype1</a></li>
                                    <li><a href="#">topictype2</a></li>
                                    <li><a href="#">topictype3</a></li>
                                </ul>
                            </div>

                            <div class="form-group">
                                <br>

                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-default">Share</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        --}%
%{--    USERNAME INFO DROPDOWN--}%%{--

        <span class="col-lg-3 dropdown">
            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <i class="fas fa-user" style="font-size:24px"></i>
                Anuj Gupta
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="#">profile</a></li>
                <li><a href="#">users</a></li>
                <li><a href="#">Topic</a></li>
                <li><a href="#">post</a></li>
                <li><a href="#">logout</a></li>
            </ul>
        </span>
    </div>
</header>

<div class="body">

    <g:layoutBody/>
</div>


<div class="footer" role="contentinfo">
    Powered By TTN
</div>
<asset:javascript src="application.js"/>
</body>
</html>--}%
