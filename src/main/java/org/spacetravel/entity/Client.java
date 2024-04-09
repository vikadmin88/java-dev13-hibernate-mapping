package org.spacetravel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(min = 3, max = 200, message = "The length of the field name must be from 3 to 200 characters!")
    private String name;

    @OneToMany(mappedBy="client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> tickets = new HashSet<>();

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
        ticket.setClient(this);
    }
}
