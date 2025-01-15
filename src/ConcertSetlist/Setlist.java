package ConcertSetlist;

import java.util.Scanner;

public class Setlist {
    public static void main(String[] args) {
        // initialize song database
        Song[] songDb = new Song[10];
        initSongDb(songDb);

        // create setlist using LList
        LList<Song> setList = new LList<>();
        Scanner in = new Scanner(System.in);

        // add songs to positions
        while (true) {
            System.out.print("Enter position in setlist to add\n(>=1, invalid position to exit): ");
            int pos = in.nextInt();

            if (pos < 1 || pos > setList.getLength() + 1) {
                break;
            }

            System.out.print("Enter ID of song to add: ");
            int id = in.nextInt();

            if (id < songDb.length) {
                Song dbSong = songDb[id];
                Song newSong = new Song(dbSong.getTitle(), dbSong.getDuration());
                setList.add(pos, newSong);
                updateStartTimes(setList);

                System.out.println("Setlist:");
                setList.display();
            }
        }

        // remove songs from positions
        while (true) {
            System.out.print("Enter position in setlist to remove\n(>=1, invalid position to exit): ");
            int pos = in.nextInt();

            if (pos < 1 || pos > setList.getLength()) {
                break;
            }

            setList.remove(pos);
            updateStartTimes(setList);

            System.out.println("Setlist:");
            setList.display();
        }

        System.out.println("Final setlist:");
        setList.display();

        // start concert at time = 0
        System.out.println("Starting concert at time = 0 minutes!");
        int currentTime = 0;

        // get next timestamp
        while (!setList.isEmpty()) {
            System.out.print("Enter next timestamp (in minutes): ");
            int nextTime = in.nextInt();

            if (nextTime < currentTime) continue;
            currentTime = nextTime;

            // process setlist
            while (!setList.isEmpty()) {
                Song current = setList.getEntry(1);
                int endTime = current.getStartTime() + current.getDuration();

                // remove and display finished songs
                if (currentTime >= endTime) {
                    setList.remove(1);
                    System.out.println(current.getTitle() + " finished");
                }
                // display song in progress
                else if (currentTime >= current.getStartTime()) {
                    System.out.println(current.getTitle() + " playing");
                    break;
                } else break;
            }

            // check if setlist is empty
            if (setList.isEmpty()) {
                System.out.println("Setlist complete");
                break;
            }
        }

        System.out.println("Concert finished!");
        in.close();
    }

    // update song start times
    private static void updateStartTimes(ListInterface<Song> list) {
        int startTime = 0;
        for (int i = 1; i <= list.getLength(); i++) {
            Song song = list.getEntry(i);
            song.setStartTime(startTime);
            startTime += song.getDuration();
        }
    }

    // initialize song database
    public static void initSongDb(Song[] sl) {
        sl[0] = new Song("Hype Boy", 3);
        sl[1] = new Song("Ditto", 3);
        sl[2] = new Song("OMG", 3);
        sl[3] = new Song("Attention", 3);
        sl[4] = new Song("Cookie", 4);
        sl[5] = new Song("Super Shy", 3);
        sl[6] = new Song("ETA", 3);
        sl[7] = new Song("New Jeans", 3);
        sl[8] = new Song("Cool With You", 3);
        sl[9] = new Song("Get Up", 3);
        System.out.println("Songs in database:");
        for (int i = 0; i < sl.length; i++) {
            System.out.println(i + " " + sl[i].getTitle() + " " + sl[i].getDuration());
        }
    }
}