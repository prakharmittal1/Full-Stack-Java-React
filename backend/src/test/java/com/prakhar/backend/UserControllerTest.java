// package com.prakhar.backend;
// import com.prakhar.backend.UserController;
// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

package com.prakhar.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    private User user1;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        user1 = new User();
        user1.setId(1);
        user1.setName("John");
        user1.setEmail("john@hotmail.com");
        user1.setPassword("johnpasss");
    }

    @Test
    public void testGetUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        when(userRepository.findAll()).thenReturn(userList);
        List actualUserList = userController.GetUsers();
        verify(userRepository).findAll();
        assertEquals(userList, actualUserList, "Verifies that GetUsers retrieves user list");
    }

    @Test
    public void testGetUserById() {
        Integer userId = user1.getId();
        User u = new User();
        u.setId(userId);
        when(userRepository.findById(user1.getId())).thenReturn(java.util.Optional.of(u));
        User user = userController.GetUser(userId);
        verify(userRepository).findById(userId);
        assertEquals(userId, user.getId(), String.format("Verifies that GetUser returns user by a Id: %s", userId));
    }

    @Test
    public void testGetUserByIdIsNull() {
        Integer userId = 100;
        User user = userController.GetUser(userId);
        verify(userRepository).findById(userId);
        assertNull(user, "Verifies that GetUser returns null if userId is absent");
    }

    @Test
    public void testPostUser() {
        when(userRepository.save(user1)).thenReturn(user1);
        User createdUser = userController.PostUser(user1);
        verify(userRepository).save(createdUser);
        assertEquals(user1, createdUser, "Verifies that PostUser adds a new user");
    }

    @Test
    public void testPutUser() {
        User oldUser = user1;
        when(userRepository.findById(oldUser.getId())).thenReturn(java.util.Optional.of(oldUser));
        User newUser = new User();
        newUser.setId(oldUser.getId());
        newUser.setName("Jack");
        newUser.setEmail("jack@hotmail.com");
        newUser.setPassword("challenge");
        when(userRepository.save(newUser)).thenReturn((newUser));
        User user = userController.PutUser(newUser);
        verify(userRepository).findById(oldUser.getId());
        verify(userRepository).save(newUser);
        assertEquals(newUser, user, "Verifies that PutUser updates user");
    }

    @Test
    public void testDeleteUser() {
        Integer userIdToBeDeleted = user1.getId();
        Integer deletedUserId = userController.DeleteUser(userIdToBeDeleted);
        verify(userRepository).deleteById(userIdToBeDeleted);
        assertEquals(userIdToBeDeleted, deletedUserId, "Verifies that DeleteUser deletes the user");
    }
}
