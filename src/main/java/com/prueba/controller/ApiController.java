package com.prueba.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.controller.constants.MsgApiControllerConstants;
import com.prueba.exception.CustomException;
import com.prueba.model.dto.UsuarioDTO;
import com.prueba.service.impl.UsuarioService;

/**
 * @author hernanC <dropimax@gmail.com>
 * @date 13/08/2020
 */

@RestController
@RequestMapping({ "/test" })
public class ApiController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UsuarioService usuarioService;

	/**
	 * @author hernanC <dropimax@gmail.com>
	 * @date 13/08/2020
	 */
	@PostMapping("/usuario")
	public ResponseEntity<HashMap<String, Object>> saveUsuario(@Valid @RequestBody UsuarioDTO usuario, BindingResult result) {

		HashMap<String, Object> response = new HashMap<>();
		HttpStatus codeReponse = HttpStatus.INTERNAL_SERVER_ERROR;

		try {
					
			if (result.hasErrors()) {
				
				List<String> errors = result.getFieldErrors().stream()
						.map(err -> err.getDefaultMessage())
						.collect(Collectors.toList());

				response.put("messages", errors);
				codeReponse = HttpStatus.BAD_REQUEST;
				
			}else {
				UsuarioDTO usuarioSave = usuarioService.saveUsuario(usuario);
				response.put("message",String.format(MsgApiControllerConstants.MSG_SAVE_USUARIO, usuarioSave.getId()));
				codeReponse = HttpStatus.OK;	
			}
	
		} catch (CustomException e) {	
			response.put("message", e.getMessage());
			codeReponse = HttpStatus.BAD_REQUEST;
		} catch (Exception ex) {
			logger.error(ex.getClass().getName(), ex);
			response.put("message", MsgApiControllerConstants.MSG_FAIL);
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<HashMap<String, Object>>(response, responseHeaders, codeReponse);

	}

}
