package com.ezen;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezen.domain.Board;
import com.ezen.domain.Member;
import com.ezen.domain.Role;
import com.ezen.persistence.BoardRepository;
import com.ezen.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepo;
	@Autowired
	private MemberRepository memberRepo;
	
	@Test
	@Ignore
	public void testInsert() {
		
		Member member1 = new Member();
		member1.setId("member1");
		member1.setPassword("1111");
		member1.setName("이순신");
		member1.setRole(Role.ROLE_MEMBER);
		member1.setEnabled(true);
		
		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("member2");
		member2.setPassword("2222");
		member2.setName("유관순");
		member2.setRole(Role.ROLE_ADMIN);
		member2.setEnabled(true);
		
		memberRepo.save(member2);
				

		for(int i = 1; i<=3; i++) {
			Board board1 = new Board();
			board1.setTitle(member1.getName()+"의 게시글 제목: " + i);
			board1.setContent(member1.getName()+"의 게시글 내용: " + i);
			board1.setMember(member1);
			boardRepo.save(board1);
		}

		
		for(int i = 1; i<=3; i++) {
			Board board2 = new Board();
			board2.setTitle(member2.getName()+"의 게시글 제목: " + i);
			board2.setContent(member2.getName()+"의 게시글 내용: " + i);
			board2.setMember(member2);
			boardRepo.save(board2);
		}

	}
	
	@Test
	public void testGetboard() {
		
		Board board = boardRepo.findById(1L).get();
		System.out.println("----------------------1번 게시글 내용 입니다.-----------------------");
		System.out.println("====> " +board);
	}
	
	@Test
	public void testGetBoardList() {
		Member member = new Member();
		member = memberRepo.findById("member1").get();
		List<Board> boardList = member.getBoardList();
		System.out.println(member.getName()+"이 등록한 전체 게시글 목록 입니다.----------------------");
		for(Board list : boardList) {
			System.out.println(list);
		}
	}
}
