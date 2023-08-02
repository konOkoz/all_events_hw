package de.ait.hw.repositories.impl;

import de.ait.hw.models.User;
import de.ait.hw.repositories.UsersRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepositoryListImpl implements UsersRepository {
    private static List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        if(user.getId() == null) {
            user.setId((long) users.size() + 1);
            users.add(user);
        } else {
            //TODO: когда будет база данных надо будет сюда записать что делать в листе обновилось автоматом
        }
        }
    @Override
    public List<User> findAll() {
     return new ArrayList<>(users);

    }

    @Override
    public Optional<User> findById(Long id) {
        for(User user: users){
            if(user.getId().equals(id))
                return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

    public void clear(){
        users.clear();
    }


}
