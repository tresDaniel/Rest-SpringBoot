package br.com.tresdaniel.serialization.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class YamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {

	public YamlJackson2HttpMessageConverter() {
		super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
	}

	
}
