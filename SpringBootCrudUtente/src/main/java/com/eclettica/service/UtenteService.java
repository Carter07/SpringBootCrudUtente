package com.eclettica.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eclettica.model.Utente;
import com.eclettica.repository.UtenteRepository;

@Service
@Transactional
public class UtenteService implements UtenteServiceI {
	
	 
	 @Autowired
	 UtenteRepository utenteRepository;

	 @Override
	 public List<Utente> getAllUtenti() {
	  return (List<Utente>) utenteRepository.findAll();
	 }

	 @Override
	 public Utente getUtenteById(long id) {
	  return utenteRepository.findById(id).get();
	 }

	 @Override
	 public void saveOrUpdate(Utente utente) {
	  utenteRepository.save(utente);
	 }

	 @Override
	 public void deleteUtente(long id) {
	  utenteRepository.deleteById(id);
	 }

}
