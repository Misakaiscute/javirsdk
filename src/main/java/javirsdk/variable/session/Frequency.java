package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

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
		private boolean canScan = false;
		public boolean getCanScan() { return canScan; }
		@JsonProperty("CanSquawk")
		private boolean canSquawk = false;
		public boolean getCanSquawk() { return canSquawk; }
		@JsonProperty("Muted")
		private boolean muted = false;
		public boolean getMuted() { return muted; }
		@JsonProperty("IsMutable")
		private boolean isMutable = false;
		public boolean getIsMutable() { return isMutable; }
		@JsonProperty("IsDeletable")
		private boolean isDeletable = false;
		public boolean getIsDeletable() { return isDeletable; }
		//$...    
}
