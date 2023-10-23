package com.example.Cabeasebackend.Controller;

import com.example.Cabeasebackend.Entity.EnquiryForm;
import com.example.Cabeasebackend.Service.EnquiryFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EnquiryFormController {

    @Autowired
    private EnquiryFormService enquiryFormService;



    @GetMapping("")
    public String getIndex(Model model ){
        model.addAttribute("enquiry",new EnquiryForm());

        return "index";
    }

    @PostMapping("/enquiry")
    public String newEnquiry(@ModelAttribute("enquiry") EnquiryForm enquiryForm)
    {
        enquiryFormService.postEnquiry(enquiryForm);
        return "redirect:/";
    }

}
