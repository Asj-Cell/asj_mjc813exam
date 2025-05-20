package q0519;

public class MemberService {
    private String id;
    private String password;

    public boolean login(String id, String password) {
        return "hong".equals(id) && "12345".equals(password);
    }

    public void logout(String id) {
        System.out.println(id + " 님이 로그아웃 되었습니다.");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
