package scholarshipSystem;

public enum Faculty {

	ARTS, MEDICINE, ARCHITECTURE, GRADUATE_STUDIES, BUSINESS, KINESIOLOGY, LAW, NURSING, ENGINEERING, SCIENCE, SOCIAL_WORK, VETERINARY, EDUCATION, OPEN_STUDIES, CONTINUING_EDUCATION;

	public static Faculty getFaculty(int index) {
		switch (index) {
		case 0:
			return ARTS;

		case 1:
			return MEDICINE;

		case 2:
			return ARCHITECTURE;

		case 3:
			return GRADUATE_STUDIES;

		case 4:
			return BUSINESS;

		case 5:
			return KINESIOLOGY;

		case 6:
			return LAW;

		case 7:
			return NURSING;

		case 8:
			return ENGINEERING;

		case 9:
			return SCIENCE;

		case 10:
			return SOCIAL_WORK;

		case 11:
			return VETERINARY;

		case 12:
			return EDUCATION;

		case 13:
			return OPEN_STUDIES;

		case 14:
			return CONTINUING_EDUCATION;

		default:
			return null;
		}
	}
}