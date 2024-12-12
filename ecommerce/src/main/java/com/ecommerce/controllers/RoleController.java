package com.ecommerce.controllers;

import com.ecommerce.entities.Role;
import com.ecommerce.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public List<Role> listRoles(){
        return roleRepository.findAll();
    }

    @PostMapping
    public Role addRole(@RequestBody Role role){
        return roleRepository.save(role);
    }

    @GetMapping("/{id}")
    public Role getRole(@PathVariable Long id){
        return roleRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id){
        roleRepository.deleteById(id);
    }
}
