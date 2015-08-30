package projeto.maispop.usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CelebridadePop implements TipoUsuario {

    @Override
    public void curir(Postagem postagem) {
	int bonus = isAtividadeRecente(postagem.getData()) ? 10 : 0;
	postagem.curtir(25 + bonus);
    }

    @Override
    public void descurtir(Postagem postagem) {
	int bonus = isAtividadeRecente(postagem.getData()) ? 10 : 0;
	postagem.descurtir(25 + bonus);
    }

    private boolean isAtividadeRecente(String dataPostagem) {
	DateTimeFormatter formatoDataHora = DateTimeFormatter
		.ofPattern("yyyy-MM-dd HH:mm:ss");

	DateTimeFormatter formatoData = DateTimeFormatter
		.ofPattern("yyyy-MM-dd");

	dataPostagem = LocalDate.parse(dataPostagem, formatoDataHora).format(
		formatoData);

	return dataPostagem.equals(LocalDate.now().toString());
    }
}
