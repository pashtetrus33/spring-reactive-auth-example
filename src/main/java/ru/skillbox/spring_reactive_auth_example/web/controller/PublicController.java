package ru.skillbox.spring_reactive_auth_example.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.skillbox.spring_reactive_auth_example.entity.Role;
import ru.skillbox.spring_reactive_auth_example.entity.RoleType;
import ru.skillbox.spring_reactive_auth_example.entity.User;
import ru.skillbox.spring_reactive_auth_example.service.UserService;
import ru.skillbox.spring_reactive_auth_example.web.model.UserDto;

@RestController
@RequestMapping("/api/v1/public")
@RequiredArgsConstructor
public class PublicController {

    private final UserService userService;

    @GetMapping
    public Mono<ResponseEntity<String>> publicMethod() {
        return Mono.just(ResponseEntity.ok("Public method calling...."));
    }

    @PostMapping("/account")
    public Mono<ResponseEntity<UserDto>> createUserAccount(@RequestBody UserDto userDto, @RequestParam RoleType roleType) {
        return Mono.just(ResponseEntity.status(HttpStatus.CREATED)
                .body(createAccount(userDto, roleType)));
    }

    private UserDto createAccount(UserDto userDto, RoleType roleType) {
        var user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        var createdUser = userService.createNewAccount(user, Role.from(roleType));

        return UserDto.builder()
                .username(createdUser.getUsername())
                .password(createdUser.getPassword())
                .build();
    }
}
