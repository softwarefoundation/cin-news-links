package br.com.devchampions.hotlink.security.services;

import br.com.devchampions.hotlink.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Primary
@Service
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {

        return usuariosPorUsername(username);
    }


    private Usuario usuariosPorUsername(String username) {
        List<GrantedAuthority> adminAuthorities = new ArrayList<>();
        adminAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        List<GrantedAuthority> usuarioAuthorities = new ArrayList<>();
        usuarioAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));


        Usuario usuario = new Usuario(1L, "user", this.passwordEncoder.encode("user"), "Ana Alice Cristina");
        usuario.setAuthorities(usuarioAuthorities);

        Usuario usuarioAdmin = new Usuario(2L, "admin", this.passwordEncoder.encode("admin"), "Tommy Anderson Blink");
        usuarioAdmin.setAuthorities(adminAuthorities);


        Map<String, Usuario> usuarios = new HashMap<>();
        usuarios.put("user", usuario);
        usuarios.put("admin", usuarioAdmin);

        return usuarios.get(username);

    }

}
