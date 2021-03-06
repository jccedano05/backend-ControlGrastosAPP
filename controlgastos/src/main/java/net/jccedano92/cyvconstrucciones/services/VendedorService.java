package net.jccedano92.cyvconstrucciones.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jccedano92.cyvconstrucciones.dto.VendedorDto;
import net.jccedano92.cyvconstrucciones.entity.VendedorEntity;
import net.jccedano92.cyvconstrucciones.model.request.VendedorRequestModel;
import net.jccedano92.cyvconstrucciones.repository.VendedorRepository;

@Service
public class VendedorService implements VendedorServiceInterface{

	
	@Autowired
	VendedorRepository vendedorRepository;
	
	@Autowired
	ModelMapper mapper;
	



	@Override
	public VendedorDto createVendedor(VendedorRequestModel vendedor) {

		VendedorEntity vendedorEntity = new VendedorEntity();
		
		vendedorEntity.setNombre( vendedor.getNombre() );
		vendedorEntity.setRfc( vendedor.getRfc() );
		vendedorEntity.setDescripcion( vendedor.getDescripcion() );
		
		VendedorEntity createdVendedor = vendedorRepository.save( vendedorEntity );
		
		VendedorDto vendedorToReturn = mapper.map( createdVendedor , VendedorDto.class);
		
		return vendedorToReturn;
		
	}




	@Override
	public List<VendedorDto> getAllVendedores() {

		List<VendedorEntity> vendedorEntities = vendedorRepository.getAllVendedores();
		
		List<VendedorDto> vendedorDtos = new ArrayList<>();
		
		for( VendedorEntity v : vendedorEntities) {
			
			VendedorDto vendedor = mapper.map(v, VendedorDto.class);
			
			vendedorDtos.add(vendedor);
			
		}
		
		return vendedorDtos;
	}




	@Override
	public VendedorDto getVendedorById(long id) {

		VendedorEntity vendedorEntity = vendedorRepository.findById( id );
		
		VendedorDto vendedorDto = mapper.map(vendedorEntity, VendedorDto.class);
		
		return vendedorDto;
	}




	@Override
	public void deleteVendedor(long id) {

		VendedorEntity vendedorEntity = vendedorRepository.findById( id );
		
		vendedorRepository.delete( vendedorEntity );
	}




	@Override
	public VendedorDto updateVendedor(long id, VendedorRequestModel vendedor) {

		VendedorEntity vendedorEntity = vendedorRepository.findById( id );
		
		
		vendedorEntity.setNombre(vendedor.getNombre());
		vendedorEntity. setRfc(vendedor.getRfc());
		vendedorEntity.setDescripcion(vendedor.getDescripcion());
		
		VendedorEntity updatedVendedor = vendedorRepository.save(vendedorEntity);
		
		VendedorDto vendedorToReturn = mapper.map(updatedVendedor, VendedorDto.class);
		
		return vendedorToReturn;
	}
	
	
}
