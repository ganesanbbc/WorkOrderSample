package com.cts.ms.wo.service;

import com.cts.ms.wo.vo.WorkOrder;
import com.cts.ms.wo.dao.WorkOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkOrderServiceImpl implements WorkOrderService {


    @Autowired
    WorkOrderDAO workOrderDAO;

    @Override
    public List<WorkOrder> getWorkOrders() {
        return workOrderDAO.getOrders();
    }

    @Override
    public WorkOrder getWorkOrderById(int i) {
         return workOrderDAO.getOrderById(i);
    }

    @Override
    public List<WorkOrder> createOrders(List<WorkOrder> workOrders) {
        return workOrderDAO.createWorkOrder(workOrders);
    }

    @Override
    public void updateOrder(Long workOrder) {

        workOrderDAO.updateWorkOrder(workOrder);
    }
}
