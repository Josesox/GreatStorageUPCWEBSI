package pe.edu.upc.greatstorage.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.greatstorage.model.Rol;
import pe.edu.upc.greatstorage.model.Usuario;
import pe.edu.upc.greatstorage.repository.IUsuarioDAO;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUsuarioDAO data;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario appUser = data.findByUsername(username);

        Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
        for(Rol role: appUser.getRoles())
        {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getDetailRol());
            grantList.add(grantedAuthority);
        }

        UserDetails user = (UserDetails) new User(username,appUser.getPassword(),grantList);

        return user;
    }
}
