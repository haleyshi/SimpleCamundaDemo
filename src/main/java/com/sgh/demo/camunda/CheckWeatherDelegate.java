/**
 * 
 */
package com.sgh.demo.camunda;

import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @author eguoshi
 *
 */
public class CheckWeatherDelegate implements JavaDelegate {

	/* (non-Javadoc)
	 * @see org.camunda.bpm.engine.delegate.JavaDelegate#execute(org.camunda.bpm.engine.delegate.DelegateExecution)
	 */
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Random rand = new Random();
		execution.setVariable("name", "SGH");
		execution.setVariable("weatherOk", rand.nextBoolean());
	}

}
