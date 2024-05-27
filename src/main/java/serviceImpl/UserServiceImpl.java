package serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.User;

import helper_exception.ResourceNotFoundException;
import repositories.userRepo;
import services.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private userRepo userRepo;

  private Logger logger = LoggerFactory.getLogger(getClass());

  public User saveuser(User user) {
    // setting ig randomly
    String userId = UUID.randomUUID().toString();
    user.setUserId(userId);
    return userRepo.save(user);
  }

  @Override
  public Optional<User> findById(String id) {
    Optional<User> user = userRepo.findById(id);
    return user;
  }

  @Override
  public Optional<User> updateUser(User user) {
    User user2 = userRepo.findById(user.getUserId())
        .orElseThrow(() -> new ResourceNotFoundException("Resource/Id not found"));
    user2.setName(user.getName());
    user2.setEmail(user.getEmail());
    user2.setPassword(user.getPassword());
    user2.setAbout(user.getAbout());
    user2.setProfilePic(user.getProfilePic());
    user2.setPhoneNumber(user.getPhoneNumber());
    user2.setEnabled(user.getEnabled());
    user2.setEmailVerified(user.getEmailVerified());
    user2.setEmailVerified(user.getEmailVerified());
    user2.setProvider(user.getProvider());
    user2.setProviderUserID(user.getProviderUserID());
    User save = userRepo.save(user2);
    return Optional.ofNullable(save);
  }

  @Override
  public void deleteUser(String id) {
    User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource/Id not found"));
    userRepo.delete(user);
  }

  @Override
  public boolean isUserExist(String userId) {
    User user = userRepo.findById(userId).orElse(null);
    return user != null ? true : false;
  }

  @Override
  public boolean isUserExistByEmail(String email) {
    User user = userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Resource/Id not found"));
    return user != null ? true : false;

  }

  @Override
  public List<User> allUser() {
    return userRepo.findAll();

  }

}
