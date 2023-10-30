package jpamvcexam.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {
	@Id
	@Column(name = "TEAM_ID")	
	private String id;
	private String name;
}
