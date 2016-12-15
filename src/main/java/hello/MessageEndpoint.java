/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author nishida
 */
@ApplicationScoped
@Path("message")
public class MessageEndpoint {
    @Inject
    MessageService messageService;
    
    @GET
    @Path("add")
    public Message add(@QueryParam("message") String message){
        return messageService.create(message);
    }
    
    @GET
    public List<Message> list(){
        return messageService.findAll();
    }
    
    
    //http://localhost:8080/hello-jpa/app/message/add?message=hello
    
    
    
}
