package com.kajucode.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kajucode.model.Personal;


public interface IPersonalRepo extends JpaRepository<Personal, Integer>{
	@Modifying
	@Query("UPDATE Personal set foto = :foto where id = :id")
	void modificarFoto(@Param("id") Integer id, @Param("foto") byte[] foto);
	


	
	@Query(value="SELECT clie.*\r\n" + 
			"	FROM Personal clie\r\n" + 
			"	inner join usuario usu	on usu.id_usuario = clie.id_personal\r\n" + 
			"	where usu.nombre = :nombre ;", nativeQuery = true)
	Personal listarPersonalPorNombreUsuario(@Param("nombre") String nombre);
}
