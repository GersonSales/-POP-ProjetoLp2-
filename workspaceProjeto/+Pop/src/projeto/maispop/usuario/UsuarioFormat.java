package projeto.maispop.usuario;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import projeto.maispop.excecoes.DataException;
import projeto.maispop.excecoes.EmailException;
import projeto.maispop.excecoes.ImagemException;
import projeto.maispop.excecoes.NomeException;
import projeto.maispop.excecoes.SenhaException;

public class UsuarioFormat {

	private static UsuarioFormat instancia;

	private UsuarioFormat() {
	}

	public static UsuarioFormat getInstancia() {
		if (instancia == null) {
			instancia = new UsuarioFormat();
		}
		return instancia;
	}

	public String validaNome(String nome) throws NomeException{
		String padraoNome = "(\\w+(\\s)*)+";
		if (nome.matches(padraoNome)) {
			return nome;
		}
		throw new NomeException("Nome dx usuarix nao pode ser vazio.");
	}

	public String validaSenha(String senha) throws SenhaException {
		String padraoSenha = ".*[^\\s]";
		if (senha.matches(padraoSenha)) {
			return senha;
		}

		throw new SenhaException();
	}

	public String validaDataNascimento(String dataNascimento)
			throws DataException {
		String padraoData = "[0-9]{2,2}/[0-9]{2,2}/[0-9]{4,4}";

		if (!(dataNascimento.matches(padraoData))) {
			throw new DataException("Formato de data esta invalida.");
		}

		try {
			DateTimeFormatter formatador = DateTimeFormatter
					.ofPattern("dd/MM/yyyy");
			LocalDate sData = LocalDate.parse(dataNascimento, formatador);
			sData = LocalDate.of(sData.getYear(), sData.getMonth(),
					Integer.parseInt(dataNascimento.substring(0, 2)));
			return sData.toString();

		} catch (DateTimeException erro) {
			if (erro.getMessage().contains("Invalid")) {
				throw new DataException("Data nao existe.");
			} else {
				throw new DataException("Formato de data esta invalida.");
			}
		}
	}

	public String validaEmail(String email) throws EmailException {
		String padraoEmail = "\\w+(\\.*\\w+)*@\\w+\\.\\w{2,3}(\\.{1,1}\\w{2,2})*";

		if (email.matches(padraoEmail)) {
			return email;
		}

		throw new EmailException("Formato de e-mail esta invalido.");
	}

	public String validaImagem(String imagem) throws ImagemException {
		String padraoImagem = "\\w+(/\\w+)*\\.(png|jpg)";

		if (imagem.matches(padraoImagem)) {
			return imagem;
		}

		throw new ImagemException();
	}

}
