package com.ttn.linksharing


class LoginCheckInterceptor {

  /*      LoginCheckI() {
            if (!session["user"]) {
                redirect(controller: 'login', action: 'index')
            }
        }*/

        boolean before() {
            /*log.info "......................."+controllerName
            log.info ">>>>>>>>>>>>>>>>>..................."*/

            true
        }

        boolean after() {
//            render(">>>>>>>>>>>>>>>>>>>after>>>>>>>>."+session["user"])
            true
        }

        void afterView() {
            // no-op
        }
        LoginCheckInterceptor(){
            matchAll().excludes(controller: "login")
        }
    }

