package com.isett.lab2.controllers;

import com.isett.lab2.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<>();

    @GetMapping("/list")
    public String listStudents(Model model) {
        model.addAttribute("students", students);
        return "students/list";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/register";
    }

    @PostMapping("/register")
    public String registerStudent(@Valid @ModelAttribute("student") Student student,
                                  BindingResult result) {
        if (result.hasErrors()) {
            return "students/register";
        }
        students.add(student);
        return "redirect:/students/list";
    }

    @GetMapping("/edit/{index}")
    public String showEditForm(@PathVariable int index, Model model) {
        if (index < 0 || index >= students.size()) {
            return "redirect:/students/list"; // if invalid index
        }
        model.addAttribute("student", students.get(index));
        model.addAttribute("index", index);
        return "students/edit";
    }

    @PostMapping("/edit/{index}")
    public String editStudent(@PathVariable int index,
                              @Valid @ModelAttribute("student") Student student,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("index", index);
            return "students/edit";
        }
        students.set(index, student);
        return "redirect:/students/list";
    }

    @GetMapping("/delete/{index}")
    public String deleteStudent(@PathVariable int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
        }
        return "redirect:/students/list";
    }

    @GetMapping("/search")
    public String searchStudents(@RequestParam(required = false) String keyword, Model model) {
        if (keyword == null || keyword.trim().isEmpty()) {
            model.addAttribute("students", students);
        } else {
            List<Student> result = students.stream()
                    .filter(s -> s.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                            s.getMajor().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
            model.addAttribute("students", result);
        }
        model.addAttribute("keyword", keyword);
        return "students/search";
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        Map<String, Long> stats = students.stream()
                .collect(Collectors.groupingBy(Student::getMajor, Collectors.counting()));

        model.addAttribute("stats", stats);
        return "students/dashboard";
    }
}
