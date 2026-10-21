
public class AttendanceSheet {

    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxStudents) {
        if (maxStudents < 0) {
            throw new IllegalArgumentException("Class size cannot be negative");
        }

        presentStudents = new String[maxStudents];
        presentCount = 0;
    }

    public void markPresent(String name) {

        if (isPresent(name)) {
            System.out.println(name + " is already marked present");
            return;
        }

        if (presentCount >= presentStudents.length) {
            System.out.println("Attendance sheet is full");
            return;
        }

        presentStudents[presentCount] = name;
        presentCount++;

        System.out.println(name + " marked present");
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {

        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Is Ben present? " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present? " + sheet.isPresent("Chen"));
    }
}

