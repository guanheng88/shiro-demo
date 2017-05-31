package com.demo.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.shiro.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    private UserService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    @RequiresAuthentication
    public String getUsers() {
        return "This is method 'getUsers'...";
    }

    @RequestMapping(value = "/role1", method = RequestMethod.GET)
    @ResponseBody
    @RequiresRoles(value = { "role1" })
    public String testRole1() {
        return "This is role1 page...";
    }

    @RequestMapping(value = "/permission1", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = { "permission1" })
    public String testPermission1() {
        return "This is permission1 page...";
    }

    @RequestMapping(value = "/role1-service", method = RequestMethod.GET)
    @ResponseBody
    public String testRole1Permission3() {
        return service.testPermission();
    }
}
