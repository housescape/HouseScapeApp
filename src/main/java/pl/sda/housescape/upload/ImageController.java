package pl.sda.housescape.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    private final ImageStorageService imageStorageService;


    @Autowired
    public ImageController(ImageStorageService imageStorageService) {
        this.imageStorageService = imageStorageService;
    }

    @GetMapping("/create-steps")
    public String index(Model model) {
        model.addAttribute("images", imageStorageService.getImages());
        return "stepscreator";
    }


    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        imageStorageService.uploadImage(new UploadImage(file, file.getOriginalFilename()));
        return "redirect:/create-steps";
    }
}
