package ticket;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import planet.Planet;
@Entity
@Table(name = "ticket")
@Data
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "passenger_id")
    private long passengerId;
    @Enumerated(EnumType.STRING)
    @Column(name = "from_planet")
    private Planet from;
    @Enumerated(EnumType.STRING)
    @Column(name = "to_planet")
    private Planet to;

    public Ticket(long passengerId, Planet from, Planet to) {
        this.passengerId = passengerId;
        this.from = from;
        this.to = to;
    }
}
