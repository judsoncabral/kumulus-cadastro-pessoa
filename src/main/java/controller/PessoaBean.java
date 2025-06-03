package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Data;
import model.Pessoa;
import model.Sexo;
import service.PessoaService;

@Data
@Named
@ViewScoped
public class PessoaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private boolean update;
	private List<Sexo> sexoList;

	@Inject
	private PessoaService pessoaService;

	@PostConstruct
	public void init() {
		if(pessoas == null) {
			pessoa = new Pessoa();
			pessoas = new ArrayList<>();
			sexoList = Arrays.asList(Sexo.values());
		}
		pessoas = pessoaService.findAll();
	}

	public void salvar() {
		if (this.update) {
			pessoaService.update(pessoa);
			this.update = false;
		} else {
			pessoaService.save(pessoa);
		}
		pessoa = new Pessoa();
		init();
	}

	public void excluir(Long pessoaId) {
		pessoaService.delete(pessoaId);
		init();
	}

	public void edit(Pessoa pessoa) {
		this.update = true;
		this.pessoa = pessoa;
	}

	public void cancelEdit() {
		this.pessoa = new Pessoa();
		this.update = false;
	}
}
