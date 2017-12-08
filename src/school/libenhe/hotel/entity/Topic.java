package school.libenhe.hotel.entity;

public class Topic {
    private Long id;
    private String name;
    private String number;
    private Long userid;
    private String sbjf;
    private String wenjinurl;
    private String sbsj;
    private String sndw;
    private String ndwcsj;
    private String ktlb;
    private String ktjb;
    private Long sysid;
    private String issh;

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", userid=" + userid +
                ", sbjf='" + sbjf + '\'' +
                ", wenjinurl='" + wenjinurl + '\'' +
                ", sbsj='" + sbsj + '\'' +
                ", sndw='" + sndw + '\'' +
                ", ndwcsj='" + ndwcsj + '\'' +
                ", ktlb='" + ktlb + '\'' +
                ", ktjb='" + ktjb + '\'' +
                ", sysid=" + sysid +
                ", issh='" + issh + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getSbjf() {
        return sbjf;
    }

    public void setSbjf(String sbjf) {
        this.sbjf = sbjf;
    }

    public String getWenjinurl() {
        return wenjinurl;
    }

    public void setWenjinurl(String wenjinurl) {
        this.wenjinurl = wenjinurl;
    }

    public String getSbsj() {
        return sbsj;
    }

    public void setSbsj(String sbsj) {
        this.sbsj = sbsj;
    }

    public String getSndw() {
        return sndw;
    }

    public void setSndw(String sndw) {
        this.sndw = sndw;
    }

    public String getNdwcsj() {
        return ndwcsj;
    }

    public void setNdwcsj(String ndwcsj) {
        this.ndwcsj = ndwcsj;
    }

    public String getKtlb() {
        return ktlb;
    }

    public void setKtlb(String ktlb) {
        this.ktlb = ktlb;
    }

    public String getKtjb() {
        return ktjb;
    }

    public void setKtjb(String ktjb) {
        this.ktjb = ktjb;
    }

    public Long getSysid() {
        return sysid;
    }

    public void setSysid(Long sysid) {
        this.sysid = sysid;
    }

    public String getIssh() {
        return issh;
    }

    public void setIssh(String issh) {
        this.issh = issh;
    }
}
