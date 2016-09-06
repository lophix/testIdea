package bean;

/**
 * 与xml报文对应的POJO
 *
 * @Authuor Administrator
 * @Create 2016-09-06-16:27
 */
public class XmlBean {
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

    /*xml请求报文体*/
    private String pay_flag;
    private String pay_acno;
    private String pay_acname;
    private String rcv_bank_name;
    private String rcv_acno;
    private String rcv_acname;
    private String cur_code;
    private String amt;  //接口文档为保留2位小数number
    private String cert_no;
    private String summary;

    public String getPay_flag() {
        return pay_flag;
    }

    public void setPay_flag(String pay_flag) {
        this.pay_flag = pay_flag;
    }

    public String getPay_acno() {
        return pay_acno;
    }

    public void setPay_acno(String pay_acno) {
        this.pay_acno = pay_acno;
    }

    public String getPay_acname() {
        return pay_acname;
    }

    public void setPay_acname(String pay_acname) {
        this.pay_acname = pay_acname;
    }

    public String getRcv_bank_name() {
        return rcv_bank_name;
    }

    public void setRcv_bank_name(String rcv_bank_name) {
        this.rcv_bank_name = rcv_bank_name;
    }

    public String getRcv_acno() {
        return rcv_acno;
    }

    public void setRcv_acno(String rcv_acno) {
        this.rcv_acno = rcv_acno;
    }

    public String getRcv_acname() {
        return rcv_acname;
    }

    public void setRcv_acname(String rcv_acname) {
        this.rcv_acname = rcv_acname;
    }

    public String getCur_code() {
        return cur_code;
    }

    public void setCur_code(String cur_code) {
        this.cur_code = cur_code;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getCert_no() {
        return cert_no;
    }

    public void setCert_no(String cert_no) {
        this.cert_no = cert_no;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

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
