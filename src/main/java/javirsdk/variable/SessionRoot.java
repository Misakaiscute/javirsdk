package javirsdk.variable;

import javirsdk.variable.session.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SessionRoot {
    @JsonProperty("WeekendInfo")
    private WeekendInfo weekendInfo = null;
    public WeekendInfo getWeekendInfo() { return weekendInfo; }
    @JsonProperty("SessionInfo")
		private SessionInfo sessionInfo = null;
		public SessionInfo getSessionInfo() { return sessionInfo; }
		@JsonProperty("DriverInfo")
		private DriverInfo driverInfo = null;
		public DriverInfo getDriverInfo() { return driverInfo; }
		@JsonProperty("CameraInfo")
		private CameraInfo cameraInfo = null;
		public CameraInfo getCameraInfo() { return cameraInfo; }
		@JsonProperty("QualifyResultsInfo")
		private QualifyResultsInfo qualifyResultsInfo = null;
		public QualifyResultsInfo getQualifyResultsInfo() { return qualifyResultsInfo; }
		@JsonProperty("SplitTimeInfo")
		private SplitTimeInfo splitTimeInfo = null;
		public SplitTimeInfo getSplitTimeInfo() { return splitTimeInfo; }
		@JsonProperty("RadioInfo")
		private RadioInfo radioInfo = null;
		public RadioInfo getRadioInfo() { return radioInfo; }
		//$...
}
