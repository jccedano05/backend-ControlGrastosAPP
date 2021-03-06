package net.jccedano92.cyvconstrucciones;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.jccedano92.cyvconstrucciones.dto.ClienteDto;
import net.jccedano92.cyvconstrucciones.dto.OficiosDto;
import net.jccedano92.cyvconstrucciones.dto.ProyectoDto;
import net.jccedano92.cyvconstrucciones.dto.VendedorDto;
import net.jccedano92.cyvconstrucciones.model.responses.ClienteRest;
import net.jccedano92.cyvconstrucciones.model.responses.OficiosRest;
import net.jccedano92.cyvconstrucciones.model.responses.ProyectoRest;
import net.jccedano92.cyvconstrucciones.model.responses.VendedorRest;
import net.jccedano92.cyvconstrucciones.security.AppProperties;

@SpringBootApplication
public class ControlgastosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlgastosApplication.class, args);
		System.out.println("funcionando");
	}
	
	
	@Bean
	public BCryptPasswordEncoder bCryptPassword() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}
	
	
	@Bean(name = "AppProperties")
	public AppProperties getAppProperties() {
		return new AppProperties();
	}
	
	@Bean
	public ModelMapper modelMapper () {
		ModelMapper mapper = new ModelMapper();
		
		mapper.typeMap(ClienteDto.class, ClienteRest.class).addMappings(m -> m.skip(ClienteRest::setListarProyectos));
		mapper.typeMap(ProyectoDto.class, ProyectoRest.class).addMappings(m -> m.skip(ProyectoRest::setListarTrabajadores));
		mapper.typeMap(VendedorDto.class, VendedorRest.class).addMappings(m -> m.skip(VendedorRest::setListarPagos));
		mapper.typeMap(OficiosDto.class, OficiosRest.class).addMappings(m -> m.skip(OficiosRest::setListarTrabajadores));
			
		return mapper;
	}

	
	

}
