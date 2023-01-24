package org.youbooking.root.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youbooking.root.entities.AppUser;
import org.youbooking.root.services.dtos.HotelDto;
import org.youbooking.root.services.interfaces.HotelServiceInterface;
import org.youbooking.root.services.interfaces.UserServiceInterface;
import org.youbooking.root.utils.IdClassMapper;

import java.util.Set;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    private final UserServiceInterface userService;
    private final HotelServiceInterface hotelService;


    @GetMapping("/fetching-all-hotels")
    public ResponseEntity<Set<HotelDto>> getAllCreatedHotelsApi(){

        return (hotelService.getAllHotels().isEmpty())
                ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.ok(hotelService.getAllHotels());
    }
    @GetMapping("/finding-user-by-role/{username}")
    public ResponseEntity<Object> getUserRoleByUsernameApi(@PathVariable("username") String username){
         AppUser user = userService.findUserByUsername(username);
         return user != null
                 ? ResponseEntity.ok(user.getStatus())
                 : ResponseEntity.status(HttpStatus.NOT_FOUND).body("The user " + username +" wa not found");
    }
    @PatchMapping(  "/ban-user")
    public ResponseEntity<Object> banUserApi(@RequestBody IdClassMapper<Long> idClassMapper){
        AppUser user = userService.banUser(idClassMapper.getId());

        return ( user == null )
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("The id that you provided was not found")
                : ResponseEntity.ok(user);
    }
    @PatchMapping("/unban-user")
    public ResponseEntity<Object> unBanUserApi(@RequestBody IdClassMapper<Long> idClassMapper){
        AppUser user = userService.unBanUser(idClassMapper.getId());

        return ( user == null )
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("The id that you provided was not found")
                : ResponseEntity.ok(user);
    }
}