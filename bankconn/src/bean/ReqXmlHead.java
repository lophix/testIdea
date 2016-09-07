package bean;

/**
 * 请求报文头
 *
 * @Authuor Administrator
 * @Create 2016-09-07-20:52
 */
public class ReqXmlHead {
    /*xml请求报文头*/
    private String tr_code;
    private String corp_no;
    private String uer_no;
    private String req_no;
    private String tr_acdt;  //接口文档为number
    private String tr_time;  //接口文档中为number
    private String atom_tr_count;  //接口文档中为number
    private String channel;
    private String reserved;  //保留字段

    public String getTr_code() {
        return tr_code;
    }

    public void setTr_code(String tr_code) {
        this.tr_code = tr_code;
    }

    public String getCorp_no() {
        return corp_no;
    }

    public void setCorp_no(String corp_no) {
        this.corp_no = corp_no;
    }

    public String getUer_no() {
        return uer_no;
    }

    public void setUer_no(String uer_no) {
        this.uer_no = uer_no;
    }

    public String getReq_no() {
        return req_no;
    }

    public void setReq_no(String req_no) {
        this.req_no = req_no;
    }

    public String getTr_acdt() {
        return tr_acdt;
    }

    public void setTr_acdt(String tr_acdt) {
        this.tr_acdt = tr_acdt;
    }

    public String getTr_time() {
        return tr_time;
    }

    public void setTr_time(String tr_time) {
        this.tr_time = tr_time;
    }

    public String getAtom_tr_count() {
        return atom_tr_count;
    }

    public void setAtom_tr_count(String atom_tr_count) {
        this.atom_tr_count = atom_tr_count;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }
}
