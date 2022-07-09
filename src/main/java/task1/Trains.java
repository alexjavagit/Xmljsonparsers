package task1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "trains")
public class Trains {
    @XmlElement(name = "train")
    private List<Train> trains = new ArrayList<>();

    public void addTrain(Train train) {
        trains.add(train);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(trains.toArray());
    }

    public int getTrainsCount() {
        return trains.size();
    }

    public List<Train> getTrains() {
        return trains;
    }

    public List<Train> getTodayTrains() {
        List<Train> today_trains = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.MM.uuuu");
        LocalDate localDate = LocalDate.now();
        //time
        LocalTime fifteenOClock = LocalTime.of(15, 0);
        LocalTime nineteenOClock = LocalTime.of(19, 0);

        for (Train train : getTrains()) {
            if (train.getDate().equals(dtf.format(localDate)) && LocalTime.parse(train.getDeparture()).isAfter(fifteenOClock)
                    && LocalTime.parse(train.getDeparture()).isBefore(nineteenOClock)) {
                today_trains.add(train);
            }
        }
        return today_trains;
    }
}
