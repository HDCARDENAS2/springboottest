package com.prueba.model.mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.prueba.controller.constants.ApiContants;
import com.prueba.model.dto.UsuarioDTO;
import com.prueba.model.entity.Usuario;

/**
 * @author hernanC <dropimax@gmail.com>
 * @date 13/08/2020
 */
@Mapper(componentModel = "spring")
public interface UsuarioMapper  {
	
	
	/**
	 * 
	 * 
	 * @author hernanC <dropimax@gmail.com>
	 * @date 13/08/2020
	 */
    @Mapping(target = "fechaNacimiento", qualifiedByName = "dateToString")
	UsuarioDTO entityToDataTransferObject(Usuario entity);
	
	/**
	 * 
	 * 
	 * @author hernanC <dropimax@gmail.com>
	 * @date 13/08/2020
	 */
    @InheritInverseConfiguration
    @Mapping(target = "fechaNacimiento", qualifiedByName = "stringToDate")
    Usuario dataTransferObjectToEntity(UsuarioDTO dataTransferObject);
    
    @Named("StringToDate")
    default Date stringToDate(String in) throws ParseException {
    	return new SimpleDateFormat(ApiContants.DEFAULT_FORMAT_DATE).parse(in);  
    }
    
    @Named("DateToString")
    default String dateToString(Date in) {
    	 DateFormat dateFormat = new SimpleDateFormat(ApiContants.DEFAULT_FORMAT_DATE);  
    	 return dateFormat.format(in);  
    }


}
