import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.*;
import java.util.ArrayList;

import javax.sound.midi.SysexMessage;

public class Test2 {
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		//ArrayList<Integer> s1Index = new ArrayList<Integer>();
		Student s1 = new Student("YANG0570", "password", "XingHao", "U1912345A", 'M', "SG", 2, LocalDateTime.of(2020,11,20,10,0), LocalDateTime.of(2020,11,27,22,0));
		Student s2 = new Student("CHAN0935", "password", "Joel", "U1923456Z", 'M', "SG", 2, LocalDateTime.of(2020,11,20,10,0), LocalDateTime.of(2020,11,27,22,0));

		StudentManager.addStudent(s1);
		StudentManager.addStudent(s2);
		
		//Staff admin = new Staff("admin", "password", 1);
		//StaffManager.addStaff(admin);
		//ArrayList <Course> courseList = CourseManager.extractDB();
		//System.out.println(courseList.get(0).getCourseCode());
		//ArrayList<Integer> s2Index = new ArrayList<Integer>();
		//Student s2 = new Student("nic_user", "pw123", "nic", "U199999", 'M', "SG", 4, s2Index, LocalTime.of(10,43,12), LocalTime.of(12,43,12));
		//StudentManager.addStudent(s2);
		
		// StudentController SC = new StudentController();
		// StaffController SF = new StaffController();
		
		//SF.printSelectedStudent("U199999");
		//SF.editStudentAccessPeriod("U199999", LocalTime.of(12,43,12), LocalTime.of(14,43,12));
		//SF.printSelectedStudent("U199999");
        
		//StudentController.addCourse("U192456", 2);
		//StudentController.addCourse("U199999", 1);
        //SC.addCourse(s1, 1);
		

		//StudentController.printCourseRegistered("U192456");
		//StudentController.printCourseRegistered("U199999");
		
		//StudentController.addCourse("U1912345A", 4);
		//StudentController.removeCourse("U192456", "CZ2002");
		//StudentController.changeIndex("U192456", 5, 4, "CZ2005");
		//StudentController.swapIndex("U192456", 5, 4, "U199999", "123");
		
		//StudentController.printCourseRegistered("U192456");
		//StudentController.printCourseRegistered("U199999");
        
        
	}
}
