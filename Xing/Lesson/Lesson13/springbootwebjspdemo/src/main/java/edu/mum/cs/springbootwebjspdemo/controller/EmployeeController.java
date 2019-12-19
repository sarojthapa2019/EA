package edu.mum.cs.springbootwebjspdemo.controller;

import edu.mum.cs.springbootwebjspdemo.domain.Employee;
import edu.mum.cs.springbootwebjspdemo.service.EmployeeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class EmployeeController {

    private static final Log logger = LogFactory.getLog(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = {"/", "employee_input"})
    public String inputEmployee(@ModelAttribute("employee") Employee employee) {
        return "EmployeeForm";
    }

    @RequestMapping(value = "/employee_save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "EmployeeForm";
        }

        String[] suppressedFields = bindingResult.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
                    + StringUtils.addStringToArray(suppressedFields, ", "));
        }

        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("employee", employee);
        return "redirect:/employee_detail";
    }

    @GetMapping("/employee_detail")
    public String employeeDetail() {
        return "EmployeeDetails";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // binder.setDisallowedFields(new String[]{"firstName"});
    }
}
