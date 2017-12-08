package school.libenhe.hotel.service;

import school.libenhe.hotel.entity.Sysuser;
import school.libenhe.hotel.entity.Topic;
import school.libenhe.hotel.utils.PageBean;

import java.util.List;

public interface ITopicService  {
    void getAll(PageBean<Topic> pageBean);

    List<Topic> query();
}
