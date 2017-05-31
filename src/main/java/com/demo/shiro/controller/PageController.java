package com.demo.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/page")
public class PageController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "/shiro/login";
    }

    @RequestMapping(value = "/error/403", method = RequestMethod.GET)
    public String error403Page() {
        return "/error/403";
    }

    @RequestMapping(value = "/custom", method = RequestMethod.GET)
    @RequiresAuthentication
    public String customPage() {
        return "/shiro/custom";
    }

    @RequestMapping(value = "/rapid1", method = RequestMethod.GET)
    public String child1Page() {
        return "/rapid/child/child1";
    }

    @RequestMapping(value = "/rapid2", method = RequestMethod.GET)
    public String child2Page() {
        return "/rapid/child/child2";
    }
}
