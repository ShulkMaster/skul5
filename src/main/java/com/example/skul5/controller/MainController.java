package com.example.skul5.controller;

import com.example.skul5.dao.StudentDao;
import com.example.skul5.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@Component
public class MainController {

    private final StudentDao dao;

    @Autowired
    public MainController(StudentDao dao) {
        this.dao = dao;
    }

    @GetMapping("/index")
    public ModelAndView Index() {
        ModelAndView vm = new ModelAndView();
        vm.setViewName("index");
        return vm;
    }

    @GetMapping("/students")
    public ModelAndView Student() {
        ModelAndView vm = new ModelAndView();
        try {
            vm.addObject("student",  dao.findAll());
        } catch (Exception ex){
            vm.addObject("students", new ArrayList<Student>());
        }
        vm.setViewName("students");
        return vm;
    }
}
