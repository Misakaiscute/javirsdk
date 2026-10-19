package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

public class WeekendOptions {
   	@JsonProperty("NumStarters")
		private int numStarters = 0;
		public int getNumStarters() { return numStarters; }
		@JsonProperty("StartingGrid")
		private String startingGrid = null;
		public String getStartingGrid() { return startingGrid; }
		@JsonProperty("QualifyScoring")
		private String qualifyScoring = null;
		public String getQualifyScoring() { return qualifyScoring; }
		@JsonProperty("CourseCautions")
		private String courseCautions = null;
		public String getCourseCautions() { return courseCautions; }
		@JsonProperty("StandingStart")
		private boolean standingStart = false;
		public boolean getStandingStart() { return standingStart; }
		@JsonProperty("Restarts")
		private String restarts = null;
		public String getRestarts() { return restarts; }
		@JsonProperty("WeatherType")
		private String weatherType = null;
		public String getWeatherType() { return weatherType; }
		@JsonProperty("Skies")
		private String skies = null;
		public String getSkies() { return skies; }
		@JsonProperty("WindDirection")
		private String windDirection = null;
		public String getWindDirection() { return windDirection; }
		@JsonProperty("WindSpeed")
		private String windSpeed = null;
		public String getWindSpeed() { return windSpeed; }
		@JsonProperty("WeatherTemp")
		private String weatherTemp = null;
		public String getWeatherTemp() { return weatherTemp; }
		@JsonProperty("RelativeHumidity")
		private String relativeHumidity = null;
		public String getRelativeHumidity() { return relativeHumidity; }
		@JsonProperty("FogLevel")
		private String fogLevel = null;
		public String getFogLevel() { return fogLevel; }
		@JsonProperty("Unofficial")
		private boolean unofficial = false;
		public boolean getUnofficial() { return unofficial; }
		@JsonProperty("CommercialMode")
		private String commercialMode = null;
		public String getCommercialMode() { return commercialMode; }
		@JsonProperty("NightMode")
		private boolean nightMode = false;
		public boolean getNightMode() { return nightMode; }
		@JsonProperty("IsFixedSetup")
		private boolean isFixedSetup = false;
		public boolean getIsFixedSetup() { return isFixedSetup; }
		@JsonProperty("StrictLapsChecking")
		private String strictLapsChecking = null;
		public String getStrictLapsChecking() { return strictLapsChecking; }
		@JsonProperty("HasOpenRegistration")
		private boolean hasOpenRegistration = false;
		public boolean getHasOpenRegistration() { return hasOpenRegistration; }
		@JsonProperty("HardcoreLevel")
		private int hardcoreLevel = 0;
		public int getHardcoreLevel() { return hardcoreLevel; }
		@JsonProperty("NumJokerLaps")
		private int numJokerLaps = 0;
		public int getNumJokerLaps() { return numJokerLaps; }
		@JsonProperty("Date")
		private String date = null;
		public String getDate() { return date; }
		@JsonProperty("TimeOfDay")
		private String timeOfDay = null;
		public String getTimeOfDay() { return timeOfDay; }
		@JsonProperty("FastRepairsLimit")
		private String fastRepairsLimit = null;
		public String getFastRepairsLimit() { return fastRepairsLimit; }
		@JsonProperty("GreenWhiteCheckeredLimit")
		private int greenWhiteCheckeredLimit = 0;
		public int getGreenWhiteCheckeredLimit() { return greenWhiteCheckeredLimit; }
		//$...    
}
