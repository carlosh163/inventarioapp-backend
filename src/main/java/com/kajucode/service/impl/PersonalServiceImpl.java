package com.kajucode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kajucode.model.Personal;
import com.kajucode.model.Usuario;
import com.kajucode.repositorio.IPersonalRepo;
import com.kajucode.repositorio.IUsuarioRepo;
import com.kajucode.service.IPersonalService;

@Service
public class PersonalServiceImpl implements IPersonalService{

	@Autowired
	private IPersonalRepo repo;
	
	@Autowired
	private IUsuarioRepo userRepo;
	
	
	@Override
	public Personal registrar(Personal obj) {
		return repo.save(obj);
	}

	//@Transactional
	@Override
	public Personal modificar(Personal obj) {
		/*if(obj.getFoto().length > 0) {
			repo.modificarFoto(obj.getIdPersonal(), obj.getFoto());
			//repoUsu.modificarUsuarioP(obj.getIdPersonal(), obj.getUsuario().getPassword());
		}	*/
		return repo.save(obj);
	}

	@Override
	public List<Personal> listar() {
		return repo.findAll();
	}
	
	@Override
	public Page<Personal> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
	

	@Override
	public Personal leer(Integer id) {
		Optional<Personal> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Personal();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}
	
	@Override
	public Personal listarPersonalPorNombreUsuario(String nombre) {		
		Personal menus = new Personal();
		
		
		menus = repo.listarPersonalPorNombreUsuario(nombre);
		
		return menus;			
	}
	
	/*@Override
	public Personal leerNombreUser(String param) {
		return repo.findByParametro(param);
	}*/
	
	/*@Override
	public Usuario CargarDatosUsuario(String username) throws UsernameNotFoundException {
		Usuario user = userRepo.findOneByUsername(username); //from usuario where username := username
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		
		
		return user;
	}*/

	
}
