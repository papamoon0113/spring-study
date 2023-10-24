package com.example.springlab.controller;

import com.example.springlab.domain.TeamDTO;
import com.example.springlab.domain.TeamMemberVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyTeamController2 {
	@GetMapping(value = "/myTeam2", produces = "application/json; charset=utf-8")
	public TeamDTO printTeamInfo(String command){
		System.out.println("API : " + command);
		TeamDTO teamDTO = new TeamDTO();
		if (command != null){
			teamDTO.setTeamName("null (값 없어서 null이 아니라 진짜 null)");
			System.out.println(teamDTO.toString());

			if (command.equals("teamMember")){
				List<TeamMemberVO> teamMember = new ArrayList<>();

				teamMember.add(new TeamMemberVO("문호준", "호구", "애그타르트"));
				teamMember.add(new TeamMemberVO("이해성", "했썽", "애플시나몬와플"));
				teamMember.add(new TeamMemberVO("손승범", "범", "와플"));
				teamMember.add(new TeamMemberVO("노은기", "노키", "초코케이크"));

				teamDTO.setTeamMember(teamMember);
				for(TeamMemberVO member : teamDTO.getTeamMember()){
					System.out.println(member.toString());
				}
			}
		}
		return teamDTO;
	}
}
