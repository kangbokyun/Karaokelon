package Karaokelon.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "newsong")
@Getter @Setter @ToString @Builder
@AllArgsConstructor @NoArgsConstructor
public class NewSongEntity extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ns_no;
	@Column
	private int sno;
	@Column
	private String stitle;
	@Column
	private String s_singer;
	@Column
	private String s_img;
	@Column
	private String s_album;
}
