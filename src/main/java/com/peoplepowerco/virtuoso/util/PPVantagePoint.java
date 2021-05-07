package com.peoplepowerco.virtuoso.util;

import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.R;

public class PPVantagePoint {
    private int index;
    private String name = null;
    private String zoom;
    private String horizontalRotation;
    private String verticalRotation;
    private int timerInSeconds = PPCameraUtils.CameraDefaultValue.DEFAULT_VANTAGE_POINT_WAIT_TIME;

    public void reset() {
        name = null;
        timerInSeconds = PPCameraUtils.CameraDefaultValue.DEFAULT_VANTAGE_POINT_WAIT_TIME;
    }

    public String getHorizontalRotation() {
        return horizontalRotation;
    }

    public int getHorizontalRotationInt() {
        int retVal = 0;
        if (horizontalRotation != null) {
            retVal = Integer.parseInt(horizontalRotation);
        }
        return retVal;
    }

    public void setHorizontalRotation(String horizontalRotation) {
        this.horizontalRotation = horizontalRotation;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        if ((name == null) || (name.isEmpty())) {
            return getVantagePointNameFromIndex();
        }
        return name;
    }

    private String getVantagePointNameFromIndex() {
        String sName = PPUtil.NULL_STRING;
        switch (index) {
            case 0:
                sName = PPAppCenter.m_Context.getString(R.string.vantage_point_1);
                break;
            case 1:
                sName = PPAppCenter.m_Context.getString(R.string.vantage_point_2);
                break;
            case 2:
                sName = PPAppCenter.m_Context.getString(R.string.vantage_point_3);
                break;
            default:
                break;
        }
        return sName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimerInSeconds() {
        return timerInSeconds;
    }

    public void setTimerInSeconds(int timerInSeconds) {
        this.timerInSeconds = timerInSeconds;
    }

    public String getVerticalRotation() {
        return verticalRotation;
    }

    public int getVerticalRotationInt() {
        int retVal = 0;

        if (verticalRotation != null) {
            retVal = Integer.parseInt(verticalRotation);
        }
        return retVal;
    }

    public void setVerticalRotation(String verticalRotation) {
        this.verticalRotation = verticalRotation;
    }

    public String getZoom() {
        return zoom;
    }

    public int getZoomInt() {
        int retVal = 0;

        if (zoom != null) {
            retVal = Integer.parseInt(zoom);
        }

        return retVal;
    }

    public void setZoom(String zoom) {
        this.zoom = zoom;
    }

    public String getTimerPrettyFormat() {
//        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
//        return formatter.format(new Date(timerInSeconds * 1000));
        return getHumanReadableTime(timerInSeconds);
    }

    /**
     * Get readable time in 00:00:00 format.
     *
     * @param seconds
     * @return
     */
    public String getHumanReadableTime(int seconds) {
        String m_strTime = null;
        int iHours = seconds / 3600;
        int iMinutes = (seconds - (iHours * 3600)) / 60;
        int iSeconds = (seconds - (iHours * 3600)) - (iMinutes * 60);

        if (seconds < 60) {
            m_strTime = iSeconds + " " + PPAppCenter.m_Context.getString(R.string.time_sec);
        } else if (seconds < 3600) {
            m_strTime = iMinutes + " " + PPAppCenter.m_Context.getString(R.string.time_min);
            if (iSeconds > 0) {
                m_strTime += " " + iSeconds + " " + PPAppCenter.m_Context.getString(R.string.time_sec);
            }
        } else {
            m_strTime = (seconds / 3600) + " " + PPAppCenter.m_Context.getString(R.string.time_hour);
            if (iMinutes > 0) {
                m_strTime += " " + iMinutes + " " + PPAppCenter.m_Context.getString(R.string.time_min);
            }
            if (iSeconds > 0) {
                m_strTime += " " + iSeconds + " " + PPAppCenter.m_Context.getString(R.string.time_sec);
            }
        }

        return m_strTime;
    }
}
