package br.com.lucas.Exception;

public class AutomacaoException extends RuntimeException {

	private static final long serialVersionUID = -3099708112099740859L;

	public AutomacaoException(String mensagem, Throwable e) {
		super(mensagem, e);
	}

	public AutomacaoException(String mensagem) {
		super(mensagem);
	}

	public AutomacaoException(Throwable e) {
		super(e);
	}
}
