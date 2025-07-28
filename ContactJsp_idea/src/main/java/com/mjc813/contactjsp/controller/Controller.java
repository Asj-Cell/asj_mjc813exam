package com.mjc813.contactjsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList; // ArrayList 임포트 추가

import com.mjc813.contactjsp.DAO.*;
import com.mjc813.contactjsp.DTO.ContactDto; // ContactDto 임포트 추가
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.printf("doGet : getMethod=%s, getContextPath=%s, getRequestURI=%s\n", request.getMethod(), request.getContextPath(), request.getRequestURI());
        doPro(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST 요청 시 한글 깨짐 방지
        request.setCharacterEncoding("UTF-8");
        System.out.printf("doPost : getMethod=%s, getContextPath=%s, getRequestURI=%s\n", request.getMethod(), request.getContextPath(), request.getRequestURI());
        doPro(request, response);
    }

    protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String context = request.getContextPath();
        String url = uri.substring(context.length());
        String site = null;    // 화면에 출력할 jsp 파일명

        System.out.printf("doPro : url=%s\n", url);

        ContactMysqlDAO dao = new ContactMysqlDAO();

        switch (url) {
            case "/home":
                site = "index.jsp";
                break;

            case "/list":
                site = dao.selectAll(request, response);
                break;

            case "/add":
                site = "add.jsp";
                break;

            case "/insert":
                site = dao.insert(request, response);
                break;

            case "/modify":

                int id = Integer.parseInt(request.getParameter("id"));
                ContactDto contactToModify = dao.modify(id);
                request.setAttribute("contact", contactToModify);
                site = "modify.jsp";
                break;

            case "/update":
                int result1 = dao.update(request, response);
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out = response.getWriter();
                if (result1 == 1) {
                    out.println("<script>");
                    out.println(" alert('연락처 수정이 완료 되었습니다!'); location.href='/list';");
                    out.println("</script>");
                    // out.flush(); // flush는 자동으로 됨.
                } else {
                    out.println("<script>");
                    out.println("alert('수정 실패!'); location.href='/modify?id=" + request.getParameter("id") + "';"); // 실패 시 현재 수정 페이지로 다시 돌아가도록 id 전달
                    out.println("</script>");
                    // out.flush(); // flush는 자동으로 됨.
                }
                return; // return은 그대로 유지하여 스크립트 실행 후 종료

            case "/delete":
                int result2 = dao.delete(request, response);
                response.setContentType("text/html; charset=UTF-8");
                out = response.getWriter();
                if (result2 == 1) {
                    out.println("<script>");
                    out.println(" alert('연락처 삭제가 완료 되었습니다!'); location.href='/list';");
                    out.println("</script>");
                } else {
                    out.println("<script>");
                    out.println("alert('삭제 실패!');");
                    out.println("</script>");
                }
                return;
            default:
                // 루트 경로 "/"로 접근 시 기본적으로 list 페이지로 가도록 처리
                if (url.equals("/")) {
                    site = dao.selectAll(request, response); // 또는 "index.jsp" 등 시작 페이지로
                } else {
                    // 정의되지 않은 다른 URL에 대한 처리
                    response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 에러 반환
                    return;
                }
        }

        // site가 null이거나 빈 문자열이 아닐 때만 포워딩
        if (site != null && !site.isEmpty()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(site);
            dispatcher.forward(request, response);
        }
    }
}