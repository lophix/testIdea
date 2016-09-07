package bean;

/**
 * 与xml报文对应的POJO
 *
 * @Authuor Administrator
 * @Create 2016-09-06-16:27
 */
public class ReqXmlBean {

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
}
