package com.sgh.demo.camunda;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.ProcessEngine;

/**
 * Process Application exposing this application's resources the process engine.
 */
@ProcessApplication
public class CamundaBpmProcessApplication extends ServletProcessApplication {

	private static final String PROCESS_DEFINITION_KEY = "Podcast";

	/**
	 * In a @PostDeploy Hook you can interact with the process engine and access
	 * the processes the application has deployed.
	 */
	@PostDeploy
	public void onDeploymentFinished(ProcessEngine processEngine) {

		// Optional: start an initial process instance
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("name", "John");
		variables.put("date", new SimpleDateFormat().format(new Date()));
		variables.put("darkLordAttacks", new Random().nextBoolean());

		processEngine.getRuntimeService().startProcessInstanceByKey(PROCESS_DEFINITION_KEY, variables);
	}

}
