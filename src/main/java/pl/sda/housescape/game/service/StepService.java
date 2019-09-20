package pl.sda.housescape.game.service;

import org.springframework.stereotype.Service;
import pl.sda.housescape.game.controller.StepForm;
import pl.sda.housescape.game.dao.GameEntity;
import pl.sda.housescape.game.dao.GameRepository;
import pl.sda.housescape.game.dao.StepEntity;
import pl.sda.housescape.game.dao.StepRepository;
import pl.sda.housescape.game.model.GameStep;
import pl.sda.housescape.upload.UploadService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StepService {

    private final GameRepository repository;
    private final StepRepository stepRepository;
    private final UploadService uploadService;


    public StepService(GameRepository repository, StepRepository stepRepository,UploadService uploadService) {
        this.repository = repository;
        this.stepRepository = stepRepository;
        this.uploadService = uploadService;
    }


    public void addStep(StepForm stepForm, Long idGame) {
//        StepEntity stepEntity = StepEntity
//                .builder()
//                .code(stepForm.getCode())
//                .description(stepForm.getDescription())
//                .imageUrl(stepForm.getImage().toString())
//                .gameEntity(repository.findAll().stream().filter(x -> x.getId().equals(idGame)).findFirst().orElse(null))
//                .build();
        stepRepository.save(StepEntity.create(stepForm.getDescription(), stepForm.getCode(), getImageUrl(stepForm)));
     //   stepRepository.save(stepEntity);
    }

    public List<GameStep> getSteps(Long idGame) {
        GameEntity gameEntity = repository.findAll().stream().filter(x -> x.getId().equals(idGame)).findFirst().orElse(null);
        return stepRepository.findAll()
                .stream()
                .filter(x -> x.getGameEntity().equals(gameEntity))
                .map(StepEntity::toModel)
                .collect(Collectors.toList());
    }
    public GameStep getStep(Long idStep) {
        return stepRepository.findAll()
                .stream()
                .filter(x -> x.getId().equals(idStep))
                .map(StepEntity::toModel)
                .findFirst().orElse(null);
    }

    public void removeStep(long id) {
        StepEntity step = stepRepository.findAll().stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
        stepRepository.delete(step);
    }

    public void editStep(StepForm stepForm, long idStep) {
        StepEntity stepEntity = stepRepository.findAll().stream().filter(x -> x.getId().equals(idStep)).findFirst().orElse(null);
        stepEntity.setCode(stepForm.getCode());
        stepEntity.setDescription(stepForm.getDescription());
        stepRepository.save(stepEntity);
    }
    private String getImageUrl(StepForm stepForm) {
        return !stepForm.getImage().isEmpty() ?
                uploadService.upload(stepForm.getImage()) :
                null;
    }

}
