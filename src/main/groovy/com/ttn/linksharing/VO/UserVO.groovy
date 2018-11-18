package com.ttn.linksharing.VO

import groovy.beans.Bindable


@Bindable
class UserVO {
    Long id
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
