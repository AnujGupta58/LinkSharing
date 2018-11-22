<div class="panel panel-default">
    <div class="panel-heading">
        Inbox
    </div>

    <div class="panel-body">
        <g:each in="${inbox}">
        <div class="row" style="padding-bottom: 10px">
            <div class="col-lg-2">
                <asset:image src="Avatar.png" class="img-responsive"/>
            </div>

            <div class="col-lg-10">
                <span class="text">${inbox.topicName}</span>
                <span class="text-muted">@${inbox.createdByemail}</span>
                <span class="text-primary" style="float: right">Grails</span>

                <div class="text">
                    <p>
                        Bootstrap is a free and open-source front-end framework for designing websites and web applications. It contains HTML- and CSS-based design templates for typography, forms, buttons, navigation and other interface components, as well as optional JavaScript extensions. Unlike many earlier web frameworks, it concerns itself with front-end development only.
                    </p>
                </div>

                <div>
                    <div class="col-lg-3">
                        <!-- <i class="fab fa-facebook fa-2x"> </i> -->
                        <!-- <i class="fab fa-tumblr fa-2x"> </i> -->
                        <span style="padding-left: 1px"><i class="fab fa-facebook fa-2x"></i></span>
                        <span style="padding-left: 10px"><i class="fab fa-tumblr fa-2x"></i></span>
                        <span style="padding-left: 10px"><i class="fab fa-google-plus-g fa-2x"></i></span>
                    </div>

                    <div class="col-lg-9">
                        <div class="col-lg-2 col-lg-offset-2" style="padding-left: 0px;padding-right: 0px;">
                            <a href="#" class="text-primary" style="text-decoration: underline;">Download</a>
                        </div>

                        <div class="col-lg-3" style="padding-left: 0px;padding-right: 0px;">
                            <a href="#" class="text-primary" style="text-decoration: underline;">View Full Size</a>
                        </div>

                        <div class="col-lg-3" style="padding-left: 0px;padding-right: 0px;">
                            <a href="#" class="text-primary" style="text-decoration: underline;">Mark As Read</a>
                        </div>

                        <div class="col-lg-2" style="padding-left: 0px;padding-right: 0px;">
                            <a href="#" class="text-primary" style="text-decoration: underline;">View Post</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <hr>
        </g:each>
    </div>
</div>
