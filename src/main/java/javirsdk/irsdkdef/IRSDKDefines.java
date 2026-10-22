package javirsdk.irsdkdef;

public final class IRSDKDefines {
    private IRSDKDefines() {}

    public static enum OnTrackLocation {
        NOT_IN_WORLD(-1),
        OFF_TRACK(0),
        IN_PIT_STALL(1),
        APPROACHING_PITS(2),
        ON_TRACK(3);

        private int underlying;
        private OnTrackLocation(int underlying) {
            this.underlying = underlying;
        }
    }
    public static enum TrackSurfaceType {
        NOT_IN_WORLD(-1),
        UNDEFINED(0),
        ASPHALT_TYPE_1(1),
        ASPHALT_TYPE_2(2),
        ASPHALT_TYPE_3(3),
        ASPHALT_TYPE_4(4),
        CONCRETE_TYPE_1(5),
        CONCRETE_TYPE_2(6),
        RACING_DIRT_TYPE_1(7),
        RACING_DIRT_TYPE_2(8),
        PAINT_TYPE_1(9),
        PAINT_TYPE_2(10),
        RUMBLE_TYPE_1(11),
        RUMBLE_TYPE_2(12),
        RUMBLE_TYPE_3(13),
        RUMBLE_TYPE_4(14),
        GRASS_TYPE_1(15),
        GRASS_TYPE_2(16),
        GRASS_TYPE_3(17),
        GRASS_TYPE_4(18),
        DIRT_TYPE_1(19),
        DIRT_TYPE_2(20),
        DIRT_TYPE_3(21),
        DIRT_TYPE_4(22),
        SAND(23),
        GRAVEL_TYPE_1(24),
        GRAVEL_TYPE_2(25),
        GRASS_CONCRETE(26),
        ASTROTURF(27);

        private int underlying;
        private TrackSurfaceType(int underlying) {
            this.underlying = underlying;
        }
    }

    public static enum SessionState {
        INVALID(0),
        GET_IN_CAR(1),
        WARMUP(2),
        PARADE_LAPS(3),
        RACING(4),
        CHECKERED(5),
        COOL_DOWN(6);

        private int underlying;
        private SessionState(int underlying) {
            this.underlying = underlying;
        }
    }
    public static enum CarLeftRight {
        OFF(0),
        CLEAR(1),
        LEFT(2),
        RIGFT(3),
        LEFT_RIGHT(4),
        TWO_LEFT(5),
        TWO_RIGHT(6);

        private int underlying;
        private CarLeftRight(int underlying) {
            this.underlying = underlying;
        }
    }
    public static enum PitServiceStatus {
        NONE(0),
        IN_PROGRESS(1),
        COMPLETE(2),
        TOO_FAR_LEFT(100),
        TOO_FAR_RIGHT(101),
        TOO_FAR_FORWARD(102),
        TOO_FAR_BACK(103),
        BAD_ANGLE(104),
        CAR_KAPUTT(105);

        private int underlying;
        private PitServiceStatus(int underlying) {
            this.underlying = underlying;
        }
    }
    public static enum PaceMode {
        SINGLE_FILE_START(0),
        DOUBLE_FILE_START(1),
        SINGLE_FILE_RESTART(2),
        DOUBLE_FILE_RESTART(3),
        NOT_PACING(4);

        private int underlying;
        private PaceMode(int underlying) {
            this.underlying = underlying;
        }
    }
    public static enum TrackWetness {
        UNKNOWN(0),
        DRY(1),
        MOSTLY_DRY(2),
        VERY_LIGHTLY_WET(3),
        LIGHTLY_WET(4),
        MODERATELY_WET(5),
        VERY_WET(6),
        EXTREMELY_WET(7);

