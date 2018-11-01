
public class table {

    private String theader;
    private String tdata;

    public String getTdata() {
        return tdata;
    }

    public void setTdata(String tdata) {
        this.tdata = tdata;
    }

    public String getTheader() {
        return theader;
    }

    public void setTheader(String theader) {
        this.theader = theader;
    }

    public table(String theader, String tdata) {
        this.theader = theader;
        this.tdata = tdata;
    }

    public table() {
    }

}

