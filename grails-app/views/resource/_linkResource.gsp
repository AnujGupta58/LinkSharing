<span class="col-lg-1">
    <a href="#myModal3" data-toggle="modal" data-target="#myModal3">
        <i class="fas fa-link" style="font-size:24px"></i></a>
</span>

<div id="myModal3" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add Link</h4>
            </div>

            <div class="modal-body">
            %{--<form class="form-horizontal" action="#">--}%
                <g:form controller="linkResource" action="create">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="link">Link*:</label>

                        <div class="col-sm-10">
                            <input type="url" class="form-control" id="link" placeholder="Enter link"
                                   name="link">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="description">Description*:</label>

                        <div class="col-sm-10">
                            <textarea class="form-control" rows="5" name="description" id="description"></textarea>
                        </div>
                    </div>

               %{--     <div class="dropdown">
                        <label class="control-label col-sm-2" for="topic">Topic*:</label>
                        <button class="btn btn-default dropdown-toggle" type="button"
                                data-toggle="dropdown" id="topic" style="padding-right: 10px;padding-left: 325px;">topic
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a href="#">topictype1</a></li>
                            <li><a href="#">topictype2</a></li>
                            <li><a href="#">topictype3</a></li>
                        </ul>
                    </div>--}%
                    <div class=" form-group">
                        %{--<g:select name="topic" value="topic" from="${session.user.getUserTopics()}"/>--}%
                        <select class="form-control " name="id">
                            <g:each in="${session.user.getUserTopics()}" var="topic">
                                <option value="${topic.id}">${topic}</option>
                            </g:each>
                        </select>
                    </div>
                    <br>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Create</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close
                            </button>
                        </div>
                    </div>
                </g:form>
            %{--</form>--}%
            </div>
            <!--<div class="modal-footer">-->
            <!--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>-->
            <!--</div>-->
        </div>
    </div>
</div>