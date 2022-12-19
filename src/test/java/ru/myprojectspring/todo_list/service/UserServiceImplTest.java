package ru.myprojectspring.todo_list.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.myprojectspring.todo_list.model.User;
import ru.myprojectspring.todo_list.repository.UserRepository;
import ru.myprojectspring.todo_list.service.user.UserServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void createUser() {
        User user = new User();
        user.setPassword("1234");
        String encodePass = "encode";
        Mockito.doReturn(encodePass).when(passwordEncoder).encode(user.getPassword());
        userService.createUser(user);
        Mockito.verify(userRepository).save(user);
        assertThat(encodePass).isEqualTo(user.getPassword());
    }
}
