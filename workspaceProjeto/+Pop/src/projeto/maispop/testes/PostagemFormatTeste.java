package projeto.maispop.testes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import projeto.maispop.excecoes.EntradaException;
<<<<<<< HEAD
=======
import projeto.maispop.usuario.IconePop;
import projeto.maispop.usuario.PostagemString;
import projeto.maispop.usuario.TipoUsuario;
>>>>>>> objetoMidia

public class PostagemFormatTeste {

    @Test
    public void test() throws EntradaException {

<<<<<<< HEAD
=======
	PostagemString postagemQualquer = new PostagemString(
		"Texto qualquer. <audio caminho</audio>  #teste2",
		"29/08/2015 04:44:23");
	TipoUsuario usuarioCelebridade = new IconePop();
>>>>>>> objetoMidia

	//System.out.println(postagemQualquer.getHashTags());

	//usuarioCelebridade.descurtir(postagemQualquer);

	//System.out.println(postagemQualquer.getHashTags());

	System.out.println("-----Data-----");

	String dataNascimento = "29/02/1995";
	System.out.println(validaData(dataNascimento));

    }

    public String validaData(String dataNascimento) {
	DateTimeFormatter padraoInicial = DateTimeFormatter
		.ofPattern("dd/MM/yyyy");
	DateTimeFormatter padraoFinal = DateTimeFormatter
		.ofPattern("yyyy-MM-dd");
	
	String dataNascimentoFinal = LocalDate.parse(dataNascimento, padraoInicial).format(
		padraoFinal);
	
	String dataNascimentoInicial = LocalDate.parse(dataNascimentoFinal, padraoFinal).format(
		padraoInicial);
	
	if (!(dataNascimento.equals(dataNascimentoInicial))) {
	    return "bissexto";
	}
	


	return dataNascimentoFinal;
    }

}