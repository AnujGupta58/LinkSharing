<span class="col-lg-1">
    <a href="#myModal2" data-toggle="modal" data-target="#myModal2">
        <i class="far fa-envelope" style="font-size:24px"></i></a>
</span>
<div id="myModal2" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send Invitation</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="#">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="email1">Email*:</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="email1"  name="email1" style="    margin-left: 95px;padding-right: -50;margin-right: 100px;">
                        </div>
                    </div>

                    <div class="dropdown">
                        <label class="control-label col-sm-2" for="Topic1">Visibility*:</label>
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" id="Topic1" style="padding-right: 10px;padding-left: 300px;margin-left: 100px;">visibility
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a href="#">private</a></li>
                            <li><a href="#">public</a></li>
                        </ul>
                    </div>
                    <br>
                    <div class="form-group">
                        <div class="col-sm-offset-8 col-sm-4">
                            <button type="submit" class="btn btn-default" style="margin-right: 40px">Share</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
