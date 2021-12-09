package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAOImpl;
import web.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAOImpl userDAOimpl;

    public UserDetailsServiceImpl(UserDAOImpl userDAOimpl) {
        this.userDAOimpl = userDAOimpl;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAOimpl.findByUserName(username);
        if (user == null){
            throw new UsernameNotFoundException(String.format("User not found", username));
        }
        return  new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), user.getAuthorities());
    }
}
