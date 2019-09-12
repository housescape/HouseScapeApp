package pl.sda.housescape.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.housescape.model.GameStep;

@Controller
public class StepController {

    private final ImageStorageService imageStorageService;

    @Autowired
    public StepController(ImageStorageService imageStorageService) {
        this.imageStorageService = imageStorageService;
    }


    @RequestMapping("/create-steps")
    public ModelAndView index(){
        ModelAndView mnv = new ModelAndView("stepscretor");
        mnv.addObject("images", imageStorageService.getImages());
        return mnv;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        imageStorageService.uploadImage(new UploadImage(file, file.getOriginalFilename()));
        return "redirect:/create-steps";
    }

}


