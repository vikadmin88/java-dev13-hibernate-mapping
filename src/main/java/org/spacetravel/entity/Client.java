package org.spacetravel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    @Size(min = 3, max = 200, message = "The length of the field name must be from 3 to 200 characters!")
    private String name;

}
