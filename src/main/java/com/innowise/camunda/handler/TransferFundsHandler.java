package com.innowise.camunda.handler;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.client.api.worker.JobHandler;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class TransferFundsHandler implements JobHandler {
    @Override
    public void handle(JobClient client, ActivatedJob job) throws Exception {
        Map<String, Object> inputVariables = job.getVariablesAsMap();

        //TODO: Add logic
        String settlementTransactionStatus = "success";

        Map<String, Object> outputVariables = new HashMap<>();
        outputVariables.put("settlementTransactionStatus", settlementTransactionStatus);

        client.newCompleteCommand(job.getKey()).variables(outputVariables).send().join();
    }
}
