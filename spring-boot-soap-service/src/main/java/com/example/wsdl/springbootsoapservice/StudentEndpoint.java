package com.example.wsdl.springbootsoapservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.www_wsdlexample_com.xml.student.StudentDetailsRequest;
import https.www_wsdlexample_com.xml.student.StudentDetailsResponse;
 
@Endpoint
public class StudentEndpoint
{
    private static final String NAMESPACE_URI = "https://www.wsdlexample.com/xml/student";
 
    private StudentRepository StudentRepository;
 
    @Autowired
    public StudentEndpoint(StudentRepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
    @ResponsePayload
    public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
        StudentDetailsResponse response = new StudentDetailsResponse();
        response.setStudent(StudentRepository.findStudent(request.getName()));
 
        return response;
    }
}
