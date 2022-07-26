package it.teorema.gestech.model;

import java.io.Serializable;

public class ResponseWrapper<T> implements Serializable {

    private static final long serialVersionUID = 3673698610730090932L;

    private String code;
    private String descrizione;
    private T payload;

	public String getCode() {
		return code;
	}

	public void setCode(String codice) {
		this.code = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}
}