        private int underlying;
        private TrackWetness(int underlying) {
            this.underlying = underlying;
        }
    }
    public static enum IncidentPointBitFlag {
        REPORT_NO_PENALTY(0x0000),
        REPORT_OUT_OF_CONTROL(0x0001),
        REPORT_OFF_TRACK(0x0002),
        REPORT_OFF_TRACK_ONGOING(0x0003),
        REPORT_CONTANCT_WITH_WORLD(0x0004),
        REPORT_COLLISION_WITH_WORLD(0x0005),
        REPORT_COLLISION_WITH_WORLD_ONGOING(0x0006),
        REPORT_CONTACT_WITH_CAR(0x0007),
        REPORT_COLLISION_WITH_CAR(0x0008),
        PENALTY_NO_PENALTY(0x0000),
        PENALTY_ZERO_X(0x0100),
        PENALTY_ONE_X(0x0200),
        PENATLY_TWO_X(0x0300),
        PENALTY_FOUR_X(0x0400),
        MASK_REPORT_MASK(0x000000FF),
        MASK_PENALTY_MASK(0x0000FF00);

        private int underlying;
        private IncidentPointBitFlag (int underlying) {
            this.underlying = underlying;
        }
    }
    public static enum EngineWarning {
        WATER_TEMP(0x0001),
        FUEL_PRESSURE(0x0002),
        OIL_PRESSURE(0x0004),
        ENGINE_STALLED(0x0008),
        PIT_SPEED_LIMITER(0x0010),
        REV_LIMITER_ACTIVE(0x0020),
        OIL_TEMP(0x0040),
        MANDATORY_REPAIRS(0x0080),
        OPTIONAL_REPAIRS(0x0100);

        private int underlying;
        private EngineWarning(int underlying) {
            this.underlying = underlying;
        }
    }
    public static class Flag {
        public static enum Global {
            CHECKERED(0x00000001),
            WHITE(0x00000002),
            GREEN(0x00000004),
            YELLOW(0x00000008),
            RED(0x00000010),
            BLUE(0x00000020),
            SLIPPERY_SURFACE(0x00000040),
            CROSSED(0x00000080),
            YELLOW_WAVING(0x00000100),
            ONE_LAP_TO_GREEN(0x00000200),
            GREEN_HELD(0x00000400),
            TEN_TO_GO(0x00000800),
            FIVE_TO_GO(0x00001000),
            RANDOM_WAVING(0x00002000),
            CAUTION(0x00004000),
            CAUTION_WAVING(0x00008000);

            private int underlying;
            private Global(int underlying) {
                this.underlying = underlying;
            }
        } 
        public static enum Driver {
            BLACK(0x00010000),
            DISQUALIFY(0x00020000),
            SERVICIBLE(0x00040000),
            FURLED(0x00080000),
            REPAIR(0x00100000),
            DQ_SCORING_INVALID(0x00200000);

            private int underlying;
            private Driver(int underlying) {
                this.underlying = underlying;
            }
        }
        public static enum StartLight {
            HIDDEN(0x10000000),
            READY(0x20000000),
            SET(0x40000000),
            GO(0x80000000);

            private int underlying;
            private StartLight(int underlying) {
                this.underlying = underlying;
            }           
        }
    }
    public static enum CameraState {
        IS_SESSION_SCREEN(0x0001),
        IS_SCENIC_ACTIVE(0x0002);

        private int underlying;
        private CameraState(int underlying) {
            this.underlying = underlying;
        }       
    }
    public static enum PitServiceBitFlag {
        LF_TYRE_CHANGE(0x0001),
        RF_TYRE_CHANGE(0x0002),
        LR_TYRE_CHANGE(0x0004),
        RR_TYRE_CHANGE(0x0008),
        BEGIN_REFUEL(0x0010),
        WINDSHIELD_TEAROFF(0x0020),
        FAST_REPAIR(0x0040);

        private int underlying;
        private PitServiceBitFlag(int underlying) {
            this.underlying = underlying;
        }
    }
    public static enum UnderPacing {
        END_OF_LINE(0x0001),
        FREE_PASS(0x0002),
        WAVEAROUND(0x0004);

        private int underlying;
        private UnderPacing(int underlying) {
            this.underlying = underlying;
        }           
    }
}
