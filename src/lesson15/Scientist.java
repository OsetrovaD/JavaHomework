package lesson15;

import lesson15.robot.Robot;
import lesson15.util.MapTestUtil;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

public class Scientist {

    @Getter
    private List<Robot> robots = new ArrayList<>();
    private Thread helper;

    public Scientist(Thread helper) {
        this.helper = helper;
    }

    public void makeAndCollectRobot() {
        while (((Helper) helper).getDetails().size() == 9) {
            robots.add(new Robot(((Helper) helper).getDetails().keySet()));
            MapTestUtil.decrementAllValues(((Helper) helper).getDetails());
        }
    }
}