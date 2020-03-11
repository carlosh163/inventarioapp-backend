package com.kajucode.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kajucode.model.Personal;
import com.kajucode.model.Usuario;
import com.kajucode.repositorio.IPersonalRepo;
import com.kajucode.repositorio.IUsuarioRepo;
import com.kajucode.service.IUsuarioService;

@Service
public class UserServiceImpl implements IUsuarioService {
	
	@Autowired
	private IPersonalRepo repo;
	
	@Autowired
	private IUsuarioRepo userRepo;
	
	@Value("${kajuinventario.default-rol}")
	private Integer DEFAULT_ROL;
	
	/*@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userRepo.findOneByUsername(username); //from usuario where username := username
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		user.getRoles().forEach( role -> {
			authorities.add(new SimpleGrantedAuthority(role.getNombre()));
		});
		
		UserDetails userDetails = new User(user.getUsername(), user.getPassword(), authorities);
		
		return userDetails;
	}*/

	@Transactional
	@Override
	public Usuario registrarTransaccional(Usuario usuario) {	
		Usuario u;
		try {
			u = userRepo.save(usuario);	
			userRepo.registrarRolPorDefecto(u.getIdUsuario(), DEFAULT_ROL);	
		}catch(Exception e) {
			throw e;
		}
		
		return u;
		
	}
	
	
	
	
	
	@Transactional
	@Override
	public Usuario modificar(Usuario u) {
		System.out.println("rol:"+u.getRoles().size());
		if(u.getRoles().size()>0) {
			u.getRoles().stream().forEach(data ->{
				userRepo.registrarRolPorDefecto(u.getIdUsuario(), data.getIdRol());
			});
		}
		
			
		return userRepo.save(u);
	}

	@Override
	public Usuario registrar(Usuario t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario leer(Integer id) {
		Optional<Usuario> op = userRepo.findById(id);
		return op.isPresent() ? op.get() : new Usuario();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
		
	}
	
	
	/*@Override
	public Usuario CargarDatosUsuario(String username) throws UsernameNotFoundException {
		Usuario user = userRepo.findOneByUsername(username); //from usuario where username := username
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		
		
		return user;
	}*/
	

}
