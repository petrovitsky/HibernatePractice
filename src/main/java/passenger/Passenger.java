package passenger;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="passenger")
@Entity
@Data
@NoArgsConstructor
public class Passenger {
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Id
     private long id;
     @Column
     private String passport;
     @Column
     private String name;

     public Passenger(String passport, String name) {
          this.passport = passport;
          this.name = name;
     }
}
