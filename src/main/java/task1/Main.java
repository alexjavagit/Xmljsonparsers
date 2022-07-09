package task1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws JAXBException {
        Trains trains = new Trains();
        File file = new File("src/main/java/task1/list.xml");

        JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        trains = (Trains) unmarshaller.unmarshal(file);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1: add new train");
            System.out.println("2: view all trains");
            System.out.println("3: view trains, which depart today from 15:00 to 19:00");
            System.out.print("-> ");

            String s = sc.nextLine();
            switch (s) {
                case "1":
                    System.out.print("Enter From city: ");
                    String from = sc.nextLine();
                    System.out.print("Enter To city: ");
                    String to = sc.nextLine();
                    System.out.print("Enter Departure Date: ");
                    String ddate = sc.nextLine();
                    System.out.print("Enter Departure Time: ");
                    String dtime = sc.nextLine();

                    trains.addTrain(new Train(trains.getTrainsCount() + 1, from, to, ddate, dtime));

                    Marshaller marshaller = jaxbContext.createMarshaller();

                    // читабельное форматирование
                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                    // пишем в файл
                    marshaller.marshal(trains, file);

                    System.out.println("New Train was successfully added!");
                    break;
                case "2":
                    System.out.println("All trains:");
                    for (Train train : trains.getTrains()) {
                        System.out.println("Train #" + train.getId() + " :  From - " + train.getFrom() + ",  To - " + train.getTo() +
                                ", Date - " + train.getDate() + ", Departure - " + train.getDeparture());
                    }
                    break;
                case "3":
                    System.out.println("TODAY's trains:");
                    for (Train train : trains.getTodayTrains()) {
                        System.out.println("Train #" + train.getId() + " :  From - " + train.getFrom() + ",  To - " + train.getTo() +
                                ", Date - " + train.getDate() + ", Departure - " + train.getDeparture());
                    }
                    break;
                default:
                    return;
            }
        }

    }


    private static void addTrain(Scanner sc) {


    }

    //    private static void deleteClient(Scanner sc) throws SQLException {
//        System.out.print("Enter client name: ");
//        String name = sc.nextLine();
//
//        PreparedStatement ps = conn.prepareStatement("DELETE FROM Clients WHERE name = ?");
//        try {
//            ps.setString(1, name);
//            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
//        } finally {
//            ps.close();
//        }
//    }
//
//    private static void changeClient(Scanner sc) throws SQLException {
//        System.out.print("Enter client name: ");
//        String name = sc.nextLine();
//        System.out.print("Enter new age: ");
//        String sAge = sc.nextLine();
//        int age = Integer.parseInt(sAge);
//
//        PreparedStatement ps = conn.prepareStatement("UPDATE Clients SET age = ? WHERE name = ?");
//        try {
//            ps.setInt(1, age);
//            ps.setString(2, name);
//            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
//        } finally {
//            ps.close();
//        }
//    }
//
//    private static void insertRandomClients(Scanner sc) throws SQLException {
//        System.out.print("Enter clients count: ");
//        String sCount = sc.nextLine();
//        int count = Integer.parseInt(sCount);
//        Random rnd = new Random();
//
//        conn.setAutoCommit(false); // enable transactions
//        try {
//            try {
//                PreparedStatement ps = conn.prepareStatement("INSERT INTO Clients (name, age) VALUES(?, ?)");
//                try {
//                    for (int i = 0; i < count; i++) {
//                        ps.setString(1, "Name" + i);
//                        ps.setInt(2, rnd.nextInt(100));
//                        ps.executeUpdate();
//                    }
//                    conn.commit();
//                } finally {
//                    ps.close();
//                }
//            } catch (Exception ex) {
//                conn.rollback();
//            }
//        } finally {
//            conn.setAutoCommit(true); // return to default mode
//        }
//    }
//
    private static void viewAllTrains() {

    }

}

