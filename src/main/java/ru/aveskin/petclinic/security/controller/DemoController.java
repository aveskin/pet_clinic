package ru.aveskin.petclinic.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping("/usual-auth")
    public String hitUsualAuth() {
        return "this is protected resource";
    }

    @GetMapping("/role-owner-auth")
    public String hitOwnerAuth() {
        return "this is owner protected resource";
    }

    @GetMapping("/role-vet-auth")
    public String hitVetAuth() {
        return "this is vet protected resource";
    }

    @GetMapping("/role-admin-auth")
    public String hitAdminAuth() {
        return "this is admin protected resource";
    }

}