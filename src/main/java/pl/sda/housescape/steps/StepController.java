package pl.sda.housescape.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StepController {

    private final ImageStorageService imageStorageService;

    @Autowired
    public StepController(ImageStorageService imageStorageService) {
        this.imageStorageService = imageStorageService;
    }

    @GetMapping("/create-steps")
    public String index(Model model) {
        model.addAttribute("images", imageStorageService.getImages());
        return "stepscretor";
    }


    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        imageStorageService.uploadImage(new UploadImage(file, file.getOriginalFilename()));
        return "redirect:/create-steps";
    }

}


