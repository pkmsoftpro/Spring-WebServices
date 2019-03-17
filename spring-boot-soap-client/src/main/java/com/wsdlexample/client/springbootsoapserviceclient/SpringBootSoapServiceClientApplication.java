package com.wsdlexample.client.springbootsoapserviceclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wsdlexample.schemas.student.StudentDetailsRequest;
import com.wsdlexample.schemas.student.StudentDetailsResponse;

@SpringBootApplication
public class SpringBootSoapServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapServiceClientApplication.class, args);
	}

	@Bean
    CommandLineRunner lookup(SOAPConnector soapConnector) {
        return args -> {
            String name = "Prashant";//Default Name
            if(args.length>0){
                name = args[0];
            }
            StudentDetailsRequest request = new StudentDetailsRequest();
            request.setName(name);
            StudentDetailsResponse response =(StudentDetailsResponse) soapConnector.callWebService("http://localhost:8080/service/student-details", request);
            System.out.println("Got Response As below ========= : ");
            System.out.println("Name : "+response.getStudent().getName());
            System.out.println("Standard : "+response.getStudent().getStandard());
            System.out.println("Address : "+response.getStudent().getAddress());
        };
    }
}
