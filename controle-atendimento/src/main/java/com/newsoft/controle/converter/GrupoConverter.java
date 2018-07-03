package com.newsoft.controle.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.newsoft.controle.model.GrupoAcesso;

/**
 * Essa classe é responsável por conter o método que atribui um código a um grupo
 * @author EquipeACL
 *
 */
public class GrupoConverter implements Converter <String,GrupoAcesso> {
	
	/**
	 * Método responsável por atribuir um código a um grupo
	 * @param codigo, que é o código a ser atribuido a um grupo
	 * @return grupo or null, dependendo da validação do código
	 */
	@Override
	public GrupoAcesso convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			GrupoAcesso grupo = new GrupoAcesso();
			grupo.setId(Integer.valueOf(codigo));
			return grupo;
		}
		return null;
	}

}
