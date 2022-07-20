package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private UserRepository userDao;

    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
       this.passwordEncoder = passwordEncoder;
    }

    /**
     * User Crud
     */
    @Override
    public User addNewUser(User User) {
        String pw=User.getPassword();
        User.setPassword(passwordEncoder.encode(pw));
        return userDao.save(User);
    }

    @Override
    public User loadUserByUsername(String username) { return userDao.findByUsername(username); }
   

    @Override
    public List<User> listUser() { return (List<User>) userDao.findAll(); }

    public User getUserById(Long id){
        return userDao.findById(id).orElse(null);
    }
    public User getUserByFirstName(String firstname){
        return userDao.findByFirstName(firstname);
    }

    public User updateUser(User use, Long id){
    	User user = userDao.findById(id).orElse(null);
    user.setFirstName(use.getFirstName());
    user.setEquipe(use.getEquipe());
    user.setEmail(use.getEmail());
    user.setPoste(use.getPoste());
    user.setLastName(use.getLastName());
  System.out.println(use.getEquipe());
    userDao.save(user);
    return user;
    }
    public String deleteUser(Long id){
    	userDao.deleteById(id);
        return "User removed  !! "+id;
    }

    

}
