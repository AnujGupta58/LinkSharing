<div class="panel panel-default">
    <div class="panel-heading">
        <span class="text-primary">Subscriptions</span>
        <span style="float: right">
            <a href="#" class="hyperlink">View All</a>
        </span>
    </div>

    <div class="panel-body">
    %{-->>>>>>>>${subscribedTopics.size()}--}%
        <g:each in="${userSubscribedTopics}" var="subscription">
            <div class="row">

                <div class="col-lg-2">
                    <asset:image src="Avatar.png" class="img-responsive"/>
                </div>

                <div class="col-lg-10">
                    <div class="text-primary">
                        <a class="hyperlink" href="#">${subscription.topicName}</a>
                    </div>

                    <div class="col-lg-4">
                        <span class="text-muted"></span>
                        %{--<g:form controller="subscription" action="delete" id="${subscription.subscriptionId}">--}%
                            <a href="${createLink(controller: 'subscription' , action: 'delete',id: "${subscription.subscriptionId}")}" class="hyperlink">Unsubscribe</a>
                        %{--</g:form>--}%
                    </div>

                    <div class="col-lg-4">
                        <span class="text-muted">Subscriptions</span>
                        <span class="text-primary">${subscription.subscriptionCount}</span>
                    </div>

                    <div class="col-lg-2">
                        <span class="text-muted">Topics</span>
                        <span class="text-primary">${subscription.resourceCount}</span>
                    </div>
                </div>

                <div class="col-lg-7 col-lg-offset-1">

                    <g:select name="visibility" value="${subscription.visibility}"
                              from="${com.ttn.linksharing.enumeration.Visibility.values()}"/>

                    %{--  <ul class="dropdown-menu">
                          <li><a href="#">Very Serious</a></li>
                          <li><a href="#">Serious</a></li>
                          <li><a href="#">Less Serious</a></li>
                      </ul>--}%

                    <g:select name="visibility" value="${subscription.seriousness}"
                              from="${com.ttn.linksharing.enumeration.Seriousness.values()}"/>

                </div>

                <div class="col-lg-4">
                    <span style="padding-left: 1px"><svg class="svg-inline--fa fa-envelope fa-w-16 fa-2x"
                                                         aria-hidden="true" data-prefix="far" data-icon="envelope"
                                                         role="img" xmlns="http://www.w3.org/2000/svg"
                                                         viewBox="0 0 512 512" data-fa-i2svg=""><path
                                fill="currentColor"
                                d="M464 64H48C21.49 64 0 85.49 0 112v288c0 26.51 21.49 48 48 48h416c26.51 0 48-21.49 48-48V112c0-26.51-21.49-48-48-48zm0 48v40.805c-22.422 18.259-58.168 46.651-134.587 106.49-16.841 13.247-50.201 45.072-73.413 44.701-23.208.375-56.579-31.459-73.413-44.701C106.18 199.465 70.425 171.067 48 152.805V112h416zM48 400V214.398c22.914 18.251 55.409 43.862 104.938 82.646 21.857 17.205 60.134 55.186 103.062 54.955 42.717.231 80.509-37.199 103.053-54.947 49.528-38.783 82.032-64.401 104.947-82.653V400H48z"></path>
                    </svg><!-- <i class="far fa-envelope fa-2x"></i> --></span>
                    <span style="padding-left: 10px"><svg class="svg-inline--fa fa-file fa-w-12 fa-2x"
                                                          aria-hidden="true" data-prefix="far" data-icon="file"
                                                          role="img" xmlns="http://www.w3.org/2000/svg"
                                                          viewBox="0 0 384 512" data-fa-i2svg=""><path
                                fill="currentColor"
                                d="M369.9 97.9L286 14C277 5 264.8-.1 252.1-.1H48C21.5 0 0 21.5 0 48v416c0 26.5 21.5 48 48 48h288c26.5 0 48-21.5 48-48V131.9c0-12.7-5.1-25-14.1-34zM332.1 128H256V51.9l76.1 76.1zM48 464V48h160v104c0 13.3 10.7 24 24 24h104v288H48z"></path>
                    </svg><!-- <i class="far fa-file fa-2x"></i> --></span>
                    <span style="padding-left: 10px"><svg class="svg-inline--fa fa-trash-alt fa-w-14 fa-2x"
                                                          aria-hidden="true" data-prefix="far" data-icon="trash-alt"
                                                          role="img" xmlns="http://www.w3.org/2000/svg"
                                                          viewBox="0 0 448 512" data-fa-i2svg=""><path
                                fill="currentColor"
                                d="M192 188v216c0 6.627-5.373 12-12 12h-24c-6.627 0-12-5.373-12-12V188c0-6.627 5.373-12 12-12h24c6.627 0 12 5.373 12 12zm100-12h-24c-6.627 0-12 5.373-12 12v216c0 6.627 5.373 12 12 12h24c6.627 0 12-5.373 12-12V188c0-6.627-5.373-12-12-12zm132-96c13.255 0 24 10.745 24 24v12c0 6.627-5.373 12-12 12h-20v336c0 26.51-21.49 48-48 48H80c-26.51 0-48-21.49-48-48V128H12c-6.627 0-12-5.373-12-12v-12c0-13.255 10.745-24 24-24h74.411l34.018-56.696A48 48 0 0 1 173.589 0h100.823a48 48 0 0 1 41.16 23.304L349.589 80H424zm-269.611 0h139.223L276.16 50.913A6 6 0 0 0 271.015 48h-94.028a6 6 0 0 0-5.145 2.913L154.389 80zM368 128H80v330a6 6 0 0 0 6 6h276a6 6 0 0 0 6-6V128z"></path>
                    </svg><!-- <i class="far fa-trash-alt fa-2x"></i> --></span>
                </div>

            </div>
            <hr>
        </g:each>
    </div>
</div>