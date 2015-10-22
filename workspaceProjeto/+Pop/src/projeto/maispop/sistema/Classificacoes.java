package projeto.maispop.sistema;

import java.util.List;
import java.util.Map;

import projeto.maispop.usuario.Usuario;

public class Classificacoes {

	private List<Usuario> listaUsuarios;

	private Map<Usuario, Integer> mapaPopularidade;
	private Map<String, Integer> mapaHashtag;

	public Classificacoes(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	private void atualizaMapaPopularidade() {
		for (Usuario usuario : listaUsuarios) {
			mapaPopularidade.put(usuario, usuario.getPopularidade());
		}
	}
	
	private void atualizaMapaHashtag() {
		for (Usuario usuario : listaUsuarios) {
			
		}
	}

}
