package model;

public enum PunishmentType {

    WARNING(3),
    MEETING(2),
    EXPULSION(1),
    NONE(4);

    private static final int EXPULSION_STANDARD = 6;
    private static final int MEETING_STANDARD = 3;
    private static final int WARNING_STANDARD = 2;

    private final int priority;

    PunishmentType(int priority) {
        this.priority = priority;
    }

    public static PunishmentType calculateType(int convertedAbsenceCount) {
        if (convertedAbsenceCount >= EXPULSION_STANDARD) {
            return EXPULSION;
        }
        if (convertedAbsenceCount >= MEETING_STANDARD) {
            return MEETING;
        }
        if (convertedAbsenceCount >= WARNING_STANDARD) {
            return WARNING;
        }
        return NONE;
    }

    public int comparePriority(PunishmentType o) {
        return priority - o.priority;
    }
}
