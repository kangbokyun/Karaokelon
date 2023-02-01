package Karaokelon.Domain.DTO;

import lombok.*;



@Setter @Getter @Builder @ToString
@AllArgsConstructor @NoArgsConstructor
public class BoardDTO {
    private int bno;
    private String btitle;
    private String bcontents;
    private String bwriter;
    private String bview;
}
