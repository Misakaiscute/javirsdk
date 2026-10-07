    package javirsdk.variable;

    public final class JavirsdkVariableStateSnapshot {
        private JavirsdkVariableStateSnapshot() {}

        private Double sessionTime = 0.0;
public Double getSessionTime() { return this.sessionTime; }
public void setSessionTime(Double v) { this.sessionTime = v; }

private Integer sessionTick = 0;
public Integer getSessionTick() { return this.sessionTick; }
public void setSessionTick(Integer v) { this.sessionTick = v; }

private Integer sessionNum = 0;
public Integer getSessionNum() { return this.sessionNum; }
public void setSessionNum(Integer v) { this.sessionNum = v; }

private Integer sessionState = 0;
public Integer getSessionState() { return this.sessionState; }
public void setSessionState(Integer v) { this.sessionState = v; }

private Integer sessionUniqueID = 0;
public Integer getSessionUniqueID() { return this.sessionUniqueID; }
public void setSessionUniqueID(Integer v) { this.sessionUniqueID = v; }

private Integer sessionFlags = 0;
public Integer getSessionFlags() { return this.sessionFlags; }
public void setSessionFlags(Integer v) { this.sessionFlags = v; }

private Double sessionTimeRemain = 0.0;
public Double getSessionTimeRemain() { return this.sessionTimeRemain; }
public void setSessionTimeRemain(Double v) { this.sessionTimeRemain = v; }

private Integer sessionLapsRemain = 0;
public Integer getSessionLapsRemain() { return this.sessionLapsRemain; }
public void setSessionLapsRemain(Integer v) { this.sessionLapsRemain = v; }

private Integer sessionLapsRemainEx = 0;
public Integer getSessionLapsRemainEx() { return this.sessionLapsRemainEx; }
public void setSessionLapsRemainEx(Integer v) { this.sessionLapsRemainEx = v; }

private Double sessionTimeTotal = 0.0;
public Double getSessionTimeTotal() { return this.sessionTimeTotal; }
public void setSessionTimeTotal(Double v) { this.sessionTimeTotal = v; }

private Integer sessionLapsTotal = 0;
public Integer getSessionLapsTotal() { return this.sessionLapsTotal; }
public void setSessionLapsTotal(Integer v) { this.sessionLapsTotal = v; }

private Integer sessionJokerLapsRemain = 0;
public Integer getSessionJokerLapsRemain() { return this.sessionJokerLapsRemain; }
public void setSessionJokerLapsRemain(Integer v) { this.sessionJokerLapsRemain = v; }

private Boolean sessionOnJokerLap = false;
public Boolean getSessionOnJokerLap() { return this.sessionOnJokerLap; }
public void setSessionOnJokerLap(Boolean v) { this.sessionOnJokerLap = v; }

private Float sessionTimeOfDay = 0f;
public Float getSessionTimeOfDay() { return this.sessionTimeOfDay; }
public void setSessionTimeOfDay(Float v) { this.sessionTimeOfDay = v; }

private Integer radioTransmitCarIdx = 0;
public Integer getRadioTransmitCarIdx() { return this.radioTransmitCarIdx; }
public void setRadioTransmitCarIdx(Integer v) { this.radioTransmitCarIdx = v; }

private Integer radioTransmitRadioIdx = 0;
public Integer getRadioTransmitRadioIdx() { return this.radioTransmitRadioIdx; }
public void setRadioTransmitRadioIdx(Integer v) { this.radioTransmitRadioIdx = v; }

private Integer radioTransmitFrequencyIdx = 0;
public Integer getRadioTransmitFrequencyIdx() { return this.radioTransmitFrequencyIdx; }
public void setRadioTransmitFrequencyIdx(Integer v) { this.radioTransmitFrequencyIdx = v; }

private Integer displayUnits = 0;
public Integer getDisplayUnits() { return this.displayUnits; }
public void setDisplayUnits(Integer v) { this.displayUnits = v; }

private Boolean driverMarker = false;
public Boolean getDriverMarker() { return this.driverMarker; }
public void setDriverMarker(Boolean v) { this.driverMarker = v; }

private Boolean pushToTalk = false;
public Boolean getPushToTalk() { return this.pushToTalk; }
public void setPushToTalk(Boolean v) { this.pushToTalk = v; }

private Boolean pushToPass = false;
public Boolean getPushToPass() { return this.pushToPass; }
public void setPushToPass(Boolean v) { this.pushToPass = v; }

private Boolean manualBoost = false;
public Boolean getManualBoost() { return this.manualBoost; }
public void setManualBoost(Boolean v) { this.manualBoost = v; }

private Boolean manualNoBoost = false;
public Boolean getManualNoBoost() { return this.manualNoBoost; }
public void setManualNoBoost(Boolean v) { this.manualNoBoost = v; }

private Boolean isOnTrack = false;
public Boolean getIsOnTrack() { return this.isOnTrack; }
public void setIsOnTrack(Boolean v) { this.isOnTrack = v; }

private Boolean isReplayPlaying = false;
public Boolean getIsReplayPlaying() { return this.isReplayPlaying; }
public void setIsReplayPlaying(Boolean v) { this.isReplayPlaying = v; }

private Integer replayFrameNum = 0;
public Integer getReplayFrameNum() { return this.replayFrameNum; }
public void setReplayFrameNum(Integer v) { this.replayFrameNum = v; }

private Integer replayFrameNumEnd = 0;
public Integer getReplayFrameNumEnd() { return this.replayFrameNumEnd; }
public void setReplayFrameNumEnd(Integer v) { this.replayFrameNumEnd = v; }

private Boolean isDiskLoggingEnabled = false;
public Boolean getIsDiskLoggingEnabled() { return this.isDiskLoggingEnabled; }
public void setIsDiskLoggingEnabled(Boolean v) { this.isDiskLoggingEnabled = v; }

private Boolean isDiskLoggingActive = false;
public Boolean getIsDiskLoggingActive() { return this.isDiskLoggingActive; }
public void setIsDiskLoggingActive(Boolean v) { this.isDiskLoggingActive = v; }

private Float frameRate = 0f;
public Float getFrameRate() { return this.frameRate; }
public void setFrameRate(Float v) { this.frameRate = v; }

private Float cpuUsageFG = 0f;
public Float getCpuUsageFG() { return this.cpuUsageFG; }
public void setCpuUsageFG(Float v) { this.cpuUsageFG = v; }

private Float gpuUsage = 0f;
public Float getGpuUsage() { return this.gpuUsage; }
public void setGpuUsage(Float v) { this.gpuUsage = v; }

private Float chanAvgLatency = 0f;
public Float getChanAvgLatency() { return this.chanAvgLatency; }
public void setChanAvgLatency(Float v) { this.chanAvgLatency = v; }

private Float chanLatency = 0f;
public Float getChanLatency() { return this.chanLatency; }
public void setChanLatency(Float v) { this.chanLatency = v; }

private Float chanQuality = 0f;
public Float getChanQuality() { return this.chanQuality; }
public void setChanQuality(Float v) { this.chanQuality = v; }

private Float chanPartnerQuality = 0f;
public Float getChanPartnerQuality() { return this.chanPartnerQuality; }
public void setChanPartnerQuality(Float v) { this.chanPartnerQuality = v; }

private Float cpuUsageBG = 0f;
public Float getCpuUsageBG() { return this.cpuUsageBG; }
public void setCpuUsageBG(Float v) { this.cpuUsageBG = v; }

private Float chanClockSkew = 0f;
public Float getChanClockSkew() { return this.chanClockSkew; }
public void setChanClockSkew(Float v) { this.chanClockSkew = v; }

private Float memPageFaultSec = 0f;
public Float getMemPageFaultSec() { return this.memPageFaultSec; }
public void setMemPageFaultSec(Float v) { this.memPageFaultSec = v; }

private Float memSoftPageFaultSec = 0f;
public Float getMemSoftPageFaultSec() { return this.memSoftPageFaultSec; }
public void setMemSoftPageFaultSec(Float v) { this.memSoftPageFaultSec = v; }

private Integer playerCarPosition = 0;
public Integer getPlayerCarPosition() { return this.playerCarPosition; }
public void setPlayerCarPosition(Integer v) { this.playerCarPosition = v; }

private Integer playerCarClassPosition = 0;
public Integer getPlayerCarClassPosition() { return this.playerCarClassPosition; }
public void setPlayerCarClassPosition(Integer v) { this.playerCarClassPosition = v; }

private Integer playerCarClass = 0;
public Integer getPlayerCarClass() { return this.playerCarClass; }
public void setPlayerCarClass(Integer v) { this.playerCarClass = v; }

private Integer playerTrackSurface = 0;
public Integer getPlayerTrackSurface() { return this.playerTrackSurface; }
public void setPlayerTrackSurface(Integer v) { this.playerTrackSurface = v; }

private Integer playerTrackSurfaceMaterial = 0;
public Integer getPlayerTrackSurfaceMaterial() { return this.playerTrackSurfaceMaterial; }
public void setPlayerTrackSurfaceMaterial(Integer v) { this.playerTrackSurfaceMaterial = v; }

private Integer playerCarIdx = 0;
public Integer getPlayerCarIdx() { return this.playerCarIdx; }
public void setPlayerCarIdx(Integer v) { this.playerCarIdx = v; }

private Integer playerCarTeamIncidentCount = 0;
public Integer getPlayerCarTeamIncidentCount() { return this.playerCarTeamIncidentCount; }
public void setPlayerCarTeamIncidentCount(Integer v) { this.playerCarTeamIncidentCount = v; }

private Integer playerCarMyIncidentCount = 0;
public Integer getPlayerCarMyIncidentCount() { return this.playerCarMyIncidentCount; }
public void setPlayerCarMyIncidentCount(Integer v) { this.playerCarMyIncidentCount = v; }

private Integer playerCarDriverIncidentCount = 0;
public Integer getPlayerCarDriverIncidentCount() { return this.playerCarDriverIncidentCount; }
public void setPlayerCarDriverIncidentCount(Integer v) { this.playerCarDriverIncidentCount = v; }

private Float playerCarWeightPenalty = 0f;
public Float getPlayerCarWeightPenalty() { return this.playerCarWeightPenalty; }
public void setPlayerCarWeightPenalty(Float v) { this.playerCarWeightPenalty = v; }

private Float playerCarPowerAdjust = 0f;
public Float getPlayerCarPowerAdjust() { return this.playerCarPowerAdjust; }
public void setPlayerCarPowerAdjust(Float v) { this.playerCarPowerAdjust = v; }

private Integer playerCarDryTireSetLimit = 0;
public Integer getPlayerCarDryTireSetLimit() { return this.playerCarDryTireSetLimit; }
public void setPlayerCarDryTireSetLimit(Integer v) { this.playerCarDryTireSetLimit = v; }

private Float playerCarTowTime = 0f;
public Float getPlayerCarTowTime() { return this.playerCarTowTime; }
public void setPlayerCarTowTime(Float v) { this.playerCarTowTime = v; }

private Boolean playerCarInPitStall = false;
public Boolean getPlayerCarInPitStall() { return this.playerCarInPitStall; }
public void setPlayerCarInPitStall(Boolean v) { this.playerCarInPitStall = v; }

private Integer playerCarPitSvStatus = 0;
public Integer getPlayerCarPitSvStatus() { return this.playerCarPitSvStatus; }
public void setPlayerCarPitSvStatus(Integer v) { this.playerCarPitSvStatus = v; }

private Integer playerTireCompound = 0;
public Integer getPlayerTireCompound() { return this.playerTireCompound; }
public void setPlayerTireCompound(Integer v) { this.playerTireCompound = v; }

private Integer playerFastRepairsUsed = 0;
public Integer getPlayerFastRepairsUsed() { return this.playerFastRepairsUsed; }
public void setPlayerFastRepairsUsed(Integer v) { this.playerFastRepairsUsed = v; }

private Boolean onPitRoad = false;
public Boolean getOnPitRoad() { return this.onPitRoad; }
public void setOnPitRoad(Boolean v) { this.onPitRoad = v; }

private Integer paceMode = 0;
public Integer getPaceMode() { return this.paceMode; }
public void setPaceMode(Integer v) { this.paceMode = v; }

private Integer[] carIdxLap = new Integer[]{0};
public Integer[] getCarIdxLap() { return this.carIdxLap; }
public void setCarIdxLap(Integer[] v) { this.carIdxLap = v; }

private Integer[] carIdxLapCompleted = new Integer[]{0};
public Integer[] getCarIdxLapCompleted() { return this.carIdxLapCompleted; }
public void setCarIdxLapCompleted(Integer[] v) { this.carIdxLapCompleted = v; }

private Float[] carIdxLapDistPct = new Float[]{0f};
public Float[] getCarIdxLapDistPct() { return this.carIdxLapDistPct; }
public void setCarIdxLapDistPct(Float[] v) { this.carIdxLapDistPct = v; }

private Integer[] carIdxTrackSurface = new Integer[]{0};
public Integer[] getCarIdxTrackSurface() { return this.carIdxTrackSurface; }
public void setCarIdxTrackSurface(Integer[] v) { this.carIdxTrackSurface = v; }

private Integer[] carIdxTrackSurfaceMaterial = new Integer[]{0};
public Integer[] getCarIdxTrackSurfaceMaterial() { return this.carIdxTrackSurfaceMaterial; }
public void setCarIdxTrackSurfaceMaterial(Integer[] v) { this.carIdxTrackSurfaceMaterial = v; }

private Boolean[] carIdxOnPitRoad = new Boolean[]{false};
public Boolean[] getCarIdxOnPitRoad() { return this.carIdxOnPitRoad; }
public void setCarIdxOnPitRoad(Boolean[] v) { this.carIdxOnPitRoad = v; }

private Integer[] carIdxPosition = new Integer[]{0};
public Integer[] getCarIdxPosition() { return this.carIdxPosition; }
public void setCarIdxPosition(Integer[] v) { this.carIdxPosition = v; }

private Integer[] carIdxClassPosition = new Integer[]{0};
public Integer[] getCarIdxClassPosition() { return this.carIdxClassPosition; }
public void setCarIdxClassPosition(Integer[] v) { this.carIdxClassPosition = v; }

private Integer[] carIdxClass = new Integer[]{0};
public Integer[] getCarIdxClass() { return this.carIdxClass; }
public void setCarIdxClass(Integer[] v) { this.carIdxClass = v; }

private Float[] carIdxF2Time = new Float[]{0f};
public Float[] getCarIdxF2Time() { return this.carIdxF2Time; }
public void setCarIdxF2Time(Float[] v) { this.carIdxF2Time = v; }

private Float[] carIdxEstTime = new Float[]{0f};
public Float[] getCarIdxEstTime() { return this.carIdxEstTime; }
public void setCarIdxEstTime(Float[] v) { this.carIdxEstTime = v; }

private Float[] carIdxLastLapTime = new Float[]{0f};
public Float[] getCarIdxLastLapTime() { return this.carIdxLastLapTime; }
public void setCarIdxLastLapTime(Float[] v) { this.carIdxLastLapTime = v; }

private Float[] carIdxBestLapTime = new Float[]{0f};
public Float[] getCarIdxBestLapTime() { return this.carIdxBestLapTime; }
public void setCarIdxBestLapTime(Float[] v) { this.carIdxBestLapTime = v; }

private Integer[] carIdxBestLapNum = new Integer[]{0};
public Integer[] getCarIdxBestLapNum() { return this.carIdxBestLapNum; }
public void setCarIdxBestLapNum(Integer[] v) { this.carIdxBestLapNum = v; }

private Integer[] carIdxTireCompound = new Integer[]{0};
public Integer[] getCarIdxTireCompound() { return this.carIdxTireCompound; }
public void setCarIdxTireCompound(Integer[] v) { this.carIdxTireCompound = v; }

private Integer[] carIdxQualTireCompound = new Integer[]{0};
public Integer[] getCarIdxQualTireCompound() { return this.carIdxQualTireCompound; }
public void setCarIdxQualTireCompound(Integer[] v) { this.carIdxQualTireCompound = v; }

private Boolean[] carIdxQualTireCompoundLocked = new Boolean[]{false};
public Boolean[] getCarIdxQualTireCompoundLocked() { return this.carIdxQualTireCompoundLocked; }
public void setCarIdxQualTireCompoundLocked(Boolean[] v) { this.carIdxQualTireCompoundLocked = v; }

private Integer[] carIdxFastRepairsUsed = new Integer[]{0};
public Integer[] getCarIdxFastRepairsUsed() { return this.carIdxFastRepairsUsed; }
public void setCarIdxFastRepairsUsed(Integer[] v) { this.carIdxFastRepairsUsed = v; }

private Integer[] carIdxSessionFlags = new Integer[]{0};
public Integer[] getCarIdxSessionFlags() { return this.carIdxSessionFlags; }
public void setCarIdxSessionFlags(Integer[] v) { this.carIdxSessionFlags = v; }

private Integer[] carIdxPaceLine = new Integer[]{0};
public Integer[] getCarIdxPaceLine() { return this.carIdxPaceLine; }
public void setCarIdxPaceLine(Integer[] v) { this.carIdxPaceLine = v; }

private Integer[] carIdxPaceRow = new Integer[]{0};
public Integer[] getCarIdxPaceRow() { return this.carIdxPaceRow; }
public void setCarIdxPaceRow(Integer[] v) { this.carIdxPaceRow = v; }

private Integer[] carIdxPaceFlags = new Integer[]{0};
public Integer[] getCarIdxPaceFlags() { return this.carIdxPaceFlags; }
public void setCarIdxPaceFlags(Integer[] v) { this.carIdxPaceFlags = v; }

private Float[] carIdxSteer = new Float[]{0f};
public Float[] getCarIdxSteer() { return this.carIdxSteer; }
public void setCarIdxSteer(Float[] v) { this.carIdxSteer = v; }

private Float[] carIdxRPM = new Float[]{0f};
public Float[] getCarIdxRPM() { return this.carIdxRPM; }
public void setCarIdxRPM(Float[] v) { this.carIdxRPM = v; }

private Integer[] carIdxGear = new Integer[]{0};
public Integer[] getCarIdxGear() { return this.carIdxGear; }
public void setCarIdxGear(Integer[] v) { this.carIdxGear = v; }

private Float steeringWheelAngle = 0f;
public Float getSteeringWheelAngle() { return this.steeringWheelAngle; }
public void setSteeringWheelAngle(Float v) { this.steeringWheelAngle = v; }

private Float throttle = 0f;
public Float getThrottle() { return this.throttle; }
public void setThrottle(Float v) { this.throttle = v; }

private Float brake = 0f;
public Float getBrake() { return this.brake; }
public void setBrake(Float v) { this.brake = v; }

private Float clutch = 0f;
public Float getClutch() { return this.clutch; }
public void setClutch(Float v) { this.clutch = v; }

private Integer gear = 0;
public Integer getGear() { return this.gear; }
public void setGear(Integer v) { this.gear = v; }

private Float rPM = 0f;
public Float getRPM() { return this.rPM; }
public void setRPM(Float v) { this.rPM = v; }

private Float playerCarSLFirstRPM = 0f;
public Float getPlayerCarSLFirstRPM() { return this.playerCarSLFirstRPM; }
public void setPlayerCarSLFirstRPM(Float v) { this.playerCarSLFirstRPM = v; }

private Float playerCarSLShiftRPM = 0f;
public Float getPlayerCarSLShiftRPM() { return this.playerCarSLShiftRPM; }
public void setPlayerCarSLShiftRPM(Float v) { this.playerCarSLShiftRPM = v; }

private Float playerCarSLLastRPM = 0f;
public Float getPlayerCarSLLastRPM() { return this.playerCarSLLastRPM; }
public void setPlayerCarSLLastRPM(Float v) { this.playerCarSLLastRPM = v; }

private Float playerCarSLBlinkRPM = 0f;
public Float getPlayerCarSLBlinkRPM() { return this.playerCarSLBlinkRPM; }
public void setPlayerCarSLBlinkRPM(Float v) { this.playerCarSLBlinkRPM = v; }

private Integer lap = 0;
public Integer getLap() { return this.lap; }
public void setLap(Integer v) { this.lap = v; }

private Integer lapCompleted = 0;
public Integer getLapCompleted() { return this.lapCompleted; }
public void setLapCompleted(Integer v) { this.lapCompleted = v; }

private Float lapDist = 0f;
public Float getLapDist() { return this.lapDist; }
public void setLapDist(Float v) { this.lapDist = v; }

private Float lapDistPct = 0f;
public Float getLapDistPct() { return this.lapDistPct; }
public void setLapDistPct(Float v) { this.lapDistPct = v; }

private Integer raceLaps = 0;
public Integer getRaceLaps() { return this.raceLaps; }
public void setRaceLaps(Integer v) { this.raceLaps = v; }

private Float carDistAhead = 0f;
public Float getCarDistAhead() { return this.carDistAhead; }
public void setCarDistAhead(Float v) { this.carDistAhead = v; }

private Float carDistBehind = 0f;
public Float getCarDistBehind() { return this.carDistBehind; }
public void setCarDistBehind(Float v) { this.carDistBehind = v; }

private Integer lapBestLap = 0;
public Integer getLapBestLap() { return this.lapBestLap; }
public void setLapBestLap(Integer v) { this.lapBestLap = v; }

private Float lapBestLapTime = 0f;
public Float getLapBestLapTime() { return this.lapBestLapTime; }
public void setLapBestLapTime(Float v) { this.lapBestLapTime = v; }

private Float lapLastLapTime = 0f;
public Float getLapLastLapTime() { return this.lapLastLapTime; }
public void setLapLastLapTime(Float v) { this.lapLastLapTime = v; }

private Float lapCurrentLapTime = 0f;
public Float getLapCurrentLapTime() { return this.lapCurrentLapTime; }
public void setLapCurrentLapTime(Float v) { this.lapCurrentLapTime = v; }

private Integer lapLasNLapSeq = 0;
public Integer getLapLasNLapSeq() { return this.lapLasNLapSeq; }
public void setLapLasNLapSeq(Integer v) { this.lapLasNLapSeq = v; }

private Float lapLastNLapTime = 0f;
public Float getLapLastNLapTime() { return this.lapLastNLapTime; }
public void setLapLastNLapTime(Float v) { this.lapLastNLapTime = v; }

private Integer lapBestNLapLap = 0;
public Integer getLapBestNLapLap() { return this.lapBestNLapLap; }
public void setLapBestNLapLap(Integer v) { this.lapBestNLapLap = v; }

private Float lapBestNLapTime = 0f;
public Float getLapBestNLapTime() { return this.lapBestNLapTime; }
public void setLapBestNLapTime(Float v) { this.lapBestNLapTime = v; }

private Float lapDeltaToBestLap = 0f;
public Float getLapDeltaToBestLap() { return this.lapDeltaToBestLap; }
public void setLapDeltaToBestLap(Float v) { this.lapDeltaToBestLap = v; }

private Float lapDeltaToBestLap_DD = 0f;
public Float getLapDeltaToBestLap_DD() { return this.lapDeltaToBestLap_DD; }
public void setLapDeltaToBestLap_DD(Float v) { this.lapDeltaToBestLap_DD = v; }

private Boolean lapDeltaToBestLap_OK = false;
public Boolean getLapDeltaToBestLap_OK() { return this.lapDeltaToBestLap_OK; }
public void setLapDeltaToBestLap_OK(Boolean v) { this.lapDeltaToBestLap_OK = v; }

private Float lapDeltaToOptimalLap = 0f;
public Float getLapDeltaToOptimalLap() { return this.lapDeltaToOptimalLap; }
public void setLapDeltaToOptimalLap(Float v) { this.lapDeltaToOptimalLap = v; }

private Float lapDeltaToOptimalLap_DD = 0f;
public Float getLapDeltaToOptimalLap_DD() { return this.lapDeltaToOptimalLap_DD; }
public void setLapDeltaToOptimalLap_DD(Float v) { this.lapDeltaToOptimalLap_DD = v; }

private Boolean lapDeltaToOptimalLap_OK = false;
public Boolean getLapDeltaToOptimalLap_OK() { return this.lapDeltaToOptimalLap_OK; }
public void setLapDeltaToOptimalLap_OK(Boolean v) { this.lapDeltaToOptimalLap_OK = v; }

private Float lapDeltaToSessionBestLap = 0f;
public Float getLapDeltaToSessionBestLap() { return this.lapDeltaToSessionBestLap; }
public void setLapDeltaToSessionBestLap(Float v) { this.lapDeltaToSessionBestLap = v; }

private Float lapDeltaToSessionBestLap_DD = 0f;
public Float getLapDeltaToSessionBestLap_DD() { return this.lapDeltaToSessionBestLap_DD; }
public void setLapDeltaToSessionBestLap_DD(Float v) { this.lapDeltaToSessionBestLap_DD = v; }

private Boolean lapDeltaToSessionBestLap_OK = false;
public Boolean getLapDeltaToSessionBestLap_OK() { return this.lapDeltaToSessionBestLap_OK; }
public void setLapDeltaToSessionBestLap_OK(Boolean v) { this.lapDeltaToSessionBestLap_OK = v; }

private Float lapDeltaToSessionOptimalLap = 0f;
public Float getLapDeltaToSessionOptimalLap() { return this.lapDeltaToSessionOptimalLap; }
public void setLapDeltaToSessionOptimalLap(Float v) { this.lapDeltaToSessionOptimalLap = v; }

private Float lapDeltaToSessionOptimalLap_DD = 0f;
public Float getLapDeltaToSessionOptimalLap_DD() { return this.lapDeltaToSessionOptimalLap_DD; }
public void setLapDeltaToSessionOptimalLap_DD(Float v) { this.lapDeltaToSessionOptimalLap_DD = v; }

private Boolean lapDeltaToSessionOptimalLap_OK = false;
public Boolean getLapDeltaToSessionOptimalLap_OK() { return this.lapDeltaToSessionOptimalLap_OK; }
public void setLapDeltaToSessionOptimalLap_OK(Boolean v) { this.lapDeltaToSessionOptimalLap_OK = v; }

private Float lapDeltaToSessionLastlLap = 0f;
public Float getLapDeltaToSessionLastlLap() { return this.lapDeltaToSessionLastlLap; }
public void setLapDeltaToSessionLastlLap(Float v) { this.lapDeltaToSessionLastlLap = v; }

private Float lapDeltaToSessionLastlLap_DD = 0f;
public Float getLapDeltaToSessionLastlLap_DD() { return this.lapDeltaToSessionLastlLap_DD; }
public void setLapDeltaToSessionLastlLap_DD(Float v) { this.lapDeltaToSessionLastlLap_DD = v; }

private Boolean lapDeltaToSessionLastlLap_OK = false;
public Boolean getLapDeltaToSessionLastlLap_OK() { return this.lapDeltaToSessionLastlLap_OK; }
public void setLapDeltaToSessionLastlLap_OK(Boolean v) { this.lapDeltaToSessionLastlLap_OK = v; }

private Float speed = 0f;
public Float getSpeed() { return this.speed; }
public void setSpeed(Float v) { this.speed = v; }

private Float yaw = 0f;
public Float getYaw() { return this.yaw; }
public void setYaw(Float v) { this.yaw = v; }

private Float yawNorth = 0f;
public Float getYawNorth() { return this.yawNorth; }
public void setYawNorth(Float v) { this.yawNorth = v; }

private Float pitch = 0f;
public Float getPitch() { return this.pitch; }
public void setPitch(Float v) { this.pitch = v; }

private Float roll = 0f;
public Float getRoll() { return this.roll; }
public void setRoll(Float v) { this.roll = v; }

private Integer enterExitReset = 0;
public Integer getEnterExitReset() { return this.enterExitReset; }
public void setEnterExitReset(Integer v) { this.enterExitReset = v; }

private Float trackTemp = 0f;
public Float getTrackTemp() { return this.trackTemp; }
public void setTrackTemp(Float v) { this.trackTemp = v; }

private Float trackTempCrew = 0f;
public Float getTrackTempCrew() { return this.trackTempCrew; }
public void setTrackTempCrew(Float v) { this.trackTempCrew = v; }

private Float airTemp = 0f;
public Float getAirTemp() { return this.airTemp; }
public void setAirTemp(Float v) { this.airTemp = v; }

private Integer trackWetness = 0;
public Integer getTrackWetness() { return this.trackWetness; }
public void setTrackWetness(Integer v) { this.trackWetness = v; }

private Integer skies = 0;
public Integer getSkies() { return this.skies; }
public void setSkies(Integer v) { this.skies = v; }

private Float airDensity = 0f;
public Float getAirDensity() { return this.airDensity; }
public void setAirDensity(Float v) { this.airDensity = v; }

private Float airPressure = 0f;
public Float getAirPressure() { return this.airPressure; }
public void setAirPressure(Float v) { this.airPressure = v; }

private Float windVel = 0f;
public Float getWindVel() { return this.windVel; }
public void setWindVel(Float v) { this.windVel = v; }

private Float windDir = 0f;
public Float getWindDir() { return this.windDir; }
public void setWindDir(Float v) { this.windDir = v; }

private Float relativeHumidity = 0f;
public Float getRelativeHumidity() { return this.relativeHumidity; }
public void setRelativeHumidity(Float v) { this.relativeHumidity = v; }

private Float fogLevel = 0f;
public Float getFogLevel() { return this.fogLevel; }
public void setFogLevel(Float v) { this.fogLevel = v; }

private Float precipitation = 0f;
public Float getPrecipitation() { return this.precipitation; }
public void setPrecipitation(Float v) { this.precipitation = v; }

private Float solarAltitude = 0f;
public Float getSolarAltitude() { return this.solarAltitude; }
public void setSolarAltitude(Float v) { this.solarAltitude = v; }

private Float solarAzimuth = 0f;
public Float getSolarAzimuth() { return this.solarAzimuth; }
public void setSolarAzimuth(Float v) { this.solarAzimuth = v; }

private Boolean weatherDeclaredWet = false;
public Boolean getWeatherDeclaredWet() { return this.weatherDeclaredWet; }
public void setWeatherDeclaredWet(Boolean v) { this.weatherDeclaredWet = v; }

private Boolean steeringFFBEnabled = false;
public Boolean getSteeringFFBEnabled() { return this.steeringFFBEnabled; }
public void setSteeringFFBEnabled(Boolean v) { this.steeringFFBEnabled = v; }

private Integer dCLapStatus = 0;
public Integer getDCLapStatus() { return this.dCLapStatus; }
public void setDCLapStatus(Integer v) { this.dCLapStatus = v; }

private Integer dCDriversSoFar = 0;
public Integer getDCDriversSoFar() { return this.dCDriversSoFar; }
public void setDCDriversSoFar(Integer v) { this.dCDriversSoFar = v; }

private Boolean okToReloadTextures = false;
public Boolean getOkToReloadTextures() { return this.okToReloadTextures; }
public void setOkToReloadTextures(Boolean v) { this.okToReloadTextures = v; }

private Boolean loadNumTextures = false;
public Boolean getLoadNumTextures() { return this.loadNumTextures; }
public void setLoadNumTextures(Boolean v) { this.loadNumTextures = v; }

private Integer carLeftRight = 0;
public Integer getCarLeftRight() { return this.carLeftRight; }
public void setCarLeftRight(Integer v) { this.carLeftRight = v; }

private Boolean pitsOpen = false;
public Boolean getPitsOpen() { return this.pitsOpen; }
public void setPitsOpen(Boolean v) { this.pitsOpen = v; }

private Boolean vidCapEnabled = false;
public Boolean getVidCapEnabled() { return this.vidCapEnabled; }
public void setVidCapEnabled(Boolean v) { this.vidCapEnabled = v; }

private Boolean vidCapActive = false;
public Boolean getVidCapActive() { return this.vidCapActive; }
public void setVidCapActive(Boolean v) { this.vidCapActive = v; }

private Integer playerIncidents = 0;
public Integer getPlayerIncidents() { return this.playerIncidents; }
public void setPlayerIncidents(Integer v) { this.playerIncidents = v; }

private Float pitRepairLeft = 0f;
public Float getPitRepairLeft() { return this.pitRepairLeft; }
public void setPitRepairLeft(Float v) { this.pitRepairLeft = v; }

private Float pitOptRepairLeft = 0f;
public Float getPitOptRepairLeft() { return this.pitOptRepairLeft; }
public void setPitOptRepairLeft(Float v) { this.pitOptRepairLeft = v; }

private Boolean pitstopActive = false;
public Boolean getPitstopActive() { return this.pitstopActive; }
public void setPitstopActive(Boolean v) { this.pitstopActive = v; }

private Integer fastRepairUsed = 0;
public Integer getFastRepairUsed() { return this.fastRepairUsed; }
public void setFastRepairUsed(Integer v) { this.fastRepairUsed = v; }

private Integer fastRepairAvailable = 0;
public Integer getFastRepairAvailable() { return this.fastRepairAvailable; }
public void setFastRepairAvailable(Integer v) { this.fastRepairAvailable = v; }

private Integer lFTiresUsed = 0;
public Integer getLFTiresUsed() { return this.lFTiresUsed; }
public void setLFTiresUsed(Integer v) { this.lFTiresUsed = v; }

private Integer rFTiresUsed = 0;
public Integer getRFTiresUsed() { return this.rFTiresUsed; }
public void setRFTiresUsed(Integer v) { this.rFTiresUsed = v; }

private Integer lRTiresUsed = 0;
public Integer getLRTiresUsed() { return this.lRTiresUsed; }
public void setLRTiresUsed(Integer v) { this.lRTiresUsed = v; }

private Integer rRTiresUsed = 0;
public Integer getRRTiresUsed() { return this.rRTiresUsed; }
public void setRRTiresUsed(Integer v) { this.rRTiresUsed = v; }

private Integer leftTireSetsUsed = 0;
public Integer getLeftTireSetsUsed() { return this.leftTireSetsUsed; }
public void setLeftTireSetsUsed(Integer v) { this.leftTireSetsUsed = v; }

private Integer rightTireSetsUsed = 0;
public Integer getRightTireSetsUsed() { return this.rightTireSetsUsed; }
public void setRightTireSetsUsed(Integer v) { this.rightTireSetsUsed = v; }

private Integer frontTireSetsUsed = 0;
public Integer getFrontTireSetsUsed() { return this.frontTireSetsUsed; }
public void setFrontTireSetsUsed(Integer v) { this.frontTireSetsUsed = v; }

private Integer rearTireSetsUsed = 0;
public Integer getRearTireSetsUsed() { return this.rearTireSetsUsed; }
public void setRearTireSetsUsed(Integer v) { this.rearTireSetsUsed = v; }

private Integer tireSetsUsed = 0;
public Integer getTireSetsUsed() { return this.tireSetsUsed; }
public void setTireSetsUsed(Integer v) { this.tireSetsUsed = v; }

private Integer lFTiresAvailable = 0;
public Integer getLFTiresAvailable() { return this.lFTiresAvailable; }
public void setLFTiresAvailable(Integer v) { this.lFTiresAvailable = v; }

private Integer rFTiresAvailable = 0;
public Integer getRFTiresAvailable() { return this.rFTiresAvailable; }
public void setRFTiresAvailable(Integer v) { this.rFTiresAvailable = v; }

private Integer lRTiresAvailable = 0;
public Integer getLRTiresAvailable() { return this.lRTiresAvailable; }
public void setLRTiresAvailable(Integer v) { this.lRTiresAvailable = v; }

private Integer rRTiresAvailable = 0;
public Integer getRRTiresAvailable() { return this.rRTiresAvailable; }
public void setRRTiresAvailable(Integer v) { this.rRTiresAvailable = v; }

private Integer leftTireSetsAvailable = 0;
public Integer getLeftTireSetsAvailable() { return this.leftTireSetsAvailable; }
public void setLeftTireSetsAvailable(Integer v) { this.leftTireSetsAvailable = v; }

private Integer rightTireSetsAvailable = 0;
public Integer getRightTireSetsAvailable() { return this.rightTireSetsAvailable; }
public void setRightTireSetsAvailable(Integer v) { this.rightTireSetsAvailable = v; }

private Integer frontTireSetsAvailable = 0;
public Integer getFrontTireSetsAvailable() { return this.frontTireSetsAvailable; }
public void setFrontTireSetsAvailable(Integer v) { this.frontTireSetsAvailable = v; }

private Integer rearTireSetsAvailable = 0;
public Integer getRearTireSetsAvailable() { return this.rearTireSetsAvailable; }
public void setRearTireSetsAvailable(Integer v) { this.rearTireSetsAvailable = v; }

private Integer tireSetsAvailable = 0;
public Integer getTireSetsAvailable() { return this.tireSetsAvailable; }
public void setTireSetsAvailable(Integer v) { this.tireSetsAvailable = v; }

private Integer camCarIdx = 0;
public Integer getCamCarIdx() { return this.camCarIdx; }
public void setCamCarIdx(Integer v) { this.camCarIdx = v; }

private Integer camCameraNumber = 0;
public Integer getCamCameraNumber() { return this.camCameraNumber; }
public void setCamCameraNumber(Integer v) { this.camCameraNumber = v; }

private Integer camGroupNumber = 0;
public Integer getCamGroupNumber() { return this.camGroupNumber; }
public void setCamGroupNumber(Integer v) { this.camGroupNumber = v; }

private Integer camCameraState = 0;
public Integer getCamCameraState() { return this.camCameraState; }
public void setCamCameraState(Integer v) { this.camCameraState = v; }

private Boolean isOnTrackCar = false;
public Boolean getIsOnTrackCar() { return this.isOnTrackCar; }
public void setIsOnTrackCar(Boolean v) { this.isOnTrackCar = v; }

private Boolean isInGarage = false;
public Boolean getIsInGarage() { return this.isInGarage; }
public void setIsInGarage(Boolean v) { this.isInGarage = v; }

private Float steeringWheelAngleMax = 0f;
public Float getSteeringWheelAngleMax() { return this.steeringWheelAngleMax; }
public void setSteeringWheelAngleMax(Float v) { this.steeringWheelAngleMax = v; }

private Float shiftPowerPct = 0f;
public Float getShiftPowerPct() { return this.shiftPowerPct; }
public void setShiftPowerPct(Float v) { this.shiftPowerPct = v; }

private Float shiftGrindRPM = 0f;
public Float getShiftGrindRPM() { return this.shiftGrindRPM; }
public void setShiftGrindRPM(Float v) { this.shiftGrindRPM = v; }

private Float throttleRaw = 0f;
public Float getThrottleRaw() { return this.throttleRaw; }
public void setThrottleRaw(Float v) { this.throttleRaw = v; }

private Float brakeRaw = 0f;
public Float getBrakeRaw() { return this.brakeRaw; }
public void setBrakeRaw(Float v) { this.brakeRaw = v; }

private Float clutchRaw = 0f;
public Float getClutchRaw() { return this.clutchRaw; }
public void setClutchRaw(Float v) { this.clutchRaw = v; }

private Float handbrakeRaw = 0f;
public Float getHandbrakeRaw() { return this.handbrakeRaw; }
public void setHandbrakeRaw(Float v) { this.handbrakeRaw = v; }

private Boolean brakeABSactive = false;
public Boolean getBrakeABSactive() { return this.brakeABSactive; }
public void setBrakeABSactive(Boolean v) { this.brakeABSactive = v; }

private Integer shifter = 0;
public Integer getShifter() { return this.shifter; }
public void setShifter(Integer v) { this.shifter = v; }

private Integer engineWarnings = 0;
public Integer getEngineWarnings() { return this.engineWarnings; }
public void setEngineWarnings(Integer v) { this.engineWarnings = v; }

private Float fuelLevelPct = 0f;
public Float getFuelLevelPct() { return this.fuelLevelPct; }
public void setFuelLevelPct(Float v) { this.fuelLevelPct = v; }

private Integer pitSvFlags = 0;
public Integer getPitSvFlags() { return this.pitSvFlags; }
public void setPitSvFlags(Integer v) { this.pitSvFlags = v; }

private Float pitSvLFP = 0f;
public Float getPitSvLFP() { return this.pitSvLFP; }
public void setPitSvLFP(Float v) { this.pitSvLFP = v; }

private Float pitSvRFP = 0f;
public Float getPitSvRFP() { return this.pitSvRFP; }
public void setPitSvRFP(Float v) { this.pitSvRFP = v; }

private Float pitSvLRP = 0f;
public Float getPitSvLRP() { return this.pitSvLRP; }
public void setPitSvLRP(Float v) { this.pitSvLRP = v; }

private Float pitSvRRP = 0f;
public Float getPitSvRRP() { return this.pitSvRRP; }
public void setPitSvRRP(Float v) { this.pitSvRRP = v; }

private Float pitSvFuel = 0f;
public Float getPitSvFuel() { return this.pitSvFuel; }
public void setPitSvFuel(Float v) { this.pitSvFuel = v; }

private Integer pitSvTireCompound = 0;
public Integer getPitSvTireCompound() { return this.pitSvTireCompound; }
public void setPitSvTireCompound(Integer v) { this.pitSvTireCompound = v; }

private Boolean[] carIdxP2P_Status = new Boolean[]{false};
public Boolean[] getCarIdxP2P_Status() { return this.carIdxP2P_Status; }
public void setCarIdxP2P_Status(Boolean[] v) { this.carIdxP2P_Status = v; }

private Integer[] carIdxP2P_Count = new Integer[]{0};
public Integer[] getCarIdxP2P_Count() { return this.carIdxP2P_Count; }
public void setCarIdxP2P_Count(Integer[] v) { this.carIdxP2P_Count = v; }

private Boolean p2P_Status = false;
public Boolean getP2P_Status() { return this.p2P_Status; }
public void setP2P_Status(Boolean v) { this.p2P_Status = v; }

private Integer p2P_Count = 0;
public Integer getP2P_Count() { return this.p2P_Count; }
public void setP2P_Count(Integer v) { this.p2P_Count = v; }

private Float steeringWheelPctTorque = 0f;
public Float getSteeringWheelPctTorque() { return this.steeringWheelPctTorque; }
public void setSteeringWheelPctTorque(Float v) { this.steeringWheelPctTorque = v; }

private Float steeringWheelPctTorqueSign = 0f;
public Float getSteeringWheelPctTorqueSign() { return this.steeringWheelPctTorqueSign; }
public void setSteeringWheelPctTorqueSign(Float v) { this.steeringWheelPctTorqueSign = v; }

private Float steeringWheelPctTorqueSignStops = 0f;
public Float getSteeringWheelPctTorqueSignStops() { return this.steeringWheelPctTorqueSignStops; }
public void setSteeringWheelPctTorqueSignStops(Float v) { this.steeringWheelPctTorqueSignStops = v; }

private Float steeringWheelPctIntensity = 0f;
public Float getSteeringWheelPctIntensity() { return this.steeringWheelPctIntensity; }
public void setSteeringWheelPctIntensity(Float v) { this.steeringWheelPctIntensity = v; }

private Float steeringWheelPctSmoothing = 0f;
public Float getSteeringWheelPctSmoothing() { return this.steeringWheelPctSmoothing; }
public void setSteeringWheelPctSmoothing(Float v) { this.steeringWheelPctSmoothing = v; }

private Float steeringWheelPctDamper = 0f;
public Float getSteeringWheelPctDamper() { return this.steeringWheelPctDamper; }
public void setSteeringWheelPctDamper(Float v) { this.steeringWheelPctDamper = v; }

private Float steeringWheelLimiter = 0f;
public Float getSteeringWheelLimiter() { return this.steeringWheelLimiter; }
public void setSteeringWheelLimiter(Float v) { this.steeringWheelLimiter = v; }

private Float steeringWheelMaxForceNm = 0f;
public Float getSteeringWheelMaxForceNm() { return this.steeringWheelMaxForceNm; }
public void setSteeringWheelMaxForceNm(Float v) { this.steeringWheelMaxForceNm = v; }

private Float steeringWheelPeakForceNm = 0f;
public Float getSteeringWheelPeakForceNm() { return this.steeringWheelPeakForceNm; }
public void setSteeringWheelPeakForceNm(Float v) { this.steeringWheelPeakForceNm = v; }

private Boolean steeringWheelUseLinear = false;
public Boolean getSteeringWheelUseLinear() { return this.steeringWheelUseLinear; }
public void setSteeringWheelUseLinear(Boolean v) { this.steeringWheelUseLinear = v; }

private Float shiftIndicatorPct = 0f;
public Float getShiftIndicatorPct() { return this.shiftIndicatorPct; }
public void setShiftIndicatorPct(Float v) { this.shiftIndicatorPct = v; }

private Boolean isGarageVisible = false;
public Boolean getIsGarageVisible() { return this.isGarageVisible; }
public void setIsGarageVisible(Boolean v) { this.isGarageVisible = v; }

private Integer replayPlaySpeed = 0;
public Integer getReplayPlaySpeed() { return this.replayPlaySpeed; }
public void setReplayPlaySpeed(Integer v) { this.replayPlaySpeed = v; }

private Boolean replayPlaySlowMotion = false;
public Boolean getReplayPlaySlowMotion() { return this.replayPlaySlowMotion; }
public void setReplayPlaySlowMotion(Boolean v) { this.replayPlaySlowMotion = v; }

private Double replaySessionTime = 0.0;
public Double getReplaySessionTime() { return this.replaySessionTime; }
public void setReplaySessionTime(Double v) { this.replaySessionTime = v; }

private Integer replaySessionNum = 0;
public Integer getReplaySessionNum() { return this.replaySessionNum; }
public void setReplaySessionNum(Integer v) { this.replaySessionNum = v; }

private Float tireLF_RumblePitch = 0f;
public Float getTireLF_RumblePitch() { return this.tireLF_RumblePitch; }
public void setTireLF_RumblePitch(Float v) { this.tireLF_RumblePitch = v; }

private Float tireRF_RumblePitch = 0f;
public Float getTireRF_RumblePitch() { return this.tireRF_RumblePitch; }
public void setTireRF_RumblePitch(Float v) { this.tireRF_RumblePitch = v; }

private Float tireLR_RumblePitch = 0f;
public Float getTireLR_RumblePitch() { return this.tireLR_RumblePitch; }
public void setTireLR_RumblePitch(Float v) { this.tireLR_RumblePitch = v; }

private Float tireRR_RumblePitch = 0f;
public Float getTireRR_RumblePitch() { return this.tireRR_RumblePitch; }
public void setTireRR_RumblePitch(Float v) { this.tireRR_RumblePitch = v; }

private Float[] steeringWheelTorque_ST = new Float[]{0f};
public Float[] getSteeringWheelTorque_ST() { return this.steeringWheelTorque_ST; }
public void setSteeringWheelTorque_ST(Float[] v) { this.steeringWheelTorque_ST = v; }

private Float steeringWheelTorque = 0f;
public Float getSteeringWheelTorque() { return this.steeringWheelTorque; }
public void setSteeringWheelTorque(Float v) { this.steeringWheelTorque = v; }

private Float[] velocityZ_ST = new Float[]{0f};
public Float[] getVelocityZ_ST() { return this.velocityZ_ST; }
public void setVelocityZ_ST(Float[] v) { this.velocityZ_ST = v; }

private Float[] velocityY_ST = new Float[]{0f};
public Float[] getVelocityY_ST() { return this.velocityY_ST; }
public void setVelocityY_ST(Float[] v) { this.velocityY_ST = v; }

private Float[] velocityX_ST = new Float[]{0f};
public Float[] getVelocityX_ST() { return this.velocityX_ST; }
public void setVelocityX_ST(Float[] v) { this.velocityX_ST = v; }

private Float velocityZ = 0f;
public Float getVelocityZ() { return this.velocityZ; }
public void setVelocityZ(Float v) { this.velocityZ = v; }

private Float velocityY = 0f;
public Float getVelocityY() { return this.velocityY; }
public void setVelocityY(Float v) { this.velocityY = v; }

private Float velocityX = 0f;
public Float getVelocityX() { return this.velocityX; }
public void setVelocityX(Float v) { this.velocityX = v; }

private Float[] yawRate_ST = new Float[]{0f};
public Float[] getYawRate_ST() { return this.yawRate_ST; }
public void setYawRate_ST(Float[] v) { this.yawRate_ST = v; }

private Float[] pitchRate_ST = new Float[]{0f};
public Float[] getPitchRate_ST() { return this.pitchRate_ST; }
public void setPitchRate_ST(Float[] v) { this.pitchRate_ST = v; }

private Float[] rollRate_ST = new Float[]{0f};
public Float[] getRollRate_ST() { return this.rollRate_ST; }
public void setRollRate_ST(Float[] v) { this.rollRate_ST = v; }

private Float yawRate = 0f;
public Float getYawRate() { return this.yawRate; }
public void setYawRate(Float v) { this.yawRate = v; }

private Float pitchRate = 0f;
public Float getPitchRate() { return this.pitchRate; }
public void setPitchRate(Float v) { this.pitchRate = v; }

private Float rollRate = 0f;
public Float getRollRate() { return this.rollRate; }
public void setRollRate(Float v) { this.rollRate = v; }

private Float[] vertAccel_ST = new Float[]{0f};
public Float[] getVertAccel_ST() { return this.vertAccel_ST; }
public void setVertAccel_ST(Float[] v) { this.vertAccel_ST = v; }

private Float[] latAccel_ST = new Float[]{0f};
public Float[] getLatAccel_ST() { return this.latAccel_ST; }
public void setLatAccel_ST(Float[] v) { this.latAccel_ST = v; }

private Float[] longAccel_ST = new Float[]{0f};
public Float[] getLongAccel_ST() { return this.longAccel_ST; }
public void setLongAccel_ST(Float[] v) { this.longAccel_ST = v; }

private Float vertAccel = 0f;
public Float getVertAccel() { return this.vertAccel; }
public void setVertAccel(Float v) { this.vertAccel = v; }

private Float latAccel = 0f;
public Float getLatAccel() { return this.latAccel; }
public void setLatAccel(Float v) { this.latAccel = v; }

private Float longAccel = 0f;
public Float getLongAccel() { return this.longAccel; }
public void setLongAccel(Float v) { this.longAccel = v; }

private Boolean dcStarter = false;
public Boolean getdcStarter() { return this.dcStarter; }
public void setdcStarter(Boolean v) { this.dcStarter = v; }

private Boolean dcPitSpeedLimiterToggle = false;
public Boolean getdcPitSpeedLimiterToggle() { return this.dcPitSpeedLimiterToggle; }
public void setdcPitSpeedLimiterToggle(Boolean v) { this.dcPitSpeedLimiterToggle = v; }

private Boolean dcHeadlightFlash = false;
public Boolean getdcHeadlightFlash() { return this.dcHeadlightFlash; }
public void setdcHeadlightFlash(Boolean v) { this.dcHeadlightFlash = v; }

private Boolean dcLowFuelAccept = false;
public Boolean getdcLowFuelAccept() { return this.dcLowFuelAccept; }
public void setdcLowFuelAccept(Boolean v) { this.dcLowFuelAccept = v; }

private Float dpRFTireChange = 0f;
public Float getdpRFTireChange() { return this.dpRFTireChange; }
public void setdpRFTireChange(Float v) { this.dpRFTireChange = v; }

private Float dpLFTireChange = 0f;
public Float getdpLFTireChange() { return this.dpLFTireChange; }
public void setdpLFTireChange(Float v) { this.dpLFTireChange = v; }

private Float dpRRTireChange = 0f;
public Float getdpRRTireChange() { return this.dpRRTireChange; }
public void setdpRRTireChange(Float v) { this.dpRRTireChange = v; }

private Float dpLRTireChange = 0f;
public Float getdpLRTireChange() { return this.dpLRTireChange; }
public void setdpLRTireChange(Float v) { this.dpLRTireChange = v; }

private Float dpFuelFill = 0f;
public Float getdpFuelFill() { return this.dpFuelFill; }
public void setdpFuelFill(Float v) { this.dpFuelFill = v; }

private Float dpWindshieldTearoff = 0f;
public Float getdpWindshieldTearoff() { return this.dpWindshieldTearoff; }
public void setdpWindshieldTearoff(Float v) { this.dpWindshieldTearoff = v; }

private Float dpFuelAddKg = 0f;
public Float getdpFuelAddKg() { return this.dpFuelAddKg; }
public void setdpFuelAddKg(Float v) { this.dpFuelAddKg = v; }

private Float dpFastRepair = 0f;
public Float getdpFastRepair() { return this.dpFastRepair; }
public void setdpFastRepair(Float v) { this.dpFastRepair = v; }

private Float dcBrakeBias = 0f;
public Float getdcBrakeBias() { return this.dcBrakeBias; }
public void setdcBrakeBias(Float v) { this.dcBrakeBias = v; }

private Float dpLFTireColdPress = 0f;
public Float getdpLFTireColdPress() { return this.dpLFTireColdPress; }
public void setdpLFTireColdPress(Float v) { this.dpLFTireColdPress = v; }

private Float dpRFTireColdPress = 0f;
public Float getdpRFTireColdPress() { return this.dpRFTireColdPress; }
public void setdpRFTireColdPress(Float v) { this.dpRFTireColdPress = v; }

private Float dpLRTireColdPress = 0f;
public Float getdpLRTireColdPress() { return this.dpLRTireColdPress; }
public void setdpLRTireColdPress(Float v) { this.dpLRTireColdPress = v; }

private Float dpRRTireColdPress = 0f;
public Float getdpRRTireColdPress() { return this.dpRRTireColdPress; }
public void setdpRRTireColdPress(Float v) { this.dpRRTireColdPress = v; }

private Float dcDashPage = 0f;
public Float getdcDashPage() { return this.dcDashPage; }
public void setdcDashPage(Float v) { this.dcDashPage = v; }

private Float dcTractionControl = 0f;
public Float getdcTractionControl() { return this.dcTractionControl; }
public void setdcTractionControl(Float v) { this.dcTractionControl = v; }

private Float dcTractionControl2 = 0f;
public Float getdcTractionControl2() { return this.dcTractionControl2; }
public void setdcTractionControl2(Float v) { this.dcTractionControl2 = v; }

private Float dcABS = 0f;
public Float getdcABS() { return this.dcABS; }
public void setdcABS(Float v) { this.dcABS = v; }

private Float dcThrottleShape = 0f;
public Float getdcThrottleShape() { return this.dcThrottleShape; }
public void setdcThrottleShape(Float v) { this.dcThrottleShape = v; }

private Float dpFuelAutoFillEnabled = 0f;
public Float getdpFuelAutoFillEnabled() { return this.dpFuelAutoFillEnabled; }
public void setdpFuelAutoFillEnabled(Float v) { this.dpFuelAutoFillEnabled = v; }

private Float dpFuelAutoFillActive = 0f;
public Float getdpFuelAutoFillActive() { return this.dpFuelAutoFillActive; }
public void setdpFuelAutoFillActive(Float v) { this.dpFuelAutoFillActive = v; }

private Boolean dcToggleWindshieldWipers = false;
public Boolean getdcToggleWindshieldWipers() { return this.dcToggleWindshieldWipers; }
public void setdcToggleWindshieldWipers(Boolean v) { this.dcToggleWindshieldWipers = v; }

private Boolean dcTriggerWindshieldWipers = false;
public Boolean getdcTriggerWindshieldWipers() { return this.dcTriggerWindshieldWipers; }
public void setdcTriggerWindshieldWipers(Boolean v) { this.dcTriggerWindshieldWipers = v; }

private Float fuelUsePerHour = 0f;
public Float getFuelUsePerHour() { return this.fuelUsePerHour; }
public void setFuelUsePerHour(Float v) { this.fuelUsePerHour = v; }

private Float voltage = 0f;
public Float getVoltage() { return this.voltage; }
public void setVoltage(Float v) { this.voltage = v; }

private Float waterTemp = 0f;
public Float getWaterTemp() { return this.waterTemp; }
public void setWaterTemp(Float v) { this.waterTemp = v; }

private Float waterLevel = 0f;
public Float getWaterLevel() { return this.waterLevel; }
public void setWaterLevel(Float v) { this.waterLevel = v; }

private Float fuelPress = 0f;
public Float getFuelPress() { return this.fuelPress; }
public void setFuelPress(Float v) { this.fuelPress = v; }

private Float oilTemp = 0f;
public Float getOilTemp() { return this.oilTemp; }
public void setOilTemp(Float v) { this.oilTemp = v; }

private Float oilPress = 0f;
public Float getOilPress() { return this.oilPress; }
public void setOilPress(Float v) { this.oilPress = v; }

private Float oilLevel = 0f;
public Float getOilLevel() { return this.oilLevel; }
public void setOilLevel(Float v) { this.oilLevel = v; }

private Float manifoldPress = 0f;
public Float getManifoldPress() { return this.manifoldPress; }
public void setManifoldPress(Float v) { this.manifoldPress = v; }

private Float fuelLevel = 0f;
public Float getFuelLevel() { return this.fuelLevel; }
public void setFuelLevel(Float v) { this.fuelLevel = v; }

private Float engine0_RPM = 0f;
public Float getEngine0_RPM() { return this.engine0_RPM; }
public void setEngine0_RPM(Float v) { this.engine0_RPM = v; }

private Float rFbrakeLinePress = 0f;
public Float getRFbrakeLinePress() { return this.rFbrakeLinePress; }
public void setRFbrakeLinePress(Float v) { this.rFbrakeLinePress = v; }

private Float rFcoldPressure = 0f;
public Float getRFcoldPressure() { return this.rFcoldPressure; }
public void setRFcoldPressure(Float v) { this.rFcoldPressure = v; }

private Float rFodometer = 0f;
public Float getRFodometer() { return this.rFodometer; }
public void setRFodometer(Float v) { this.rFodometer = v; }

private Float rFtempCL = 0f;
public Float getRFtempCL() { return this.rFtempCL; }
public void setRFtempCL(Float v) { this.rFtempCL = v; }

private Float rFtempCM = 0f;
public Float getRFtempCM() { return this.rFtempCM; }
public void setRFtempCM(Float v) { this.rFtempCM = v; }

private Float rFtempCR = 0f;
public Float getRFtempCR() { return this.rFtempCR; }
public void setRFtempCR(Float v) { this.rFtempCR = v; }

private Float rFwearL = 0f;
public Float getRFwearL() { return this.rFwearL; }
public void setRFwearL(Float v) { this.rFwearL = v; }

private Float rFwearM = 0f;
public Float getRFwearM() { return this.rFwearM; }
public void setRFwearM(Float v) { this.rFwearM = v; }

private Float rFwearR = 0f;
public Float getRFwearR() { return this.rFwearR; }
public void setRFwearR(Float v) { this.rFwearR = v; }

private Float lFbrakeLinePress = 0f;
public Float getLFbrakeLinePress() { return this.lFbrakeLinePress; }
public void setLFbrakeLinePress(Float v) { this.lFbrakeLinePress = v; }

private Float lFcoldPressure = 0f;
public Float getLFcoldPressure() { return this.lFcoldPressure; }
public void setLFcoldPressure(Float v) { this.lFcoldPressure = v; }

private Float lFodometer = 0f;
public Float getLFodometer() { return this.lFodometer; }
public void setLFodometer(Float v) { this.lFodometer = v; }

private Float lFtempCL = 0f;
public Float getLFtempCL() { return this.lFtempCL; }
public void setLFtempCL(Float v) { this.lFtempCL = v; }

private Float lFtempCM = 0f;
public Float getLFtempCM() { return this.lFtempCM; }
public void setLFtempCM(Float v) { this.lFtempCM = v; }

private Float lFtempCR = 0f;
public Float getLFtempCR() { return this.lFtempCR; }
public void setLFtempCR(Float v) { this.lFtempCR = v; }

private Float lFwearL = 0f;
public Float getLFwearL() { return this.lFwearL; }
public void setLFwearL(Float v) { this.lFwearL = v; }

private Float lFwearM = 0f;
public Float getLFwearM() { return this.lFwearM; }
public void setLFwearM(Float v) { this.lFwearM = v; }

private Float lFwearR = 0f;
public Float getLFwearR() { return this.lFwearR; }
public void setLFwearR(Float v) { this.lFwearR = v; }

private Float rRbrakeLinePress = 0f;
public Float getRRbrakeLinePress() { return this.rRbrakeLinePress; }
public void setRRbrakeLinePress(Float v) { this.rRbrakeLinePress = v; }

private Float rRcoldPressure = 0f;
public Float getRRcoldPressure() { return this.rRcoldPressure; }
public void setRRcoldPressure(Float v) { this.rRcoldPressure = v; }

private Float rRodometer = 0f;
public Float getRRodometer() { return this.rRodometer; }
public void setRRodometer(Float v) { this.rRodometer = v; }

private Float rRtempCL = 0f;
public Float getRRtempCL() { return this.rRtempCL; }
public void setRRtempCL(Float v) { this.rRtempCL = v; }

private Float rRtempCM = 0f;
public Float getRRtempCM() { return this.rRtempCM; }
public void setRRtempCM(Float v) { this.rRtempCM = v; }

private Float rRtempCR = 0f;
public Float getRRtempCR() { return this.rRtempCR; }
public void setRRtempCR(Float v) { this.rRtempCR = v; }

private Float rRwearL = 0f;
public Float getRRwearL() { return this.rRwearL; }
public void setRRwearL(Float v) { this.rRwearL = v; }

private Float rRwearM = 0f;
public Float getRRwearM() { return this.rRwearM; }
public void setRRwearM(Float v) { this.rRwearM = v; }

private Float rRwearR = 0f;
public Float getRRwearR() { return this.rRwearR; }
public void setRRwearR(Float v) { this.rRwearR = v; }

private Float lRbrakeLinePress = 0f;
public Float getLRbrakeLinePress() { return this.lRbrakeLinePress; }
public void setLRbrakeLinePress(Float v) { this.lRbrakeLinePress = v; }

private Float lRcoldPressure = 0f;
public Float getLRcoldPressure() { return this.lRcoldPressure; }
public void setLRcoldPressure(Float v) { this.lRcoldPressure = v; }

private Float lRodometer = 0f;
public Float getLRodometer() { return this.lRodometer; }
public void setLRodometer(Float v) { this.lRodometer = v; }

private Float lRtempCL = 0f;
public Float getLRtempCL() { return this.lRtempCL; }
public void setLRtempCL(Float v) { this.lRtempCL = v; }

private Float lRtempCM = 0f;
public Float getLRtempCM() { return this.lRtempCM; }
public void setLRtempCM(Float v) { this.lRtempCM = v; }

private Float lRtempCR = 0f;
public Float getLRtempCR() { return this.lRtempCR; }
public void setLRtempCR(Float v) { this.lRtempCR = v; }

private Float lRwearL = 0f;
public Float getLRwearL() { return this.lRwearL; }
public void setLRwearL(Float v) { this.lRwearL = v; }

private Float lRwearM = 0f;
public Float getLRwearM() { return this.lRwearM; }
public void setLRwearM(Float v) { this.lRwearM = v; }

private Float lRwearR = 0f;
public Float getLRwearR() { return this.lRwearR; }
public void setLRwearR(Float v) { this.lRwearR = v; }

private Float lRshockDefl = 0f;
public Float getLRshockDefl() { return this.lRshockDefl; }
public void setLRshockDefl(Float v) { this.lRshockDefl = v; }

private Float[] lRshockDefl_ST = new Float[]{0f};
public Float[] getLRshockDefl_ST() { return this.lRshockDefl_ST; }
public void setLRshockDefl_ST(Float[] v) { this.lRshockDefl_ST = v; }

private Float lRshockVel = 0f;
public Float getLRshockVel() { return this.lRshockVel; }
public void setLRshockVel(Float v) { this.lRshockVel = v; }

private Float[] lRshockVel_ST = new Float[]{0f};
public Float[] getLRshockVel_ST() { return this.lRshockVel_ST; }
public void setLRshockVel_ST(Float[] v) { this.lRshockVel_ST = v; }

private Float rRshockDefl = 0f;
public Float getRRshockDefl() { return this.rRshockDefl; }
public void setRRshockDefl(Float v) { this.rRshockDefl = v; }

private Float[] rRshockDefl_ST = new Float[]{0f};
public Float[] getRRshockDefl_ST() { return this.rRshockDefl_ST; }
public void setRRshockDefl_ST(Float[] v) { this.rRshockDefl_ST = v; }

private Float rRshockVel = 0f;
public Float getRRshockVel() { return this.rRshockVel; }
public void setRRshockVel(Float v) { this.rRshockVel = v; }

private Float[] rRshockVel_ST = new Float[]{0f};
public Float[] getRRshockVel_ST() { return this.rRshockVel_ST; }
public void setRRshockVel_ST(Float[] v) { this.rRshockVel_ST = v; }

private Float lFshockDefl = 0f;
public Float getLFshockDefl() { return this.lFshockDefl; }
public void setLFshockDefl(Float v) { this.lFshockDefl = v; }

private Float[] lFshockDefl_ST = new Float[]{0f};
public Float[] getLFshockDefl_ST() { return this.lFshockDefl_ST; }
public void setLFshockDefl_ST(Float[] v) { this.lFshockDefl_ST = v; }

private Float lFshockVel = 0f;
public Float getLFshockVel() { return this.lFshockVel; }
public void setLFshockVel(Float v) { this.lFshockVel = v; }

private Float[] lFshockVel_ST = new Float[]{0f};
public Float[] getLFshockVel_ST() { return this.lFshockVel_ST; }
public void setLFshockVel_ST(Float[] v) { this.lFshockVel_ST = v; }

private Float rFshockDefl = 0f;
public Float getRFshockDefl() { return this.rFshockDefl; }
public void setRFshockDefl(Float v) { this.rFshockDefl = v; }

private Float[] rFshockDefl_ST = new Float[]{0f};
public Float[] getRFshockDefl_ST() { return this.rFshockDefl_ST; }
public void setRFshockDefl_ST(Float[] v) { this.rFshockDefl_ST = v; }

private Float rFshockVel = 0f;
public Float getRFshockVel() { return this.rFshockVel; }
public void setRFshockVel(Float v) { this.rFshockVel = v; }

private Float[] rFshockVel_ST = new Float[]{0f};
public Float[] getRFshockVel_ST() { return this.rFshockVel_ST; }
public void setRFshockVel_ST(Float[] v) { this.rFshockVel_ST = v; }



        public static class Builder {
            private JavirsdkVariableStateSnapshot INSTANCE;
            public Builder() {
                INSTANCE = new JavirsdkVariableStateSnapshot();
            }
            public JavirsdkVariableStateSnapshot build() {
                return INSTANCE;
            }
            public Builder setSessionTime(Double v) { this.INSTANCE.sessionTime = v; return this; }
public Builder setSessionTick(Integer v) { this.INSTANCE.sessionTick = v; return this; }
public Builder setSessionNum(Integer v) { this.INSTANCE.sessionNum = v; return this; }
public Builder setSessionState(Integer v) { this.INSTANCE.sessionState = v; return this; }
public Builder setSessionUniqueID(Integer v) { this.INSTANCE.sessionUniqueID = v; return this; }
public Builder setSessionFlags(Integer v) { this.INSTANCE.sessionFlags = v; return this; }
public Builder setSessionTimeRemain(Double v) { this.INSTANCE.sessionTimeRemain = v; return this; }
public Builder setSessionLapsRemain(Integer v) { this.INSTANCE.sessionLapsRemain = v; return this; }
public Builder setSessionLapsRemainEx(Integer v) { this.INSTANCE.sessionLapsRemainEx = v; return this; }
public Builder setSessionTimeTotal(Double v) { this.INSTANCE.sessionTimeTotal = v; return this; }
public Builder setSessionLapsTotal(Integer v) { this.INSTANCE.sessionLapsTotal = v; return this; }
public Builder setSessionJokerLapsRemain(Integer v) { this.INSTANCE.sessionJokerLapsRemain = v; return this; }
public Builder setSessionOnJokerLap(Boolean v) { this.INSTANCE.sessionOnJokerLap = v; return this; }
public Builder setSessionTimeOfDay(Float v) { this.INSTANCE.sessionTimeOfDay = v; return this; }
public Builder setRadioTransmitCarIdx(Integer v) { this.INSTANCE.radioTransmitCarIdx = v; return this; }
public Builder setRadioTransmitRadioIdx(Integer v) { this.INSTANCE.radioTransmitRadioIdx = v; return this; }
public Builder setRadioTransmitFrequencyIdx(Integer v) { this.INSTANCE.radioTransmitFrequencyIdx = v; return this; }
public Builder setDisplayUnits(Integer v) { this.INSTANCE.displayUnits = v; return this; }
public Builder setDriverMarker(Boolean v) { this.INSTANCE.driverMarker = v; return this; }
public Builder setPushToTalk(Boolean v) { this.INSTANCE.pushToTalk = v; return this; }
public Builder setPushToPass(Boolean v) { this.INSTANCE.pushToPass = v; return this; }
public Builder setManualBoost(Boolean v) { this.INSTANCE.manualBoost = v; return this; }
public Builder setManualNoBoost(Boolean v) { this.INSTANCE.manualNoBoost = v; return this; }
public Builder setIsOnTrack(Boolean v) { this.INSTANCE.isOnTrack = v; return this; }
public Builder setIsReplayPlaying(Boolean v) { this.INSTANCE.isReplayPlaying = v; return this; }
public Builder setReplayFrameNum(Integer v) { this.INSTANCE.replayFrameNum = v; return this; }
public Builder setReplayFrameNumEnd(Integer v) { this.INSTANCE.replayFrameNumEnd = v; return this; }
public Builder setIsDiskLoggingEnabled(Boolean v) { this.INSTANCE.isDiskLoggingEnabled = v; return this; }
public Builder setIsDiskLoggingActive(Boolean v) { this.INSTANCE.isDiskLoggingActive = v; return this; }
public Builder setFrameRate(Float v) { this.INSTANCE.frameRate = v; return this; }
public Builder setCpuUsageFG(Float v) { this.INSTANCE.cpuUsageFG = v; return this; }
public Builder setGpuUsage(Float v) { this.INSTANCE.gpuUsage = v; return this; }
public Builder setChanAvgLatency(Float v) { this.INSTANCE.chanAvgLatency = v; return this; }
public Builder setChanLatency(Float v) { this.INSTANCE.chanLatency = v; return this; }
public Builder setChanQuality(Float v) { this.INSTANCE.chanQuality = v; return this; }
public Builder setChanPartnerQuality(Float v) { this.INSTANCE.chanPartnerQuality = v; return this; }
public Builder setCpuUsageBG(Float v) { this.INSTANCE.cpuUsageBG = v; return this; }
public Builder setChanClockSkew(Float v) { this.INSTANCE.chanClockSkew = v; return this; }
public Builder setMemPageFaultSec(Float v) { this.INSTANCE.memPageFaultSec = v; return this; }
public Builder setMemSoftPageFaultSec(Float v) { this.INSTANCE.memSoftPageFaultSec = v; return this; }
public Builder setPlayerCarPosition(Integer v) { this.INSTANCE.playerCarPosition = v; return this; }
public Builder setPlayerCarClassPosition(Integer v) { this.INSTANCE.playerCarClassPosition = v; return this; }
public Builder setPlayerCarClass(Integer v) { this.INSTANCE.playerCarClass = v; return this; }
public Builder setPlayerTrackSurface(Integer v) { this.INSTANCE.playerTrackSurface = v; return this; }
public Builder setPlayerTrackSurfaceMaterial(Integer v) { this.INSTANCE.playerTrackSurfaceMaterial = v; return this; }
public Builder setPlayerCarIdx(Integer v) { this.INSTANCE.playerCarIdx = v; return this; }
public Builder setPlayerCarTeamIncidentCount(Integer v) { this.INSTANCE.playerCarTeamIncidentCount = v; return this; }
public Builder setPlayerCarMyIncidentCount(Integer v) { this.INSTANCE.playerCarMyIncidentCount = v; return this; }
public Builder setPlayerCarDriverIncidentCount(Integer v) { this.INSTANCE.playerCarDriverIncidentCount = v; return this; }
public Builder setPlayerCarWeightPenalty(Float v) { this.INSTANCE.playerCarWeightPenalty = v; return this; }
public Builder setPlayerCarPowerAdjust(Float v) { this.INSTANCE.playerCarPowerAdjust = v; return this; }
public Builder setPlayerCarDryTireSetLimit(Integer v) { this.INSTANCE.playerCarDryTireSetLimit = v; return this; }
public Builder setPlayerCarTowTime(Float v) { this.INSTANCE.playerCarTowTime = v; return this; }
public Builder setPlayerCarInPitStall(Boolean v) { this.INSTANCE.playerCarInPitStall = v; return this; }
public Builder setPlayerCarPitSvStatus(Integer v) { this.INSTANCE.playerCarPitSvStatus = v; return this; }
public Builder setPlayerTireCompound(Integer v) { this.INSTANCE.playerTireCompound = v; return this; }
public Builder setPlayerFastRepairsUsed(Integer v) { this.INSTANCE.playerFastRepairsUsed = v; return this; }
public Builder setOnPitRoad(Boolean v) { this.INSTANCE.onPitRoad = v; return this; }
public Builder setPaceMode(Integer v) { this.INSTANCE.paceMode = v; return this; }
public Builder setCarIdxLap(Integer[] v) { this.INSTANCE.carIdxLap = v; return this; }
public Builder setCarIdxLapCompleted(Integer[] v) { this.INSTANCE.carIdxLapCompleted = v; return this; }
public Builder setCarIdxLapDistPct(Float[] v) { this.INSTANCE.carIdxLapDistPct = v; return this; }
public Builder setCarIdxTrackSurface(Integer[] v) { this.INSTANCE.carIdxTrackSurface = v; return this; }
public Builder setCarIdxTrackSurfaceMaterial(Integer[] v) { this.INSTANCE.carIdxTrackSurfaceMaterial = v; return this; }
public Builder setCarIdxOnPitRoad(Boolean[] v) { this.INSTANCE.carIdxOnPitRoad = v; return this; }
public Builder setCarIdxPosition(Integer[] v) { this.INSTANCE.carIdxPosition = v; return this; }
public Builder setCarIdxClassPosition(Integer[] v) { this.INSTANCE.carIdxClassPosition = v; return this; }
public Builder setCarIdxClass(Integer[] v) { this.INSTANCE.carIdxClass = v; return this; }
public Builder setCarIdxF2Time(Float[] v) { this.INSTANCE.carIdxF2Time = v; return this; }
public Builder setCarIdxEstTime(Float[] v) { this.INSTANCE.carIdxEstTime = v; return this; }
public Builder setCarIdxLastLapTime(Float[] v) { this.INSTANCE.carIdxLastLapTime = v; return this; }
public Builder setCarIdxBestLapTime(Float[] v) { this.INSTANCE.carIdxBestLapTime = v; return this; }
public Builder setCarIdxBestLapNum(Integer[] v) { this.INSTANCE.carIdxBestLapNum = v; return this; }
public Builder setCarIdxTireCompound(Integer[] v) { this.INSTANCE.carIdxTireCompound = v; return this; }
public Builder setCarIdxQualTireCompound(Integer[] v) { this.INSTANCE.carIdxQualTireCompound = v; return this; }
public Builder setCarIdxQualTireCompoundLocked(Boolean[] v) { this.INSTANCE.carIdxQualTireCompoundLocked = v; return this; }
public Builder setCarIdxFastRepairsUsed(Integer[] v) { this.INSTANCE.carIdxFastRepairsUsed = v; return this; }
public Builder setCarIdxSessionFlags(Integer[] v) { this.INSTANCE.carIdxSessionFlags = v; return this; }
public Builder setCarIdxPaceLine(Integer[] v) { this.INSTANCE.carIdxPaceLine = v; return this; }
public Builder setCarIdxPaceRow(Integer[] v) { this.INSTANCE.carIdxPaceRow = v; return this; }
public Builder setCarIdxPaceFlags(Integer[] v) { this.INSTANCE.carIdxPaceFlags = v; return this; }
public Builder setCarIdxSteer(Float[] v) { this.INSTANCE.carIdxSteer = v; return this; }
public Builder setCarIdxRPM(Float[] v) { this.INSTANCE.carIdxRPM = v; return this; }
public Builder setCarIdxGear(Integer[] v) { this.INSTANCE.carIdxGear = v; return this; }
public Builder setSteeringWheelAngle(Float v) { this.INSTANCE.steeringWheelAngle = v; return this; }
public Builder setThrottle(Float v) { this.INSTANCE.throttle = v; return this; }
public Builder setBrake(Float v) { this.INSTANCE.brake = v; return this; }
public Builder setClutch(Float v) { this.INSTANCE.clutch = v; return this; }
public Builder setGear(Integer v) { this.INSTANCE.gear = v; return this; }
public Builder setRPM(Float v) { this.INSTANCE.rPM = v; return this; }
public Builder setPlayerCarSLFirstRPM(Float v) { this.INSTANCE.playerCarSLFirstRPM = v; return this; }
public Builder setPlayerCarSLShiftRPM(Float v) { this.INSTANCE.playerCarSLShiftRPM = v; return this; }
public Builder setPlayerCarSLLastRPM(Float v) { this.INSTANCE.playerCarSLLastRPM = v; return this; }
public Builder setPlayerCarSLBlinkRPM(Float v) { this.INSTANCE.playerCarSLBlinkRPM = v; return this; }
public Builder setLap(Integer v) { this.INSTANCE.lap = v; return this; }
public Builder setLapCompleted(Integer v) { this.INSTANCE.lapCompleted = v; return this; }
public Builder setLapDist(Float v) { this.INSTANCE.lapDist = v; return this; }
public Builder setLapDistPct(Float v) { this.INSTANCE.lapDistPct = v; return this; }
public Builder setRaceLaps(Integer v) { this.INSTANCE.raceLaps = v; return this; }
public Builder setCarDistAhead(Float v) { this.INSTANCE.carDistAhead = v; return this; }
public Builder setCarDistBehind(Float v) { this.INSTANCE.carDistBehind = v; return this; }
public Builder setLapBestLap(Integer v) { this.INSTANCE.lapBestLap = v; return this; }
public Builder setLapBestLapTime(Float v) { this.INSTANCE.lapBestLapTime = v; return this; }
public Builder setLapLastLapTime(Float v) { this.INSTANCE.lapLastLapTime = v; return this; }
public Builder setLapCurrentLapTime(Float v) { this.INSTANCE.lapCurrentLapTime = v; return this; }
public Builder setLapLasNLapSeq(Integer v) { this.INSTANCE.lapLasNLapSeq = v; return this; }
public Builder setLapLastNLapTime(Float v) { this.INSTANCE.lapLastNLapTime = v; return this; }
public Builder setLapBestNLapLap(Integer v) { this.INSTANCE.lapBestNLapLap = v; return this; }
public Builder setLapBestNLapTime(Float v) { this.INSTANCE.lapBestNLapTime = v; return this; }
public Builder setLapDeltaToBestLap(Float v) { this.INSTANCE.lapDeltaToBestLap = v; return this; }
public Builder setLapDeltaToBestLap_DD(Float v) { this.INSTANCE.lapDeltaToBestLap_DD = v; return this; }
public Builder setLapDeltaToBestLap_OK(Boolean v) { this.INSTANCE.lapDeltaToBestLap_OK = v; return this; }
public Builder setLapDeltaToOptimalLap(Float v) { this.INSTANCE.lapDeltaToOptimalLap = v; return this; }
public Builder setLapDeltaToOptimalLap_DD(Float v) { this.INSTANCE.lapDeltaToOptimalLap_DD = v; return this; }
public Builder setLapDeltaToOptimalLap_OK(Boolean v) { this.INSTANCE.lapDeltaToOptimalLap_OK = v; return this; }
public Builder setLapDeltaToSessionBestLap(Float v) { this.INSTANCE.lapDeltaToSessionBestLap = v; return this; }
public Builder setLapDeltaToSessionBestLap_DD(Float v) { this.INSTANCE.lapDeltaToSessionBestLap_DD = v; return this; }
public Builder setLapDeltaToSessionBestLap_OK(Boolean v) { this.INSTANCE.lapDeltaToSessionBestLap_OK = v; return this; }
public Builder setLapDeltaToSessionOptimalLap(Float v) { this.INSTANCE.lapDeltaToSessionOptimalLap = v; return this; }
public Builder setLapDeltaToSessionOptimalLap_DD(Float v) { this.INSTANCE.lapDeltaToSessionOptimalLap_DD = v; return this; }
public Builder setLapDeltaToSessionOptimalLap_OK(Boolean v) { this.INSTANCE.lapDeltaToSessionOptimalLap_OK = v; return this; }
public Builder setLapDeltaToSessionLastlLap(Float v) { this.INSTANCE.lapDeltaToSessionLastlLap = v; return this; }
public Builder setLapDeltaToSessionLastlLap_DD(Float v) { this.INSTANCE.lapDeltaToSessionLastlLap_DD = v; return this; }
public Builder setLapDeltaToSessionLastlLap_OK(Boolean v) { this.INSTANCE.lapDeltaToSessionLastlLap_OK = v; return this; }
public Builder setSpeed(Float v) { this.INSTANCE.speed = v; return this; }
public Builder setYaw(Float v) { this.INSTANCE.yaw = v; return this; }
public Builder setYawNorth(Float v) { this.INSTANCE.yawNorth = v; return this; }
public Builder setPitch(Float v) { this.INSTANCE.pitch = v; return this; }
public Builder setRoll(Float v) { this.INSTANCE.roll = v; return this; }
public Builder setEnterExitReset(Integer v) { this.INSTANCE.enterExitReset = v; return this; }
public Builder setTrackTemp(Float v) { this.INSTANCE.trackTemp = v; return this; }
public Builder setTrackTempCrew(Float v) { this.INSTANCE.trackTempCrew = v; return this; }
public Builder setAirTemp(Float v) { this.INSTANCE.airTemp = v; return this; }
public Builder setTrackWetness(Integer v) { this.INSTANCE.trackWetness = v; return this; }
public Builder setSkies(Integer v) { this.INSTANCE.skies = v; return this; }
public Builder setAirDensity(Float v) { this.INSTANCE.airDensity = v; return this; }
public Builder setAirPressure(Float v) { this.INSTANCE.airPressure = v; return this; }
public Builder setWindVel(Float v) { this.INSTANCE.windVel = v; return this; }
public Builder setWindDir(Float v) { this.INSTANCE.windDir = v; return this; }
public Builder setRelativeHumidity(Float v) { this.INSTANCE.relativeHumidity = v; return this; }
public Builder setFogLevel(Float v) { this.INSTANCE.fogLevel = v; return this; }
public Builder setPrecipitation(Float v) { this.INSTANCE.precipitation = v; return this; }
public Builder setSolarAltitude(Float v) { this.INSTANCE.solarAltitude = v; return this; }
public Builder setSolarAzimuth(Float v) { this.INSTANCE.solarAzimuth = v; return this; }
public Builder setWeatherDeclaredWet(Boolean v) { this.INSTANCE.weatherDeclaredWet = v; return this; }
public Builder setSteeringFFBEnabled(Boolean v) { this.INSTANCE.steeringFFBEnabled = v; return this; }
public Builder setDCLapStatus(Integer v) { this.INSTANCE.dCLapStatus = v; return this; }
public Builder setDCDriversSoFar(Integer v) { this.INSTANCE.dCDriversSoFar = v; return this; }
public Builder setOkToReloadTextures(Boolean v) { this.INSTANCE.okToReloadTextures = v; return this; }
public Builder setLoadNumTextures(Boolean v) { this.INSTANCE.loadNumTextures = v; return this; }
public Builder setCarLeftRight(Integer v) { this.INSTANCE.carLeftRight = v; return this; }
public Builder setPitsOpen(Boolean v) { this.INSTANCE.pitsOpen = v; return this; }
public Builder setVidCapEnabled(Boolean v) { this.INSTANCE.vidCapEnabled = v; return this; }
public Builder setVidCapActive(Boolean v) { this.INSTANCE.vidCapActive = v; return this; }
public Builder setPlayerIncidents(Integer v) { this.INSTANCE.playerIncidents = v; return this; }
public Builder setPitRepairLeft(Float v) { this.INSTANCE.pitRepairLeft = v; return this; }
public Builder setPitOptRepairLeft(Float v) { this.INSTANCE.pitOptRepairLeft = v; return this; }
public Builder setPitstopActive(Boolean v) { this.INSTANCE.pitstopActive = v; return this; }
public Builder setFastRepairUsed(Integer v) { this.INSTANCE.fastRepairUsed = v; return this; }
public Builder setFastRepairAvailable(Integer v) { this.INSTANCE.fastRepairAvailable = v; return this; }
public Builder setLFTiresUsed(Integer v) { this.INSTANCE.lFTiresUsed = v; return this; }
public Builder setRFTiresUsed(Integer v) { this.INSTANCE.rFTiresUsed = v; return this; }
public Builder setLRTiresUsed(Integer v) { this.INSTANCE.lRTiresUsed = v; return this; }
public Builder setRRTiresUsed(Integer v) { this.INSTANCE.rRTiresUsed = v; return this; }
public Builder setLeftTireSetsUsed(Integer v) { this.INSTANCE.leftTireSetsUsed = v; return this; }
public Builder setRightTireSetsUsed(Integer v) { this.INSTANCE.rightTireSetsUsed = v; return this; }
public Builder setFrontTireSetsUsed(Integer v) { this.INSTANCE.frontTireSetsUsed = v; return this; }
public Builder setRearTireSetsUsed(Integer v) { this.INSTANCE.rearTireSetsUsed = v; return this; }
public Builder setTireSetsUsed(Integer v) { this.INSTANCE.tireSetsUsed = v; return this; }
public Builder setLFTiresAvailable(Integer v) { this.INSTANCE.lFTiresAvailable = v; return this; }
public Builder setRFTiresAvailable(Integer v) { this.INSTANCE.rFTiresAvailable = v; return this; }
public Builder setLRTiresAvailable(Integer v) { this.INSTANCE.lRTiresAvailable = v; return this; }
public Builder setRRTiresAvailable(Integer v) { this.INSTANCE.rRTiresAvailable = v; return this; }
public Builder setLeftTireSetsAvailable(Integer v) { this.INSTANCE.leftTireSetsAvailable = v; return this; }
public Builder setRightTireSetsAvailable(Integer v) { this.INSTANCE.rightTireSetsAvailable = v; return this; }
public Builder setFrontTireSetsAvailable(Integer v) { this.INSTANCE.frontTireSetsAvailable = v; return this; }
public Builder setRearTireSetsAvailable(Integer v) { this.INSTANCE.rearTireSetsAvailable = v; return this; }
public Builder setTireSetsAvailable(Integer v) { this.INSTANCE.tireSetsAvailable = v; return this; }
public Builder setCamCarIdx(Integer v) { this.INSTANCE.camCarIdx = v; return this; }
public Builder setCamCameraNumber(Integer v) { this.INSTANCE.camCameraNumber = v; return this; }
public Builder setCamGroupNumber(Integer v) { this.INSTANCE.camGroupNumber = v; return this; }
public Builder setCamCameraState(Integer v) { this.INSTANCE.camCameraState = v; return this; }
public Builder setIsOnTrackCar(Boolean v) { this.INSTANCE.isOnTrackCar = v; return this; }
public Builder setIsInGarage(Boolean v) { this.INSTANCE.isInGarage = v; return this; }
public Builder setSteeringWheelAngleMax(Float v) { this.INSTANCE.steeringWheelAngleMax = v; return this; }
public Builder setShiftPowerPct(Float v) { this.INSTANCE.shiftPowerPct = v; return this; }
public Builder setShiftGrindRPM(Float v) { this.INSTANCE.shiftGrindRPM = v; return this; }
public Builder setThrottleRaw(Float v) { this.INSTANCE.throttleRaw = v; return this; }
public Builder setBrakeRaw(Float v) { this.INSTANCE.brakeRaw = v; return this; }
public Builder setClutchRaw(Float v) { this.INSTANCE.clutchRaw = v; return this; }
public Builder setHandbrakeRaw(Float v) { this.INSTANCE.handbrakeRaw = v; return this; }
public Builder setBrakeABSactive(Boolean v) { this.INSTANCE.brakeABSactive = v; return this; }
public Builder setShifter(Integer v) { this.INSTANCE.shifter = v; return this; }
public Builder setEngineWarnings(Integer v) { this.INSTANCE.engineWarnings = v; return this; }
public Builder setFuelLevelPct(Float v) { this.INSTANCE.fuelLevelPct = v; return this; }
public Builder setPitSvFlags(Integer v) { this.INSTANCE.pitSvFlags = v; return this; }
public Builder setPitSvLFP(Float v) { this.INSTANCE.pitSvLFP = v; return this; }
public Builder setPitSvRFP(Float v) { this.INSTANCE.pitSvRFP = v; return this; }
public Builder setPitSvLRP(Float v) { this.INSTANCE.pitSvLRP = v; return this; }
public Builder setPitSvRRP(Float v) { this.INSTANCE.pitSvRRP = v; return this; }
public Builder setPitSvFuel(Float v) { this.INSTANCE.pitSvFuel = v; return this; }
public Builder setPitSvTireCompound(Integer v) { this.INSTANCE.pitSvTireCompound = v; return this; }
public Builder setCarIdxP2P_Status(Boolean[] v) { this.INSTANCE.carIdxP2P_Status = v; return this; }
public Builder setCarIdxP2P_Count(Integer[] v) { this.INSTANCE.carIdxP2P_Count = v; return this; }
public Builder setP2P_Status(Boolean v) { this.INSTANCE.p2P_Status = v; return this; }
public Builder setP2P_Count(Integer v) { this.INSTANCE.p2P_Count = v; return this; }
public Builder setSteeringWheelPctTorque(Float v) { this.INSTANCE.steeringWheelPctTorque = v; return this; }
public Builder setSteeringWheelPctTorqueSign(Float v) { this.INSTANCE.steeringWheelPctTorqueSign = v; return this; }
public Builder setSteeringWheelPctTorqueSignStops(Float v) { this.INSTANCE.steeringWheelPctTorqueSignStops = v; return this; }
public Builder setSteeringWheelPctIntensity(Float v) { this.INSTANCE.steeringWheelPctIntensity = v; return this; }
public Builder setSteeringWheelPctSmoothing(Float v) { this.INSTANCE.steeringWheelPctSmoothing = v; return this; }
public Builder setSteeringWheelPctDamper(Float v) { this.INSTANCE.steeringWheelPctDamper = v; return this; }
public Builder setSteeringWheelLimiter(Float v) { this.INSTANCE.steeringWheelLimiter = v; return this; }
public Builder setSteeringWheelMaxForceNm(Float v) { this.INSTANCE.steeringWheelMaxForceNm = v; return this; }
public Builder setSteeringWheelPeakForceNm(Float v) { this.INSTANCE.steeringWheelPeakForceNm = v; return this; }
public Builder setSteeringWheelUseLinear(Boolean v) { this.INSTANCE.steeringWheelUseLinear = v; return this; }
public Builder setShiftIndicatorPct(Float v) { this.INSTANCE.shiftIndicatorPct = v; return this; }
public Builder setIsGarageVisible(Boolean v) { this.INSTANCE.isGarageVisible = v; return this; }
public Builder setReplayPlaySpeed(Integer v) { this.INSTANCE.replayPlaySpeed = v; return this; }
public Builder setReplayPlaySlowMotion(Boolean v) { this.INSTANCE.replayPlaySlowMotion = v; return this; }
public Builder setReplaySessionTime(Double v) { this.INSTANCE.replaySessionTime = v; return this; }
public Builder setReplaySessionNum(Integer v) { this.INSTANCE.replaySessionNum = v; return this; }
public Builder setTireLF_RumblePitch(Float v) { this.INSTANCE.tireLF_RumblePitch = v; return this; }
public Builder setTireRF_RumblePitch(Float v) { this.INSTANCE.tireRF_RumblePitch = v; return this; }
public Builder setTireLR_RumblePitch(Float v) { this.INSTANCE.tireLR_RumblePitch = v; return this; }
public Builder setTireRR_RumblePitch(Float v) { this.INSTANCE.tireRR_RumblePitch = v; return this; }
public Builder setSteeringWheelTorque_ST(Float[] v) { this.INSTANCE.steeringWheelTorque_ST = v; return this; }
public Builder setSteeringWheelTorque(Float v) { this.INSTANCE.steeringWheelTorque = v; return this; }
public Builder setVelocityZ_ST(Float[] v) { this.INSTANCE.velocityZ_ST = v; return this; }
public Builder setVelocityY_ST(Float[] v) { this.INSTANCE.velocityY_ST = v; return this; }
public Builder setVelocityX_ST(Float[] v) { this.INSTANCE.velocityX_ST = v; return this; }
public Builder setVelocityZ(Float v) { this.INSTANCE.velocityZ = v; return this; }
public Builder setVelocityY(Float v) { this.INSTANCE.velocityY = v; return this; }
public Builder setVelocityX(Float v) { this.INSTANCE.velocityX = v; return this; }
public Builder setYawRate_ST(Float[] v) { this.INSTANCE.yawRate_ST = v; return this; }
public Builder setPitchRate_ST(Float[] v) { this.INSTANCE.pitchRate_ST = v; return this; }
public Builder setRollRate_ST(Float[] v) { this.INSTANCE.rollRate_ST = v; return this; }
public Builder setYawRate(Float v) { this.INSTANCE.yawRate = v; return this; }
public Builder setPitchRate(Float v) { this.INSTANCE.pitchRate = v; return this; }
public Builder setRollRate(Float v) { this.INSTANCE.rollRate = v; return this; }
public Builder setVertAccel_ST(Float[] v) { this.INSTANCE.vertAccel_ST = v; return this; }
public Builder setLatAccel_ST(Float[] v) { this.INSTANCE.latAccel_ST = v; return this; }
public Builder setLongAccel_ST(Float[] v) { this.INSTANCE.longAccel_ST = v; return this; }
public Builder setVertAccel(Float v) { this.INSTANCE.vertAccel = v; return this; }
public Builder setLatAccel(Float v) { this.INSTANCE.latAccel = v; return this; }
public Builder setLongAccel(Float v) { this.INSTANCE.longAccel = v; return this; }
public Builder setdcStarter(Boolean v) { this.INSTANCE.dcStarter = v; return this; }
public Builder setdcPitSpeedLimiterToggle(Boolean v) { this.INSTANCE.dcPitSpeedLimiterToggle = v; return this; }
public Builder setdcHeadlightFlash(Boolean v) { this.INSTANCE.dcHeadlightFlash = v; return this; }
public Builder setdcLowFuelAccept(Boolean v) { this.INSTANCE.dcLowFuelAccept = v; return this; }
public Builder setdpRFTireChange(Float v) { this.INSTANCE.dpRFTireChange = v; return this; }
public Builder setdpLFTireChange(Float v) { this.INSTANCE.dpLFTireChange = v; return this; }
public Builder setdpRRTireChange(Float v) { this.INSTANCE.dpRRTireChange = v; return this; }
public Builder setdpLRTireChange(Float v) { this.INSTANCE.dpLRTireChange = v; return this; }
public Builder setdpFuelFill(Float v) { this.INSTANCE.dpFuelFill = v; return this; }
public Builder setdpWindshieldTearoff(Float v) { this.INSTANCE.dpWindshieldTearoff = v; return this; }
public Builder setdpFuelAddKg(Float v) { this.INSTANCE.dpFuelAddKg = v; return this; }
public Builder setdpFastRepair(Float v) { this.INSTANCE.dpFastRepair = v; return this; }
public Builder setdcBrakeBias(Float v) { this.INSTANCE.dcBrakeBias = v; return this; }
public Builder setdpLFTireColdPress(Float v) { this.INSTANCE.dpLFTireColdPress = v; return this; }
public Builder setdpRFTireColdPress(Float v) { this.INSTANCE.dpRFTireColdPress = v; return this; }
public Builder setdpLRTireColdPress(Float v) { this.INSTANCE.dpLRTireColdPress = v; return this; }
public Builder setdpRRTireColdPress(Float v) { this.INSTANCE.dpRRTireColdPress = v; return this; }
public Builder setdcDashPage(Float v) { this.INSTANCE.dcDashPage = v; return this; }
public Builder setdcTractionControl(Float v) { this.INSTANCE.dcTractionControl = v; return this; }
public Builder setdcTractionControl2(Float v) { this.INSTANCE.dcTractionControl2 = v; return this; }
public Builder setdcABS(Float v) { this.INSTANCE.dcABS = v; return this; }
public Builder setdcThrottleShape(Float v) { this.INSTANCE.dcThrottleShape = v; return this; }
public Builder setdpFuelAutoFillEnabled(Float v) { this.INSTANCE.dpFuelAutoFillEnabled = v; return this; }
public Builder setdpFuelAutoFillActive(Float v) { this.INSTANCE.dpFuelAutoFillActive = v; return this; }
public Builder setdcToggleWindshieldWipers(Boolean v) { this.INSTANCE.dcToggleWindshieldWipers = v; return this; }
public Builder setdcTriggerWindshieldWipers(Boolean v) { this.INSTANCE.dcTriggerWindshieldWipers = v; return this; }
public Builder setFuelUsePerHour(Float v) { this.INSTANCE.fuelUsePerHour = v; return this; }
public Builder setVoltage(Float v) { this.INSTANCE.voltage = v; return this; }
public Builder setWaterTemp(Float v) { this.INSTANCE.waterTemp = v; return this; }
public Builder setWaterLevel(Float v) { this.INSTANCE.waterLevel = v; return this; }
public Builder setFuelPress(Float v) { this.INSTANCE.fuelPress = v; return this; }
public Builder setOilTemp(Float v) { this.INSTANCE.oilTemp = v; return this; }
public Builder setOilPress(Float v) { this.INSTANCE.oilPress = v; return this; }
public Builder setOilLevel(Float v) { this.INSTANCE.oilLevel = v; return this; }
public Builder setManifoldPress(Float v) { this.INSTANCE.manifoldPress = v; return this; }
public Builder setFuelLevel(Float v) { this.INSTANCE.fuelLevel = v; return this; }
public Builder setEngine0_RPM(Float v) { this.INSTANCE.engine0_RPM = v; return this; }
public Builder setRFbrakeLinePress(Float v) { this.INSTANCE.rFbrakeLinePress = v; return this; }
public Builder setRFcoldPressure(Float v) { this.INSTANCE.rFcoldPressure = v; return this; }
public Builder setRFodometer(Float v) { this.INSTANCE.rFodometer = v; return this; }
public Builder setRFtempCL(Float v) { this.INSTANCE.rFtempCL = v; return this; }
public Builder setRFtempCM(Float v) { this.INSTANCE.rFtempCM = v; return this; }
public Builder setRFtempCR(Float v) { this.INSTANCE.rFtempCR = v; return this; }
public Builder setRFwearL(Float v) { this.INSTANCE.rFwearL = v; return this; }
public Builder setRFwearM(Float v) { this.INSTANCE.rFwearM = v; return this; }
public Builder setRFwearR(Float v) { this.INSTANCE.rFwearR = v; return this; }
public Builder setLFbrakeLinePress(Float v) { this.INSTANCE.lFbrakeLinePress = v; return this; }
public Builder setLFcoldPressure(Float v) { this.INSTANCE.lFcoldPressure = v; return this; }
public Builder setLFodometer(Float v) { this.INSTANCE.lFodometer = v; return this; }
public Builder setLFtempCL(Float v) { this.INSTANCE.lFtempCL = v; return this; }
public Builder setLFtempCM(Float v) { this.INSTANCE.lFtempCM = v; return this; }
public Builder setLFtempCR(Float v) { this.INSTANCE.lFtempCR = v; return this; }
public Builder setLFwearL(Float v) { this.INSTANCE.lFwearL = v; return this; }
public Builder setLFwearM(Float v) { this.INSTANCE.lFwearM = v; return this; }
public Builder setLFwearR(Float v) { this.INSTANCE.lFwearR = v; return this; }
public Builder setRRbrakeLinePress(Float v) { this.INSTANCE.rRbrakeLinePress = v; return this; }
public Builder setRRcoldPressure(Float v) { this.INSTANCE.rRcoldPressure = v; return this; }
public Builder setRRodometer(Float v) { this.INSTANCE.rRodometer = v; return this; }
public Builder setRRtempCL(Float v) { this.INSTANCE.rRtempCL = v; return this; }
public Builder setRRtempCM(Float v) { this.INSTANCE.rRtempCM = v; return this; }
public Builder setRRtempCR(Float v) { this.INSTANCE.rRtempCR = v; return this; }
public Builder setRRwearL(Float v) { this.INSTANCE.rRwearL = v; return this; }
public Builder setRRwearM(Float v) { this.INSTANCE.rRwearM = v; return this; }
public Builder setRRwearR(Float v) { this.INSTANCE.rRwearR = v; return this; }
public Builder setLRbrakeLinePress(Float v) { this.INSTANCE.lRbrakeLinePress = v; return this; }
public Builder setLRcoldPressure(Float v) { this.INSTANCE.lRcoldPressure = v; return this; }
public Builder setLRodometer(Float v) { this.INSTANCE.lRodometer = v; return this; }
public Builder setLRtempCL(Float v) { this.INSTANCE.lRtempCL = v; return this; }
public Builder setLRtempCM(Float v) { this.INSTANCE.lRtempCM = v; return this; }
public Builder setLRtempCR(Float v) { this.INSTANCE.lRtempCR = v; return this; }
public Builder setLRwearL(Float v) { this.INSTANCE.lRwearL = v; return this; }
public Builder setLRwearM(Float v) { this.INSTANCE.lRwearM = v; return this; }
public Builder setLRwearR(Float v) { this.INSTANCE.lRwearR = v; return this; }
public Builder setLRshockDefl(Float v) { this.INSTANCE.lRshockDefl = v; return this; }
public Builder setLRshockDefl_ST(Float[] v) { this.INSTANCE.lRshockDefl_ST = v; return this; }
public Builder setLRshockVel(Float v) { this.INSTANCE.lRshockVel = v; return this; }
public Builder setLRshockVel_ST(Float[] v) { this.INSTANCE.lRshockVel_ST = v; return this; }
public Builder setRRshockDefl(Float v) { this.INSTANCE.rRshockDefl = v; return this; }
public Builder setRRshockDefl_ST(Float[] v) { this.INSTANCE.rRshockDefl_ST = v; return this; }
public Builder setRRshockVel(Float v) { this.INSTANCE.rRshockVel = v; return this; }
public Builder setRRshockVel_ST(Float[] v) { this.INSTANCE.rRshockVel_ST = v; return this; }
public Builder setLFshockDefl(Float v) { this.INSTANCE.lFshockDefl = v; return this; }
public Builder setLFshockDefl_ST(Float[] v) { this.INSTANCE.lFshockDefl_ST = v; return this; }
public Builder setLFshockVel(Float v) { this.INSTANCE.lFshockVel = v; return this; }
public Builder setLFshockVel_ST(Float[] v) { this.INSTANCE.lFshockVel_ST = v; return this; }
public Builder setRFshockDefl(Float v) { this.INSTANCE.rFshockDefl = v; return this; }
public Builder setRFshockDefl_ST(Float[] v) { this.INSTANCE.rFshockDefl_ST = v; return this; }
public Builder setRFshockVel(Float v) { this.INSTANCE.rFshockVel = v; return this; }
public Builder setRFshockVel_ST(Float[] v) { this.INSTANCE.rFshockVel_ST = v; return this; }

        }
    }
