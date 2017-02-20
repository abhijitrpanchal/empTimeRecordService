package com.poc.springboot.employeetimerecords;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class EmployeeTimeRecordsController {
	
	@RequestMapping(method = RequestMethod.POST)
    public void CreateEmployee(@RequestBody String lstEmployee) {
        System.out.println(lstEmployee);
        try {
	        	JSONArray jsonarr = new JSONArray(lstEmployee);
	        	System.out.println("Length = " + jsonarr.length());
	        	
	            for(int i = 0; i < jsonarr.length(); i++){
		            JSONObject jsonobj = jsonarr.getJSONObject(i);
		            ObjectMapper mapper = new ObjectMapper();
		            Employee employee = mapper.readValue(jsonobj.toString(), Employee.class);
		            displayEmployee(employee);
	            }
			} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
    }

	private void displayEmployee(Employee employee){
		System.out.println("\nId : " + employee.getId());		
		System.out.println("\nName : " + employee.getName());		
		System.out.println("\nAge : " + employee.getAge());		
	}
}
