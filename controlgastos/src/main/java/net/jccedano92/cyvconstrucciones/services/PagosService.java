package net.jccedano92.cyvconstrucciones.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jccedano92.cyvconstrucciones.dto.PagosDto;
import net.jccedano92.cyvconstrucciones.entity.PagosEntity;
import net.jccedano92.cyvconstrucciones.entity.ProyectoEntity;
import net.jccedano92.cyvconstrucciones.entity.VendedorEntity;
import net.jccedano92.cyvconstrucciones.model.request.PagosRequestModel;
import net.jccedano92.cyvconstrucciones.repository.PagosRepository;
import net.jccedano92.cyvconstrucciones.repository.ProyectoRepository;
import net.jccedano92.cyvconstrucciones.repository.VendedorRepository;
import net.jccedano92.cyvconstrucciones.utils.DateFormatJCCV;

@Service
public class PagosService implements PagosServiceInterface{

	
	@Autowired
	PagosRepository pagosRepository;
	
	@Autowired
	ProyectoRepository proyectoRepository;
	
	@Autowired
	VendedorRepository vendedorRepository;
	
	@Autowired
	ModelMapper mapper;
	
	
	
	
	@Override
	public PagosDto createPago(PagosRequestModel pagos) {

		
		ProyectoEntity proyectoEntity = proyectoRepository.findById( pagos.getProyectoId());
		
		VendedorEntity vendedorEntity = vendedorRepository.findById( pagos.getVendedorId());
		
		
		PagosEntity pagoEntity = new PagosEntity();
		
		
		pagoEntity.setProyecto(proyectoEntity);
		
		pagoEntity.setVendedor(vendedorEntity);;
		
		pagoEntity.setFechaEmision(DateFormatJCCV.ParseStringToDate(pagos.getFechaEmision())); //convertir a date
		
		pagoEntity.setNumeroFactura(pagos.getNumeroFactura());
		
		pagoEntity.setCosto(pagos.getCosto());
		
		pagoEntity.setDescripcion(pagos.getDescripcion());
		
		
		
		PagosEntity createdPago = pagosRepository.save(pagoEntity);
		
		PagosDto pagoToReturn = mapper.map(createdPago, PagosDto.class);
		
		return pagoToReturn;
	}




	@Override
	public List<PagosDto> getAllPagos() {

		List<PagosEntity> pagosEntity = pagosRepository.getAllPagos();
		
		List<PagosDto> pagosDtos = new ArrayList<>();
		
		for( PagosEntity t : pagosEntity) {
			
			PagosDto pago = mapper.map(t, PagosDto.class);
			
			pagosDtos.add(pago);
			
		}
		
		return pagosDtos;

	}




	@Override
	public PagosDto getPagoById(long id) {

		PagosEntity pagoEntity = pagosRepository.findById( id );
		
		PagosDto pagoDtos = mapper.map(pagoEntity, PagosDto.class);
		
		return pagoDtos;
	}




	@Override
	public void deletePago(long id) {

		PagosEntity pagoEntity = pagosRepository.findById( id );
		
		pagosRepository.delete( pagoEntity );
		
	}




	@Override
	public PagosDto updatePago(long id, PagosRequestModel pago) {

		PagosEntity pagoEntity = pagosRepository.findById( id );

		ProyectoEntity proyectoEntity = proyectoRepository.findById( pago.getProyectoId());
		
		VendedorEntity vendedorEntity = vendedorRepository.findById( pago.getVendedorId());
		
		
		pagoEntity.setProyecto(proyectoEntity);
		
		pagoEntity.setVendedor(vendedorEntity);;
		
		pagoEntity.setFechaEmision(DateFormatJCCV.ParseStringToDate(pago.getFechaEmision())); 
		
		pagoEntity.setNumeroFactura(pago.getNumeroFactura());
		
		pagoEntity.setCosto(pago.getCosto());
		
		pagoEntity.setDescripcion(pago.getDescripcion());
		
		
		
		PagosEntity createdPago = pagosRepository.save(pagoEntity);
		
		PagosDto pagoToReturn = mapper.map(createdPago, PagosDto.class);
		
		return pagoToReturn;

	}




	@Override
	public List<PagosDto> getAllPagosWhereMatchProyectoId(long proyectoId) {

		List<PagosEntity> pagosEntity = pagosRepository.getAllPagosWhereMatchProyectoId( proyectoId );
		
		List<PagosDto> pagosDtos = new ArrayList<>();
		
		for( PagosEntity t : pagosEntity) {
			
			PagosDto pago = mapper.map(t, PagosDto.class);
			
			pagosDtos.add(pago);
			
		}
		
		return pagosDtos;
	}




	@Override
	public List<PagosDto> getAllPagosWhereMatchVendedorId(long oficioId) {
		
		List<PagosEntity> pagosEntity = pagosRepository.getAllPagosWhereMatchVendedorId( oficioId );
		
		List<PagosDto> pagosDtos = new ArrayList<>();
		
		for( PagosEntity t : pagosEntity) {
			
			PagosDto pago = mapper.map(t, PagosDto.class);
			
			pagosDtos.add(pago);
			
		}
		
		return pagosDtos;

	}
	
	
}
