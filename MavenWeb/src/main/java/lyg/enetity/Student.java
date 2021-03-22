package lyg.enetity;


/**
 * @author 李沅罡
 */

public class Student {
    private String sId;
    private String sName;
    private String sGender;
    private String sBorn;
    private String sEmail;
    private String sPassword;
    private String sNote;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsGender() {
        return sGender;
    }

    public void setsGender(String sGender) {
        this.sGender = sGender;
    }

    public String getsBorn() {
        return sBorn;
    }

    public void setsBorn(String sBorn) {
        this.sBorn = sBorn;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getsNote() {
        return sNote;
    }

    public void setsNote(String sNote) {
        this.sNote = sNote;
    }

    public Student() {
    }

    public Student(String sId, String sName, String sGender, String sBorn, String sEmail, String sPassword, String sNote) {
        this.sId = sId;
        this.sName = sName;
        this.sGender = sGender;
        this.sBorn = sBorn;
        this.sEmail = sEmail;
        this.sPassword = sPassword;
        this.sNote = sNote;
    }
}
