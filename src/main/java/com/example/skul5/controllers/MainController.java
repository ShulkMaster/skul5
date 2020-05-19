package com.example.skul5.controllers;

import com.example.skul5.dao.StudentDao;
import com.example.skul5.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@Component
public class MainController {

    private final StudentDao dao;

    @Autowired
    public MainController(StudentDao dao) {
        this.dao = dao;
    }

    @GetMapping(value = {"/", "/index", "/inicio"})
    public ModelAndView Index() {
        ModelAndView vm = new ModelAndView();
        vm.setViewName("index");
        vm.addObject("student", new Student());
        return vm;
    }

    @GetMapping("/listado")
    public ModelAndView Student() {
        ModelAndView vm = new ModelAndView();
        try {
            vm.addObject("students", dao.findAll());
        } catch (Exception ex) {
            vm.addObject("students", new ArrayList<Student>());
        }
        vm.setViewName("list");
        return vm;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute Student student, BindingResult result) {
        ModelAndView vm = new ModelAndView();
        if (!result.hasErrors()) {
            vm.addObject("student", new Student());
            dao.save(student);
        }
        vm.setViewName("index");
        return vm;
    }
}
