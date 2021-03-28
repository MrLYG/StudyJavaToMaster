package lyg.service;

import lyg.enetity.ClassInfo;

import java.util.List;

public interface ClassInfoService {
    List<ClassInfo> getClassInfoByPage(String pageNo);

    int getCountofClass();

    Boolean add(ClassInfo classInfo);

    Boolean delete(ClassInfo classInfo);

    List<ClassInfo> searchclassInfos(ClassInfo classInfo);

    Boolean isHaveForeignClass(ClassInfo classInfo1);
}
