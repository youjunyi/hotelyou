package school.libenhe.hotel.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import school.libenhe.hotel.dao.ISysuserDao;
import school.libenhe.hotel.entity.Sysuser;
import school.libenhe.hotel.utils.Condition;
import school.libenhe.hotel.utils.JdbcUtils;
import school.libenhe.hotel.utils.PageBean;

import java.util.ArrayList;
import java.util.List;

public class SysuserDao implements ISysuserDao {
    private QueryRunner qr = JdbcUtils.getQueryRunner();

    @Override
    public void getAll(PageBean<Sysuser> pageBean) {
        int totalCount = this.getTotalCount(pageBean);
        pageBean.setTotalCount(totalCount);

        List<Object> list = new ArrayList<Object>();

        if (pageBean.getCurrentPage() <= 0) {
            pageBean.setCurrentPage(1); // �ѵ�ǰҳ����Ϊ1
        } else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
            pageBean.setCurrentPage(pageBean.getTotalPage()); // �ѵ�ǰҳ����Ϊ���ҳ��
        }

        // ��ȡ��ǰҳ�� �����ѯ����ʼ�С����ص�����
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1) * pageBean.getPageCount(); // ��ѯ����ʼ��
        int count = pageBean.getPageCount(); // ��ѯ���ص�����

        Condition condition = pageBean.getCondition();

        // ��ҳ��ѯ����; �Ѳ�ѯ�����������õ�pb������
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT");
        sb.append(" f.* ");

        sb.append(" FROM ");
        sb.append("     	sysuser f");
        sb.append(" WHERE 	1=1 ");

        // �ж�
        if (condition != null) {
            String name = condition.getFoodName();
            if (name != null && !name.isEmpty()) {
                sb.append("  AND f.name LIKE ? ");
                list.add("%" + name + "%");
            }

        }
        sb.append(" limit ?,? ");
        list.add(index);
        list.add(count);
        try {
            // ���ݵ�ǰҳ����ѯ��ǰҳ����(һҳ����)
            if (index >= 0) {
                List<Sysuser> pageData = qr.query(sb.toString(),
                        new BeanListHandler<Sysuser>(Sysuser.class), list.toArray());
                // ���õ�pb������
                pageBean.setPageData(pageData);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Sysuser> query() {
        String sql = "SELECT * FROM sysuser";
        try {
            return qr.query(sql, new BeanListHandler<Sysuser>(Sysuser.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Sysuser> query(String name) {
        String sql = "SELECT * FROM sysuser WHERE name LIKE ?";
        try {
            return qr.query(sql, new BeanListHandler<Sysuser>(Sysuser.class), "%"
                    + name + "%");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void delete(int i) {
        String sql = "DELETE FROM sysuser WHERE id=?";
        try {
            qr.update(sql, i);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Sysuser findById(int i) {
        String sql = "SELECT * FROM sysuser where id =?";
        try {
            return qr.query(sql, new BeanHandler<Sysuser>(Sysuser.class), i);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Sysuser sysuser) {
        String sql = " INSERT sysuser(name,number,zjjb,zjlb,bz) VALUES(?,?,?,?,?)";
        try {
            qr.update(sql,sysuser.getName(),sysuser.getNumber(),sysuser.getZjjb(),sysuser.getZjlb(),sysuser.getBz());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updata(Sysuser sysuser) {
        String sql = "UPDATE sysuser SET name=?,number=?,zjjb=?,zjlb=?,bz=? WHERE id =?";
        try {
            qr.update(sql, sysuser.getName(),sysuser.getNumber(),sysuser.getZjjb(),sysuser.getZjlb(),sysuser.getBz(),sysuser.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getTotalCount(PageBean<Sysuser> pb) {
        StringBuilder sb = new StringBuilder();
        List<Object> list = new ArrayList<Object>();
        sb.append(" SELECT");
        sb.append("   count(*) ");
        sb.append(" FROM ");
        sb.append("     	sysuser f ");
        sb.append(" WHERE 	1=1 ");

        Condition condition = pb.getCondition();
        // �ж�
        if (condition != null) {
            String name = condition.getFoodName();
            if (name != null && !name.isEmpty()) {
                sb.append("  AND f.name LIKE ? ");
                list.add("%" + name + "%");
            }


        }
        try {
            // ִ�в�ѯ�� ���ؽ���ĵ�һ�еĵ�һ��
            Long count = qr.query(sb.toString(), new ScalarHandler<Long>(),
                    list.toArray());
            return count.intValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
