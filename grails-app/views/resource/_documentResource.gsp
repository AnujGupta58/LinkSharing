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
                <h4 class="modal-title">Add Document</h4>
            </div>

            <div class="modal-body">
            %{--<form class="form-horizontal" action="#">--}%
                <g:form controller="documentResource" action="create">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="filepath">Document*:</label>

                        <div class="col-sm-10">
                            <input type="file" class="form-control" id="filepath" name="filepath">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="description">Description*:</label>

                        <div class="col-sm-10">
                            <textarea class="form-control" rows="5" name="description" id="description"></textarea>
                        </div>
                    </div>

           %{--         <div class="dropdown">
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
                    </div>--}%
                    <div class=" form-group col-lg-12">
                        <label class="control-label">Topic*:</label>
                        %{--<g:select name="topic" value="topic" from="${session.user.getUserTopics()}"/>--}%
                        <select class="form-control " name="id">
                            <g:each in="${session.user.getUserTopics()}" var="topic">
                                <option value="${topic.id}">${topic}</option>
                            </g:each>
                        </select>
                    </div>

                    <div class="form-group">
                        <br>

                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Create</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </g:form>
            %{--</form>--}%
            </div>
        </div>
    </div>
</div>