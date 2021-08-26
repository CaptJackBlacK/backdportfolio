package com.jeffdoug.dportfolio.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jeffdoug.dportfolio.domain.Cliente;
import com.jeffdoug.dportfolio.domain.enums.TipoCliente;

public class DashboardDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Cliente> clientes = new ArrayList<>();
	private List<Cliente> clientesPresumido = new ArrayList<>();
	private List<Cliente> clientesSimples = new ArrayList<>();
	private List<Cliente> clientesMesAnterior = new ArrayList<>();
	private Integer tamClientes = 0;
	private Integer tamClientesPresumido = 0;
	private Integer tamClientesSimples = 0;
	private Integer tamClientesMesAnterior = 0;
	
	
	public DashboardDTO() {
		
	}
	
	public DashboardDTO(List<Cliente> clientes) throws Exception {
		PreencheListas(clientes);
	}
	
	public void PreencheListas(List<Cliente> clientes) throws Exception{
		
		for (Cliente c : clientes) {
			
			if ( c.getTipo() == TipoCliente.LUCROPRESUMIDO ) {
				this.clientesPresumido.add(c);
			} else if ( c.getTipo() == TipoCliente.SIMPLESNACIONAL ) {
				this.clientesSimples.add(c);
			}
		}
		this.tamClientes = clientes.size();
		this.tamClientesPresumido = clientesPresumido.size();
		this.tamClientesSimples = clientesSimples.size();
		this.tamClientesMesAnterior = clientesMesAnterior.size();
	}
	
	public void ContaData() {
		
	}
	
	public Integer getTamClientes() {
		return tamClientes;
	}

	public Integer getTamClientesPresumido() {
		return tamClientesPresumido;
	}

	public Integer getTamClientesSimples() {
		return tamClientesSimples;
	}

	public Integer getTamClientesMesAnterior() {
		return tamClientesMesAnterior;
	}
	
	
}
