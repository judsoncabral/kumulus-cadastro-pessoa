package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import model.Endereco;
import model.Pessoa;
import service.EnderecoService;
import service.PessoaService;


@Data
@Named
@ViewScoped
public class EnderecoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Endereco endereco;
	private List<Endereco> enderecos;
	private boolean update;
	private List<Pessoa> pessoas;

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private PessoaService pessoaService;


	@PostConstruct
	public void init() {
		pessoas = pessoaService.findAll();
		if(enderecos == null) {
			endereco = new Endereco();
			enderecos = new ArrayList<>();
		}
		enderecos = enderecoService.findAll();
	}

	public void salvar() {
		if (this.update) {
			enderecoService.update(endereco);
			this.update = false;
		} else {
			enderecoService.save(endereco);
		}
		endereco = new Endereco();
		init();
	}

	public void excluir(Long enderecoId) {
		enderecoService.delete(enderecoId);
		init();
	}

	public void edit(Endereco endereco) {
		this.update = true;
		this.endereco = endereco;
	}

	public void cancelEdit() {
		this.endereco = new Endereco();
		this.update = false;
	}

}
