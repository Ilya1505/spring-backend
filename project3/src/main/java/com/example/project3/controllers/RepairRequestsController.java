package com.example.project3.controllers;

import com.example.project3.models.RepairRequest;
import com.example.project3.services.RepairRequestService;
import com.example.project3.services.ServiceCarServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RepairRequestsController {
    private final ServiceCarServiceType serviceCarServiceType;
    private final RepairRequestService repairRequestService;

    @Autowired
    public RepairRequestsController(ServiceCarServiceType serviceCarServiceType, RepairRequestService repairRequestService) {
        this.serviceCarServiceType = serviceCarServiceType;
        this.repairRequestService = repairRequestService;
    }

    //получение страницы создания заявки
    @GetMapping("/add-repair-request/{carServiceId}/{carServiceTypeId}")
    public String getPageCreatingRepairRequest(@PathVariable("carServiceId") Integer carServiceId,
                                               @PathVariable("carServiceTypeId") Integer carServiceTypeId,
                                               Model model) {
//        @ModelAttribute("repairRequest") RepairRequest repairRequest
        RepairRequest repairRequest = new RepairRequest();
        repairRequest.setServiceType(serviceCarServiceType.getServiceTypeById(carServiceTypeId));
        model.addAttribute("repairRequest", repairRequest);
        return "repair-request";

    }

    @PostMapping("/add-repair-request/{carServiceId}/{carServiceTypeId}")
    public String CreateRepairRequest(@PathVariable("carServiceId") Integer carServiceId,
                                      @PathVariable("carServiceTypeId") Integer carServiceTypeId,
                                      @ModelAttribute("repairRequest") RepairRequest repairRequest,
                                      BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "service";
        }

        repairRequestService.saveRepairRequest(carServiceId, carServiceTypeId, repairRequest);
        return "redirect:/car-service/" + carServiceTypeId + '/' + carServiceId;
    }
}
