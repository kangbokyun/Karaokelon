package Karaokelon.Domain.Entity;

import Karaokelon.Domain.Entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board")
@Setter @Getter @Builder @ToString
@AllArgsConstructor @NoArgsConstructor
public class BoardEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;
    @Column
    private String btitle;
    @Column
    private String bcontents;
    @Column
    private String bwriter;
    @Column
    private String bview;

    @ManyToOne @JoinColumn(name = "cateno")
    private CategoryEntity categoryEntity;
    @ManyToOne @JoinColumn(name = "mcno")
    private MiddleCategoryEntity middleCategory;
}
