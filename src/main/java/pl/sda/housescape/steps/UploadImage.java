package pl.sda.housescape.steps;

import org.springframework.web.multipart.MultipartFile;

public class UploadImage {
    private MultipartFile file;
    private String name;

    public UploadImage(MultipartFile file, String name) {
        this.file = file;
        this.name = name;
    }

    public MultipartFile getFile() {
        return file;
    }

    public String getName() {
        return name;
    }

    public Image toImage(String urlToFile) {
        return new Image(name, urlToFile);
    }

}
