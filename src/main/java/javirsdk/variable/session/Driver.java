package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Driver {
    @JsonProperty("CarIdx")
		private int carIdx = 0;
		public int getCarIdx() { return carIdx; }
		@JsonProperty("UserName")
		private String userName = null;
		public String getUserName() { return userName; }
		@JsonProperty("CarNumber")
		private String carNumber = null;
		public String getCarNumber() { return carNumber; }
		@JsonProperty("CarClassID")
		private int carClassID = 0;
		public int getCarClassID() { return carClassID; }
		@JsonProperty("CarClassShortName")
		private String carClassShortName = null;
		public String getCarClassShortName() { return carClassShortName; }
		@JsonProperty("CarClassRelSpeed")
		private int carClassRelSpeed = 0;
		public int getCarClassRelSpeed() { return carClassRelSpeed; }
		@JsonProperty("CarClassLicenseLevel")
		private int carClassLicenseLevel = 0;
		public int getCarClassLicenseLevel() { return carClassLicenseLevel; }
		@JsonProperty("CarClassMaxFuelPct")
		private String carClassMaxFuelPct = null;
		public String getCarClassMaxFuelPct() { return carClassMaxFuelPct; }
		@JsonProperty("CarClassWeightPenalty")
		private String carClassWeightPenalty = null;
		public String getCarClassWeightPenalty() { return carClassWeightPenalty; }
		@JsonProperty("CarClassPowerAdjust")
		private String carClassPowerAdjust = null;
		public String getCarClassPowerAdjust() { return carClassPowerAdjust; }
		@JsonProperty("CarClassDryTireSetLimit")
		private String carClassDryTireSetLimit = null;
		public String getCarClassDryTireSetLimit() { return carClassDryTireSetLimit; }
		@JsonProperty("CarClassColor")
		private int carClassColor = 0;
		public int getCarClassColor() { return carClassColor; }
		@JsonProperty("CarClassEstLapTime")
		private float carClassEstLapTime = 0f;
		public float getCarClassEstLapTime() { return carClassEstLapTime; }
		@JsonProperty("ClubID")
		private int clubID = 0;
		public int getClubID() { return clubID; }
		@JsonProperty("ClubName")
		private String clubName = null;
		public String getClubName() { return clubName; }
		@JsonProperty("DivisionID")
		private int divisionID = 0;
		public int getDivisionID() { return divisionID; }
		@JsonProperty("DivisionName")
		private String divisionName = null;
		public String getDivisionName() { return divisionName; }
		@JsonProperty("CurDriverIncidentCount")
		private int curDriverIncidentCount = 0;
		public int getCurDriverIncidentCount() { return curDriverIncidentCount; }
		@JsonProperty("TeamIncidentCount")
		private int teamIncidentCount = 0;
		public int getTeamIncidentCount() { return teamIncidentCount; }
		@JsonProperty("HelmetDesignStr")
		private String helmetDesignStr = null;
		public String getHelmetDesignStr() { return helmetDesignStr; }
		@JsonProperty("CarDesignStr")
		private String carDesignStr = null;
		public String getCarDesignStr() { return carDesignStr; }
		@JsonProperty("SuitDesignStr")
		private String suitDesignStr = null;
		public String getSuitDesignStr() { return suitDesignStr; }
		@JsonProperty("CarNumberDesignStr")
		private String carNumberDesignStr = null;
		public String getCarNumberDesignStr() { return carNumberDesignStr; }
		@JsonProperty("CarSponsor_1")
		private int carSponsor_1 = 0;
		public int getCarSponsor_1() { return carSponsor_1; }
		@JsonProperty("CarSponsor_2")
		private int carSponsor_2 = 0;
		public int getCarSponsor_2() { return carSponsor_2; }
		@JsonProperty("IRating")
		private int iRating = 0;
		public int getIRating() { return iRating; }
		@JsonProperty("Initials")
		private String initials = null;
		public String getInitials() { return initials; }
		@JsonProperty("IsSpectator")
		private byte isSpectator = 0;
		public boolean getIsSpectator() { return isSpectator == 1; }
		@JsonProperty("LicLevel")
		private int licLevel = 0;
		public int getLicLevel() { return licLevel; }
		@JsonProperty("LicSubLevel")
		private int licSafetyRating = 0;
		public int getLicSafetyRating() { return licSafetyRating; }
		@JsonProperty("LicString")
		private String licString = null;
		public String getLicString() { return licString; }
		@JsonProperty("LicColor")
		private int licColor = 0;
		public int getLicColor() { return licColor; }
		@JsonProperty("AbbrevName")
		private String nameAbbreviated = null;
		public String getNameAbbreviated() { return nameAbbreviated; }
		@JsonProperty("CarNumberRaw")
		private int carNumberRaw = 0;
		public int getCarNumberRaw() { return carNumberRaw; }
		@JsonProperty("CarID")
		private int carID = 0;
		public int getCarID() { return carID; }
		@JsonProperty("CarPath")
		private String carPath = null;
		public String getCarPath() { return carPath; }
		@JsonProperty("CarIsPaceCar")
		private byte carIsPaceCar = 0;
		public boolean getCarIsPaceCar() { return carIsPaceCar == 1; }
		@JsonProperty("CarIsAI")
		private byte carIsAI = 0;
		public boolean getCarIsAI() { return carIsAI == 1; }
		@JsonProperty("CarScreenName")
		private String carScreenName = null;
		public String getCarScreenName() { return carScreenName; }
		@JsonProperty("CarScreenNameShort")
		private String carScreenNameShort = null;
		public String getCarScreenNameShort() { return carScreenNameShort; }
		//$...
}
