package hello.controller;

import java.util.concurrent.atomic.AtomicLong;

import hello.model.Greeting;
import hello.model.GreetingSomeone;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*@RequestMapping(value = "/greeting", method = GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }*/

    @RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public HttpEntity<Greeting> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        //return new Greeting(counter.incrementAndGet(), String.format(template, name));

        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(" Again")).withSelfRel());

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

   // @RequestMapping(value = "/greeting", method = RequestMethod.POST, consumes = {MediaType.})

    @RequestMapping(value ="/greeting/someone", method = RequestMethod.POST)
    public ResponseEntity<?> greetingSomeone(@RequestBody GreetingSomeone greetingSomeone){
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
