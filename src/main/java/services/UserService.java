package services;

import java.util.List;
import java.util.Optional;

import com.entities.User;

public interface UserService {

  // Interface to save new user in database
  User saveuser(User user);

  // Interface to find user by Id from database
  Optional<User> findById(String id);

  // Interface to update existing user in database
  Optional<User> updateUser(User user);

  // Interface to delete user from database
  void deleteUser(String id);

  // check if user exist in database
  boolean isUserExist(String userId);

  // check if user exist by email in database
  boolean isUserExistByEmail(String email);

  // fetch all user
  List<User> allUser();

}
