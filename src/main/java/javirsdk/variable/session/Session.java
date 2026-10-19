package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

public class Session {
   	@JsonProperty("SessionNum")
		private int sessionNum = 0;
		public int getSessionNum() { return sessionNum; }
		@JsonProperty("SessionLaps")
		private String sessionLaps = null;
		public String getSessionLaps() { return sessionLaps; }
		@JsonProperty("SessionTime")
		private String sessionTime = null;
		public String getSessionTime() { return sessionTime; }
		@JsonProperty("SessionType")
		private String sessionType = null;
		public String getSessionType() { return sessionType; }
		@JsonProperty("SessionNumLapsToAvg")
		private int sessionNumLapsToAvg = 0;
		public int getSessionNumLapsToAvg() { return sessionNumLapsToAvg; }
		@JsonProperty("ResultsPositions")
		private ResultsPosition[] resultsPositions = null;
		public ResultsPosition[] getResultsPositions() { return resultsPositions; }
		@JsonProperty("ResultsFastestLap")
		private ResultsFastestLap[] resultsFastestLap = null;
		public ResultsFastestLap[] getResultsFastestLap() { return resultsFastestLap; }
		@JsonProperty("ResultsAverageLapTime")
		private double resultsAverageLapTime = 0.0;
		public double getResultsAverageLapTime() { return resultsAverageLapTime; }
		@JsonProperty("ResultsNumCautionFlags")
		private int resultsNumCautionFlags = 0;
		public int getResultsNumCautionFlags() { return resultsNumCautionFlags; }
		@JsonProperty("ResultsNumCautionLaps")
		private int resultsNumCautionLaps = 0;
		public int getResultsNumCautionLaps() { return resultsNumCautionLaps; }
		@JsonProperty("ResultsNumLeadChanges")
		private int resultsNumLeadChanges = 0;
		public int getResultsNumLeadChanges() { return resultsNumLeadChanges; }
		@JsonProperty("ResultsLapsComplete")
		private int resultsLapsComplete = 0;
		public int getResultsLapsComplete() { return resultsLapsComplete; }
		@JsonProperty("ResultsOfficial")
		private boolean resultsOfficial = false;
		public boolean getResultsOfficial() { return resultsOfficial; }
		//$...    
}
