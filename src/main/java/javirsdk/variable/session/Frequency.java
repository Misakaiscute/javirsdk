package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Frequency {
   	@JsonProperty("FrequencyNum")
		private int frequencyNum = 0;
		public int getFrequencyNum() { return frequencyNum; }
		@JsonProperty("FrequencyName")
		private String frequencyName = null;
		public String getFrequencyName() { return frequencyName; }
		@JsonProperty("Priority")
		private int priority = 0;
		public int getPriority() { return priority; }
		@JsonProperty("CarIdx")
		private int carIdx = 0;
		public int getCarIdx() { return carIdx; }
		@JsonProperty("EntryIdx")
		private int entryIdx = 0;
		public int getEntryIdx() { return entryIdx; }
		@JsonProperty("ClubID")
		private int clubID = 0;
		public int getClubID() { return clubID; }
		@JsonProperty("CanScan")
		private byte canScan = 0;
		public boolean getCanScan() { return canScan == 1; }
		@JsonProperty("CanSquawk")
		private byte canSquawk = 0;
		public boolean getCanSquawk() { return canSquawk == 1; }
		@JsonProperty("Muted")
		private byte muted = 0;
		public boolean getMuted() { return muted == 1; }
		@JsonProperty("IsMutable")
		private byte isMutable = 0;
		public boolean getIsMutable() { return isMutable == 1; }
		@JsonProperty("IsDeletable")
		private byte isDeletable = 0;
		public boolean getIsDeletable() { return isDeletable == 1; }
		//$...    
}
