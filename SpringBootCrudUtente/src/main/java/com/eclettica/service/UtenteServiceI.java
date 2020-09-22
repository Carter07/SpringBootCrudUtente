package com.eclettica.service;

import java.util.List;
import com.eclettica.model.Utente;

public interface UtenteServiceI {
	
	 public List<Utente> getAllUtenti();
	 
	 public Utente getUtenteById(long id);
	 
	 public void saveOrUpdate(Utente utente);
	 
	 public void deleteUtente(long id);

}
