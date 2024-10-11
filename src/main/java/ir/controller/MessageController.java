package ir.controller;

import ir.model.Message;
import ir.model.Role;
import ir.model.Ticket;
import ir.service.MessageService;
import ir.service.RoleService;
import ir.service.TicketService;
import ir.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequestMapping("/messages")

public class MessageController {
    private final MessageService messageService;
    private final TicketService ticketService;
    private final UserService userService;


    public MessageController(MessageService messageService, TicketService ticketService, UserService userService) {
        this.messageService = messageService;

        this.ticketService = ticketService;
        this.userService = userService;
    }

    @PostMapping
    public String saveMessage(Message message, @ModelAttribute("ticketId") Long ticketId, @ModelAttribute("username")String username) {
        try {
            message.setTicket(ticketService.findById(ticketId));
            message.setUser(userService.findByUsername(username));
            message.setDateTime(LocalDateTime.now());
            messageService.save(message);
            log.info("message Saved");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "redirect:/messages";
    }

    @DeleteMapping(path = "/{messageId}")
    public String removeMessage(@PathVariable("messageId") long messageId) {
        try {
            messageService.delete(messageId);
            log.info("Message Removed");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "redirect:/messages";
    }


}
