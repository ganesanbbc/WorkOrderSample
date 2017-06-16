package com.cts.ms.wo;

import com.cts.ms.wo.controller.WorkOrderController;
import com.cts.ms.wo.service.WorkOrderServiceImpl;
import com.cts.ms.wo.vo.WorkOrder;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.cts.ms.wo.ServiceEndPoint.GET_SERVICES;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WorkEngineApp.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkOrderRestControllerTest {


    @InjectMocks
    WorkOrderController controller;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Mock
    private WorkOrderServiceImpl workOrderService;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        //Don't Delete this for reference
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        mockMvc = standaloneSetup(controller).build();
    }


    @Test
    public void thatGotSuccessResponseWhenCallGetServiceOrderList() throws Exception {
        when(workOrderService.getWorkOrders()).thenReturn(new WorkOrder(""));
        RequestBuilder mockRequest = MockMvcRequestBuilders.get(GET_SERVICES);
        ResultMatcher expectedResult = status().isOk();
        mockMvc.perform(mockRequest)
                .andExpect(expectedResult);
    }


    @Test
    public void thatGotServiceListWhenRequestServiceList() throws Exception {
        when(workOrderService.getWorkOrders()).thenReturn(new WorkOrder(""));
        RequestBuilder getServiceRequest = MockMvcRequestBuilders.get(GET_SERVICES)
                .accept(MediaType.APPLICATION_JSON);
        ResultMatcher expectedResult = jsonPath("$.name").exists();
        mockMvc.perform(getServiceRequest).andExpect(expectedResult);
    }

}
