package lyg.enetity;


/**
 * @author 李沅罡
 */

public class Manager {

    private String mId;
    private String mUsername;
    private String mPassword;
    private String mLevel;

    public Manager(String userName, String password) {
        this.mUsername = userName;
        this.mPassword = password;
    }


    public Manager() {
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mId='" + mId + '\'' +
                ", mUsername='" + mUsername + '\'' +
                ", mPassword='" + mPassword + '\'' +
                ", mLevel='" + mLevel + '\'' +
                '}';
    }

    public Manager(String mId, String mUsername, String mPassword, String mLevel) {
        this.mId = mId;
        this.mUsername = mUsername;
        this.mPassword = mPassword;
        this.mLevel = mLevel;
    }

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
