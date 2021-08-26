package com.jeffdoug.dportfolio.dto;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.jeffdoug.dportfolio.domain.Cliente;
import com.jeffdoug.dportfolio.domain.enums.TipoCliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	private String razao;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=14, max=14, message="O tamanho correto do CNPJ é de 14 caracteres")
	private String cnpj;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	private String email;
	
	private TipoCliente tipo;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data;

	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		razao = obj.getRazao();
		cnpj = obj.getCnpj();
		email = obj.getEmail();
		tipo = obj.getTipo();
		data = obj.getData();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazao() {
		return razao;
	}

	public void getRazao(String razao) {
		this.razao = razao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

	public String getDataFormatada() {
		Date dataAtual = getData();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat.format(dataAtual);
        return dataFormatada;
	}

	public Date getData() {
		return data;
	}

	
	public void setData(Date data) {
		this.data = data;
	}
	
	
}