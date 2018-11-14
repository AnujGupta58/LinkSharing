<!doctype html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js" integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ" crossorigin="anonymous"></script>
</head>
<body>

<span class="col-lg-1">
    <a href="#myModal" data-toggle="modal" data-target="#myModal">
        <i class="fas fa-comment" style="font-size:24px"></i>
    </a>
</span>

<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create Topic</h4>
            </div>

            <div class="modal-body">
                <form class="form-horizontal" action="#">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="name1">Name*:</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name1" name="name1"
                                   style="    margin-left: 95px;padding-right: -50px;margin-right: 100px;">
                        </div>
                    </div>

                    <div class="dropdown">
                        <label class="control-label col-sm-2" for="visibility">Visibility*:</label>
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"
                                id="visibility"
                                style="padding-right: 10px;padding-left: 300px;margin-left: 100px;">visibility
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#">private</a></li>
                            <li><a href="#">public</a></li>
                        </ul>
                    </div>
                    <br>

                    <div class="form-group">
                        <div class="col-sm-offset-8 col-sm-4">
                            <button type="submit" class="btn btn-default"
                                    style="margin-right: 40px">Save</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>