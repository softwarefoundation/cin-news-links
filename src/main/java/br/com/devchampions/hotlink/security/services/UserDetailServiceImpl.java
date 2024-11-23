package br.com.devchampions.hotlink.security.services;

import br.com.devchampions.hotlink.dto.UsuarioDto;
import br.com.devchampions.hotlink.entity.Roles;
import br.com.devchampions.hotlink.entity.Usuario;
import br.com.devchampions.hotlink.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuarioOptional = this.usuarioRepository.findByUsername(username);

        if (usuarioOptional.isPresent()) {

            Usuario usuario = usuarioOptional.get();

            UsuarioDto usuarioDto = new UsuarioDto(usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.getNome());

            List<GrantedAuthority> authorities = new ArrayList<>();
            if (usuario.getRoles() != null) {

                for (Roles role : usuario.getRoles()) {
                    authorities.add(new SimpleGrantedAuthority(role.getNome()));
                }
                usuarioDto.setAuthorities(authorities);
            }

            return usuarioDto;

        } else {
            throw new UsernameNotFoundException("Usuário ou senha inválidos: ".concat(username));
        }
    }

}
