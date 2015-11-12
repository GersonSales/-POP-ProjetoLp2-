package projeto.maispop.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListaDeAmigos implements Iterable<Amigavel>, Serializable {

	private List<Amigavel> listaDeAmigos;
	private Set<Amigavel> pendentes;

	public ListaDeAmigos() {
		this.listaDeAmigos = new ArrayList<>();
		this.pendentes = new HashSet<>();

	}

	public void aceitaAmizade(Amigavel amigo) {
		this.listaDeAmigos.add(amigo);
		this.pendentes.remove(amigo);
	}

	public void adicionaAmigo(Amigavel amigo) {
		this.pendentes.add(amigo);
	}

	public boolean contemAmigo(String emailUsuario) {
		for (Amigavel amigavel : listaDeAmigos) {
			if (amigavel.getEmail().equals(emailUsuario)) {
				return true;
			}
		}
		return false;
	}

	public boolean contemPendencia(String emailUsuario) {
		for (Amigavel amigavel : pendentes) {
			if (amigavel.getEmail().equals(emailUsuario)) {
				return true;
			}
		}
		return false;
	}

	public int getQtdAmigos() {
		return this.listaDeAmigos.size();
	}

	@Override
	public Iterator<Amigavel> iterator() {
		return this.listaDeAmigos.iterator();
	}

	public void rejeitaAmizade(Amigavel amigo) {
		this.pendentes.remove(amigo);

	}


	public void removeAmigo(Amigavel amigo) {
		this.listaDeAmigos.remove(amigo);
	}

}
