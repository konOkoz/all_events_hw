package de.ait.hw.services;

import de.ait.hw.dto.articlesDto.ArticlesDto;
import de.ait.hw.dto.eventsDtos.EventsDto;
import de.ait.hw.dto.usersDtos.NewUserDto;
import de.ait.hw.dto.usersDtos.UpdateUserDto;
import de.ait.hw.dto.usersDtos.UserDto;
import de.ait.hw.dto.usersDtos.UsersDto;
import de.ait.hw.models.User;

public interface UsersService {
    UserDto addUser(NewUserDto newUser);

    UsersDto getAllUsers();

    UserDto deleteUser(Long userId);

    UserDto updateUser(Long userId, UpdateUserDto updateUser);

    UserDto getUser(Long userId);

    ArticlesDto getArticlesOfUser(Long userId);

}
