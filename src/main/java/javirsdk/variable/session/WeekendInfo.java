package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

public class WeekendInfo {
    @JsonProperty("TrackName")
		private String trackName = null;
		public String getTrackName() { return trackName; }
		@JsonProperty("TrackID")
		private int trackID = 0;
		public int getTrackID() { return trackID; }
		@JsonProperty("TrackLength")
		private String trackLength = null;
		public String getTrackLength() { return trackLength; }
		@JsonProperty("TrackDisplayName")
		private String trackDisplayName = null;
		public String getTrackDisplayName() { return trackDisplayName; }
		@JsonProperty("TrackDisplayShortName")
		private String trackDisplayShortName = null;
		public String getTrackDisplayShortName() { return trackDisplayShortName; }
		@JsonProperty("TrackConfigName")
		private String trackConfigName = null;
		public String getTrackConfigName() { return trackConfigName; }
		@JsonProperty("TrackCity")
		private String trackCity = null;
		public String getTrackCity() { return trackCity; }
		@JsonProperty("TrackCountry")
		private String trackCountry = null;
		public String getTrackCountry() { return trackCountry; }
		@JsonProperty("TrackAltitude")
		private String trackAltitude = null;
		public String getTrackAltitude() { return trackAltitude; }
		@JsonProperty("TrackLatitude")
		private String trackLatitude = null;
		public String getTrackLatitude() { return trackLatitude; }
		@JsonProperty("TrackLongitude")
		private String trackLongitude = null;
		public String getTrackLongitude() { return trackLongitude; }
		@JsonProperty("TrackNumTurns")
		private int trackNumTurns = 0;
		public int getTrackNumTurns() { return trackNumTurns; }
		@JsonProperty("TrackPitSpeedLimit")
		private String trackPitSpeedLimit = null;
		public String getTrackPitSpeedLimit() { return trackPitSpeedLimit; }
		@JsonProperty("TrackType")
		private String trackType = null;
		public String getTrackType() { return trackType; }
		@JsonProperty("TrackWeatherType")
		private String trackWeatherType = null;
		public String getTrackWeatherType() { return trackWeatherType; }
		@JsonProperty("TrackSkies")
		private String trackSkies = null;
		public String getTrackSkies() { return trackSkies; }
		@JsonProperty("TrackSurfaceTemp")
		private String trackSurfaceTemp = null;
		public String getTrackSurfaceTemp() { return trackSurfaceTemp; }
		@JsonProperty("TrackAirTemp")
		private String trackAirTemp = null;
		public String getTrackAirTemp() { return trackAirTemp; }
		@JsonProperty("TrackAirPressure")
		private String trackAirPressure = null;
		public String getTrackAirPressure() { return trackAirPressure; }
		@JsonProperty("TrackWindVel")
		private String trackWindVel = null;
		public String getTrackWindVel() { return trackWindVel; }
		@JsonProperty("TrackWindDir")
		private String trackWindDir = null;
		public String getTrackWindDir() { return trackWindDir; }
		@JsonProperty("TrackRelativeHumidity")
		private String trackRelativeHumidity = null;
		public String getTrackRelativeHumidity() { return trackRelativeHumidity; }
		@JsonProperty("TrackFogLevel")
		private String trackFogLevel = null;
		public String getTrackFogLevel() { return trackFogLevel; }
		@JsonProperty("SeriesID")
		private int seriesID = 0;
		public int getSeriesID() { return seriesID; }
		@JsonProperty("SeasonID")
		private int seasonID = 0;
		public int getSeasonID() { return seasonID; }
		@JsonProperty("SessionID")
		private int sessionID = 0;
		public int getSessionID() { return sessionID; }
		@JsonProperty("SubSessionID")
		private int subSessionID = 0;
		public int getSubSessionID() { return subSessionID; }
		@JsonProperty("LeagueID")
		private int leagueID = 0;
		public int getLeagueID() { return leagueID; }
		@JsonProperty("Official")
		private boolean official = false;
		public boolean getOfficial() { return official; }
		@JsonProperty("RaceWeek")
		private int raceWeek = 0;
		public int getRaceWeek() { return raceWeek; }
		@JsonProperty("EventType")
		private String eventType = null;
		public String getEventType() { return eventType; }
		@JsonProperty("Category")
		private String category = null;
		public String getCategory() { return category; }
		@JsonProperty("SimMode")
		private String simMode = null;
		public String getSimMode() { return simMode; }
		@JsonProperty("TeamRacing")
		private boolean teamRacing = false;
		public boolean getTeamRacing() { return teamRacing; }
		@JsonProperty("DCRuleSet")
		private String dCRuleSet = null;
		public String getDCRuleSet() { return dCRuleSet; }
		@JsonProperty("QualifierMustStartRace")
		private boolean qualifierMustStartRace = false;
		public boolean getQualifierMustStartRace() { return qualifierMustStartRace; }
		@JsonProperty("NumCarClasses")
		private int numCarClasses = 0;
		public int getNumCarClasses() { return numCarClasses; }
		@JsonProperty("NumCarTypes")
		private int numCarTypes = 0;
		public int getNumCarTypes() { return numCarTypes; }
		@JsonProperty("WeekendOptions")
		private WeekendOptions weekendOptions = null;
		public WeekendOptions getWeekendOptions() { return weekendOptions; }
		@JsonProperty("TelemetryOptions")
		private TelemetryOptions telemetryOptions = null;
		public TelemetryOptions getTelemetryOptions() { return telemetryOptions; }
		//$...    
}
