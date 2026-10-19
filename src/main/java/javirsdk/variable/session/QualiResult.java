package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

public class QualiResult {
   	@JsonProperty("CarIdx")
		private int carIdx = 0;
		public int getCarIdx() { return carIdx; }
		@JsonProperty("Position")
		private int position = 0;
		public int getPosition() { return position; }
		@JsonProperty("ClassPosition")
		private int classPosition = 0;
		public int getClassPosition() { return classPosition; }
		@JsonProperty("FastestLap")
		private int fastestLap = 0;
		public int getFastestLap() { return fastestLap; }
		@JsonProperty("FastestTime")
		private double fastestTime = 0.0;
		public double getFastestTime() { return fastestTime; }
		//$...    
}
