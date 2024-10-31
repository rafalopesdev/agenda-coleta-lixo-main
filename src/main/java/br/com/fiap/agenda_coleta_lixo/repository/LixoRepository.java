package br.com.fiap.agenda_coleta_lixo.repository;

import br.com.fiap.agenda_coleta_lixo.model.LixoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LixoRepository extends MongoRepository<LixoModel, String> {
}

