package Karaokelon.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "middlecategory")
@Setter @Getter @ToString @Builder
@AllArgsConstructor @NoArgsConstructor
public class MiddleCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mcno;
    @Column
    private String mcname;
    @Column
    private String mccode;
    @OneToMany(mappedBy = "middleCategory")
    List<BoardEntity> boardEntityList = new ArrayList<>();
}
