package com.co.kr.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class Pagination {
	
	public static Map<String, Object> pagination(int totalcount, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		//페이지 번호 초기화
		HttpSession session = request.getSession();
		String pnum = (String) session.getAttribute("page");
		System.out.println("pnum"+pnum);
		if(pnum == null) {pnum = "1";}
		
		// Parsing String into Integer
		int rowNUM = Integer.parseInt(pnum);
		if(rowNUM < 0) {rowNUM = 1;}
		
		// arrange of pagination
		int pageNum;
		if(totalcount % 10 == 0) {
			pageNum = totalcount / 10;
		}else {
			pageNum = (totalcount / 10)+1;
		}
		
		if(rowNUM > pageNum) {rowNUM = pageNum;}
		
		// 페이지네이션 중간범위
		int temp = (rowNUM - 1) % 10;
		int startPage = rowNUM - temp;
		int endPage = startPage + (10-1);
		
		if(endPage > pageNum) {endPage = pageNum;}
		
		int offset = (rowNUM -1) * 10;
		
		map.put("rowNUM", rowNUM);
		map.put("pageNum", pageNum);
		map.put("startpage", startPage);
		map.put("endpage", endPage);
		map.put("offset", offset);

		return map;
	}
}
