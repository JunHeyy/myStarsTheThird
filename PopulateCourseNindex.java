import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalTime;

public class PopulateCourseNindex {
	public static void main(String[] args) throws ClassNotFoundException, IOException {

		ArrayList<Timeslot> Lecture2002 = new ArrayList<Timeslot>();
		Lecture2002.add(new Timeslot(2, LocalTime.of(9,30), LocalTime.of(10,30), "a"));
		Lecture2002.add(new Timeslot(5, LocalTime.of(11,30), LocalTime.of(12,30), "a"));

		ArrayList<Lesson> CZ2002lesson1 = new ArrayList<Lesson>();
		ArrayList<Timeslot> Tut12002 = new ArrayList<Timeslot>();
		Tut12002.add(new Timeslot(1, LocalTime.of(11,30), LocalTime.of(12,30), "a"));
		ArrayList<Timeslot> Lab12002 = new ArrayList<Timeslot>();
		Lab12002.add(new Timeslot(1, LocalTime.of(8,30), LocalTime.of(10,30), "o"));

		Lesson CZ2002lesson1a = new Lesson("Lec", "Online", "CS2", Lecture2002);
		Lesson CZ2002lesson1b = new Lesson("Tut", "TR+33", "DSAI1", Tut12002);
		Lesson CZ2002lesson1c = new Lesson("Lab", "SPL", "DSAI1", Lab12002);
		CZ2002lesson1.add(CZ2002lesson1a);
		CZ2002lesson1.add(CZ2002lesson1b);
		CZ2002lesson1.add(CZ2002lesson1c);
		
		ArrayList<Lesson> CZ2002lesson2 = new ArrayList<Lesson>();
		ArrayList<Timeslot> Tut22002 = new ArrayList<Timeslot>();
		Tut22002.add(new Timeslot(1, LocalTime.of(9,30), LocalTime.of(10,30), "a"));
		ArrayList<Timeslot> Lab22002 = new ArrayList<Timeslot>();
		Lab22002.add(new Timeslot(5, LocalTime.of(12,30), LocalTime.of(14,30), "o"));

		Lesson CZ2002lesson2a = new Lesson("Lec", "Online", "CS2", Lecture2002);
		Lesson CZ2002lesson2b = new Lesson("Tut", "LHN-TR+17", "SS10", Tut22002);
		Lesson CZ2002lesson2c = new Lesson("Lab", "SPL", "SS10", Lab22002);
		CZ2002lesson2.add(CZ2002lesson2a);
		CZ2002lesson2.add(CZ2002lesson2b);
		CZ2002lesson2.add(CZ2002lesson2c);
		
		ArrayList<Lesson> CZ2002lesson3 = new ArrayList<Lesson>();
		ArrayList<Timeslot> Tut32002 = new ArrayList<Timeslot>();
		Tut32002.add(new Timeslot(4, LocalTime.of(10,30), LocalTime.of(11,30), "a"));
		ArrayList<Timeslot> Lab32002 = new ArrayList<Timeslot>();
		Lab32002.add(new Timeslot(4, LocalTime.of(14,30), LocalTime.of(16,30), "e"));

		Lesson CZ2002lesson3a = new Lesson("Lec", "Online", "CS2", Lecture2002);
		Lesson CZ2002lesson3b = new Lesson("Tut", "TR+17", "SS11", Tut32002);
		Lesson CZ2002lesson3c = new Lesson("Lab", "SWLAB1", "SS11", Lab32002);
		CZ2002lesson3.add(CZ2002lesson3a);
		CZ2002lesson3.add(CZ2002lesson3b);
		CZ2002lesson3.add(CZ2002lesson3c);
		
		
		ArrayList<Index> CZ2002Index = new ArrayList<Index>();
		Index CZ2002Index1 = new Index (10198, "CZ2002", 1, 0, CZ2002lesson1);
		Index CZ2002Index2 = new Index (10200, "CZ2002", 10, 0, CZ2002lesson2);
		Index CZ2002Index3 = new Index (10201, "CZ2002", 10, 0, CZ2002lesson3);
		CZ2002Index.add(CZ2002Index1);
		CZ2002Index.add(CZ2002Index2);
		CZ2002Index.add(CZ2002Index3);
		
		Course CZ2002 = new Course("CZ2002", "Object-Oriented Design and Programming", "SCSE", 3, CZ2002Index);
		
		/************************************************/
		
		ArrayList<Timeslot> Lecture2005 = new ArrayList<Timeslot>();
		Lecture2005.add(new Timeslot(4, LocalTime.of(9,30), LocalTime.of(11,30), "a"));

		ArrayList<Lesson> CZ2005lesson1 = new ArrayList<Lesson>();
		ArrayList<Timeslot> Tut12005 = new ArrayList<Timeslot>();
		Tut12005.add(new Timeslot(2, LocalTime.of(8,30), LocalTime.of(9,30), "a"));
		ArrayList<Timeslot> Lab12005 = new ArrayList<Timeslot>();
		Lab12005.add(new Timeslot(1, LocalTime.of(10,30), LocalTime.of(12,30), "e"));

		Lesson CZ2005lesson1a = new Lesson("Lec", "Online", "CS2", Lecture2005);
		Lesson CZ2005lesson1b = new Lesson("Tut", "TR+15", "SS1", Tut12005);
		Lesson CZ2005lesson1c = new Lesson("Lab", "SWLAB1", "SS1", Lab12005);
		CZ2005lesson1.add(CZ2005lesson1a);
		CZ2005lesson1.add(CZ2005lesson1b);
		CZ2005lesson1.add(CZ2005lesson1c);
		
		ArrayList<Lesson> CZ2005lesson2 = new ArrayList<Lesson>();
		ArrayList<Timeslot> Tut22005 = new ArrayList<Timeslot>();
		Tut22005.add(new Timeslot(1, LocalTime.of(10,30), LocalTime.of(11,30), "a"));
		ArrayList<Timeslot> Lab22005 = new ArrayList<Timeslot>();
		Lab22005.add(new Timeslot(1, LocalTime.of(8,30), LocalTime.of(10,30), "o"));

		Lesson CZ2005lesson2a = new Lesson("Lec", "Online", "CS2", Lecture2005);
		Lesson CZ2005lesson2b = new Lesson("Tut", "TR+17", "SS2", Tut22005);
		Lesson CZ2005lesson2c = new Lesson("Lab", "SWLAB1", "SS2", Lab22005);
		CZ2005lesson2.add(CZ2005lesson2a);
		CZ2005lesson2.add(CZ2005lesson2b);
		CZ2005lesson2.add(CZ2005lesson2c);
		
		ArrayList<Lesson> CZ2005lesson3 = new ArrayList<Lesson>();
		ArrayList<Timeslot> Tut32005 = new ArrayList<Timeslot>();
		Tut32005.add(new Timeslot(2, LocalTime.of(13,30), LocalTime.of(14,30), "a"));
		ArrayList<Timeslot> Lab32005 = new ArrayList<Timeslot>();
		Lab32005.add(new Timeslot(4, LocalTime.of(14,30), LocalTime.of(16,30), "o"));

		Lesson CZ2005lesson3a = new Lesson("Lec", "Online", "CS2", Lecture2005);
		Lesson CZ2005lesson3b = new Lesson("Tut", "TR+19", "SS3", Tut32005);
		Lesson CZ2005lesson3c = new Lesson("Lab", "SWLAB3", "SS3", Lab32005);
		CZ2005lesson3.add(CZ2005lesson3a);
		CZ2005lesson3.add(CZ2005lesson3b);
		CZ2005lesson3.add(CZ2005lesson3c);
		
		ArrayList<Index> CZ2005Index = new ArrayList<Index>();
		Index CZ2005Index1a = new Index(10229, "CZ2005", 10, 0, CZ2005lesson1);
		Index CZ2005Index1b = new Index(10230, "CZ2005", 10, 0, CZ2005lesson2);
		Index CZ2005Index1c = new Index(10231, "CZ2005", 10, 0, CZ2005lesson3);
		CZ2005Index.add(CZ2005Index1a);
		CZ2005Index.add(CZ2005Index1b);
		CZ2005Index.add(CZ2005Index1c);
		
		Course CZ2005 = new Course("CZ2005", "Operating Systems", "SCSE", 3, CZ2005Index);
		
		/**************************************************/
		
		ArrayList<Timeslot> Lecture2007 = new ArrayList<Timeslot>();
		Lecture2007.add(new Timeslot(4, LocalTime.of(12,30), LocalTime.of(13,30), "a"));
		Lecture2007.add(new Timeslot(1, LocalTime.of(13,30), LocalTime.of(14,30), "a"));

		ArrayList<Lesson> CZ2007lesson1 = new ArrayList<Lesson>();
		ArrayList<Timeslot> Tut12007 = new ArrayList<Timeslot>();
		Tut12007.add(new Timeslot(1, LocalTime.of(14,30), LocalTime.of(15,30), "a"));
		ArrayList<Timeslot> Lab12007 = new ArrayList<Timeslot>();
		Lab12007.add(new Timeslot(2, LocalTime.of(12,30), LocalTime.of(14,30), "e"));

		Lesson CZ2007lesson1a = new Lesson("Lec", "Online", "CS2", Lecture2007);
		Lesson CZ2007lesson1b = new Lesson("Tut", "TR+37", "SS1", Tut12007);
		Lesson CZ2007lesson1c = new Lesson("Lab", "SWLAB2", "SS1", Lab12007);
		CZ2007lesson1.add(CZ2007lesson1a);
		CZ2007lesson1.add(CZ2007lesson1b);
		CZ2007lesson1.add(CZ2007lesson1c);
		
		ArrayList <Lesson>CZ2007lesson2 = new ArrayList<Lesson>();
		ArrayList<Timeslot> Tut22007 = new ArrayList<Timeslot>();
		Tut22007.add(new Timeslot(3, LocalTime.of(9,30), LocalTime.of(10,30), "a"));
		ArrayList<Timeslot> Lab22007 = new ArrayList<Timeslot>();
		Lab22007.add(new Timeslot(2, LocalTime.of(14,30), LocalTime.of(16,30), "o"));

		Lesson CZ2007lesson2a = new Lesson("Lec", "Online", "CS2", Lecture2007);
		Lesson CZ2007lesson2b = new Lesson("Tut", "TR+15", "SS1", Tut22007);
		Lesson CZ2007lesson2c = new Lesson("Lab", "SWLAB3", "SS1", Lab22007);
		CZ2007lesson2.add(CZ2007lesson2a);
		CZ2007lesson2.add(CZ2007lesson2b);
		CZ2007lesson2.add(CZ2007lesson2c);
		
		ArrayList <Lesson>CZ2007lesson3 = new ArrayList<Lesson>();
		ArrayList<Timeslot> Tut32007 = new ArrayList<Timeslot>();
		Tut32007.add(new Timeslot(1, LocalTime.of(10,30), LocalTime.of(11,30), "a"));
		ArrayList<Timeslot> Lab32007 = new ArrayList<Timeslot>();
		Lab32007.add(new Timeslot(1, LocalTime.of(14,30), LocalTime.of(16,30), "e"));

		Lesson CZ2007lesson3a = new Lesson("Lec", "Online", "CS2", Lecture2007);
		Lesson CZ2007lesson3b = new Lesson("Tut", "TRX44", "SS4", Tut32007);
		Lesson CZ2007lesson3c = new Lesson("Lab", "SWLAB1", "SS4", Lab32007);
		CZ2007lesson3.add(CZ2007lesson3a);
		CZ2007lesson3.add(CZ2007lesson3b);
		CZ2007lesson3.add(CZ2007lesson3c);
		
		ArrayList <Index>CZ2007Index = new ArrayList<Index>();
		Index CZ2007Index1a = new Index(10250, "CZ2007", 10, 0, CZ2007lesson1);
		Index CZ2007Index1b = new Index(10251, "CZ2007", 10, 0, CZ2007lesson2);
		Index CZ2007Index1c = new Index(10253, "CZ2007", 10, 0, CZ2007lesson3);
		CZ2007Index.add(CZ2007Index1a);
		CZ2007Index.add(CZ2007Index1b);
		CZ2007Index.add(CZ2007Index1c);
		
		Course CZ2007 = new Course("CZ2007", "Introduction to Databases", "SCSE", 3, CZ2007Index);

		/**************************************************/

		ArrayList<Lesson> BU8401lesson1 = new ArrayList<Lesson>();
		ArrayList<Timeslot> Sem18401 = new ArrayList<Timeslot>();
		Sem18401.add(new Timeslot(1, LocalTime.of(14,30), LocalTime.of(17,30), "a"));
		Lesson BU8401lesson1a = new Lesson("Sem", "S3-SR6", "1", Sem18401);
		BU8401lesson1.add(BU8401lesson1a);
		
		ArrayList<Lesson> BU8401lesson2 = new ArrayList<Lesson>();
		ArrayList<Timeslot> Sem28401 = new ArrayList<Timeslot>();
		Sem18401.add(new Timeslot(2, LocalTime.of(14,30), LocalTime.of(17,30), "a"));
		Lesson BU8401lesson2a = new Lesson("Sem", "S3-SR7", "3", Sem28401);
		BU8401lesson2.add(BU8401lesson2a);

		ArrayList<Lesson> BU8401lesson3 = new ArrayList<Lesson>();
		ArrayList<Timeslot> Sem38401 = new ArrayList<Timeslot>();
		Sem38401.add(new Timeslot(3, LocalTime.of(14,30), LocalTime.of(17,30), "a"));
		Lesson BU8401lesson3a = new Lesson("Sem", "S3-SR7", "4", Sem38401);
		BU8401lesson3.add(BU8401lesson3a);		
		
		ArrayList <Index>BU8401Index = new ArrayList<Index>();
		Index BU8401Index1a = new Index (00604, "BU8401", 10, 0, BU8401lesson1);
		Index BU8401Index1b = new Index (00606, "BU8401", 10, 0, BU8401lesson2);
		Index BU8401Index1c = new Index (00607, "BU8401", 10, 0, BU8401lesson3);
		BU8401Index.add(BU8401Index1a);
		BU8401Index.add(BU8401Index1b);
		BU8401Index.add(BU8401Index1c);
		
		Course BU8401 = new Course("BU8401", "Management Decision Tools", "NBS", 3, BU8401Index);
		//CourseManager.removeCourse("CZ2007");
		//CourseManager.removeCourse("CZ2005");
		//CourseManager.removeCourse("CZ2002");
		CourseManager.addCourse(CZ2007);
		CourseManager.addCourse(CZ2005);
		CourseManager.addCourse(CZ2002);
		CourseManager.addCourse(BU8401);
	}
}
