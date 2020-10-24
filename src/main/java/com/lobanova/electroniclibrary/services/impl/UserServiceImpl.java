package com.lobanova.electroniclibrary.services.impl;

import com.lobanova.electroniclibrary.dtos.UserDto;
import com.lobanova.electroniclibrary.entities.User;
import com.lobanova.electroniclibrary.repositories.UserRepository;
import com.lobanova.electroniclibrary.services.AddressService;
import com.lobanova.electroniclibrary.services.CommentService;
import com.lobanova.electroniclibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressService addressService;
    private final CommentService commentService;
    private final ConversionService conversionService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           AddressService addressService,
                           CommentService commentService,
                           ConversionService conversionService) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
        this.addressService = addressService;
        this.commentService = commentService;
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = conversionService.convert(userDto, User.class);
        if (userDto.getCountry() != null || userDto.getCity() != null) {
            user.setAddress(addressService.getOrCreateAddress(userDto.getCountry(), userDto.getCity()));
        }
        user = userRepository.save(user);
        return conversionService.convert(user, UserDto.class);
    }

    public UserDto read(Long id) {
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = conversionService.convert(userDto, User.class);
        user.setComments(new HashSet<>(commentService.getCommentsByUserId(user.getId())));
        user = userRepository.save(user);
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Set<UserDto> getAll() {
        Set<User> users = new HashSet<>((Collection<? extends User>) userRepository.findAll());
        return users.stream().map(user -> conversionService.convert(user, UserDto.class)).collect(Collectors.toSet());
    }
}
