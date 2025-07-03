# 상봉3반 학생들 실기 시험을 위함

# 홈쇼핑 회원관리 문제 (https://yunamom.tistory.com/204)

- 해당 URL 의 문제와 풀이는 JDK 1.8 버전용 소스이므로 이것을 JDK 17 이상으로 변환하였다.

# 오라클 11 설치 후 system 암호 변경, 테이블 추가, 데이터 추가
- https://dev-handbook.tistory.com/42
- 오라클11이 설치되어 있는 로컬에서 명령프롬프트 실행, ID: system, PW: 1234 로 변경하고 접속 해야 한다. (alter user system identified by 1234;)
- member.sql 파일의 쿼리들을 정상적으로 실행해서 member_tbl_02, money_tbl_02 테이블을 생성하고 데이터를 추가해야 한다.


# 소스 설명 (https://yunamom.tistory.com/264)
- JDK 17 버전 업 하면서 달라진 부분은 아래와 같다.
- src/main/webapp/WEB-INF/lib/servlet-api.jar 파일 삭제 ===> jakarta.servlet-api.6.0.0.jar 파일 추가
- Controller.java 파일과 Member.java 파일의 import javax.* ===> import jakarta.* 변경
- Apache Tomcat 9.0 ===> Apache Tomcat 11 버전 업그레이드 해야 함
- 중요한 Controller.java, MemberDAO.java, *.jsp 에는 주석으로 설명했음.

# 선생이 GIT 에 올린 소스를 이클립스에서 실행하는 방법
- doc 폴더에 있는 *.png 파일들을 순서대로 스크린샷 찍어서 빨간 네모 표시한 곳을 유의해서 따라하면 됨.
- 문제에는 8080 포트가 아니라 8090 포트로 변경해서 실행해야 하므로 이클립스 에서 Tomcat 실행시 8080 을 8090 으로 변경해야 함. 스크린샷에는 8080을 그대로 사용했었으나 여러분들은 8090으로 변경해야 함.


# 실기 고사시에는 모든 소스를 무에서 유로 코딩해야 함.
- 이클립스 Workspace 작업 영역은 C:\hrdkorea 폴더에 생성해야 함.
- 프로젝트 생성은 꼭 Dynamic Web Project 로 생성해야 함. 여러분들의 프로젝트 이름은 HRD_비번호 (수험자가 부여받은 비번) 으로 프로젝트 생성 해야 함.
- 최종 결과물은 C:\hrdkorea 폴더를 반드시 SW_비번.zip 으로 압축해서 제출해야 한다고 함.
