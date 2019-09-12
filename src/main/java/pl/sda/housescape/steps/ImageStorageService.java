package pl.sda.housescape.steps;

import org.springframework.stereotype.Service;
import pl.sda.housescape.model.GameStep;

import java.util.*;

@Service
public class ImageStorageService {

    private final CloudinaryService cloudinaryService;
    private Map<String, Image> imageStorage;
    private List<GameStep> gameSteps;

    public ImageStorageService(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
        this.imageStorage = new HashMap<>();
    }

    public void uploadImage(UploadImage upload) {
        String urlToFile = cloudinaryService.uploadFile(upload.getFile());
        Image image = upload.toImage(urlToFile);
        imageStorage.put(UUID.randomUUID().toString(), image);

    }


    public Collection<Image> getImages() {
        return imageStorage.values();
    }
}
