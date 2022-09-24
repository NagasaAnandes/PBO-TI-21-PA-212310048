
public class Students {
		int NPM, Semester;
		String Fullname, ClassName;
		float GPA;
		
		int getNPM(int val) {
			NPM = val;
			return NPM;
		}
		
		String getFullname(String val) {
			Fullname = val;
			return Fullname;
		}
		
		String getClassName(String val) {
			ClassName = val;
			return ClassName;
		}
		
		int getSemester(int val) {
			Semester = val;
			return Semester;
		}
		
		float getGPA(float val) {
			GPA = val;
			return GPA;
		}
}
