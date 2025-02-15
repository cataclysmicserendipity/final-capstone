package com.techelevator.controller;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Crust;
import com.techelevator.model.Pizza;
import com.techelevator.model.Size;
import com.techelevator.model.Topping;
import com.techelevator.service.UserAccessService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class UserAccessController {
    UserAccessService userAccessService;

    public UserAccessController(UserAccessService userAccessService) {
        this.userAccessService = userAccessService;
    }

    @PutMapping(path = "/toppings/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Topping updateTopping(@PathVariable String name, @RequestBody Topping topping) {
        try {
            return userAccessService.updateTopping(name, topping);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping(path = "/pizzas")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Pizza addPizza(@RequestBody Pizza pizza) {
        try {
            return userAccessService.addPizza(pizza);
        }catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping(path = "/pizzas/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Pizza editPizza(@PathVariable int id, @RequestBody Pizza pizza) {
        try {
            return userAccessService.editPizza(id, pizza);
        }catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping(path = "/topping")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Topping addPizzaOption(@RequestBody Topping topping) {
        try{
            return userAccessService.addPizzaOption(topping);
        }catch (DaoException e) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
    }

    @PostMapping(path = "/crust")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Topping addCrust(@RequestBody Crust crust) {
        try{
            return userAccessService.addCrust(crust);
        }catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping(path = "/size")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Topping addSize(@RequestBody Size size) {
        try{
            return userAccessService.addSize(size);
        }catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
