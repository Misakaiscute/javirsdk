package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverInfo {
 		@JsonProperty("DriverCarIdx")
		private int driverCarIdx = 0;
		public int getDriverCarIdx() { return driverCarIdx; }
		@JsonProperty("DriverUserID")
		private int driverUserID = 0;
		public int getDriverUserID() { return driverUserID; }
		@JsonProperty("PaceCarIdx")
		private int paceCarIdx = 0;
		public int getPaceCarIdx() { return paceCarIdx; }
		@JsonProperty("DriverHeadPosX")
		private float driverHeadPosX = 0;
		public float getDriverHeadPosX() { return driverHeadPosX; }
		@JsonProperty("DriverHeadPosY")
		private float driverHeadPosY = 0;
		public float getDriverHeadPosY() { return driverHeadPosY; }
		@JsonProperty("DriverHeadPosZ")
		private float driverHeadPosZ = 0;
		public float getDriverHeadPosZ() { return driverHeadPosZ; }
		@JsonProperty("DriverCarIdleRPM")
		private float driverCarIdleRPM = 0f;
		public float getDriverCarIdleRPM() { return driverCarIdleRPM; }
		@JsonProperty("DriverCarRedLine")
		private float driverCarRedLine = 0f;
		public float getDriverCarRedLine() { return driverCarRedLine; }
		@JsonProperty("DriverCarFuelKgPerLtr")
		private float driverCarFuelKgPerLtr = 0f;
		public float getDriverCarFuelKgPerLtr() { return driverCarFuelKgPerLtr; }
		@JsonProperty("DriverCarFuelMaxLtr")
		private float driverCarFuelMaxLtr = 0f;
		public float getDriverCarFuelMaxLtr() { return driverCarFuelMaxLtr; }
		@JsonProperty("DriverCarMaxFuelPct")
		private float driverCarMaxFuelPct = 0f;
		public float getDriverCarMaxFuelPct() { return driverCarMaxFuelPct; }
		@JsonProperty("DriverCarGearNumForward")
		private int driverCarGearNumForward = 0;
		public int getDriverCarGearNumForward() { return driverCarGearNumForward; }
		@JsonProperty("DriverCarGearNeutral")
		private int driverCarGearNeutral = 0;
		public int getDriverCarGearNeutral() { return driverCarGearNeutral; }
		@JsonProperty("DriverCarGearReverse")
		private int driverCarGearReverse = 0;
		public int getDriverCarGearReverse() { return driverCarGearReverse; }
		@JsonProperty("DriverCarSLFirstRPM")
		private float driverCarSLFirstRPM = 0f;
		public float getDriverCarSLFirstRPM() { return driverCarSLFirstRPM; }
		@JsonProperty("DriverCarSLShiftRPM")
		private float driverCarSLShiftRPM = 0f;
		public float getDriverCarSLShiftRPM() { return driverCarSLShiftRPM; }
		@JsonProperty("DriverCarSLLastRPM")
		private float driverCarSLLastRPM = 0f;
		public float getDriverCarSLLastRPM() { return driverCarSLLastRPM; }
		@JsonProperty("DriverCarSLBlinkRPM")
		private float driverCarSLBlinkRPM = 0f;
		public float getDriverCarSLBlinkRPM() { return driverCarSLBlinkRPM; }
		@JsonProperty("DriverPitTrkPct")
		private float driverPitTrkPct = 0f;
		public float getDriverPitTrkPct() { return driverPitTrkPct; }
		@JsonProperty("DriverCarEstLapTime")
		private float driverCarEstLapTime = 0f;
		public float getDriverCarEstLapTime() { return driverCarEstLapTime; }
		@JsonProperty("DriverSetupName")
		private String driverSetupName = null;
		public String getDriverSetupName() { return driverSetupName; }
		@JsonProperty("DriverSetupLoadTypeName")
		private String driverSetupLoadTypeName = null;
		public String getDriverSetupLoadTypeName() { return driverSetupLoadTypeName; }
		@JsonProperty("DriverSetupIsModified")
		private byte driverSetupIsModified = 0;
		public boolean getDriverSetupIsModified() { return driverSetupIsModified == 1; }
		@JsonProperty("DriverSetupPassedTech")
		private byte driverSetupPassedTech = 0;
		public boolean getDriverSetupPassedTech() { return driverSetupPassedTech == 1; }
		@JsonProperty("DriverIncidentCount")
		private int driverIncidentCount = 0;
		public int getDriverIncidentCount() { return driverIncidentCount; }
		@JsonProperty("Drivers")
		private Driver[] drivers = null;
		public Driver[] getDrivers() { return drivers; }
    //$...    
}
