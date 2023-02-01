package Karaokelon.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "member")
@Getter @Setter @ToString @Builder
@AllArgsConstructor @NoArgsConstructor
public class MemberEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;
    @Column
    private String mid;
    @Column
    private String mpw;
    @Column
    private String mname;
    @Column 
    private String memail;
    @Column
    private String mphone;
    @Column
    private String maddress;
    @Column
    private String mreserv;
}
