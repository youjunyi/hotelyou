package school.libenhe.hotel.entity;

public class Sysuser {
    private Long id;
    private String number;
    private String name;
    private String zjjb;
    private String zjlb;
    private String bz;

    @Override
    public String toString() {
        return "Sysuser{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", zjjb='" + zjjb + '\'' +
                ", zjlb='" + zjlb + '\'' +
                ", bz='" + bz + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZjjb() {
        return zjjb;
    }

    public void setZjjb(String zjjb) {
        this.zjjb = zjjb;
    }

    public String getZjlb() {
        return zjlb;
    }

    public void setZjlb(String zjlb) {
        this.zjlb = zjlb;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
