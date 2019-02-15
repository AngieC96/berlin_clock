package berlinclock;

import java.util.Date;

public class TimeDisplayer {

    private StatusComputer statusComputer;

    public TimeDisplayer(Date time){ statusComputer = new StatusComputer(time); }
}
