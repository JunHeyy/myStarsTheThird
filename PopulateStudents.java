import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.*;
import java.util.ArrayList;

import javax.sound.midi.SysexMessage;

/**
 * File to add populate student objects, not part of program.
 */
public class PopulateStudents {
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		//ArrayList<Integer> s1Index = new ArrayList<Integer>();


		Student s1 = new Student("YANG0570", "password", "XingHao", "U1912345A", 'M', "SG", 2, LocalDateTime.of(2020,11,20,10,0), LocalDateTime.of(2020,11,27,22,0));
		Student s2 = new Student("CHAN0935", "password", "Joel", "U1923456Z", 'M', "SG", 2, LocalDateTime.of(2020,11,20,10,0), LocalDateTime.of(2020,12,27,22,0));
		Student s3 = new Student("JTOH050", "password", "Jun Jie", "U1922277E", 'M', "SG", 2, LocalDateTime.of(2020,11,24,23,0), LocalDateTime.of(2020,12,27,2,0));
		Student s4 = new Student("DLOW94", "password", "Daniel", "U1922660C", 'M', "SG", 2, LocalDateTime.of(2020,11,24,23,0), LocalDateTime.of(2020,12,27,2,0));
		Student s5 = new Student("CIAO18", "password", "Chelsea", "U1933660C", 'F', "SG", 2, LocalDateTime.of(2020,11,20,23,0), LocalDateTime.of(2020,11,23,2,0));
		Student s6 = new Student("KHEE18", "password", "Khee Gin", "U1944660C", 'M', "SG", 2, LocalDateTime.of(2020,11,24,23,0), LocalDateTime.of(2020,12,27,2,0));
		Student s7 = new Student("TASS18", "password", "Tasmin", "U1955660C", 'F', "SG", 2, LocalDateTime.of(2020,11,27,23,0), LocalDateTime.of(2020,12,27,2,0));
		Student s8 = new Student("MING18", "password", "Wei Ming", "U1966660C", 'M', "SG", 2, LocalDateTime.of(2020,11,24,23,0), LocalDateTime.of(2020,12,27,2,0));
		Student s9 = new Student("TAN18", "password", "Tan Tan", "U1977660C", 'M', "SG", 2, LocalDateTime.of(2020,11,24,23,0), LocalDateTime.of(2020,12,27,2,0));
		Student s10 = new Student("YPNIC18", "password", "Nicholas", "U1988660C", 'M', "SG", 2, LocalDateTime.of(2020,11,24,23,0), LocalDateTime.of(2020,12,27,2,0));
		Student s11 = new Student("YPJJ18", "password", "Junn", "U1999660C", 'M', "SG", 2, LocalDateTime.of(2020,11,24,23,0), LocalDateTime.of(2020,12,27,2,0));
		Student s12 = new Student("YPKG18", "password", "Khee", "U1000660C", 'M', "SG", 2, LocalDateTime.of(2020,11,24,23,0), LocalDateTime.of(2020,12,27,2,0));
		Student s13 = new Student("CHONG18", "password", "Chong Xiang", "U1011660C", 'M', "SG", 2, LocalDateTime.of(2020,11,24,23,0), LocalDateTime.of(2020,12,27,2,0));
		Student s14 = new Student("LOH18", "password", "Donald Loh", "U1022660C", 'M', "SG", 2, LocalDateTime.of(2020,11,24,23,0), LocalDateTime.of(2020,12,27,2,0));
		Student s15 = new Student("FKHONG003", "password", "Nicholas", "U1932445A", 'M', "SG", 2, LocalDateTime.of(2020,11,20,10,0), LocalDateTime.of(2020,12,27,22,0));
		StudentManager.addStudent(s1);
		StudentManager.addStudent(s2);
		StudentManager.addStudent(s3);
		StudentManager.addStudent(s4);
		StudentManager.addStudent(s5);
		StudentManager.addStudent(s6);
		StudentManager.addStudent(s7);
		StudentManager.addStudent(s8);
		StudentManager.addStudent(s9);
		StudentManager.addStudent(s10);
		StudentManager.addStudent(s11);
		StudentManager.addStudent(s12);
		StudentManager.addStudent(s13);
		StudentManager.addStudent(s14);
		StudentManager.addStudent(s15);

        
        
	}
}
