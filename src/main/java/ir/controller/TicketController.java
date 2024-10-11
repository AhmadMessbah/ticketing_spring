package ir.controller;

import ir.model.Message;
import ir.model.Ticket;
import ir.model.User;
import ir.model.enums.TicketStatus;
import ir.service.MessageService;
import ir.service.TicketService;
import ir.service.UserService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;
    private final UserService userService;
    private final MessageService messageService;

    public TicketController(TicketService ticketService, UserService userService, MessageService messageService) {
        this.ticketService = ticketService;
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping(path = "/messages/{ticketId}")
    public String getMessages(Model model, @PathVariable("ticketId") Long ticketId) {
        model.addAttribute("message", new Message());
        model.addAttribute("messageList", messageService.findByTicketId(ticketId));
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("ticketId", ticketId);
        return "message";
    }

    @GetMapping
    public String showAllTickets(Model model) {
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("tickets", ticketService.findAll());
        model.addAttribute("allUsers", userService.findAll());
        return "ticket";
    }

    @PostMapping
    public String saveTicket(Ticket ticketForm, Model model, @ModelAttribute("status") TicketStatus status, @ModelAttribute("user") String username) {
        try {
            User user = userService.findByUsername(username);
            Ticket ticket = Ticket.builder()
                    .title(ticketForm.getTitle())
                    .status(status)
                    .dateTime(ticketForm.getDateTime())
                    .user(user)
                    .build();
            ticketService.save(ticket);
            log.info("Ticket Saved : " + ticket);
        }catch (Exception e) {
       log.error(e.getMessage());
        }
        return "redirect:/tickets";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTicket(@PathVariable ("id") Long id) {
        try {
            ticketService.delete(id);
            log.info("Ticket Removed : " + id);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "redirect:/tickets";
    }
}
