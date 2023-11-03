package com.food.exp.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.exp.dto.LikesDTO;
import com.food.exp.dto.MemberDTO;
import com.food.exp.dto.PageDTO;
import com.food.exp.dto.RevDTO;

@Repository("MypageDAO")
public class MypageDAO {

	@Autowired
	SqlSessionTemplate session;

	// 회원 정보 가져오기
	public MemberDTO getInfo(String user_email) {
		return session.selectOne("MypageMapper.getInfo", user_email);
	}
	// 회원 정보 변경 
	public int changeInfo(MemberDTO dto) {
		return session.update("MypageMapper.changeInfo", dto);
	}
	// 회원 탈퇴
	public int delMember(String user_email) {
		return session.delete("MypageMapper.delMember", user_email);
	}
	
	// 즐겨찾기 페이지
	public int totalCount(String user_email) {
		return session.selectOne("MypageMapper.totalCount", user_email);
	}
	// 즐겨찾기 가져오기
	/*
	 * public List<LikesDTO> getLikes(String user_email) { return
	 * session.selectList("MypageMapper.getLikes", user_email); }
	 */
	public PageDTO getLikes(int curPage, String user_email) {
	    PageDTO pageDTO = new PageDTO();
	    int offset = (curPage - 1) * pageDTO.getPerPage();
	    int limit = pageDTO.getPerPage();

	    List<LikesDTO> list = session.selectList("MypageMapper.getLikes", user_email, new RowBounds(offset, limit));

	    pageDTO.setList(list);
	    pageDTO.setCurPage(curPage);

	    // 전체 좋아요 수를 가져와서 설정합니다.
	    int totalLikes = totalCount(user_email);
	    pageDTO.setTotalCount(totalLikes);

	    return pageDTO;
	}
	// 즐겨찾기 삭제
	public int delLikes(LikesDTO dto) {
		return session.delete("MypageMapper.delLikes", dto);
	}
	
	// 리뷰 정보 가져오기
	public List<RevDTO> getRev(String user_email) {
		return session.selectList("MypageMapper.getRev", user_email);
	}
}
