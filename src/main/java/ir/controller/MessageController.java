package ir.controller;

import ir.model.Message;
import ir.model.Role;
import ir.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/message")

public class MessageController {
    private final MessageService messageService;


    public MessageController(MessageService messageService) {
        this.messageService = messageService;

    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("message", new Message());
        model.addAttribute("messageList", messageService.findAll());
        return "message";
    }


    @PostMapping
    public String saveMessage(Message message) {
        try{
            messageService.save(message);
            log.info("message Saved");
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return "redirect:/message";
    }

    @DeleteMapping(path = "/{messageId}")
    public String removeMessage(@PathVariable("messageId") long messageId) {
        try{
            messageService.delete(messageId);
            log.info("Message Removed");
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return "redirect:/message";
    }



}
