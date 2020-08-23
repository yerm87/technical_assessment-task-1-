package palyndromicStrings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import palyndromicStrings.entity.StringEntity;
import palyndromicStrings.repo.StringRepository;
import palyndromicStrings.services.MainService;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    MainService service;

    @Autowired
    StringRepository repo;

    @GetMapping("/")
    public String formWithString(Model model){
        boolean boolVal = repo.findById(1).isPresent();
        StringEntity se = null;

        if(!boolVal){
            se = new StringEntity();
            se.setPalyndromicString("");
            repo.save(se);
            model.addAttribute("name", "");
        } else {
            se = repo.findById(1).get();
            String palyndromicString = se.getPalyndromicString();
            model.addAttribute("name", palyndromicString);
        }

        return "form";
    }

    @PostMapping("/form-action")
    public String handleForm(@RequestParam(name="inputString") String param){
        service.createPalyndromicString(param);
        return "redirect:/";
    }
}


