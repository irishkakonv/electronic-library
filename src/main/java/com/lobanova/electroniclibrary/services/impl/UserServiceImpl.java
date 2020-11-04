package com.lobanova.electroniclibrary.services.impl;

import com.lobanova.electroniclibrary.dtos.UserDto;
import com.lobanova.electroniclibrary.entities.CustomUserDetails;
import com.lobanova.electroniclibrary.entities.User;
import com.lobanova.electroniclibrary.repositories.UserRepository;
import com.lobanova.electroniclibrary.security.CustomUserDetailsService;
import com.lobanova.electroniclibrary.services.AddressService;
import com.lobanova.electroniclibrary.services.CommentService;
import com.lobanova.electroniclibrary.services.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressService addressService;
    private final CommentService commentService;
    private final ConversionService conversionService;
    private final CustomUserDetailServiceImpl customUserDetailsService;

    public UserServiceImpl(UserRepository userRepository,
                           AddressService addressService,
                           CommentService commentService,
                           ConversionService conversionService,
                           CustomUserDetailServiceImpl customUserDetailsService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
        this.commentService = commentService;
        this.conversionService = conversionService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = conversionService.convert(userDto, User.class);
        CustomUserDetails customUserDetails = customUserDetailsService.createUserDetails(user, userDto);
        user.setUserDetails(customUserDetails);
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
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(user -> conversionService.convert(user, UserDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public UserDto signUp(String userName, String password) {
        return conversionService.convert(
                userRepository.findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException(userName)), UserDto.class
        );
    }

    @Override
    public UserDto getUserById(Long id) {
        return conversionService.convert(
                userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(id.toString())), UserDto.class
        );
    }
}
