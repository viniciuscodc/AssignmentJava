package com.assignment.restAPI.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRoute extends RouteBuilder {
	
    private String projectPath = System.getProperty("user.dir");

	@Override
	public void configure() throws Exception {
//		from("file://" + path + "/input")
//		    .log("file: ${header.CamelFileName} - path: ${header.CamelFilePath}")
//		    .log("${file:name}")
//			.to("file://" + path + "/output");
		
//		from("file://" + path + "/input")
//		.setHeader(Exchange.HTTP_METHOD, simple("GET"))
//		.to("http://localhost:8080/api/events")
//		.process(new MyProcessor());
		
		from("file://" + projectPath + "/inputPayloadHere")
		    .log("File input: ${header.CamelFileName} - path: ${header.CamelFilePath}")
	        .convertBodyTo(String.class)
		    .setBody(simple("${body}"))
		    .setHeader(Exchange.HTTP_METHOD, simple("POST"))
		    .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		    .to("http://localhost:8080/api/payload");
	}
}
