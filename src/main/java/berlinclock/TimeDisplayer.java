package berlinclock;

import java.util.Date;

public class TimeDisplayer {

    private StatusComputer statusComputer;

    public TimeDisplayer(Date time){ statusComputer = new StatusComputer(time); }

    public String getFiveBlockHourString() {
        String template = "   %c    %c     %c    %c   ";
        char[] status = statusComputer.computeFiveBlockHourStatus();

        return String.format(template, status[0], status[1], status[2], status[3]);
    }

    public String getSingleBlockHourString() {
        String template = "   %c    %c     %c    %c   ";
        char[] status = statusComputer.computeSingleBlockHourStatus();

        return String.format(template, status[0], status[1], status[2], status[3]);
    }

    public String getSecondString(){
        return String.format("           %c           ", statusComputer.computeSecondStatus());
    }

}
