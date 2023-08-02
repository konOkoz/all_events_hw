package de.ait.hw.controllers;

import de.ait.hw.controllers.api.UsersApi;
import de.ait.hw.dto.articlesDto.ArticlesDto;
import de.ait.hw.dto.eventsDtos.EventsDto;
import de.ait.hw.dto.usersDtos.NewUserDto;
import de.ait.hw.dto.usersDtos.UpdateUserDto;
import de.ait.hw.dto.usersDtos.UserDto;
import de.ait.hw.dto.usersDtos.UsersDto;
import de.ait.hw.models.User;
import de.ait.hw.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class UsersController implements UsersApi {

    private final UsersService usersService;

    @Override
    public UserDto addUser(NewUserDto newUser){
        return usersService.addUser(newUser);
    }

    @Override
    public UsersDto getAllUsers() {
        return usersService.getAllUsers();
    }

    @Override
    public UserDto deleteUser(Long userId) {
        return usersService.deleteUser(userId);
    }

    @Override
    public UserDto updateUser(Long userId, UpdateUserDto updateUser) {
        return usersService.updateUser(userId, updateUser);
    }

    @Override
    public UserDto getUser(Long userId) {
        return usersService.getUser(userId);
    }

    @Override
    public ArticlesDto getArticlesOfUser(Long userId) {
        return usersService.getArticlesOfUser(userId);
    }

}
