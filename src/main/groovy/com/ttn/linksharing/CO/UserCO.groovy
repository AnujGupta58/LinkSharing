package com.ttn.linksharing.CO

import groovy.beans.Bindable


@Bindable
class UserCO {
    String email
    String password
    String name
    String firstName
    String lastName
    byte[] photo
    boolean admin
    boolean isActive
    Integer topicCount
    Integer resourceCount
    Integer subscriptionCount

}
