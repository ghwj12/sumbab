package com.sumbab.project.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sumbab.project.model.PickService;



@Controller
public class PickController {

	@Autowired
	private PickService pickService;
	
	//�����Կ� ��� ��ư Ŭ��
	//��ȯ���� 1:�̹� �����Կ� �ش� ���԰� ��� ���� ���, 0:�����Կ� �ش� ���� �߰�
	@RequestMapping("/Pick/PickProcess/{storeNum}")
	public String memberPick(@PathVariable int storeNum, HttpServletResponse response, HttpServletRequest request, Model model) {
		String id="";			//merge�ϸ� session�� �ִ� id ���
		int result=0;
		if(!id.equals("")) {		//�α��� ���� ���
			result = pickService.addPick(id, storeNum);
			model.addAttribute("identified", true);
		}else {						//��ȸ���� ���
			List<String> list = new ArrayList<>(); 		//��Ű�� ���� ���Թ�ȣ�� �ִ� ��ü
			Cookie[] cookies = request.getCookies();	//Ŭ���̾�Ʈ�� �ִ� ��Ű�� ��������
			String value = "";							
			String[] picked = null;
			if(cookies != null) {						//Ŭ���̾�Ʈ�� ��Ű�� ������ ���
				for(int i=0; i<cookies.length; i++) {
					if(cookies[i].getName().equals("pick")) {	//�����Կ� �ش��ϴ� ��Ű�� ������ ���
						System.out.println("������ ��Ű ����!!!");
						value = cookies[i].getValue();	//��Ű�� ����Ǿ� �ִ� ���Թ�ȣ���� ���ڿ��� ����
						picked = value.split("a");		//���ڿ��� ������ ���Թ�ȣ���� ,�� �����Ͽ� �迭�� ����
						break;
					}
				}
			}
			if(value.equals("")) {						//�����Կ� �ش��ϴ� ��Ű�� �������� ���� ���
				System.out.println("���Թ�ȣ �ϳ��� ����!!!");
				Cookie cookie = new Cookie("pick", Integer.toString(storeNum));
				cookie.setMaxAge(60*60*24);
				cookie.setPath("/");
				response.addCookie(cookie);
				result = 0;
			} else {
				for(int i=0; i<picked.length; i++) {
					if(picked[i].equals(Integer.toString(storeNum))) {	//�����Կ� �߰��� ���Թ�ȣ�� �̹� ���� ���
						System.out.println("�̹� ���Թ�ȣ ����!!!");
						result = 1;
						break;
					}
				}
				if(result != 1) {							//�����Կ� �߰��� ���Թ�ȣ�� ���� ���
					for(int i=0; i<picked.length; i++)		
						list.add(picked[i]);				//���� ��ȣ�� �߰��ϱ� ���� ũ�Ⱑ ������ ���� ���� List Ÿ������ ������ �ִ� ���Թ�ȣ�� ���
					list.add(Integer.toString(storeNum));	//���� ��ȣ �߰�
					String finalStorage = "";				
					for(int i=0; i<list.size(); i++)
						finalStorage += list.get(i) + "a";	//��Ű�� List Ÿ������ ������ �� ���� ������ �ٽ� String������ ���Թ�ȣ�� ���
					Cookie cookie = new Cookie("pick", finalStorage);
					cookie.setMaxAge(60*60*24);
					cookie.setPath("/");
					response.addCookie(cookie);
					result = 0;
				}
			}
		}
		model.addAttribute("result", result);
		return "Pick/PickProcess";
	}
	
	
	public String login(HttpServletRequest request) {
		String id="hello";				
		Cookie[] cookies = request.getCookies();	
		String value = "";							
		String[] picked = null;
		if(cookies != null) {						
			for(int i=0; i<cookies.length; i++) {
				if(cookies[i].getName().equals("pick")) {	//�����Կ� �ش��ϴ� ��Ű�� ������ ���
					value = cookies[i].getValue();	//��Ű�� ����Ǿ� �ִ� ���Թ�ȣ���� ���ڿ��� ����
					picked = value.split(",");		//���ڿ��� ������ ���Թ�ȣ���� ,�� �����Ͽ� �迭�� ����
					break;
				}
			}
		}
		if(!value.equals("")) {						//�����Կ� �ش��ϴ� ��Ű�� ������ ���
			for(int i=0; i<picked.length; i++) {
				pickService.addPick(id, Integer.parseInt(picked[i]));
			}
		}
		return"메인페이지";
	}
	
}
