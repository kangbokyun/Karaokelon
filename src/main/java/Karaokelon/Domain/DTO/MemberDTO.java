package Karaokelon.Domain.DTO;

import lombok.*;

@Getter @Setter @ToString @Builder
@AllArgsConstructor @NoArgsConstructor
public class MemberDTO {
	private int mno;
	private String mid;
	private String mpw;
	private String mname;
	private String mphone;
	private String maddress;
	private String memail;
	private String mreserv;
}
