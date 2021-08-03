package course;

import com.lagou.entity.*;
import mapper.CourseCommentDao;
import mapper.CourseDao;
import mapper.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @BelongsProject: lagou-edu
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-09-08 16:25
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class TestCourse {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseCommentDao courseCommentDao;

//    @Test
//    public void getAllCourse(){
//        List<Course> list = courseDao.getAllCourse();
//        for(Course course : list){
////            if( course.getId().toString() .equals("8") ){
//                String flag = course.getActivityCourse()!=null ? "【火爆活动中】":"";
//                System.out.println("课程："+flag + course.getId() +"->"+ course.getCourseName());
//
//                for(CourseSection cs : course.getCourseSections() ){
//                    System.out.println("\t\t章节" + cs.getId() +"--->" + cs.getSectionName());
//                    for(CourseLesson cl : cs.getCourseLessons()){
//                        if(cl.getCourseMedia() != null){
//                            System.out.println("\t\t\t小节" + cl.getId() +"--->" + cl.getTheme()+",视频：" + cl.getCourseMedia().getFileId()+",时长：【"+ cl.getCourseMedia().getDuration()+"】");
//                        }else{
//                            System.out.println("\t\t\t小节" + cl.getId() +"--->" + cl.getTheme()+",视频：【待上传】,时长：【00:00】");
//                        }
//                    }
//                }
////            }
//        }
//    }

//    @Test
//    public void getCoursesByUserid(){
//        List<Course> list = courseDao.getCourseByUserId("100030018");
//        for(Course course : list){
////            if( course.getId().toString() .equals("8") ){
//            String flag = course.getActivityCourse()!=null ? "【火爆活动中】":"";
//            System.out.println("课程："+flag + course.getId() +"->"+ course.getCourseName());
//
//            for(CourseSection cs : course.getCourseSections() ){
//                System.out.println("\t\t章节" + cs.getId() +"--->" + cs.getSectionName());
//                for(CourseLesson cl : cs.getCourseLessons()){
//                    if(cl.getCourseMedia() != null){
//                        System.out.println("\t\t\t小节" + cl.getId() +"--->" + cl.getTheme()+",视频：" + cl.getCourseMedia().getFileId()+",时长：【"+ cl.getCourseMedia().getDuration()+"】");
//                    }else{
//                        System.out.println("\t\t\t小节" + cl.getId() +"--->" + cl.getTheme()+",视频：【待上传】,时长：【00:00】");
//                    }
//                }
//            }
////            }
//        }
//    }


    @Test
    public void getCourseById() {
//        Course course = courseDao.getCourseById(7);
//        String flag = course.getActivityCourse() != null ? "【火爆活动中】" : "";
//        System.out.println("课程：" + flag + course.getId() + "->" + course.getCourseName());
//
//        for (CourseSection cs : course.getCourseSections()) {
//            System.out.println("\t\t章节" + cs.getId() + "--->" + cs.getSectionName());
//            for (CourseLesson cl : cs.getCourseLessons()) {
//                if (cl.getCourseMedia() != null) {
//                    System.out.println("\t\t\t小节" + cl.getId() + "--->" + cl.getTheme() + ",视频：" + cl.getCourseMedia().getFileId() + ",时长：【" + cl.getCourseMedia().getDuration() + "】");
//                } else {
//                    System.out.println("\t\t\t小节" + cl.getId() + "--->" + cl.getTheme() + ",视频：【待上传】,时长：【00:00】");
//                }
//            }
//        }
    }


//    @Test
//    public void getComment(){
//        List<CourseComment> list = courseCommentDao.getCommentsByCourseId(7, 0, 20);
//        for(CourseComment comment : list){
//            System.out.println("【"+comment.getUserName()+"】"+"留言：" + comment.getComment());
//            for(CourseCommentFavoriteRecord fr: comment.getFavoriteRecords()){
//                System.out.println("--->" + fr.getUserId());
//            }
//        }
//    }
}
