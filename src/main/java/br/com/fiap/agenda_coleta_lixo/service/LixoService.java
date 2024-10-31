package br.com.fiap.agenda_coleta_lixo.service;

import br.com.fiap.agenda_coleta_lixo.model.LixoModel;
import br.com.fiap.agenda_coleta_lixo.repository.LixoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LixoService {
    @Autowired
    private LixoRepository lixoRepository;

    public List<LixoModel> getAllLixo() {
        return lixoRepository.findAll();
    }

    public Optional<LixoModel> getLixoById(String id) {
        return lixoRepository.findById(id);
    }

    public LixoModel createLixo(LixoModel lixoModel) {
        return lixoRepository.save(lixoModel);
    }

    public LixoModel updateLixo(String id, LixoModel lixoDetails) {
        return lixoRepository.findById(id).map(lixo -> {
            lixo.setTipo(lixoDetails.getTipo());
            lixo.setDia(lixoDetails.getDia());
            lixo.setHorario(lixoDetails.getHorario());
            lixo.setEndereco(lixoDetails.getEndereco());
            return lixoRepository.save(lixo);
        }).orElseGet(() -> {
            lixoDetails.setId(id);
            return lixoRepository.save(lixoDetails);
        });
    }

    public void deleteLixo(String id) {
        lixoRepository.deleteById(id);
    }
}

