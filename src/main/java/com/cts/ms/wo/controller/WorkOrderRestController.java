package com.cts.ms.wo.controller;


import com.cts.ms.wo.ServiceEndPoint;
import com.cts.ms.wo.vo.WorkOrder;
import com.cts.ms.wo.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class WorkOrderRestController {


    @Autowired
    private WorkOrderService workOrderService;

    @RequestMapping(path = ServiceEndPoint.GET_SERVICES, method = GET)
    public WorkOrder getService() {
        return workOrderService.getWorkOrders();
    }

}