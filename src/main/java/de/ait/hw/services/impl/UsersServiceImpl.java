package de.ait.hw.services.impl;

import de.ait.hw.dto.articlesDto.ArticleDto;
import de.ait.hw.dto.articlesDto.ArticlesDto;
import de.ait.hw.dto.eventsDtos.EventsDto;
import de.ait.hw.dto.usersDtos.NewUserDto;
import de.ait.hw.dto.usersDtos.UpdateUserDto;
import de.ait.hw.dto.usersDtos.UserDto;
import de.ait.hw.dto.usersDtos.UsersDto;
import de.ait.hw.exceptions.ForbiddenOperationException;
import de.ait.hw.exceptions.NotFoundException;
import de.ait.hw.models.User;
import de.ait.hw.repositories.UsersRepository;
import de.ait.hw.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static de.ait.hw.dto.usersDtos.UserDto.from;
import static de.ait.hw.dto.articlesDto.ArticleDto.from;


@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    @Override
    public UserDto addUser(NewUserDto newUser) {
        User user = User.builder()
                        .email(newUser.getEmail())
                        .password(newUser.getPassword())
                        .role(User.Role.USER)
                        .state(User.State.NOT_CONFIRMED)
                        .articles(new ArrayList<>())
                        .build();
        user.setRole(User.Role.USER);
        user.setState(User.State.NOT_CONFIRMED);

        usersRepository.save(user);

        return from(user);
    }

    @Override
    public UsersDto getAllUsers() {
        List<User> users = usersRepository.findAll();

        return UsersDto.builder()
                .users(from(users))
                .count(users.size())
                .build();
    }

    @Override
    public UserDto deleteUser(Long userId) {
//        Optional<User> user = usersRepository.findById(userId);
//
//        if(user.isEmpty()) {
//            throw new NotFoundException("User with id <"+ userId+"> not found");
//        }
//
//        usersRepository.delete(user.get());

        User user = getUserOrThrow(userId);

        usersRepository.delete(user);
        return from(user);

    }

    @Override
    public UserDto updateUser(Long userId, UpdateUserDto updateUser) {

        User user = getUserOrThrow(userId);

        if(updateUser.getNewRole().equals("ADMIN")) {
            throw new ForbiddenOperationException("Cannot make an administrator");
        }

        user.setState(User.State.valueOf(updateUser.getNewState()));
        user.setRole(User.Role.valueOf(updateUser.getNewRole()));


        usersRepository.save(user);

        return from(user);
    }

    @Override
    public UserDto getUser(Long userId) {
        return from(getUserOrThrow(userId));
    }

    @Override
    public ArticlesDto getArticlesOfUser(Long userId) {
        User user = getUserOrThrow(userId);

        return ArticlesDto.builder()
                .articles(from(user.getArticles()))
                .count(user.getArticles().size())
                .build();

    }

    private User getUserOrThrow(Long userId) {
        User user = usersRepository.findById(userId).orElseThrow(() ->
                new NotFoundException("User with id <"+ userId +"> not found"));
        return user;
    }
}
