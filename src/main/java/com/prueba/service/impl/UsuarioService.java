package com.prueba.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prueba.dal.impl.UsuarioDAO;
import com.prueba.exception.CustomException;
import com.prueba.model.dto.UsuarioDTO;
import com.prueba.service.IUsuarioService;
import com.prueba.validator.UsuarioValidator;

/**
 * @author hernanC <dropimax@gmail.com>
 * @date 13/08/2020
 */
@Service
public class UsuarioService implements IUsuarioService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private UsuarioValidator usuarioValidator;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	/**
	 * @author hernanC <dropimax@gmail.com>
	 * @throws Exception 
	 * @date 13/08/2020
	 */
	@Override
	public UsuarioDTO saveUsuario(UsuarioDTO usuario) throws Exception {
		
		try {
			
			usuarioValidator.bussinesLogic(usuario);

			UsuarioDTO findUsuario = usuarioDAO.findByIdentificacion(usuario.getIdentificacion());
	
			if( findUsuario != null) {
				usuario.setId(findUsuario.getId());
			}else {
				usuario.setId(null);
			}
			
			usuario.setClave(passwordEncoder.encode(usuario.getClave()));
			
			UsuarioDTO usuarioSave = usuarioDAO.saveUsuario(usuario);	
			
			return usuarioSave;
			
		}  catch (CustomException e) {
			throw e;
		}  catch (Exception ex) {
			logger.error(ex.getClass().getName());
			throw ex;
		}
	}
	

}
