
package com.example;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    LoginRepository repo;

    @Autowired
    private PatientRepository repo1;

    // Payment Repository
    @Autowired
    private PaymentRepository paymentRepo;

    // =========================
    // HOME
    // =========================

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    // =========================
    // LOGIN AND SIGNUP
    // =========================

    @GetMapping("/Login")
    public String Login() {
        return "Login";
    }

    @GetMapping("/SignUp")
    public String SignUp() {
        return "SignUp";
    }

    @PostMapping("/Register")
    public String Register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {

        SetData s = new SetData(username, password);
        repo.save(s);

        model.addAttribute("msg",
                "Registration Succesfully..!");

        return "Login";
    }

    @PostMapping("/Login")
    public String Login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {

        SetData user = repo.findByUsername(username);

        if (user != null &&
                user.getPassword().equals(password)) {

            model.addAttribute("msg",
                    "Login Successful");

            return "report";

        } else {

            model.addAttribute("msg",
                    "Invalid Username and Password");

            return "login";
        }
    }

    // =========================
    // PATIENT MANAGEMENT
    // =========================

    // Add Patient Page
    @GetMapping("/addpatient")
    public String addPatient(Model model) {

        model.addAttribute("patient", new Patient());

        return "addpatient";
    }

    // Save Patient
    @PostMapping("/savePatient")
    public String savePatient(
            @ModelAttribute Patient patient) {

        repo1.save(patient);

        return "redirect:/patients";
    }

    // View All Patients
    @GetMapping("/patients")
    public String getAllPatients(Model model) {

        model.addAttribute("patients",
                repo1.findAll());

        return "patientResult";
    }

    // Edit Patient Page
    @GetMapping("/editData")
    public String editPatient(
            @RequestParam("id") Long id,
            Model model) {

        Patient p = repo1.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "ID not found: " + id));

        model.addAttribute("p", p);

        return "editData";
    }

    // Update Patient
    @PostMapping("/update")
    public String updatePatient(
            @ModelAttribute Patient patient) {

        repo1.save(patient);

        return "redirect:/patients";
    }

    // Delete Patient
    @GetMapping("/delete")
    public String deletePatient(
            @RequestParam("id") Long id) {

        repo1.deleteById(id);

        return "redirect:/patients";
    }
    @GetMapping("/PaymentAdd")
    public String PaymentAdd() {
        return "PaymentAdd";
    }
    // =========================
    // REPORT MANAGEMENT
    // =========================

    // Open Report Page
    @GetMapping("/report")
    public String openReportPage() {

        return "Report";
    }

    // PDF Report
    @GetMapping("/PdfReport")
    public String PdfReport(Model model) {

        model.addAttribute("patients",
                repo1.findAll());

        return "PdfReport";
    }

    // Create Report
    @GetMapping("/reportpdf")
    public String generateReport(
            @RequestParam("id") Long id,
            Model model) {

        Patient patient = repo1.getById(id);

        model.addAttribute("patient", patient);

        return "reportpdf";
    }

    // Save Report
    @PostMapping("/savereport")
    public String saveReport(
            @ModelAttribute Patient patient) {

        repo1.save(patient);

        return "redirect:/reportlist";
    }

    // View All Reports
    @GetMapping("/reportlist")
    public String getAllReports(Model model) {

        model.addAttribute("patients",
                repo1.findAll());

        return "reportSsaved";
    }

    // =========================
    // HELP AND FAQ
    // =========================

    @GetMapping("/help")
    public String help() {

        return "help";
    }

    @GetMapping("/FAQ")
    public String FAQ() {

        return "FAQ";
    }

    // Logout / Index
    @GetMapping("/index")
    public String logout() {

        return "index";
    }




}