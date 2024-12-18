package ir;

//import ir.model.entity.Message;
//import ir.model.entity.Role;
//import ir.model.entity.Ticket;
//import ir.model.entity.User;
//import ir.model.enums.TicketStatus;
import ir.service.MessageService;
import ir.service.RoleService;
import ir.service.TicketService;
import ir.service.UserService;
import lombok.extern.slf4j.Slf4j;

//import java.time.LocalDateTime;

@Slf4j
public class AppTest {
    private static RoleService roleService;
    private static UserService userService;
    private static TicketService ticketService;
    private static MessageService messageService;

    public AppTest(RoleService roleService, UserService userService, TicketService ticketService, MessageService messageService) {
        AppTest.roleService = roleService;
        AppTest.userService = userService;
        AppTest.ticketService = ticketService;
        AppTest.messageService = messageService;
    }

    public static void firstTest() {
//        Role adminRole = new Role("ROLE_ADMIN");
//        roleService.save(adminRole);
//        log.info("Admin Role Saved");
//
//        Role userRole = new Role("ROLE_USER");
//        roleService.save(userRole);
//        log.info("User Role Saved");
//
//        User adminUser =
//                User
//                        .builder()
//                        .username("ali")
//                        .password("123456")
//                        .firstName("Ali")
//                        .lastName("Alipour")
//                        .email("ali@gmail.com")
//                        .phone("123456789")
//                        .role(adminRole)
//                        .build();
//        userService.save(adminUser);
//        log.info("Admin User Saved");
//
//        User userUser =
//                User
//                        .builder()
//                        .username("Reza")
//                        .password("123456")
//                        .firstName("Reza")
//                        .lastName("Rezaii")
//                        .email("Reza@gmail.com")
//                        .phone("123456789")
//                        .role(userRole)
//                        .build();
//        userService.save(userUser);
//        log.info("User User Saved");
//
//        Ticket ticket =
//                Ticket
//                        .builder()
//                        .title("My Ticket")
//                        .user(userUser)
//                        .dateTime(LocalDateTime.now())
//                        .status(TicketStatus.NotSeen)
//                        .build();
//        ticketService.save(ticket);
//        log.info("Ticket Saved");
//
//
//        Message message1 =
//                Message
//                        .builder()
//                        .content("darkhast 1")
//                        .dateTime(LocalDateTime.now())
//                        .user(userUser)
//                        .ticket(ticket)
//                        .build();
//        messageService.save(message1);
//        log.info("Message1 Saved");
//
//        ticket.addMessage(message1);
//        ticket.setStatus(TicketStatus.Seen);
//        ticketService.update(ticket);
//        log.info("Ticket Updated");
//
//        Message message2 =
//                Message
//                        .builder()
//                        .content("Pasokh 1")
//                        .dateTime(LocalDateTime.now())
//                        .user(adminUser)
//                        .ticket(ticket)
//                        .build();
//        messageService.save(message2);
//        log.info("Message2 Saved");
//
//        ticket.addMessage(message2);
//        ticket.setStatus(TicketStatus.Responsed);
//        ticketService.update(ticket);
//        log.info("Ticket Updated");
//
//
//        Message message3 =
//                Message
//                        .builder()
//                        .content("darkhast 2")
//                        .dateTime(LocalDateTime.now())
//                        .user(userUser)
//                        .ticket(ticket)
//                        .build();
//        messageService.update(message3);
//        log.info("Message3 Saved");
//
//        ticket.addMessage(message3);
//        ticketService.update(ticket);
//        log.info("Ticket Updated");
//
//        Message message4 =
//                Message
//                        .builder()
//                        .content("Pasokh 2")
//                        .dateTime(LocalDateTime.now())
//                        .user(adminUser)
//                        .ticket(ticket)
//                        .build();
//        messageService.save(message4);
//        log.info("Message4 Saved");
//
//        ticket.addMessage(message4);
//        ticket.setStatus(TicketStatus.Responsed);
//        ticketService.update(ticket);
//        log.info("Ticket Updated");
//        System.out.println("----------------------------------------------");
//
//        Ticket t1 = ticketService.findById(1L);
//
//        System.out.println(t1.getUser().getUsername() + " Create Ticket " + ticket.getTitle());
//
//        System.out.println("----------------------------------------------");
//
////        List<Message> messageList = messageService.findByTicketId(ticket.getId());
////        for (Message m1 : messageList) {
//
//        for (Message m1 : ticket.getMessageList()) {
//            if (m1.getUser().getRole().getRoleName().equals("ROLE_ADMIN")) {
//                System.out.printf("\t\t\t\t\t\t\t%s : %s%n", m1.getContent(),m1.getUser().getUsername());
//            } else {
//                System.out.printf("%10s : %s%n", m1.getUser().getUsername(),m1.getContent());
//            }
//        }
//        System.out.println("----------------------------------------------");
//
    }


}
