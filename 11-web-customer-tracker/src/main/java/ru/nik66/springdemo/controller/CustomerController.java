package ru.nik66.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nik66.springdemo.entity.Customer;
import ru.nik66.springdemo.serivce.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("customers", this.customerService.getCustomers());
        return "list-customers";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam("searchParam") String searchParam, Model model) {
        if (searchParam == null) {
            return "redirect:/customer/list";
        }
        searchParam = searchParam.trim();
        if (!searchParam.isEmpty()) {
            model.addAttribute("customers", this.customerService.searchCustomers(searchParam));
            return "list-customers";
        } else {
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/showAddForm")
    public String showAddFrom(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        this.customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("customerId") int customerId, Model model) {
        model.addAttribute("customer", this.customerService.getCustomer(customerId));
        return "customer-form";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int customerId) {
        this.customerService.deleteCustomer(this.customerService.getCustomer(customerId));
        return "redirect:/customer/list";
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
