package ir.model;

import ir.model.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name="ticketEntity")
@Table(name="ticket_tbl")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus status;

    @Column(name="date_time")
    private LocalDateTime dateTime;
//    todo : group

    @OneToMany(mappedBy = "ticket")
    private List<Message> messageList;

    @ManyToOne
    @JoinColumn(name="username")
    private User user;

    public void addMessage(Message message) {
        if(messageList == null) {
            messageList = new ArrayList<>();
        }
        messageList.add(message);
    }
}
