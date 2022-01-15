package com.assignment.restAPI.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.assignment.restAPI.entity.Payload;

@Component
public class FileRoute extends RouteBuilder {
	
    private String path2 = System.getProperty("user.dir");
	private String path = "C:\\Users\\vinicius\\Desktop\\Randoli\\restApi";

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
		
		from("file://" + path + "/input")
	    .log("file: ${header.CamelFileName} - path: ${header.CamelFilePath}")
	    .log("${file:name}")
        .convertBodyTo(String.class)
	    .setBody(simple("${body}"))
	    .setHeader(Exchange.HTTP_METHOD, simple("POST"))
	    .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
	    .to("http://localhost:8080/api/event/payload");
	}
	
	public class MyProcessor implements Processor {

	    public void process(Exchange exchange) throws Exception {
	        System.out.println(exchange.getIn().getBody(Payload.class));
	    }
	}

}
