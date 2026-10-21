package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsPosition {
   	@JsonProperty("CarIdx")
		private int carIdx = 0;
		public int getCarIdx() { return carIdx; }
		@JsonProperty("Position")
		private int position = 0;
		public int getPosition() { return position; }
		@JsonProperty("ClassPosition")
		private int classPosition = 0;
		public int getClassPosition() { return classPosition; }
		@JsonProperty("FastestTime")
		private double fastestTime = 0.0;
		public double getFastestTime() { return fastestTime; }
		@JsonProperty("Lap")
		private int lap = 0;
		public int getLap() { return lap; }
		@JsonProperty("LastTime")
		private double lastTime = 0.0;
		public double getLastTime() { return lastTime; }
		@JsonProperty("LapsComplete")
		private int lapsComplete = 0;
		public int getLapsComplete() { return lapsComplete; }
		@JsonProperty("LapsDriven")
		private int lapsDriven = 0;
		public int getLapsDriven() { return lapsDriven; }
		@JsonProperty("ReasonOutId")
		private int reasonOutId = 0;
		public int getReasonOutId() { return reasonOutId; }
		//$...    
}
