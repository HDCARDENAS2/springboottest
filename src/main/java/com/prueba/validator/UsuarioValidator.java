package com.prueba.validator;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.prueba.controller.constants.ApiContants;
import com.prueba.controller.constants.MsgUsuarioValidatorConstants;
import com.prueba.exception.CustomException;
import com.prueba.model.dto.UsuarioDTO;

/**
 * @author hernanC <dropimax@gmail.com>
 * @date 13/08/2020
 */
@Component
public class UsuarioValidator {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * @author hernanC <dropimax@gmail.com>
	 * @throws Exception
	 * @date 13/08/2020
	 */
	public void bussinesLogic(UsuarioDTO usuario) throws Exception {

		try {

			if (usuario.getEdad() < 18) {
				throw new CustomException(MsgUsuarioValidatorConstants.MSG_V_1);
			} else if (!(usuario.getSexo() == 'M' || usuario.getSexo() == 'F')) {
				throw new CustomException(MsgUsuarioValidatorConstants.MSG_V_2);
			}

			Date fechaNacimiento = new SimpleDateFormat(ApiContants.DEFAULT_FORMAT_DATE).parse(usuario.getFechaNacimiento());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fechaNacimiento);

			LocalDate today = LocalDate.now();
			LocalDate birthday = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
					calendar.get(Calendar.DAY_OF_MONTH));

			Period period = Period.between(birthday, today);

			if (period.getYears() != usuario.getEdad()) {
				throw new CustomException(MsgUsuarioValidatorConstants.MSG_V_3);
			}

			String usuarioData = usuario.getUsuario().toLowerCase();

			List<String> dataValidateUserio = new ArrayList<>();

			dataValidateUserio.addAll(Arrays.asList(usuario.getNombres().toLowerCase().split(" ")));
			dataValidateUserio.addAll(Arrays.asList(usuario.getApellidos().toLowerCase().split(" ")));

			for (String valueData : dataValidateUserio) {
				if (usuarioData.contains(valueData)) {
					throw new CustomException(
							MsgUsuarioValidatorConstants.MSG_V_4);
				}
			}

			String claveTemp = usuario.getClave();

			List<String> dataValidateClave = new ArrayList<>();
			dataValidateClave.add(calendar.get(Calendar.DAY_OF_MONTH) + "");
			dataValidateClave.add((calendar.get(Calendar.MONTH) + 1) + "");
			dataValidateClave.add(calendar.get(Calendar.YEAR) + "");
			dataValidateClave.add(calendar.get(Calendar.DAY_OF_MONTH) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-"
					+ calendar.get(Calendar.YEAR));
			dataValidateClave.add(calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
					+ calendar.get(Calendar.YEAR));
			
			for (String valueData : dataValidateClave) {
				if (claveTemp.contains(valueData)) {
					throw new CustomException(
							MsgUsuarioValidatorConstants.MSG_V_5);
				}
			}
			

		} catch (CustomException e) {
			throw e;
		} catch (Exception ex) {
			logger.error(ex.getClass().getName());
			throw ex;
		}
	}

}
