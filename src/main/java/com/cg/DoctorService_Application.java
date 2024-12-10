package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DoctorService_Application {

	public static void main(String[] args) {
		SpringApplication.run(DoctorService_Application.class, args);
	}

}
/*
 1.Add
 Post:http://localhost:9091/api/adddoctor
 Body:
 {
    
    "name":"Vaibhavi",
    "qualification":"BDS"
}

2.getall
Get:http://localhost:9091/api/doclist
 
 3.delete
 delete byId:http://localhost:9091/api/delete/2
 
 4:Update
 put:http://localhost:9091/api/update/4
 Body: 
 {
 "name":"Vaibhavi",
 "qualification":"MD"
 }
 
 5.Find By id
 Get:http://localhost:9091/api/find/4
 
 //swagger
   http://localhost:9091/swagger-ui/index.html
   //Actuator
    http://lin-5cg4313dwt.corp.capgemini.com:8013/actuator/health
  
 loggings:
	 localhost:9091/api/log/alldoctors
6.Custom Query
http://localhost:9091/api/Count?dname=manasi*/
