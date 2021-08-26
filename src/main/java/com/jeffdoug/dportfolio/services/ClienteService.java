package com.jeffdoug.dportfolio.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jeffdoug.dportfolio.domain.Cliente;
import com.jeffdoug.dportfolio.dto.ClienteDTO;
import com.jeffdoug.dportfolio.repositories.ClienteRepository;
import com.jeffdoug.dportfolio.services.exceptions.DataIntegrityException;
import com.jeffdoug.dportfolio.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) throws ObjectNotFoundException {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Cliente update(Cliente obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
		}
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public String countDatas(){
		Calendar dat = Calendar.getInstance();
		dat.setTime(new Date());
		dat.add(Calendar.MONTH,-1);
		return repo.findByData(dat.getTime(), new Date());
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getRazao(), objDto.getCnpj(), objDto.getEmail(), objDto.getTipo(), objDto.getData());
	}
	
	
}