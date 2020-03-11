package com.kajucode.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kajucode.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

	Usuario findOneByUsername(String username);
	
	@Modifying
	@Query(value = "INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (:idUsuario, :idRol)", nativeQuery = true)
	void registrarRolPorDefecto(@Param("idUsuario") Integer idUsuario, @Param("idRol") Integer idRol);
	
	
	/*@Modifying
	@Query("UPDATE Usuario set clave = :clave where id = :id")
	void modificarUsuarioPass(@Param("id") Integer id, @Param("clave") String clave);*/
}
