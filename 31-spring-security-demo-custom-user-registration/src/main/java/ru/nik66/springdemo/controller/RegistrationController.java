package ru.nik66.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.nik66.springdemo.entity.User;
import ru.nik66.springdemo.service.RoleService;
import ru.nik66.springdemo.service.UserService;
import ru.nik66.springdemo.user.CrmUser;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserService userService;
    private RoleService roleService;
    private static final Logger logger = Logger.getLogger(RegistrationController.class.getName());

    private Map<String, String> roles;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, editor);
    }

    @PostConstruct
    public void loadRoles() {
        List<String> roleNames = roleService.getAllRoles();
        for (String roleName : roleNames) {
            roles.put(roleName, getNormalRoleName(roleName));
        }
    }

    private String getNormalRoleName(String roleName) {
        if (roleName == null || roleName.isEmpty()) {
            logger.warning("Role name is empty!");
            return roleName;
        }
        if (!roleName.startsWith("ROLE_")) {
            logger.warning("It is not role: " + roleName);
            return roleName;
        }
        String result = roleName.substring(roleName.indexOf('_') + 1);

        return result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
    }

    @GetMapping("/showRegistrationForm")
    public String showRegForm(Model model) {
        model.addAttribute("crmUser", new CrmUser());
        model.addAttribute("roles", roles);
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser crmUser, BindingResult bindingResult, Model model) {
        String userName = crmUser.getUserName();
        logger.info("Processing registration form for: " + userName);
        if (bindingResult.hasErrors()) {
            model.addAttribute("crmUser", new CrmUser());
            // add roles to the model for form display
            model.addAttribute("roles", roles);
            model.addAttribute("registrationError", "User name/password can not be empty.");
            logger.warning("User name/password can not be empty.");
            return "registration-form";
        }
        User existing = userService.findByUserName(userName);
        if (existing != null) {
            model.addAttribute("crmUser", new CrmUser());
            model.addAttribute("roles", roles);
            model.addAttribute("registrationError", "User name already exists.");
            logger.warning("User name already exists.");
            return "registration-form";
        }
        userService.save(crmUser);
        logger.info("Successfully created user: " + userName);
        return "registration-confirmation";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

}
