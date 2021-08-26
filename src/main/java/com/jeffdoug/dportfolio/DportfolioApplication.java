package com.jeffdoug.dportfolio;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jeffdoug.dportfolio.domain.Cliente;
import com.jeffdoug.dportfolio.domain.enums.TipoCliente;
import com.jeffdoug.dportfolio.dto.DashboardDTO;
import com.jeffdoug.dportfolio.repositories.ClienteRepository;

@SpringBootApplication
public class DportfolioApplication implements CommandLineRunner {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DportfolioApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Cliente cli1 = new Cliente(null, "Jefferson Douglas", "69009125568", "jefferson@gmail.com",  TipoCliente.LUCROPRESUMIDO, sdf.parse("01/07/2021"));
		Cliente cli2 = new Cliente(null, "Alan", "69009125568", "jefferson@gmail.com",  TipoCliente.SIMPLESNACIONAL, sdf.parse("05/01/2021"));
		Cliente cli3 = new Cliente(null, "Matheus", "69009125568", "jefferson@gmail.com",  TipoCliente.SIMPLESNACIONAL,  sdf.parse("29/07/2021"));
		Cliente cli4 = new Cliente(null, "Breno", "69009125568", "jefferson@gmail.com",  TipoCliente.LUCROPRESUMIDO,  sdf.parse("30/07/2021"));
		
		List<Cliente> saveAll = clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
		DashboardDTO dash = new DashboardDTO(saveAll);
		System.out.println("Clientes Total : "+dash.getTamClientes());
		System.out.println("Simples Total : "+dash.getTamClientesSimples());
		System.out.println("Presumido Total : "+dash.getTamClientesPresumido());
		System.out.println("Clientes do Mes Anterior : "+dash.getTamClientesMesAnterior());
		
		}
	
}
