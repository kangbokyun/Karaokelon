package Karaokelon.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reply")
@Setter @Getter @ToString @Builder
@AllArgsConstructor @NoArgsConstructor
public class ReplyEntity extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno;
    @Column
    private String rcontents;
    @Column
    private int rmno;
    @Column
    private int rbno;
    @Column
    private int rdistinctno;
}
