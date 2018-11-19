package com.ttn.linksharing.VO

import com.ttn.linksharing.enumeration.Seriousness
import com.ttn.linksharing.enumeration.Visibility

class SubscriptionVO {
    String createdByName
    String createdByemail
    Seriousness seriousness
    Visibility visibility
    String topicName
    Integer subscriptionId
    Integer topicId
    Integer subscriptionCount
    Integer resourceCount
}
