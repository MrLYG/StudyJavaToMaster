package per.lyg.enetity;


import java.io.Serializable;

/**
 * @author 李沅罡
 */

public class Manager {

    private String mId;
    private String mUsername;
    private String mPassword;
    private String mLevel;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public Manager() {
    }

    public Manager(String mId, String mUsername, String mPassword, String mLevel) {
        this.mId = mId;
        this.mUsername = mUsername;
        this.mPassword = mPassword;
        this.mLevel = mLevel;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmLevel() {
        return mLevel;
    }

    public void setmLevel(String mLevel) {
        this.mLevel = mLevel;
    }
}
